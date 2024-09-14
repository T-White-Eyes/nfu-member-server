package com.nfu.member.repository.category

import com.nfu.member.entity.category.Category
import org.springframework.data.jpa.repository.JpaRepository

interface CategoryRepository: JpaRepository<Category, Long> {
}