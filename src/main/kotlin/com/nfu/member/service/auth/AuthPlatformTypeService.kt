package com.nfu.member.service.auth

import com.nfu.member.repository.auth.AuthPlatformTypeRepository
import org.springframework.stereotype.Service

@Service
class AuthPlatformTypeService(
    private val authPlatformTypeRepository: AuthPlatformTypeRepository,
) {
}