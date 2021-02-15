package com.hm.ecom;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.google.gson.Gson;
import com.hm.ecom.model.AggregationRequest;
import com.hm.ecom.service.AggregationService;
import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class ApplicationTests {
	
	@Autowired
	AggregationService aggregationService;
	
	/*@Mock
    private PreorderRepository preorderRepository;
	
	@InjectMocks // auto inject helloRepository
    private OrderService orderService = new OrderServiceImpl();

    @BeforeEach
    void setMockOutput() {
    	
    
    }	*/
	
	@Test
	void getMedian() {
		/*List<Preorder> preorder = new ArrayList<Preorder>();
    	Preorder preorder0 = new Preorder();
    	preorder0.setSrl(Long.valueOf( 6805 ));
    	preorder.add(preorder0);
    	
    	when(preorderRepository.findLastCart(Long.valueOf( 2 ), Long.valueOf( 1 ), Long.valueOf( 321 )).thenReturn( preorder);
    	
    	assertEquals("76D5A65A4FD04494BE2CA18AF3341C83", orderService.getLastCartId(2,1, 321, 1));
    	*/
		Gson g = new Gson();
		
		
		String input="{\"headers\":[{\"v\":\"h1\"},{\"v\":\"label\"},{\"v\":\"h2\"}],\r\n"
				+ " \"rows\":[ {\"row\":[{\"v\":\"1\"},{\"v\":\"1\"},{\"v\":\"2\"}]},\r\n"
				+ "         {\"row\":[{\"v\":\"1\"},{\"v\":\"c1\"},{\"v\":\"2\"}]},\r\n"
				+ "          {\"row\":[{\"v\":\"2\"},{\"v\":\"c1\"},{\"v\":\"3\"}]},\r\n"
				+ "          {\"row\":[{\"v\":\"3\"},{\"v\":\"c1\"},{\"v\":\"4\"}]},\r\n"
				+ "          {\"row\":[{\"v\":\"3\"},{\"v\":\"c3\"},{\"v\":\"4\"}]},\r\n"
				+ "          {\"row\":[{\"v\":\"0\"},{\"v\":\"c2\"},{\"v\":\"-99999\"}]},\r\n"
				+ "          {\"row\":[{\"v\":\"3.000000099\"},{\"v\":\"c2\"},{\"v\":\"-3.3434343434399\"}]},\r\n"
				+ "          {\"row\":[{\"v\":\"7\"},{\"v\":\"c2\"},{\"v\":\"33\"}]}\r\n"
				+ "\r\n"
				+ " ]\r\n"
				+ " \r\n"
				+ "}";
		AggregationRequest request = g.fromJson(input, AggregationRequest.class);
		
		
		String output = "{\"headers\":[{\"v\":\"h1\"},{\"v\":\"label\"},{\"v\":\"h2\"}],\"rows\":[{\"row\":[{\"v\":\"3.0\"},{\"v\":\"c3\"},{\"v\":\"4.0\"}]},{\"row\":[{\"v\":\"1.0\"},{\"v\":\"1\"},{\"v\":\"2.0\"}]},{\"row\":[{\"v\":\"2.0\"},{\"v\":\"c1\"},{\"v\":\"3.0\"}]},{\"row\":[{\"v\":\"3.000000099\"},{\"v\":\"c2\"},{\"v\":\"-3.3434343434399\"}]}]}";
		AggregationRequest expectedResponse =  g.fromJson(output, AggregationRequest.class);
		
		String actualResualt = g.toJson(aggregationService.getMedian(request));
		String expectedResult = g.toJson(expectedResponse);
		
		assertEquals(actualResualt, expectedResult);
	}

}
