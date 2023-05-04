package com.kh.mybatis.board.model.vo;

import java.sql.Date;

import lombok.Data;

@Data
public class Reply {

	private int replyNo;
	private String replyContent;
	private int refBno;
	private String replyWriter;
	private Date createDate;
	private String status;

	public Reply() {
	}

	public Reply(int replyNo, String replyContent, int refBno, String replyWriter, Date createDate, String status) {
		super();
		this.replyNo = replyNo;
		this.replyContent = replyContent;
		this.refBno = refBno;
		this.replyWriter = replyWriter;
		this.createDate = createDate;
		this.status = status;
	}

}
