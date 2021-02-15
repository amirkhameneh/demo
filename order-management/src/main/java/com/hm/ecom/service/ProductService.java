package com.hm.ecom.service;

import java.util.List;

import com.hm.ecom.model.Filter;
import com.hm.ecom.model.FilterResponseModel;
import com.hm.ecom.model.ProductDetail;
import com.hm.ecom.model.ProductDetailRequest;
import com.hm.ecom.model.ProductDetailResponse;
import com.hm.ecom.model.SelectedFilter;

public interface ProductService {
	List<FilterResponseModel> getAllByCompanyAndCenterAndCategory(long company ,long category, long center); 
	
	List<ProductDetail> getProductList(long company ,long category, long center ,int pageSize, int pageNo, String sort, List<SelectedFilter> selectedFilter);
	
	ProductDetailResponse getProductDetail(ProductDetailRequest productDetailrequest);
}
