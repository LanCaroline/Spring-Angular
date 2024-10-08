/*
 * This file was generated by the Gradle 'init' task.
 *
 * This generated file contains a sample Java application project to get you started.
 * For more details on building Java & JVM projects, please refer to https://docs.gradle.org/8.6/userguide/building_java_projects.html in the Gradle documentation.
 */

plugins {
    // Apply the application plugin to add support for building a CLI application in Java.
    application
    id("java")
    checkstyle

}

group = "br.com.start"
version = "1.0-SNAPSHOT"
val mapstructVersion = "1.5.5.Final"
val lombokVersion = "1.18.30"
val lombokMapstructBinding = "0.2.0"

repositories {
    // Use Maven Central for resolving dependencies.
    mavenCentral()
}

dependencies {
    // Use JUnit Jupiter for testing.
    testImplementation(libs.junit.jupiter)

    testRuntimeOnly("org.junit.platform:junit-platform-launcher")

    // This dependency is used by the application.
    implementation("org.mapstruct:mapstruct:$mapstructVersion")
    implementation("org.projectlombok:lombok-mapstruct-binding:$lombokMapstructBinding")
    //implementation(libs.guava)

    compileOnly("org.projectlombok:lombok:$lombokVersion")

    annotationProcessor("org.mapstruct:mapstruct-processor:$mapstructVersion")
    annotationProcessor("org.projectlombok:lombok-mapstruct-binding:$lombokMapstructBinding")
    annotationProcessor("org.projectlombok:lombok:$lombokVersion")

}

tasks.named<Test>("test") {
    // Use JUnit Platform for unit tests.
    useJUnitPlatform()
}



tasks.checkstyleMain{
    source = fileTree("src/main/java")
}


