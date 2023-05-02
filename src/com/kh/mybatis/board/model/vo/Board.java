package com.kh.mybatis.board.model.vo;

import java.sql.Date;

import lombok.Data;

@Data
public class Board {

	private int boardNo;
	private String boardTitle;
	private String boardContent;
	private String boardWriter;
	private int count;
	private Date createDate;
	private String status;

	public Board() {
	}

	public Board(int boardNo, String boardTitle, String boardContent, String boardWriter, int count, Date createDate,
			String status) {
		super();
		this.boardNo = boardNo;
		this.boardTitle = boardTitle;
		this.boardContent = boardContent;
		this.boardWriter = boardWriter;
		this.count = count;
		this.createDate = createDate;
		this.status = status;
	}

}
