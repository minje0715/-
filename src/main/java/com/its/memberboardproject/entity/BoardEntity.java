package com.its.memberboardproject.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter @Setter
@Table(name = "board_table")
public class BoardEntity extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "board_id")
    private Long bid;

    @Column(name = "board_title")
    private String boardTitle;

    @Column(name = "board_contents")
    private String boardContents;

    @Column(name = "board_hits")
    private int boardHits;


    @Column
    private String boardFileName;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id")
    private MemberEntity memberEntity;


}
