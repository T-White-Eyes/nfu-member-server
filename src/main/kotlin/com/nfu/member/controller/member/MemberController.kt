package com.nfu.member.controller.member

import com.nfu.member.dto.member.MemberSignUpRequestDto
import com.nfu.member.dto.member.MemberTokenRequestDto
import com.nfu.member.service.member.MemberService
import com.nfu.member.service.member.MemberSignUpService
import com.nfu.member.service.member.MemberTokenService
import com.nfu.member.service.member.MemberValidationService
import org.springframework.http.HttpStatus
import org.springframework.http.HttpStatusCode
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping(value = ["/api/v1/members"])
class MemberController(
    private val memberService: MemberService,
    private val memberValidationService: MemberValidationService,
    private val memberSignUpService: MemberSignUpService,
    private val memberTokenService: MemberTokenService,
) {

    @RequestMapping(method = [RequestMethod.POST], value = [""])
    fun signUp(@RequestBody memberSignUpRequestDto: MemberSignUpRequestDto): ResponseEntity<*> {
        val memberDto = memberValidationService.validateForSignUp(memberSignUpRequestDto)
            .let {
                memberSignUpService.signUp(memberSignUpRequestDto)
            }

        return ResponseEntity(memberDto, HttpStatusCode.valueOf(HttpStatus.CREATED.value()))
    }

    @RequestMapping(method = [RequestMethod.POST], value = ["/tokens"])
    fun getTokens(@RequestBody memberTokenRequestDto: MemberTokenRequestDto): ResponseEntity<*> {
        memberValidationService.validateForGettingTokens(memberTokenRequestDto)

        val memberDto = memberService.getMemberDtoByEmail(memberTokenRequestDto.email)
            .also { memberDto ->
                memberValidationService.matchAuthPlatformInfo(
                    memberDto = memberDto,
                    authPlatformTypeId = memberTokenRequestDto.authPlatformTypeId,
                    authPlatformId = memberTokenRequestDto.authPlatformId
                )
            }

        val memberTokenDto = memberTokenService.generateTokens(memberDto)

        return ResponseEntity(memberTokenDto, HttpStatusCode.valueOf(HttpStatus.OK.value()))
    }

    @RequestMapping(method = [RequestMethod.GET], value = ["/{memberId}"])
    fun getById(@PathVariable memberId: Long): ResponseEntity<*> {
        val memberDto = memberService.getMemberDtoById(memberId)

        return ResponseEntity(memberDto, HttpStatusCode.valueOf(HttpStatus.OK.value()))
    }
}