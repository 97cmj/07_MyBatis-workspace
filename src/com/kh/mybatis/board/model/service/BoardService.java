package com.kh.mybatis.board.model.service;

import java.util.ArrayList;
import java.util.HashMap;

import com.kh.mybatis.board.model.vo.Board;
import com.kh.mybatis.board.model.vo.Reply;
import com.kh.mybatis.common.model.vo.PageInfo;



public interface BoardService {

    // 게시글 리스트 조회 (페이징 처리)
    int selectListCount();

    ArrayList<Board> selectList(PageInfo pi);

    //댓글 리스트 조회
    ArrayList<Reply> selectReplyList(int bno);
    
    //게시글 검색 기능 (페이징 처리)
    int selectSearchCount(HashMap<String, String> map);
    
    //검색 리스트 조회
    ArrayList<Board> selectSearchList(HashMap<String, String> map, PageInfo pi);
    
    //조회수 증가
    int increaseCount(int bno);

    //게시글 상세 조회
    Board selectBoard(int bno);

    //게시글 등록
    int insertBoard(Board b);

    //게시글 수정
    int updateBoard(Board b);

    //게시글 삭제
    int deleteBoard(int bno);



}
