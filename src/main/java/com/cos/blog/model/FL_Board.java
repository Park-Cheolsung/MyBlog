package com.cos.blog.model;

import java.sql.Date;
import java.sql.Timestamp;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.CreationTimestamp;

@Entity			//FL_Board 클래스가  오라클에 테이블이 생성이 된다.
public class FL_Board {

	@Id												//Primary key
	@GeneratedValue(strategy = GenerationType.IDENTITY)			//프로젝트에서 연결된 DB의 넘버링 전략을 따라간다.
	private int brdSeq;							//시퀀스, auto_increment
	
	@Column(nullable = false, length = 100)
	private String title;							//제목

	@Lob	//대용량 데이터
	private String content;					//섬머트리 라이브러리 <html> 태그가 섞여서 디자인이 됨
	
	@ColumnDefault("0")
	private int count;							//조회수
	
	@ManyToOne(fetch = FetchType.EAGER)		//Many = Board, One = User 
	@JoinColumn(name = "empSeq")
	private FL_User user;						//DB는 오프젝트를 저장할 수 없다. FK, 자바는 오브젝트를 저장할 수 있다.
	
	@OneToMany(mappedBy = "board", fetch = FetchType.EAGER)			//mappedBy 연관관계의 주인이 아니다. 
	private List<FL_Reply> reply;					//DB에 컬럼을 만들지 마세요.
		
	@CreationTimestamp						//시간이 자동입력
	private Timestamp createDate;
	
}
