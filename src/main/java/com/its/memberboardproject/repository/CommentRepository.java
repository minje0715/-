package com.its.memberboardproject.repository;

import com.its.memberboardproject.dto.BoardDTO;
import com.its.memberboardproject.dto.CommentDTO;
import com.its.memberboardproject.entity.CommentEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CommentRepository extends JpaRepository<CommentEntity, Long> {

    List<CommentEntity> findByBoardId(Long bid);
}
