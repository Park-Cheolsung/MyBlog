package com.cos.blog.test;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

//사용자가 요청 -> 응답(HTML 파일)의 경우 -> @Cotroller
//사용자가 요청 -> 응답(Data)로 응답
@RestController
public class HttpControllerTest {
	
	private static final String TAG = "HttpControllerTest : ";

	@GetMapping("/http/lombak")
	public String lombokTest() {
		Member m = Member.builder().empEmail("cstech64@gmail.com").build();
		
		System.out.println(TAG + "getter : " + m.getEmpId());
		m.setEmpId("210001");
		System.out.println(TAG + "getter : " + m.getEmpId());
	
		return "lombok 완료";
	}
	
	//인터넷 브라우저 요청은 무조건 get요청밖에 할 수 없다.
	//http://localhost:8000/http/get(select)
	@GetMapping("/http/get")
	public String getTest(Member m) {
				
		return "get 요청 : emp_id = " + m.getEmpId() + ", emp_nm = " + m.getEmpNm() 
		                                                  + ", emp_pwd = " + m.getEmpPwd()
														  + ",emp_phone_no = " + m.getEmpPhoneNo();
	}

	//http://localhost:8000/http/post(insert)
	@PostMapping("/http/post")			//text/plain, application/json
	//public String getPost(@RequestBody Member m) {	
	public String postTest(@RequestBody Member m) {	//Spring MessageConvert(spring boot)

		return "post 요청 : " + m.getEmpId() + ", " + m.getEmpNm() + ", " 
										   + m.getEmpPwd() + ", " + m.getEmpPhoneNo();
	}

	//http://localhost:8000/http/put(update)
	@PutMapping("/http/put")
	public String putTest(@RequestBody Member m) {
		return "put 요청 : " + m.getEmpId() + ", " + m.getEmpNm() + ", " 
				   						  + m.getEmpPwd() + ", " + m.getEmpPhoneNo();
	}
	
	//http://localhost:8000/http/delete(delete)
	@DeleteMapping("/http/delete")
	public String deleteTest() {
		return "delete 요청";
	}

}
