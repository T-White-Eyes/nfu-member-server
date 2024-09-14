package com.nfu.member.service.member

import com.nfu.member.dto.member.MemberDto
import com.nfu.member.entity.member.Member
import com.nfu.member.exception.ApiException
import com.nfu.member.exception.constant.ApiError
import com.nfu.member.repository.member.MemberRepository
import com.nfu.member.repository.member.QMemberRepository
import com.nfu.member.util.kotlin.alsoIfTrue
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class MemberService(
    private val memberRepository: MemberRepository,
    private val qMemberRepository: QMemberRepository,
) {

    @Transactional(rollbackFor = [Exception::class])
    fun save(member: Member): Member {
        return memberRepository.save(member)
    }

    @Transactional(readOnly = true)
    fun existsByAuthPlatformId(authPlatformId: String): Boolean {
        return qMemberRepository.existsByAuthPlatformId(authPlatformId)
    }

    @Transactional(readOnly = true)
    fun existsByEmail(email: String): Boolean {
        return qMemberRepository.existsByEmail(email)
    }

    @Transactional(readOnly = true)
    fun existsByNickname(nickname: String): Boolean {
        return qMemberRepository.existsByNickname(nickname)
    }

    @Transactional(readOnly = true)
    fun verifyNotExistsAuthPlatformId(authPlatformId: String) {
        existsByAuthPlatformId(authPlatformId)
            .alsoIfTrue {
                throw ApiException(ApiError.ALREADY_EXISTS_AUTH_PLATFORM_ID)
            }
    }

    @Transactional(readOnly = true)
    fun verifyNotExistsEmail(email: String) {
        existsByEmail(email)
            .alsoIfTrue {
                throw ApiException(ApiError.ALREADY_EXISTS_EMAIL)
            }
    }

    @Transactional(readOnly = true)
    fun verifyNotExistsNickname(nickname: String) {
        existsByNickname(nickname)
            .alsoIfTrue {
                throw ApiException(ApiError.ALREADY_EXISTS_NICKNAME)
            }
    }

    @Transactional(readOnly = true)
    fun getMemberDtoById(memberId: Long): MemberDto {
        return qMemberRepository.findMemberDtoById(memberId)
            ?: throw ApiException(ApiError.NOT_FOUND_MEMBER)
    }
}