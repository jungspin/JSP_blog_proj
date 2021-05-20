package com.cos.blog.domain.board;

import java.sql.Timestamp;

public class Board { // N, 1

	private int id; // PK, Sequence
	private String title; // 찐 id
	private String content;
	private int userId; // FK -> 데이터베이스에서는 제약조건 걸지마 !!!!
	private Timestamp created; // user 가 생성된 시간
	
	public Board() {
		super();
	}

	public Board(int id, String title, String content, int userId, Timestamp created) {
		super();
		this.id = id;
		this.title = title;
		this.content = content;
		this.userId = userId;
		this.created = created;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public Timestamp getCreated() {
		return created;
	}

	public void setCreated(Timestamp created) {
		this.created = created;
	}
	
	
	
	
}
