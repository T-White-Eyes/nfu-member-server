package com.nfu.member.repository.category

import com.querydsl.jpa.impl.JPAQueryFactory
import org.springframework.stereotype.Repository

@Repository
class QCategoryRepository(
    private val queryFactory: JPAQueryFactory,
) {
}