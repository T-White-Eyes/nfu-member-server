package com.nfu.member.repository.member.interest.category

import com.querydsl.jpa.impl.JPAQueryFactory
import org.springframework.stereotype.Repository

@Repository
class QMemberInterestCategoryRepository(
    private val queryFactory: JPAQueryFactory,
) {
}