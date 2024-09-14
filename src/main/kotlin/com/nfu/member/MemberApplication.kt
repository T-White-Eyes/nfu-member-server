package com.nfu.member

import com.nfu.member.constant.jpa.time.DateTimeProviderName
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.context.properties.ConfigurationPropertiesScan
import org.springframework.boot.runApplication
import org.springframework.data.jpa.repository.config.EnableJpaAuditing

@ConfigurationPropertiesScan
@EnableJpaAuditing(dateTimeProviderRef = DateTimeProviderName.OFFSET_DATE_TIME_PROVIDER)
@SpringBootApplication
class MemberApplication

fun main(args: Array<String>) {
	runApplication<MemberApplication>(*args)
}
