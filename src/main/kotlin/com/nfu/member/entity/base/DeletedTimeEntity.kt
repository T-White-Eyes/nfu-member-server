package com.nfu.member.entity.base

import jakarta.persistence.Column
import jakarta.persistence.EntityListeners
import jakarta.persistence.MappedSuperclass
import org.springframework.data.jpa.domain.support.AuditingEntityListener
import java.time.OffsetDateTime

@MappedSuperclass
class DeletedTimeEntity {

    @Column(name = "deleted_at")
    val deletedAt: OffsetDateTime? = null
}