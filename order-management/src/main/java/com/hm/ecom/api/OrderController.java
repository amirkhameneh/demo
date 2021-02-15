package com.hm.ecom.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.hm.ecom.model.AddToCartRequest;
import com.hm.ecom.model.DeleteItemRequest;
import com.hm.ecom.model.GetCartRequest;
import com.hm.ecom.model.ProductDetailRequest;
import com.hm.ecom.model.ProductListRequestModel;
import com.hm.ecom.service.OrderService;
import com.hm.ecom.util.Token;

@RestController
@RequestMapping(APIName.CARDS)
public class OrderController {
	@Autowired
	OrderService orderService;
	
	
    @Autowired
    protected ResponseUtil responseUtil;
    
    @RequestMapping(path = APIName.GET_PREORDER_ID, method = RequestMethod.POST)
    public ResponseEntity<APIResponse> getLastCartId(
            @PathVariable("company_id") Long company,
            @RequestHeader(value="Authorization") String token
             ) throws Exception {
		
		return responseUtil.successResponse(orderService.getLastCartId(Token.getDomain(token), Token.getCenter(token), Token.getUser(token), Token.getCenter(token)));
    }    
    
    
    @RequestMapping(path = APIName.GET_NEW_CART, method = RequestMethod.POST)
    public ResponseEntity<APIResponse> getNewCartId(
            @PathVariable("company_id") Long company,
            @RequestHeader(value="Authorization") String token
             ) throws Exception {
		
		return responseUtil.successResponse(orderService.getNewCardId(Token.getDomain(token), Token.getCenter(token), Token.getUser(token), Token.getCenter(token),token.substring(7)));
    }        

    @RequestMapping(path = APIName.ADD_TO_CART, method = RequestMethod.POST)
    public ResponseEntity<APIResponse> getAddToCart(
            @PathVariable("company_id") Long company,
            @RequestBody AddToCartRequest addToCartRequest
             ) throws Exception {
		
		return responseUtil.successResponse(orderService.addToCart(addToCartRequest.getPreorder(), addToCartRequest.getProduct()
				 								, addToCartRequest.getQty(), addToCartRequest.getSupplier(), addToCartRequest.getExpireDate()));
    }         

    @RequestMapping(path = APIName.DELETE_ITEM, method = RequestMethod.POST)
    public ResponseEntity<APIResponse> deleteItem(
            @PathVariable("company_id") Long company,
            @RequestBody DeleteItemRequest deleteItemRequest
             ) throws Exception {
		
		return responseUtil.successResponse(orderService.deleteItem(deleteItemRequest.getPreorder(), deleteItemRequest.getRowID()));
    }     
    
    @RequestMapping(path = APIName.GET_CART, method = RequestMethod.POST)
    public ResponseEntity<APIResponse> getCart(
            @PathVariable("company_id") Long company,
            @RequestBody GetCartRequest getCartRequest
             ) throws Exception {
		
		return responseUtil.successResponse(orderService.getCart(getCartRequest.getPreorder()));
    }    
}
