package com.nfu.member.entity.base

import jakarta.persistence.Column
import jakarta.persistence.EntityListeners
import jakarta.persistence.MappedSuperclass
import org.springframework.data.annotation.CreatedDate
import org.springframework.data.jpa.domain.support.AuditingEntityListener
import java.time.OffsetDateTime

@MappedSuperclass
@EntityListeners(AuditingEntityListener::class)
class CreatedTimeEntity {

    @CreatedDate
    @Column(name = "created_at")
    val createdAt: OffsetDateTime = OffsetDateTime.now()
}