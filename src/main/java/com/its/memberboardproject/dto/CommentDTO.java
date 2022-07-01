package com.its.memberboardproject.dto;

import com.its.memberboardproject.entity.CommentEntity;
import lombok.Data;

import java.time.LocalDateTime;
    @Data
    public class CommentDTO {
        private Long cid;
        private Long boardId;
        private String commentWriter;
        private String commentContents;
        private LocalDateTime createdTime;
        private LocalDateTime updatedTime;




        public static CommentDTO toDTO(CommentEntity commentEntity) {
            CommentDTO commentDTO = new CommentDTO();
            commentDTO.setCid(commentEntity.getCid());
            commentDTO.setBoardId(commentEntity.getBoardId());
            commentDTO.setCommentWriter(commentEntity.getCommentWriter());
            commentDTO.setCommentContents(commentEntity.getCommentContents());
            commentDTO.setCreatedTime(commentEntity.getCreatedTime());
            return commentDTO;
        }
    }
