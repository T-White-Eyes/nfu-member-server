package com.nfu.member.helper.profile

import com.nfu.member.constant.profile.ApplicationProfile
import org.springframework.core.env.Environment

object ApplicationProfileHelper {

    fun isLocal(environment: Environment): Boolean {
        return environment.activeProfiles[0] == ApplicationProfile.LOCAL
    }

    fun isDev(environment: Environment): Boolean {
        return environment.activeProfiles[0] == ApplicationProfile.DEVELOP
    }

    fun isProduction(environment: Environment): Boolean {
        return environment.activeProfiles[0] == ApplicationProfile.PRODUCTION
    }

    fun getProfile(environment: Environment): String {
        return environment.activeProfiles[0]
    }
}