package com.nfu.member.service.member

import com.nfu.member.dto.member.MemberDto
import com.nfu.member.dto.member.MemberSignUpRequestDto
import com.nfu.member.entity.member.Member
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.stereotype.Service

@Service
class MemberSignUpService(
    private val memberService: MemberService,
    private val passwordEncoder: PasswordEncoder,
) {

    fun signUp(memberSignUpRequestDto: MemberSignUpRequestDto): MemberDto {
        val member = Member.fromMemberSignUpRequestDto(memberSignUpRequestDto, passwordEncoder)

        return memberService.save(member)
            .let {
                MemberDto.fromMember(it)
            }
    }
}