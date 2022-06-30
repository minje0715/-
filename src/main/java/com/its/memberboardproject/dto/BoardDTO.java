package com.its.memberboardproject.dto;

import com.its.memberboardproject.entity.BoardEntity;
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
    private String boardWriter;
    private String boardContents;
    private int boardHits;

    private LocalDateTime createdTime;
    private LocalDateTime updatedTime;

    private String boardFileName;
    private MultipartFile boardFile;

    public static BoardDTO toBoardDTO(BoardEntity boardEntity) {
        BoardDTO boardDTO = new BoardDTO();
        boardDTO.setBid(boardEntity.getBid());
        boardDTO.setBoardTitle(boardEntity.getBoardTitle());
        boardDTO.setBoardWriter(boardEntity.getBoardWriter());
        boardDTO.setBoardContents(boardEntity.getBoardContents());
        boardDTO.setBoardHits(boardEntity.getBoardHits());
        boardDTO.setCreatedTime(boardEntity.getCreatedTime());
        boardDTO.setUpdatedTime(boardEntity.getUpdatedTime());
        boardDTO.setBoardFileName(boardEntity.getBoardFileName());
        return boardDTO;
    }
}
