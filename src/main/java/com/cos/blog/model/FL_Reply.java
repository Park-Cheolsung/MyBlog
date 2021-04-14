package com.cos.blog.model;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.CreationTimestamp;

@Entity			//FL_Board 클래스가  오라클에 테이블이 생성이 된다.
public class FL_Reply {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)		//SEQUENCY
	private int repSeq;
	
	@Column(nullable = false, length = 200)
	private String content;
	
	@ManyToOne									//Many = Reply, One = Board
	@JoinColumn(name = "brdSeq")
	private FL_Board board;				//DB는 오프젝트를 저장할 수 없다. FK, 자바는 오브젝트를 저장할 수 있다.
	
	@ManyToOne									//Many = Board, User = One
	@JoinColumn(name = "empSeq")
	private FL_User user;						//DB는 오프젝트를 저장할 수 없다. FK, 자바는 오브젝트를 저장할 수 있다.
	
	@CreationTimestamp						//시간이 자동입력
	private Timestamp createDate;
	
}
