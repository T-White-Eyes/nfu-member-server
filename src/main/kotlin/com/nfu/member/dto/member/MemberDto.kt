package com.nfu.member.dto.member

import com.nfu.member.constant.auth.AuthPlatFormType
import com.nfu.member.entity.member.Member
import com.querydsl.core.annotations.QueryProjection

class MemberDto @QueryProjection constructor(
    val id: Long,
    val authPlatFormType: AuthPlatFormType,
    val authPlatformId: String,
    val email: String,
    val nickname: String,
    val isIncludeWeekend: Boolean,
) {

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