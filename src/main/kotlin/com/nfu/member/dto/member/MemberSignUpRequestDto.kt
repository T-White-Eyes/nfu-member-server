package com.nfu.member.dto.member

class MemberSignUpRequestDto(
    val authPlatformTypeId: Short,
    val authPlatformId: String,
    val email: String,
    val nickname: String,
    val password: String? = null,
    val isIncludeWeekend: Boolean,
) {
}