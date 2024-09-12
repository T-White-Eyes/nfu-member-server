package com.nfu.member.service.member.interest.category

import com.nfu.member.entity.member.interest.category.MemberInterestCategory
import com.nfu.member.repository.member.interest.category.MemberInterestCategoryRepository
import com.nfu.member.repository.member.interest.category.QMemberInterestCategoryRepository
import org.springframework.stereotype.Service

@Service
class MemberInterestCategoryService(
    private val memberInterestCategoryRepository: MemberInterestCategoryRepository,
    private val qMemberInterestCategoryRepository: QMemberInterestCategoryRepository,
) {
}