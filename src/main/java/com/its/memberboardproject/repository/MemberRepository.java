package com.its.memberboardproject.repository;

import com.its.memberboardproject.entity.MemberEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface MemberRepository extends JpaRepository <MemberEntity, Long> {

    Optional<MemberEntity> findByMemberEmail(String memberEmail);
}
