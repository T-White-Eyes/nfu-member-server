package com.nfu.member.dto.member

import com.nfu.member.constant.jwt.JwtPrefix

class MemberTokenDto(
    val member: MemberDto,
    val accessToken: String,
    val refreshToken: String,
) {
    val tokenPrefix: String = JwtPrefix.BEARER
}