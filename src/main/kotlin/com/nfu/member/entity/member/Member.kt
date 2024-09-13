package com.nfu.member.entity.member

import com.nfu.member.dto.member.MemberSignUpRequestDto
import com.nfu.member.entity.auth.AuthPlatformType
import com.nfu.member.entity.base.BaseTimeEntity
import com.nfu.member.util.kotlin.isNotNullOrNotBlank
import jakarta.persistence.*
import org.springframework.security.crypto.password.PasswordEncoder

@Entity
@Table(name = "member")
class Member(

    @Column(name = "auth_platform_type_id")
    val authPlatformTypeId: Short,

    @Column(name = "auth_platform_id", length = 1023, unique = true)
    val authPlatformId: String,

    @Column(name = "email", length = 511, unique = true)
    val email: String,

    @Column(name = "nickname", length = 63, unique = true)
    val nickname: String,

    @Column(name = "password", length = 511)
    val password: String? = null,

    @Column(name = "is_include_weekend", columnDefinition = "TINYINT", length = 1)
    val isIncludeWeekend: Boolean,
): BaseTimeEntity() {

    @Id
    @Column(name = "id", columnDefinition = "INT")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "auth_platform_type_id", insertable = false, updatable = false)
    lateinit var authPlatformType: AuthPlatformType

    @Column(name = "is_deleted", columnDefinition = "TINYINT", length = 1)
    val isDeleted: Boolean = false

    companion object {

        fun fromMemberSignUpRequestDto(
            memberSignUpRequestDto: MemberSignUpRequestDto,
            passwordEncoder: PasswordEncoder
        ): Member {
            val encodedPassword = if (memberSignUpRequestDto.password.isNotNullOrNotBlank()) {
                passwordEncoder.encode(memberSignUpRequestDto.password)
            } else {
                null
            }

            return Member(
                memberSignUpRequestDto.authPlatformTypeId,
                memberSignUpRequestDto.authPlatformId,
                memberSignUpRequestDto.email,
                memberSignUpRequestDto.nickname,
                encodedPassword,
                memberSignUpRequestDto.isIncludeWeekend
            )
        }
    }
}