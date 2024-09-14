object Version {
	const val KOTLIN_VERSION = "1.9.25"
	const val NETFLIX_EUREKA_CLIENT_VERSION = "4.1.3"
	const val SPRING_CLOUD_CONFIG_VERSION = "4.1.3"
	const val SPRING_BOOT_VERSION = "3.3.3"
	const val JACKSON_MODULE_VERSION = "2.17.2"
	const val MARIADB_JAVA_CLIENT_VERSION = "3.4.1"
	const val QUERY_DSL_VERSION = "5.1.0"
	const val JWT_VERSION = "0.12.6"
}

plugins {
	val KOTLIN_VERSION = "1.9.25"
	val SPRING_PLUGIN_VERSION = "1.9.25"
	val SPRING_BOOT_VERSION = "3.3.3"
	val SPRING_BOOT_DEPENDENCY_MANAGEMENT_VERSION = "1.1.6"

	kotlin("jvm") version KOTLIN_VERSION
	kotlin("plugin.jpa") version KOTLIN_VERSION
	kotlin("plugin.spring") version SPRING_PLUGIN_VERSION
	kotlin("kapt") version KOTLIN_VERSION
	id("org.springframework.boot") version SPRING_BOOT_VERSION
	id("io.spring.dependency-management") version SPRING_BOOT_DEPENDENCY_MANAGEMENT_VERSION
}

group = "com.nfu"
version = "0.0.1"

java {
	toolchain {
		languageVersion = JavaLanguageVersion.of(21)
	}
}

repositories {
	mavenCentral()
}

extra["springCloudVersion"] = "2023.0.3"

dependencies {
	implementation("com.fasterxml.jackson.module:jackson-module-kotlin:${Version.JACKSON_MODULE_VERSION}")
	implementation("org.jetbrains.kotlin:kotlin-reflect:${Version.KOTLIN_VERSION}")

	implementation("org.springframework.boot:spring-boot-starter-web:${Version.SPRING_BOOT_VERSION}")
	implementation("org.springframework.boot:spring-boot-starter-validation:${Version.SPRING_BOOT_VERSION}")
	implementation("org.springframework.boot:spring-boot-starter-data-jpa:${Version.SPRING_BOOT_VERSION}")
	implementation("org.springframework.cloud:spring-cloud-starter-config:${Version.SPRING_CLOUD_CONFIG_VERSION}")
	implementation("org.springframework.cloud:spring-cloud-starter-netflix-eureka-client:${Version.NETFLIX_EUREKA_CLIENT_VERSION}")

	implementation("org.mariadb.jdbc:mariadb-java-client:${Version.MARIADB_JAVA_CLIENT_VERSION}")

	implementation("com.querydsl:querydsl-jpa:${Version.QUERY_DSL_VERSION}:jakarta")
	kapt("com.querydsl:querydsl-apt:${Version.QUERY_DSL_VERSION}:jakarta")

	implementation("io.jsonwebtoken:jjwt-api:${Version.JWT_VERSION}")
	implementation("io.jsonwebtoken:jjwt-impl:${Version.JWT_VERSION}")
	implementation("io.jsonwebtoken:jjwt-jackson:${Version.JWT_VERSION}")

	testImplementation("org.springframework.boot:spring-boot-starter-test:${Version.SPRING_BOOT_VERSION}")
}

dependencyManagement {
	imports {
		mavenBom("org.springframework.cloud:spring-cloud-dependencies:${property("springCloudVersion")}")
	}
}

kotlin {
	compilerOptions {
		freeCompilerArgs.addAll("-Xjsr305=strict")
	}
}

tasks.withType<Test> {
	useJUnitPlatform()
}

allOpen {
	annotation("jakarta.persistence.Entity")
	annotation("jakarta.persistence.MappedSuperclass")
	annotation("jakarta.persistence.Embeddable")
}
