package com.cos.blog.test;

import java.sql.Date;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor				//모든 변수에 대해서만 생성자 처리
@NoArgsConstructor
//@RequiredArgsConstructor	//final 이붙은 변수에 대해서만 생성자 처리
public class Member {

	private int EMP_SEQ;
	private int ORG_SEQ; 
	private String EMP_DIV_CD; 
	private String empId; 
	private String empNm; 
	private String empPwd; 
	private String empEmail; 
	private String empPhoneNo; 
	private String EMER_NO; 
	private String EMP_JOIN_DAY; 
	private String SKILL_LV_CD; 
	private String POS_CD; 
	private String STAT_CD; 
		
	private String REG_ID; 
	private Date REG_DT; 
	private String CHG_ID; 
	private Date CHG_DT;
	
	@Builder
	public Member(String empId, String empNm, String empPwd, String empEmail, String empPhoneNo) {
		super();
		this.empId = empId;
		this.empNm = empNm;
		this.empPwd = empPwd;
		this.empEmail = empEmail;
		this.empPhoneNo = empPhoneNo;
	}

	
	
}
