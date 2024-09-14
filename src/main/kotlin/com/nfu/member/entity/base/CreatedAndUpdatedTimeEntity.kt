package com.nfu.member.entity.base

import jakarta.persistence.EntityListeners
import jakarta.persistence.MappedSuperclass
import org.springframework.data.annotation.CreatedDate
import org.springframework.data.annotation.LastModifiedDate
import org.springframework.data.jpa.domain.support.AuditingEntityListener
import java.time.OffsetDateTime

@MappedSuperclass
@EntityListeners(AuditingEntityListener::class)
class CreatedAndUpdatedTimeEntity {

    @CreatedDate
    lateinit var createdAt: OffsetDateTime

    @LastModifiedDate
    lateinit var updatedAt: OffsetDateTime
}