package com.hm.ecom.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Optional;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.hm.ecom.model.Customer;
import com.hm.ecom.model.GetCartResponse;
import com.hm.ecom.model.Preorder;
import com.hm.ecom.model.PreorderItem;
import com.hm.ecom.model.PreorderItemView;
import com.hm.ecom.model.ProductDetail;
import com.hm.ecom.repository.CustomerRepository;
import com.hm.ecom.repository.PreorderItemRepository;
import com.hm.ecom.repository.PreorderItemViewRepository;
import com.hm.ecom.repository.PreorderRepository;
import com.hm.ecom.repository.ProductDetailRepository;

@Component
public class OrderServiceImpl implements OrderService {
	
	@Autowired
	CustomerRepository customerRepository;

	@Autowired
	PreorderRepository preorderRepository;
	
	@Autowired
	ProductDetailRepository productDetailRepository;

	@Autowired
	PreorderItemRepository preorderItemRepository;
	
	@Autowired
	PreorderItemViewRepository preorderItemViewRepository;
	
	@Override 
	public String getLastCartId(long domain ,long center, long user, long device) {

		
		List<Customer> customer =  customerRepository.findByUserSrl(user);
		List<Preorder> preorder = new ArrayList<Preorder>();
		if (customer.size() > 0) {
			//System.out.println(customer.get(0).getSrl());
			 preorder =  preorderRepository.findLastCart(domain, center, customer.get(0).getSrl());
		}
		
		if (preorder.size() > 0) {
			return preorder.get(0).getId();
		} else {
			return "";
		}
		
		
	}
	
	
	@Override 
	public 	String getNewCardId(long domain ,long center, long user, long device, String token) {
		Preorder preorder = new Preorder();
		preorder.setDomain(domain);
		preorder.setCenter(center);
		
		List<Customer> customer =  customerRepository.findByUserSrl(user);
		preorder.setCustomer(customer.get(0).getSrl());

		preorder.setOrderSt(Long.valueOf(10));
		preorder.setToken(token);
		preorder.setOrderDate(new Date(System.currentTimeMillis()));
		preorder.setOrderType("CARD");
		preorderRepository.save(preorder);
		
		return preorderRepository.findID(preorder.getSrl());

		
	};
	
	@Override 
	public 		String addToCart(String preorderID ,Long product, Long qty, Long supplier, String expeireDate) throws Exception {
		PreorderItem preorderItem = new PreorderItem();
		Long preorder = preorderRepository.getSrlById(preorderID);
		

		
		
		Long preorderSrl = preorderItemRepository.getSrlByProduct(preorder, product, supplier , expeireDate+"-");
		
		if (preorderSrl !=null) {
			preorderItem.setSrl(preorderSrl);
		}else {
			preorderItem.setSrl(null);
		}
		
		preorderItem.setPreorder(preorder);
		preorderItem.setProduct(product);
		
		preorderItem.setSupplier(supplier);

		
		if (expeireDate!="") {
			preorderItem.setExpireDate(new SimpleDateFormat("yyyyMMdd", Locale.ENGLISH).parse(expeireDate));
		}
		
		
		ProductDetail productDetail = productDetailRepository.findBySrl(product);
		

		
		Long vqty ;
		if (qty <= productDetail.getQty()) {
			vqty = qty;
		}else {
			vqty =  productDetail.getQty();
			
		}
		
		preorderItem.setQty(vqty);

		preorderItem.setPrePrice(productDetail.getPrePrice()*vqty*10);
		preorderItem.setPostPrice(productDetail.getPostPrice()*vqty*10);
		
		preorderItem.setGiftQty(Long.valueOf(0));
		preorderItem.setTax(Long.valueOf(0));
		preorderItem.setToll(Long.valueOf(0));
		preorderItem.setDisscount(productDetail.getPrePrice()*vqty - productDetail.getPostPrice()*vqty );
		
		if (vqty>0) {
			preorderItemRepository.save(preorderItem);
			return "Added";
		} else {
			return "Negative Qty";
		}
		
		

		
		
	}
	
	public String deleteItem(String preorderID,Long rowId) {
		preorderItemRepository.deleteById(rowId);
		return "Item Has Been Deleted";
	}
	
	public List<PreorderItemView> getPreorderItems(String preorderID) {
		return preorderItemViewRepository.getOrderItems(preorderID);
	}
	public GetCartResponse getCart(String preorderID) {
		GetCartResponse getCartResponse = new GetCartResponse();
		List<PreorderItemView> preorderItemView = new ArrayList();
		preorderItemView = getPreorderItems(preorderID);
		
		getCartResponse.setPreorderItems(preorderItemView);
		
		getCartResponse.setSumAmount(preorderItemView.stream().mapToLong(PreorderItemView::getPostPrice).sum());
		
		return getCartResponse;
	}
}
