package com.nfu.member.config.jpa.time

import com.nfu.member.constant.jpa.time.DateTimeProviderName
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.data.auditing.DateTimeProvider
import java.time.OffsetDateTime
import java.util.*

@Configuration
class DateTimeProviderConfig {

    @Bean(DateTimeProviderName.OFFSET_DATE_TIME_PROVIDER)
    fun dateTimeProvider(): DateTimeProvider {
        return DateTimeProvider { Optional.of(OffsetDateTime.now()) }
    }
}
