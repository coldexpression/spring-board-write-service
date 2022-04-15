package com.carrot.writeservice.board.repository;

import com.carrot.writeservice.board.model.SaveBoardParam;
import com.carrot.writeservice.board.model.SearchBoardModel;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
public interface BoardRepository {

    // 게시글 전체 조회
    List<SearchBoardModel> selectBoardInfos();

    // 게시글 개별 조회
    SearchBoardModel selectBoardInfo(Long id);

    // 게시글 저장
    void postBoardInfo(SaveBoardParam saveBoardParam);
}
