package com.its.memberboardproject.repository;

import com.its.memberboardproject.dto.BoardDTO;
import com.its.memberboardproject.entity.BoardEntity;
import com.its.memberboardproject.entity.CommentEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BoardRepository extends JpaRepository<BoardEntity, Long> {

    @Modifying
    @Query(value = "update Board_table b set b.board_hits = b.board_hits + 1 where b.bid = :bid", nativeQuery = true)
    void boardHits(@Param("bid") Long bid);

    Page<BoardEntity> findByBoardTitleContaining(String q, Pageable paging);

    Page<BoardEntity> findByBoardContentsContaining(String q, Pageable paging);

}
