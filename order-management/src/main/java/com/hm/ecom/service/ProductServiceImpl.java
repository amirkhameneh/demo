package com.hm.ecom.service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Component;

import com.hm.ecom.model.Filter;
import com.hm.ecom.model.FilterResponseModel;
import com.hm.ecom.model.Option;
import com.hm.ecom.model.ProductAttributeList;
import com.hm.ecom.model.ProductDetail;
import com.hm.ecom.model.ProductDetailRequest;
import com.hm.ecom.model.ProductDetailResponse;
import com.hm.ecom.model.ProductFilter;
import com.hm.ecom.model.SelectedFilter;
import com.hm.ecom.model.Value;
import com.hm.ecom.repository.FilterRepository;
import com.hm.ecom.repository.ProductAttributeListRepository;
import com.hm.ecom.repository.ProductAttributeViewRepository;
import com.hm.ecom.repository.ProductClassRepository;
import com.hm.ecom.repository.ProductDetailRepository;
import com.hm.ecom.repository.ProductFilterRepository;
import com.hm.ecom.repository.ProductFilterSpecification;
import com.hm.ecom.repository.ProductImageRepository;


@Component
public class ProductServiceImpl implements  ProductService {
	
	@Autowired
	FilterRepository filterRepository;
	
	@Autowired
	ProductFilterRepository productFilterRepository;
	
	@Autowired
	ProductDetailRepository productDetailRepository;
	
	@Autowired
	ProductAttributeViewRepository productAttributeViewRepository;
	
	@Autowired
	ProductAttributeListRepository productAttributeListRepository;

	 //@PersistenceContext
	 @Autowired
     private EntityManagerFactory entityManagerFactory;	
	 
	 @Autowired
     private ProductImageRepository productImageRepository;

	 @Autowired
     private ProductClassRepository productClassRepository;
	 
	@Override 
    public List<FilterResponseModel> getAllByCompanyAndCenterAndCategory(long company ,long center , long category) {
		
	    //EntityManagerFactory entityManagerFactory = new PersistenceProvider().createEntityManagerFactory;
	    		//Persistence.createEntityManagerFactory("PERSISTENCE");
	    
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		
		List<FilterResponseModel> responseList = new ArrayList<>();
		
		
		//FilterResponseModel filterResponseModel = new FilterResponseModel();
		for (Filter m : filterRepository.findAllByCompanyAndCategory(company, category)) {
			FilterResponseModel filterResponseModel = new FilterResponseModel();
			filterResponseModel.setId(m.getSrl());
			filterResponseModel.setCode(m.getCode());
			filterResponseModel.setName(m.getName());
			filterResponseModel.setType(m.getType());
			filterResponseModel.setOrder(m.getOrder());
			
			if (m.getSource() != null) {  
				Query  query = entityManager.createNativeQuery(m.getSource().replace("#CAT#", Long.toString(category)));
				filterResponseModel.setOptions(query.getResultList());
				
				//filterResponseModel.setOptions(optionRepository.findOptions("SELECT srl code ,user_name  name  FROM org_users") );	
			} else if (m.getAtrribute() !=null){
				
				List<Option> options = new ArrayList<>();
				for (ProductAttributeList a : productAttributeListRepository.findByAttribute(m.getAtrribute())) {
					Option option = new Option();
					option.setCode(a.getCode());
					option.setName(a.getName());
					option.setOrder(a.getOrder());
					options.add(option);
				}
				filterResponseModel.setOptions(options);
			}
			
			responseList.add(filterResponseModel);
			
	      }
		
		entityManager.close();
		
		return responseList;
	}
	 
	 
	@Override 
    public List<ProductDetail> getProductList(long company ,long category, long center , int pageNo,int pageSize, String sort, List<SelectedFilter> selectedFilter){
		List<ProductDetail> res;		
		
		
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		String valStr;
		String qstr = "select PCM_ORDER.GET_CLASS_SRL(srl) as \"Srl\" ," + 
				"        nvl(short_name,GOOD_NAME) as \"Name\", " + 
				"        PCM_ORDER.fnc_get_god_PRICE_RESULT2(NULL,SRL,NULL, NULL , NULL, NULL) AS \"Title\"," + 
				"        COR_SERVICES.GET_PUBLIC_WSL_ENDPOINT||'/cor/getimage/4d43f-rsffgrikin-654/'||PCM_INV_IMAGE(SRL) as \"Image\"" +  
				" FROM  INV_GOODS g where parent_srl is null and ";
		if (category != -1) {
			qstr  = qstr + "odom_srl = "+company+" and srl in (select igod_srl from PCM_PRODUCTFILTERS where FILTER_TYPE = 1 and P_VAL = "+category+") ";
		} else {	
			qstr  = qstr + "odom_srl = "+company ;
		}
		
        for (SelectedFilter f : selectedFilter) {
        	if (f.getValue() != null) {
        		qstr  = qstr + " and srl in (select igod_srl from PCM_PRODUCTFILTERS where PFLT_SRL = "+f.getSrl()+" and P_VAL = "+f.getValue()+") ";
        	} else if (f.getText() != "") {
        		qstr  = qstr + " and srl in (select igod_srl from PCM_PRODUCTFILTERS where PFLT_SRL = "+f.getSrl()+" and P_TEXT like '%"+f.getText()+"%') ";
        	}else if (f.getValues().size() >0) {
        		valStr = "(";
        		
        		for (Value v :f.getValues() ) {
        			if (valStr == "(") {
        				valStr =valStr +Long.toString(v.getVal());
        			}else {
        				valStr =valStr + ","+Long.toString(v.getVal());	
        			}
        			 
        		}
        		
        		valStr =valStr + ")";
        		
        		qstr  = qstr + " and srl in (select igod_srl from PCM_PRODUCTFILTERS where PFLT_SRL = "+f.getSrl()+" and P_VAL in "+valStr+") ";
        	}
        	
        	
		
		}
        qstr  = qstr + " order by  " +sort;
		
		Query  query = entityManager.createNativeQuery(qstr);
		
		//res = query.getResultList();
		List<Object[]> fff = query.getResultList();
		
		List<ProductDetail> products = new ArrayList<>()  ;
		//if (fff.size() <=(pageNo+1)*pageSize )
		for (int i=pageNo*pageSize;i<Math.min((pageNo+1)*pageSize,fff.size()) ; i++) {
			ProductDetail prd = new ProductDetail();
			prd.setSrl( Long.valueOf(fff.get(i)[0].toString()) );
			prd.setName(fff.get(i)[1].toString());
			prd.setTitle(fff.get(i)[2].toString());
			prd.setImage(fff.get(i)[3].toString());
			products.add( prd);
		}
		/*for (ProductDetail h : res) {
			
			products.add( h);
		}*/
		
		entityManager.close();
	
		return products;
		//return productDetailRepository.findByProduct(products);
		//return productDetailRepository.findAll();
		/*esponseList.add(Long.toString(category));
		responseList.add(selectedFilter.get(0).getValue().toString());
		responseList.add(selectedFilter.get(0).getValues().get(0).getVal().toString());*/
		
		
		/*for (ProductFilter h : productFilterRepository.findAll( new ProductFilterSpecification(company ,category ,center selectedFilter
				,null,null), PageRequest.of(pageNo, pageSize, Sort.by(Sort.Direction.DESC,sort)))) {
			
			products.add(h.getProduct());
		}*/
		//List<Long> products = new ArrayList<>();
		//Query  query = entityManager.createNativeQuery("select ");
		
		
	}
	
	@Override 
    public ProductDetailResponse getProductDetail(ProductDetailRequest productDetailrequest) {
		ProductDetailResponse prs = new ProductDetailResponse();
		ProductDetail prd = productDetailRepository.findBySrl(productDetailrequest.getProduct());
		prs.setName(prd.getName());
		prs.setLname(prd.getLname());
		prs.setBrand(prd.getBrand());
		prs.setDescription(prd.getDescription());
		prs.setMainImage(prd.getImage());		
		prs.setAttributes(productAttributeViewRepository.findByProduct(productDetailrequest.getProduct()));
		prs.setPrePrice(prd.getPrePrice());
		prs.setPostPrice(prd.getPostPrice());
		prs.setQty(prd.getQty());
		
		
		List<String> images = new ArrayList<>()  ;
		images.add(prd.getImage());
		images.add(prd.getImage());
		images.add(prd.getImage());
		images.add(prd.getImage());
		
		prs.setImages(images);
		
		prs.setOtherImages(productImageRepository.findAllBySrl(productDetailrequest.getProduct()));
		prs.setProductClasses(productClassRepository.findAllByParent(prd.getParent()));
		
		
		
		return prs;
	} 
        
}
