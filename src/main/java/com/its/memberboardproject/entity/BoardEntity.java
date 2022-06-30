package com.its.memberboardproject.entity;

import com.its.memberboardproject.dto.BoardDTO;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@Table(name = "board_table")
public class BoardEntity extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Long bid;

    @Column
    private String boardTitle;

    @Column
    private String boardWriter;

    @Column
    private String boardContents;

    @Column
    private int boardHits;


    @Column
    private String boardFileName;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id")
    private MemberEntity memberEntity;


    public static BoardEntity toSaveEntity(BoardDTO boardDTO, MemberEntity memberEntity) {
        BoardEntity boardEntity = new BoardEntity();
        boardEntity.setBid(boardDTO.getBid());
        boardEntity.setBoardTitle(boardDTO.getBoardTitle());
        boardEntity.setBoardWriter(boardDTO.getBoardWriter());
        boardEntity.setBoardContents(boardDTO.getBoardContents());
        boardEntity.setBoardHits(0);
        boardEntity.setBoardFileName(boardDTO.getBoardFileName());
        boardEntity.setMemberEntity(memberEntity);
        return boardEntity;
    }

    public static BoardEntity toUpdateEntity(BoardDTO boardDTO) {
        BoardEntity boardEntity = new BoardEntity();
        boardEntity.setBid(boardDTO.getBid());
        boardEntity.setBoardTitle(boardDTO.getBoardTitle());
        boardEntity.setBoardWriter(boardDTO.getBoardWriter());
        boardEntity.setBoardContents(boardDTO.getBoardContents());
        boardEntity.setBoardHits(boardDTO.getBoardHits());
        boardEntity.setBoardFileName(boardDTO.getBoardFileName());
        return boardEntity;
    }
}
