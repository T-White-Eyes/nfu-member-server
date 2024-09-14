package com.nfu.member.dto.member

class MemberTokenRequestDto(
    val authPlatformTypeId: Short,
    val authPlatformId: String,
    val email: String,
    val password: String? = null,
) {
}