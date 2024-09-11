package com.nfu.member.entity.member

import com.nfu.member.entity.auth.AuthPlatformType
import jakarta.persistence.*
import java.time.OffsetDateTime

@Entity
@Table(name = "member")
class Member(

    @Column(name = "auth_platform_type_id")
    val authPlatformTypeId: Short,

    @Column(name = "auth_platform_id", length = 1023)
    val authPlatformId: String,

    @Column(name = "email", length = 511)
    val email: String,

    @Column(name = "nickname", length = 63)
    val nickname: String,

    @Column(name = "password", length = 511)
    val password: String? = null,

    @Column(name = "is_include_weekend", columnDefinition = "TINYINT", length = 1)
    val isIncludeWeekend: Boolean,
) {

    @Id
    @Column(name = "id", columnDefinition = "INT")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "auth_platform_type_id", insertable = false, updatable = false)
    lateinit var authPlatformType: AuthPlatformType

    @Column(name = "is_deleted", columnDefinition = "TINYINT", length = 1)
    val isDeleted: Boolean = false

    @Column(name = "created_at")
    val createdAt: OffsetDateTime = OffsetDateTime.now()

    @Column(name = "updated_at")
    val updatedAt: OffsetDateTime = OffsetDateTime.now()

    @Column(name = "deleted_at")
    val deletedAt: OffsetDateTime = OffsetDateTime.now()
}