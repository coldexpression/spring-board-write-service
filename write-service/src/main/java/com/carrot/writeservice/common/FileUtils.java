package com.carrot.writeservice.common;

import com.carrot.writeservice.board.model.SaveBoardParam;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Component;
import org.springframework.util.ObjectUtils;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import java.io.File;
import java.io.IOException;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Iterator;
import java.util.List;

@Component
public class FileUtils {

    public SaveBoardParam parseFileInfo(String title, MultipartHttpServletRequest multipartHttpServletRequest) throws Exception {
        if (ObjectUtils.isEmpty(multipartHttpServletRequest)) return null;
        ZonedDateTime current = ZonedDateTime.now();
        DateTimeFormatter format = DateTimeFormatter.ofPattern("yyyyMMdd");
        String path = "images/" + current.format(format);
        File file = new File(path);
        if (!file.exists()) file.mkdirs();

        Iterator<String> fileNames = multipartHttpServletRequest.getFileNames();
        while(fileNames.hasNext()) {
            String originalFileExtension = "";
            List<MultipartFile> files = multipartHttpServletRequest.getFiles(fileNames.next());
            for (MultipartFile multipartFile : files) {
                if (!multipartFile.isEmpty()) {
                    String contentType = multipartFile.getContentType();
                    if (ObjectUtils.isEmpty(contentType)) break;
                    if (contentType.contains("image/jpeg")) originalFileExtension = ".jpg";
                    else if (contentType.contains("image/png")) originalFileExtension = ".png";
                    else if (contentType.contains("image/gif")) originalFileExtension = ".gif";
                    else break;
                }
                String newFileName = Long.toString(System.nanoTime()) + originalFileExtension;
                SaveBoardParam saveBoardParam = SaveBoardParam.builder()
                        .title(title)
                        .path(path + "/" + newFileName)
                        .fileName(multipartFile.getOriginalFilename())
                        .build();
                file = new File(path + "/" + newFileName);
                multipartFile.transferTo(file);
                return saveBoardParam;
            }
        }
        return null;
    }
}
