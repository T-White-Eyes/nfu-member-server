package com.nfu.member.service.member

import com.nfu.member.repository.member.MemberRepository
import com.nfu.member.repository.member.QMemberRepository
import org.springframework.stereotype.Service

@Service
class MemberService(
    private val memberRepository: MemberRepository,
    private val qMemberRepository: QMemberRepository,
) {
}