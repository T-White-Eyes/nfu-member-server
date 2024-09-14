package com.nfu.member.controller.member

import com.nfu.member.dto.member.MemberSignUpRequestDto
import com.nfu.member.service.member.MemberService
import com.nfu.member.service.member.MemberSignUpService
import org.springframework.http.HttpStatus
import org.springframework.http.HttpStatusCode
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping(value = ["/api/v1/members"])
class MemberController(
    private val memberService: MemberService,
    private val memberSignUpService: MemberSignUpService
) {

    @RequestMapping(method = [RequestMethod.POST], value = [""])
    fun signUp(@RequestBody memberSignUpRequestDto: MemberSignUpRequestDto): ResponseEntity<*> {
        val memberDto = memberSignUpService.verify(memberSignUpRequestDto)
            .let {
                memberSignUpService.signUp(memberSignUpRequestDto)
            }

        return ResponseEntity(memberDto, HttpStatusCode.valueOf(HttpStatus.CREATED.value()))
    }
}