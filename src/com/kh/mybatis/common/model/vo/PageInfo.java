package com.kh.mybatis.common.model.vo;

import lombok.Data;

@Data
public class PageInfo {

    private int listCount; // 총 게시글 갯수
    private int currentPage; // 현재 페이지 (즉, 요청한 페이지)
    private int pageLimit; // 한 페이지 하단에 보여질 페이지 최대 갯수 (1,2,3,4,5,6,7,8,9,10)
    private int boardLimit; // 한 페이지내에 보여질 게시글 최대 갯수 (10개)
    private int maxPage; // 전체 페이지들 중에서의 가장 마지막 페이지 (listCount, boardLimit을 가지고 구할 예정)
    private int startPage; // 현재 페이지에 하단에 보여질 페이징 바의 시작수 (1, 11, 21, 31, ...) (pageLimit, currentPage를 가지고 구할 예정)
    private int endPage; // 현재 페이지에 하단에 보여질 페이징 바의 끝 수 (10, 20, 30, 40, ...) (startPage, pageLimit, maxPage 를 가지고 구할 예정)
	
    public PageInfo() {}
    
    public PageInfo(int listCount, int currentPage, int pageLimit, int boardLimit, int maxPage, int startPage,
			int endPage) {
		super();
		this.listCount = listCount;
		this.currentPage = currentPage;
		this.pageLimit = pageLimit;
		this.boardLimit = boardLimit;
		this.maxPage = maxPage;
		this.startPage = startPage;
		this.endPage = endPage;
	}

}
