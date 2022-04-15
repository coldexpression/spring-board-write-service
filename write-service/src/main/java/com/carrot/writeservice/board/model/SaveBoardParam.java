package com.carrot.writeservice.board.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@Builder
public class SaveBoardParam {

    private String fileName;
    private String title;
    private String path;
}
