package com.its.memberboardproject.entity;

import com.its.memberboardproject.dto.CommentDTO;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Controller;

import javax.persistence.*;
    @Entity
    @Getter
    @Setter
    @Table(name = "comment_table")
    public class CommentEntity extends BaseEntity{
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column
        private Long cid;

        @Column
        private Long boardId;

        @Column
        private String commentWriter;

        @Column
        private String commentContents;

        @ManyToOne(fetch = FetchType.LAZY)
        @JoinColumn(name = "id") // 참조하는 테이블의 실제 컬럼 이름을 줘야함
        private MemberEntity memberEntity;


        @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.REMOVE)
        @JoinColumn(name = "bid")
        private BoardEntity boardEntity;

        public static  CommentEntity toSaveEntity(CommentDTO commentDTO, BoardEntity boardEntity, MemberEntity memberEntity) {
            CommentEntity commentEntity = new CommentEntity();
            commentEntity.setCommentWriter(memberEntity.getMemberEmail());
            commentEntity.setCommentContents(commentDTO.getCommentContents());
            commentEntity.setBoardId(boardEntity.getBid());
            commentEntity.setBoardEntity(boardEntity);
            commentEntity.setMemberEntity(memberEntity);
            return commentEntity;
        }
    }


