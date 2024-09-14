package com.nfu.member.constant.auth

enum class AuthPlatFormType(
    val id: Short
) {

    GOOGLE(1),
    NAVER(2),
    KAKAO(3),

    ;

    companion object {
        fun getById(id: Short): AuthPlatFormType  = entries.first { it.id == id }
    }
}