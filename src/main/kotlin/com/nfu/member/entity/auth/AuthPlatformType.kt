package com.nfu.member.entity.auth

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.Id

@Entity
class AuthPlatformType {

    @Id
    @Column(name = "id", columnDefinition = "TINYINT")
    val id: Short = 0

    @Column(name = "name", length = 63)
    val name: String = ""
}