package com.its.memberboardproject.entity;

import com.its.memberboardproject.dto.MemberDTO;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter @Setter
@Table (name = "memberboard_table")
public class MemberEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Long id;

    @Column(unique = true)
    private String memberEmail;

    @Column
    private String memberPassword;

    @Column
    private String memberName;

    @Column
    private String memberPhone;

    @Column
    private String memberFileName;

    @OneToMany(mappedBy = "memberEntity", cascade = CascadeType.PERSIST, orphanRemoval = false, fetch = FetchType.LAZY)
    private List<BoardEntity> boardEntityList = new ArrayList<>();

//    @OneToMany(mappedBy = "memberEntity" , cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
//    private List<CommentEntity> commentEntityList = new ArrayList<>();

    public static MemberEntity toSaveEntity(MemberDTO memberDTO) {
        MemberEntity memberEntity = new MemberEntity();
        memberEntity.setMemberEmail(memberDTO.getMemberEmail());
        memberEntity.setMemberPassword(memberDTO.getMemberPassword());
        memberEntity.setMemberName(memberDTO.getMemberName());
        memberEntity.setMemberPhone(memberDTO.getMemberPhone());
        memberEntity.setMemberFileName(memberDTO.getMemberFileName());
        return memberEntity;
    }

    public static MemberEntity toUpdateEntity(MemberDTO memberDTO) {
        MemberEntity memberEntity = new MemberEntity();
        memberEntity.setId(memberDTO.getId());
        memberEntity.setMemberEmail(memberDTO.getMemberEmail());
        memberEntity.setMemberPassword(memberDTO.getMemberPassword());
        memberEntity.setMemberName(memberDTO.getMemberName());
        memberEntity.setMemberPhone(memberDTO.getMemberPhone());
        memberEntity.setMemberFileName(memberDTO.getMemberFileName());
        return memberEntity;
    }
}
