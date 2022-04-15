package com.carrot.writeservice.board.model;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class SearchBoardModel {

    private long id;
    private String path;
    private String title;
    private String imgName;
    private String date;
}
