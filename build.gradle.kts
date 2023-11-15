plugins {
    id("java")
    id("maven-publish")
    id("org.liquibase.gradle") version "2.2.0"
}

val group = "org.santiarerhi.mirl"
val version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    // Liquibase
    liquibaseRuntime("org.liquibase:liquibase-core:4.8.0")
    liquibaseRuntime("org.liquibase:liquibase-groovy-dsl:2.1.1")
    liquibaseRuntime("org.postgresql:postgresql:42.6.0")
    liquibaseRuntime("info.picocli:picocli:4.6.3")
    liquibaseRuntime("org.yaml:snakeyaml:2.2")

    // Test
    testImplementation(platform("org.junit:junit-bom:5.9.1"))
    testImplementation("org.junit.jupiter:junit-jupiter-api:5.10.0")

}

liquibase {
    activities.register("main") {
        this.arguments = mapOf("logLevel" to "info", "changelogFile" to "liquibase/db.changelog.xml", "url" to "jdbc:postgresql://localhost:9876/postgres?timezone=GMT", "username" to "postgres", "password" to "ultimatelysecure")
    }

}

tasks.test {
    useJUnitPlatform()
}
