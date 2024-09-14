package com.nfu.member.service.member

import com.nfu.member.constant.policy.member.MemberPolicy
import com.nfu.member.dto.member.MemberDto
import com.nfu.member.dto.member.MemberSignUpRequestDto
import com.nfu.member.dto.member.MemberTokenRequestDto
import com.nfu.member.exception.ApiException
import com.nfu.member.exception.constant.ApiError
import com.nfu.member.util.kotlin.alsoIfTrue
import com.nfu.member.util.kotlin.isNotMatches
import org.springframework.stereotype.Service
import java.util.regex.Pattern

@Service
class MemberValidationService(
    private val memberService: MemberService,
) {

    fun validateForSignUp(memberSignUpRequestDto: MemberSignUpRequestDto) {
        validateAuthPlatformId(memberSignUpRequestDto.authPlatformId)
        validateEmail(memberSignUpRequestDto.email)
        validateNickname(memberSignUpRequestDto.nickname)
        validatePassword(memberSignUpRequestDto.password)

        validateExistsAuthPlatformId(memberSignUpRequestDto.authPlatformId)
        validateExistsEmail(memberSignUpRequestDto.email)
        validateExistsNickname(memberSignUpRequestDto.nickname)
    }

    fun validateForGettingTokens(memberTokenRequestDto: MemberTokenRequestDto) {
        validateAuthPlatformId(memberTokenRequestDto.authPlatformId)
        validateEmail(memberTokenRequestDto.email)
        validatePassword(memberTokenRequestDto.password)
    }

    fun matchAuthPlatformInfo(memberDto: MemberDto, authPlatformTypeId: Short, authPlatformId: String) {
        matchAuthPlatformTypeId(memberDto, authPlatformTypeId)
        matchAuthPlatformId(memberDto, authPlatformId)
    }

    fun matchAuthPlatformTypeId(memberDto: MemberDto, authPlatformTypeId: Short) {
        if (memberDto.isMatchAuthPlatformTypeId(authPlatformTypeId)) {
            throw ApiException(ApiError.NOT_MATCHED_AUTH_PLATFORM_TYPE_ID)
        }
    }

    fun matchAuthPlatformId(memberDto: MemberDto, authPlatformId: String) {
        if (memberDto.isMatchAuthPlatformId(authPlatformId)) {
            throw ApiException(ApiError.NOT_MATCHED_AUTH_PLATFORM_ID)
        }
    }

    fun validateAuthPlatformId(authPlatformId: String) {
        if (authPlatformId.isBlank()) {
            throw ApiException(ApiError.INVALID_AUTH_PLATFORM_ID)
        }
    }

    fun validateEmail(email: String) {
        val memberEmailPatternMatcher = Pattern.compile(MemberPolicy.MEMBER_EMAIL_REGEX).matcher(email)

        if (memberEmailPatternMatcher.isNotMatches()) {
            throw ApiException(ApiError.INVALID_EMAIL)
        }
    }

    fun validateNickname(nickname: String) {
        val memberNicknamePatternMatcher = Pattern.compile(MemberPolicy.MEMBER_NICKNAME_REGEX).matcher(nickname)

        if (memberNicknamePatternMatcher.isNotMatches()) {
            throw ApiException(ApiError.INVALID_NICKNAME)
        }
    }

    fun validatePassword(password: String?) {
        if (password.isNullOrBlank()) {
            return
        }

        val memberPasswordPatternMatcher = Pattern.compile(MemberPolicy.MEMBER_PASSWORD_REGEX).matcher(password)

        if (memberPasswordPatternMatcher.isNotMatches()) {
            throw ApiException(ApiError.INVALID_PASSWORD)
        }
    }

    fun validateExistsAuthPlatformId(authPlatformId: String) {
        memberService.existsByAuthPlatformId(authPlatformId)
            .alsoIfTrue {
                throw ApiException(ApiError.ALREADY_EXISTS_AUTH_PLATFORM_ID)
            }
    }

    fun validateExistsEmail(email: String) {
        memberService.existsByEmail(email)
            .alsoIfTrue {
                throw ApiException(ApiError.ALREADY_EXISTS_EMAIL)
            }
    }

    fun validateExistsNickname(nickname: String) {
        memberService.existsByNickname(nickname)
            .alsoIfTrue {
                throw ApiException(ApiError.ALREADY_EXISTS_NICKNAME)
            }
    }
}