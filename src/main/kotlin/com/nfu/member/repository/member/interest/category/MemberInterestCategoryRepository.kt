package com.nfu.member.repository.member.interest.category

import com.nfu.member.entity.member.interest.category.MemberInterestCategory
import com.nfu.member.entity.member.interest.category.id.MemberInterestCategoryId
import org.springframework.data.jpa.repository.JpaRepository

interface MemberInterestCategoryRepository: JpaRepository<MemberInterestCategory, MemberInterestCategoryId> {
}