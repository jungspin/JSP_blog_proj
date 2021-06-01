package com.cos.blog.domain.board;

import java.sql.Timestamp;

public class Board { // N, 1
	
	private Integer id; // PK, Sequence
	private String title;
	private String content;
	private Integer userId; // FK DB에서 제약조건 걸지마
	private Timestamp created; // user 가 회원가입한 시간
	
	
	
	@Override
	public String toString() {
		return "Board [id=" + id + ", title=" + title + ", content=" + content + ", userId=" + userId + ", created="
				+ created + "]";
	}

	public Board() {
		
	}

	public Board(Integer id, String title, String content, Integer userId, Timestamp created) {
		
		this.id = id;
		this.title = title;
		this.content = content;
		this.userId = userId;
		this.created = created;
	}

	public Integer getId() {
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

	public Integer getUserId() {
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
