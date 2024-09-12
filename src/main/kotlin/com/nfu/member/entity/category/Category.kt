package com.nfu.member.entity.category

import com.nfu.member.entity.base.CreatedAndUpdatedTimeEntity
import jakarta.persistence.*

@Entity
@Table(name = "category")
class Category(

    @Column(name = "name", length = 255)
    val name: String
): CreatedAndUpdatedTimeEntity() {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", columnDefinition = "INT")
    val id: Long = 0

    @Column(name = "is_enabled", columnDefinition = "TINYINT", length = 1)
    val isEnabled: Boolean = true

    @Column(name = "is_deleted", columnDefinition = "TINYINT", length = 1)
    val isDeleted: Boolean = false
}