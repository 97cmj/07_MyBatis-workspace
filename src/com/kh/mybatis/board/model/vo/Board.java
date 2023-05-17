package com.kh.mybatis.board.model.vo;

import java.sql.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

public class Board {

	private int boardNo;
	private String boardTitle;
	private String boardWriter;
	private int count;
	private Date createDate;
	
	

}
