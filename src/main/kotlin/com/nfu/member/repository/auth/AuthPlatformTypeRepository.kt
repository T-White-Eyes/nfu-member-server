package com.nfu.member.repository.auth

import com.nfu.member.entity.auth.AuthPlatformType
import org.springframework.data.jpa.repository.JpaRepository

interface AuthPlatformTypeRepository: JpaRepository<AuthPlatformType, Short> {
}