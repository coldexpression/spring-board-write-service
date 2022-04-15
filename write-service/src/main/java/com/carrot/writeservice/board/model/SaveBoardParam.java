package com.carrot.writeservice.board.model;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@Builder
public class SaveBoardParam {

    private String fileName;
    private String title;
    private String path;
}
