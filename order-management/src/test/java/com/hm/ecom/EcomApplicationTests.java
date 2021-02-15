package com.hm.ecom;

import  org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import  org.springframework.boot.test.context.SpringBootTest;

import com.google.gson.Gson;
import com.hm.ecom.model.Preorder;
import com.hm.ecom.repository.PreorderRepository;
import com.hm.ecom.service.OrderService;
import com.hm.ecom.service.OrderServiceImpl;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;

@SpringBootTest
class EcomApplicationTests {
	
	@Autowired
	OrderService orderService;
	
	/*@Mock
    private PreorderRepository preorderRepository;
	
	@InjectMocks // auto inject helloRepository
    private OrderService orderService = new OrderServiceImpl();

    @BeforeEach
    void setMockOutput() {
    	
    
    }	*/
	
	@Test
	void getLastCard() {
		
		/*List<Preorder> preorder = new ArrayList<Preorder>();
    	Preorder preorder0 = new Preorder();
    	preorder0.setSrl(Long.valueOf( 6805 ));
    	preorder.add(preorder0);
    	
    	when(preorderRepository.findLastCart(Long.valueOf( 2 ), Long.valueOf( 1 ), Long.valueOf( 321 )).thenReturn( preorder);
    	*/

				
		
		
		assertEquals("76D5A65A4FD04494BE2CA18AF3341C83", orderService.getLastCartId(2,1, 321, 1));
	}

}
