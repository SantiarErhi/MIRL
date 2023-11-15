plugins {
    java
    id("org.springframework.boot") version "3.1.4"
    id("io.spring.dependency-management") version "1.1.3"
}

group = "org.santiarerhi.mirl.api"
version = "0.0.1-SNAPSHOT"

java {
    sourceCompatibility = JavaVersion.VERSION_17
}

configurations {
    compileOnly {
        extendsFrom(configurations.annotationProcessor.get())
    }
}

repositories {
    mavenCentral()
}

dependencies {
    // Spring
    implementation("org.springframework.boot:spring-boot-starter-data-jdbc:3.1.4")
    implementation("org.springframework.boot:spring-boot-starter-data-jpa:3.1.4")
    implementation("org.springframework.boot:spring-boot-starter-data-rest:3.0.4")
    implementation("org.springframework.boot:spring-boot-starter-web:3.1.0")
    annotationProcessor("org.springframework.boot:spring-boot-configuration-processor:3.0.4")
    implementation("org.springframework.boot:spring-boot-starter-oauth2-resource-server:3.1.5")
    implementation("org.springframework.security:spring-security-oauth2-jose:6.1.5")
    implementation("org.springframework.boot:spring-boot-starter-security:3.1.5")

    testImplementation("org.springframework.boot:spring-boot-starter-test:3.1.0")

    developmentOnly("org.springframework.boot:spring-boot-devtools")
    developmentOnly("org.springframework.boot:spring-boot-docker-compose")
    // Keycloak
    implementation("org.keycloak:keycloak-core:22.0.4")
    implementation("org.keycloak:keycloak-policy-enforcer:22.0.4")
    implementation("org.keycloak:keycloak-admin-client:22.0.4")
    implementation("org.keycloak:keycloak-authz-client:22.0.4")
    testImplementation("org.keycloak:keycloak-test-helper:22.0.4")

    // Annotation
    compileOnly("org.projectlombok:lombok")
    annotationProcessor("org.projectlombok:lombok")
    // PostgreSQL
    implementation("org.postgresql:postgresql")
    implementation("org.eclipse.persistence:eclipselink:4.0.2")
    implementation("javax.xml.bind:jaxb-api:2.3.0")

    implementation("com.google.guava:guava:32.1.2-jre")

    // SLF4j
    runtimeOnly("ch.qos.logback:logback-classic")

}

tasks.withType<Test> {
    useJUnitPlatform()
}
