import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
	id("org.springframework.boot") version "2.4.7-SNAPSHOT"
	id("io.spring.dependency-management") version "1.0.11.RELEASE"
	kotlin("jvm") version "1.4.32"
	kotlin("plugin.spring") version "1.4.32"
	id("io.freefair.lombok") version "6.0.0-m2"
}

group = "io.stud.forest"
version = "0.0.1-SNAPSHOT"
java.sourceCompatibility = JavaVersion.VERSION_11

repositories {
	mavenCentral()
	maven { url = uri("https://repo.spring.io/milestone") }
	maven { url = uri("https://repo.spring.io/snapshot") }
}

dependencies {
	implementation("org.springframework.boot:spring-boot-starter-web")
	implementation("org.springframework.boot:spring-boot-starter-data-jpa")
	implementation("mysql:mysql-connector-java:8.0.23")
	implementation("com.fasterxml.jackson.module:jackson-module-kotlin")
	implementation("org.jetbrains.kotlin:kotlin-reflect")
	implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8")
	implementation("org.flywaydb:flyway-core:7.1.0")
	implementation("com.squareup.retrofit2:retrofit:2.9.0")
	implementation("com.squareup.retrofit2:converter-gson:2.9.0")
	implementation("io.reactivex.rxjava3:rxjava:3.0.13")
	implementation("com.github.akarnokd:rxjava3-retrofit-adapter:3.0.0")
	//circuit breaker
//	implementation("io.github.resilience4j:resilience4j-circuitbreaker:1.7.0")
//	implementation("io.github.resilience4j:resilience4j-all:1.7.0")
	implementation("org.springframework.cloud:spring-cloud-starter:3.0.3")

	implementation("org.springframework.cloud:spring-cloud-starter-circuitbreaker-resilience4j:1.0.6.RELEASE")


//	implementation("org.awaitility:awaitility:4.1.0")

	testImplementation("org.springframework.boot:spring-boot-starter-test")
//	testImplementation("org.junit.jupiter:junit-jupiter-api:5.3.1'")
//	testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine:5.3.1")
	testImplementation("io.strikt:strikt-core:0.31.0")
}

tasks.withType<KotlinCompile> {
	kotlinOptions {
		freeCompilerArgs = listOf("-Xjsr305=strict")
		jvmTarget = "11"
	}
}

tasks.withType<Test> {
	useJUnitPlatform()
}
