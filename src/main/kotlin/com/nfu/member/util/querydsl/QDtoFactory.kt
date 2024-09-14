package com.nfu.member.util.querydsl

import com.nfu.member.dto.member.QMemberDto
import com.nfu.member.entity.member.QMember.member

object QDtoFactory {

    fun createQMemberDto() = QMemberDto(
        member.id,
        member.authPlatformTypeId,
        member.authPlatformId,
        member.email,
        member.nickname,
        member.isIncludeWeekend
    )
}