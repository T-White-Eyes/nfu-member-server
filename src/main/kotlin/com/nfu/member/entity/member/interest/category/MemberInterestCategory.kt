package com.nfu.member.entity.member.interest.category

import com.nfu.member.entity.base.CreatedTimeEntity
import com.nfu.member.entity.member.interest.category.id.MemberInterestCategoryId
import jakarta.persistence.EmbeddedId
import jakarta.persistence.Entity
import jakarta.persistence.Table

@Entity
@Table(name = "member_interest_category")
class MemberInterestCategory(

    @EmbeddedId
    val id: MemberInterestCategoryId,
): CreatedTimeEntity() {
}