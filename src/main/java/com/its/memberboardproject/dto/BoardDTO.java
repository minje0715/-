package com.its.memberboardproject.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.web.multipart.MultipartFile;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BoardDTO {
    private Long bid;
    private String boardTitle;
    private String boardContents;
    private int boardHits;

    private LocalDateTime createdTime;
    private LocalDateTime updatedTime;

    private String boardFileName;
    private MultipartFile boardFile;

}
