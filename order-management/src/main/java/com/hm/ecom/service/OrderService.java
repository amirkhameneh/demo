package com.hm.ecom.service;

import java.util.List;

import com.hm.ecom.model.FilterResponseModel;
import com.hm.ecom.model.GetCartResponse;
import com.hm.ecom.model.PreorderItemView;

public interface OrderService {
	String getLastCartId(long domain ,long center, long user, long device);
	
	String getNewCardId(long domain ,long center, long user, long device, String token);
	
	String addToCart(String preorderID ,Long product, Long qty, Long supplier, String expeireDate) throws Exception;
	
	String deleteItem(String preorderID,Long rowId);
	
	List<PreorderItemView> getPreorderItems(String preorderID);
	
	GetCartResponse getCart(String preorderID);
	
}
