package com.nfu.member.repository.member

import com.querydsl.jpa.impl.JPAQueryFactory
import org.springframework.stereotype.Repository

@Repository
class QMemberRepository(
    private val queryFactory: JPAQueryFactory,
) {
}