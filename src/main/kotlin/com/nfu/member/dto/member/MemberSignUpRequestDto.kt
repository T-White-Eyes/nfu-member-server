package com.nfu.member.dto.member

import com.nfu.member.constant.policy.member.MemberPolicy
import com.nfu.member.exception.ApiException
import com.nfu.member.exception.constant.ApiError
import com.nfu.member.util.kotlin.isNotMatches
import java.util.regex.Pattern

class MemberSignUpRequestDto(
    val authPlatformTypeId: Short,
    val authPlatformId: String,
    val email: String,
    val nickname: String,
    val password: String? = null,
    val isIncludeWeekend: Boolean,
) {

    fun verify() {
        verifyAuthPlatformId()
        verifyEmail()
        verifyNickname()
        verifyPassword()
    }

    private fun verifyAuthPlatformId() {
        if (this.authPlatformId.isBlank()) {
            throw ApiException(ApiError.INVALID_AUTH_PLATFORM_ID)
        }
    }

    private fun verifyEmail() {
        val memberEmailPatternMatcher = Pattern.compile(MemberPolicy.MEMBER_EMAIL_REGEX).matcher(this.email)
        if (memberEmailPatternMatcher.isNotMatches()) {
            throw ApiException(ApiError.INVALID_EMAIL)
        }
    }

    private fun verifyNickname() {
        val memberNicknamePatternMatcher = Pattern.compile(MemberPolicy.MEMBER_NICKNAME_REGEX).matcher(this.nickname)
        if (memberNicknamePatternMatcher.isNotMatches()) {
            throw ApiException(ApiError.INVALID_NICKNAME)
        }
    }

    private fun verifyPassword() {
        if (this.password.isNullOrBlank()) {
            return
        }

        val memberPasswordPatternMatcher = Pattern.compile(MemberPolicy.MEMBER_PASSWORD_REGEX).matcher(this.password)
        if (memberPasswordPatternMatcher.isNotMatches()) {
            throw ApiException(ApiError.INVALID_PASSWORD)
        }
    }
}