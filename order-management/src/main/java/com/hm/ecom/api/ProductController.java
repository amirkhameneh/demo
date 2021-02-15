package com.hm.ecom.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.hm.ecom.model.AuthRequestModel;
import com.hm.ecom.model.FilterRequestModel;
import com.hm.ecom.model.ProductDetailRequest;
import com.hm.ecom.model.ProductListRequestModel;
import com.hm.ecom.service.AuthService;
import com.hm.ecom.service.ProductService;

@RestController
@RequestMapping(APIName.PRODUCTS)
public class ProductController {
	
    @Autowired
    ProductService productService;
    
    @Autowired
    protected ResponseUtil responseUtil;
	
    @RequestMapping(path = APIName.FILTERS, method = RequestMethod.POST)
    public ResponseEntity<APIResponse> filters(
            @PathVariable("company_id") Long company,
            @RequestBody FilterRequestModel filterRequestModel) {
		
		return responseUtil.successResponse(productService.getAllByCompanyAndCenterAndCategory(filterRequestModel.getDomain(), filterRequestModel.getCenter(), filterRequestModel.getCategory()));
    }

    @RequestMapping(path = APIName.PRODUCT_LIST, method = RequestMethod.POST)
    public ResponseEntity<APIResponse> productList(
            @PathVariable("company_id") Long company,
            @RequestBody ProductListRequestModel productListRequestModel) {
		
		return responseUtil.successResponse(productService.getProductList(productListRequestModel.getDomain(), productListRequestModel.getCategory(), productListRequestModel.getCenter(),productListRequestModel.getPageNo(),productListRequestModel.getPageSize(),productListRequestModel.getSort(),productListRequestModel.getSelectedFilters()));
    }
    
    @RequestMapping(path = APIName.PRODUCT_DETAIL, method = RequestMethod.POST)
    public ResponseEntity<APIResponse> productDetail(
            @PathVariable("company_id") Long company,
            @RequestBody ProductDetailRequest productDetailRequest) {
		
		return responseUtil.successResponse(productService.getProductDetail(productDetailRequest));
    }    
    
}
