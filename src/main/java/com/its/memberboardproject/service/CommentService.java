package com.its.memberboardproject.service;

import com.its.memberboardproject.dto.CommentDTO;
import com.its.memberboardproject.entity.BoardEntity;
import com.its.memberboardproject.entity.CommentEntity;
import com.its.memberboardproject.entity.MemberEntity;
import com.its.memberboardproject.repository.BoardRepository;
import com.its.memberboardproject.repository.CommentRepository;
import com.its.memberboardproject.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CommentService {
    private final CommentRepository commentRepository;
    private final BoardRepository boardRepository;

    private final MemberRepository memberRepository ;

    public Long save(CommentDTO commentDTO) {
       Optional<BoardEntity> optionalBoardEntity = boardRepository.findById(commentDTO.getBoardId());
        Optional<MemberEntity> optionMemberEntity = memberRepository.findByMemberEmail(commentDTO.getCommentWriter());
        if(optionMemberEntity.isPresent()){
            MemberEntity memberEntity = optionMemberEntity.get();
            if(optionalBoardEntity.isPresent()){
                BoardEntity boardEntity = optionalBoardEntity.get();
                CommentEntity commentEntity = CommentEntity.toSaveEntity(commentDTO, boardEntity, memberEntity);
                Long savedId = commentRepository.save(commentEntity).getCid();
                return savedId;
            }else{
                return null;
        }
        }else {
            return null;
        }
    }

    public List<CommentDTO> findByBoardId(Long boardId) {
       List<CommentEntity> commentEntityList = commentRepository.findByBoardId(boardId);
       List<CommentDTO> commentDTOList = new ArrayList<>();
       for(CommentEntity comment: commentEntityList){
           commentDTOList.add(CommentDTO.toDTO(comment));
       }return commentDTOList;
    }

}
