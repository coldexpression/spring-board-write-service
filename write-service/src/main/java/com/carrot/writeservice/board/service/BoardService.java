package com.carrot.writeservice.board.service;

import com.carrot.writeservice.board.model.SaveBoardParam;
import com.carrot.writeservice.board.model.SearchBoardModel;
import com.carrot.writeservice.board.repository.BoardRepository;
import com.carrot.writeservice.common.FileUtils;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class BoardService {

    private final BoardRepository boardRepository;
    private final FileUtils fileUtils;

    public List<SearchBoardModel> searchBoardInfos() {
        List<SearchBoardModel> searchBoardModels = boardRepository.selectBoardInfos();
        SearchBoardModel searchBoardModel = searchBoardModels.get(0);
        log.info("title = {}", searchBoardModel.getTitle());
        log.info("path = {}", searchBoardModel.getPath());
        log.info("date = {}", searchBoardModel.getDate());
        return boardRepository.selectBoardInfos();
    }

    public SearchBoardModel searchBoardInfo(Long id) {
        return boardRepository.selectBoardInfo(id);
    }

    public void saveBoardInfo(String title, MultipartHttpServletRequest multipartHttpServletRequest) throws Exception {
        log.info("title = {}" , title);
        SaveBoardParam saveBoardParam = fileUtils.parseFileInfo(title, multipartHttpServletRequest);
        boardRepository.postBoardInfo(saveBoardParam);
    }
}
