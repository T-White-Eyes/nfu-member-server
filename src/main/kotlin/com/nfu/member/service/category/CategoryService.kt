package com.nfu.member.service.category

import com.nfu.member.entity.category.Category
import com.nfu.member.repository.category.CategoryRepository
import com.nfu.member.repository.category.QCategoryRepository
import org.springframework.stereotype.Service

@Service
class CategoryService(
    private val categoryRepository: CategoryRepository,
    private val qCategoryRepository: QCategoryRepository,
) {
}