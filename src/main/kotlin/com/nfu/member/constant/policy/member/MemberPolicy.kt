package com.nfu.member.constant.policy.member

object MemberPolicy {

    /**
     * 이메일 사용자명 부분은 영어 대소문자, 숫자, .(점), _, %, +, -를 허용
     * @ 뒤의 도메인 부분은 영어 대소문자, 숫자, .(점), -를 허용
     * 도메인의 마지막 부분은 영어 대소문자로 2자 이상
     */
    const val MEMBER_EMAIL_REGEX = "^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}$"

    /**
     * 영어, 숫자, 한글만 허용
     * 최소 1글자, 최대 24글자
     */
    const val MEMBER_NICKNAME_REGEX = "^[a-zA-Z0-9가-힣]{1,24}$"

    /**
     * 최소 8자 이상
     * 영어 대문자 포함
     * 영어 소문자 포함
     * 숫자 포함
     * 특수 문자 포함 (예: @#$%^&*)
     */
    const val MEMBER_PASSWORD_REGEX = "^(?=.*[A-Z])(?=.*[a-z])(?=.*\\d)(?=.*[@\$!%*?&])[A-Za-z\\d@\$!%*?&]{8,}$"
}