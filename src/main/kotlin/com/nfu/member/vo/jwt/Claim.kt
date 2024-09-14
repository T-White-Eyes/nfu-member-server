package com.nfu.member.vo.jwt

import com.nfu.member.dto.member.MemberDto

class Claim(
    val id: Long,
    val email: String,
) {

    companion object {

        fun fromMemberDto(memberDto: MemberDto): Claim {
            return Claim(memberDto.id, memberDto.email)
        }
    }
}