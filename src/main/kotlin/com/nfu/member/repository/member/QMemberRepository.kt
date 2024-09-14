package com.nfu.member.repository.member

import com.nfu.member.dto.member.MemberDto
import com.nfu.member.entity.member.QMember.member
import com.nfu.member.util.kotlin.isNotNull
import com.nfu.member.util.querydsl.QDtoFactory
import com.querydsl.jpa.impl.JPAQueryFactory
import org.springframework.stereotype.Repository

@Repository
class QMemberRepository(
    private val queryFactory: JPAQueryFactory,
) {

    fun existsByAuthPlatformId(authPlatformId: String): Boolean {
        return queryFactory
            .select(member.id)
            .from(member)
            .where(member.authPlatformId.eq(authPlatformId))
            .fetchOne()
            .isNotNull()
    }

    fun existsByEmail(email: String): Boolean {
        return queryFactory
            .select(member.id)
            .from(member)
            .where(member.email.eq(email))
            .fetchOne()
            .isNotNull()
    }

    fun existsByNickname(nickname: String): Boolean {
        return queryFactory
            .select(member.id)
            .from(member)
            .where(member.nickname.eq(nickname))
            .fetchOne()
            .isNotNull()
    }

    fun findMemberDtoById(memberId: Long): MemberDto? {
        return queryFactory
            .select(QDtoFactory.createQMemberDto())
            .from(member)
            .where(member.id.eq(memberId))
            .fetchOne()
    }
}