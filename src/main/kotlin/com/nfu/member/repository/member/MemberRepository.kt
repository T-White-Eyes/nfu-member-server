package com.nfu.member.repository.member

import com.nfu.member.entity.member.Member
import org.springframework.data.jpa.repository.JpaRepository

interface MemberRepository: JpaRepository<Member, Long> {
}