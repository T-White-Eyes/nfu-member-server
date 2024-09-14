package com.nfu.member.dto.member

import com.nfu.member.constant.auth.AuthPlatFormType
import com.nfu.member.entity.member.Member
import com.querydsl.core.annotations.QueryProjection

class MemberDto(
    val id: Long,
    val authPlatFormType: AuthPlatFormType,
    val authPlatformId: String,
    val email: String,
    val nickname: String,
    val isIncludeWeekend: Boolean,
) {

    @QueryProjection
    constructor(
        id: Long,
        authPlatFormTypeId: Short,
        authPlatformId: String,
        email: String,
        nickname: String,
        isIncludeWeekend: Boolean,
    ): this(
        id = id,
        authPlatFormType = AuthPlatFormType.getById(authPlatFormTypeId),
        authPlatformId = authPlatformId,
        email = email,
        nickname = nickname,
        isIncludeWeekend = isIncludeWeekend
    )

    companion object {

        fun fromMember(member: Member): MemberDto {
            return MemberDto(
                id = member.id,
                authPlatFormType = AuthPlatFormType.getById(member.authPlatformTypeId),
                authPlatformId = member.authPlatformId,
                email = member.email,
                nickname = member.nickname,
                isIncludeWeekend = member.isIncludeWeekend
            )
        }
    }
}