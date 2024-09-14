package com.nfu.member.entity.member.interest.category.id

import com.nfu.member.entity.category.Category
import com.nfu.member.entity.member.Member
import jakarta.persistence.*
import java.io.Serializable

@Embeddable
class MemberInterestCategoryId(

    @Column(name = "member_id", columnDefinition = "INT")
    val memberId: Long,

    @Column(name = "category_id", columnDefinition = "INT")
    val categoryId: Long,
): Serializable {

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id", insertable = false, updatable = false)
    lateinit var member: Member

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "category_id", insertable = false, updatable = false)
    lateinit var category: Category
}