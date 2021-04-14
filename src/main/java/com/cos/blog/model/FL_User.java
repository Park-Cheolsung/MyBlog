package com.cos.blog.model;

import java.sql.Timestamp;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.DynamicInsert;

import lombok.Data;

//ORM -> Java(다른언어 포함) Object -> 테이블로 매핑해주는 기술
@Data
@Entity			//User 클래스가  오라클에 테이블이 생성이 된다.
//@DynamicInsert		//Insert 시 값이 null인 필드는 제외한다.
public class FL_User {

	@Id												//Primary key
	@GeneratedValue(strategy = GenerationType.IDENTITY)			//프로젝트에서 연결된 DB의 넘버링 전략을 따라간다.
	private int empSeq;							//시퀀스, auto_increment
	
	@Column(nullable = false, length = 30, unique = true)
	private String empId;		//아이디

	@Column(nullable = false, length = 50)
	private String userName;		//이름
	
	@Column(nullable = false, length = 100)			// => 해쉬(비밀번호 암호화)
	private String password;
	
	@Column(nullable = false, length = 50)			//
	private String empEmail;
	
//	@ColumnDefault("'user'")			
	//DB는 RoleType이라는게 없다.
	@Enumerated(EnumType.STRING)
	private RoleType role;											//Enum을 쓰는게 좋다. //Admin, user, manager 도메인 (범위) 지정
	
	@CreationTimestamp											//시간이 자동입력
    private Timestamp createDate;	
	
}
