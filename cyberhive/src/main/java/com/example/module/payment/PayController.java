package com.example.module.payment;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.module.product.ProductDto;
import com.example.module.product.ProductService;

@Controller
@RequestMapping(value = "/payment")
public class PayController {
	
	private static final Logger logger = LoggerFactory.getLogger(PayController.class);
	
	@Autowired
	ProductService productService;
	
	@RequestMapping(value = "/PaymentForm")
	public String paymentForm(@RequestParam("prdtSeq") String prdtSeq, Model model) {
		
		logger.info("### Received prdtSeq: {}", prdtSeq);
		
		ProductDto dto = new ProductDto();
		dto.setPrdtSeq(prdtSeq);
		
		ProductDto product = productService.selectOne(dto);
		
		model.addAttribute("item", product);
		
		return "user/payment/PaymentForm";
	}
	
	@RequestMapping(value = "/PaymentSuccess")
	public String paysuccess() {
		return "user/payment/TossPaymentsSucess";
	}
	
	@RequestMapping(value = "/PaymentFail")
	public String payfail() {
		return "user/payment/TossPaymentsFail";
	}
	
   @PostMapping("/PaymentConfirm")
   @ResponseBody
   public ResponseEntity<String> confirmPayment(@RequestBody PayDto payDto) throws IOException, InterruptedException{
	   String requestBody = String.format(
		        "{\"paymentKey\":\"%s\",\"orderId\":\"%s\",\"amount\":%d}",
		        payDto.getPaymentKey(), payDto.getOrderId(), payDto.getAmount()
		    );
	   
	   HttpRequest request = HttpRequest.newBuilder()
			    .uri(URI.create("https://api.tosspayments.com/v1/payments/confirm"))
			    .header("Authorization", "Basic dGVzdF9za196WExrS0V5cE5BcldtbzUwblgzbG1lYXhZRzVSOg==")
			    .header("Content-Type", "application/json")
			    .method("POST", HttpRequest.BodyPublishers.ofString(requestBody))
			    .build();
			HttpResponse<String> response = HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofString());
			
			System.out.println(response.body());
			
			return ResponseEntity.ok(response.body());
	 }
   
   private static String extractValueFromJson(String json, String key) {
       int keyIndex = json.indexOf(key);
       if (keyIndex == -1) {
           return null; // 키가 없으면 null 반환
       }
       int startIndex = json.indexOf(":", keyIndex) + 1;
       int endIndex = json.indexOf(",", startIndex);
       if (endIndex == -1) {
           endIndex = json.indexOf("}", startIndex);
       }
       return json.substring(startIndex, endIndex).replace("\"", "").trim(); // 따옴표 제거하고 반환
   }
}
