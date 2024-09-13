package com.nfu.member.util.kotlin

import java.util.regex.Matcher

fun CharSequence?.isNotNullOrNotBlank(): Boolean {
    return !this.isNullOrBlank()
}

fun CharSequence?.isNotNullOrNotEmpty(): Boolean {
    return !this.isNullOrEmpty()
}

fun <T> Collection<T>?.isNotNullOrNotEmpty(): Boolean {
    return !this.isNullOrEmpty()
}

fun <T> T?.isNotNull(): Boolean {
    return this != null
}

fun Matcher.isNotMatches(): Boolean {
    return !this.matches()
}

fun Number.isZero(): Boolean {
    return this == 0
}

fun Number.isNotZero(): Boolean {
    return !this.isZero()
}

inline fun <T> T?.alsoIfTrue(block: () -> Unit): T? {
    this?.also {
        if (it as Boolean) block()
    }

    return this
}

inline fun <T> T?.alsoIfFalse(block: () -> Unit): T? {
    this?.also {
        if (!(it as Boolean)) block()
    }

    return this
}