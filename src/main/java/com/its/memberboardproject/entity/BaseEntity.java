package com.its.memberboardproject.entity;
import lombok.Getter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.Column;
import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import java.time.LocalDateTime;

@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
@Getter
public class BaseEntity {
    @CreationTimestamp
    @Column(updatable = false)
    private LocalDateTime createdTime; // insert가 발생했을 때에 시간에만 관여

    @UpdateTimestamp
    @Column(insertable = false)
    private LocalDateTime updatedTime; // update쿼리가 나갔을 때만 관여
}

