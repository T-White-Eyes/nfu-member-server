package com.nfu.member.util.jwt

import com.nfu.member.constant.jwt.JwtClaimField
import com.nfu.member.constant.jwt.JwtProperties
import com.nfu.member.vo.jwt.Claim
import io.jsonwebtoken.Jwts
import io.jsonwebtoken.security.Keys
import org.springframework.stereotype.Component
import java.util.*

@Component
class JwtGenerator(
    private val jwtProperties: JwtProperties,
) {

    private val secretKey = Keys.hmacShaKeyFor(jwtProperties.secretKey.toByteArray())

    fun generateAccessToken(claim: Claim): String {
        val claims = makeClaims(claim)
        val now = Date()
        val expiration = Date(now.time + jwtProperties.accessTokenExpiration)

        return Jwts.builder()
            .claims(claims)
            .issuedAt(Date(System.currentTimeMillis()))
            .expiration(expiration)
            .signWith(secretKey)
            .compact()
    }

    fun generateRefreshToken(claim: Claim): String {
        val claims = makeClaims(claim)
        val now = Date()
        val expiration = Date(now.time + jwtProperties.refreshTokenExpiration)

        return Jwts.builder()
            .claims(claims)
            .issuedAt(Date(System.currentTimeMillis()))
            .expiration(expiration)
            .signWith(secretKey)
            .compact()
    }

    private fun makeClaims(claim: Claim): MutableMap<String, Any> {
        val claims = mutableMapOf<String, Any>()
        claims[JwtClaimField.ID] = claim.id
        claims[JwtClaimField.EMAIL] = claim.email

        return claims
    }
}