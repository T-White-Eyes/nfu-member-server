package com.nfu.member.service.member

import com.nfu.member.dto.member.MemberDto
import com.nfu.member.dto.member.MemberTokenDto
import com.nfu.member.util.jwt.JwtGenerator
import com.nfu.member.vo.jwt.Claim
import org.springframework.stereotype.Service

@Service
class MemberTokenService(
    private val jwtGenerator: JwtGenerator,
) {

    fun generateTokens(memberDto: MemberDto): MemberTokenDto {
        val claim = Claim.fromMemberDto(memberDto)

        val accessToken = jwtGenerator.generateAccessToken(claim)
        val refreshToken = jwtGenerator.generateRefreshToken(claim)

        return MemberTokenDto(memberDto, accessToken, refreshToken)
    }
}