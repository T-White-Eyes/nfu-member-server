package com.nfu.member.entity.base

import jakarta.persistence.Column
import jakarta.persistence.EntityListeners
import jakarta.persistence.MappedSuperclass
import org.springframework.data.annotation.CreatedDate
import org.springframework.data.annotation.LastModifiedDate
import org.springframework.data.jpa.domain.support.AuditingEntityListener
import java.time.OffsetDateTime

@MappedSuperclass
@EntityListeners(AuditingEntityListener::class)
class BaseTimeEntity {

    @CreatedDate
    @Column(name = "created_at")
    lateinit var createdAt: OffsetDateTime

    @LastModifiedDate
    @Column(name = "updated_at")
    lateinit var updatedAt: OffsetDateTime

    @Column(name = "deleted_at")
    val deletedAt: OffsetDateTime? = null
}