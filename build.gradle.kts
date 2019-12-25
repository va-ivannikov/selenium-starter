plugins {
    kotlin("jvm") version "1.3.61"
    id("com.github.erdi.webdriver-binaries") version "2.1"
}

group = "ru.vip.selenium"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

val junitVersion = "5.5.2"
val seleniumVersion = "3.141.59"
val chromeDriverVersion = "79.0.3945.36"
val jvmTargetVersion = "1.8"

dependencies {
    implementation(kotlin("stdlib-jdk8"))
    testImplementation("org.junit.jupiter:junit-jupiter:$junitVersion")
    testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine:$junitVersion")
    testImplementation("org.seleniumhq.selenium:selenium-java:$seleniumVersion")
    testImplementation("org.seleniumhq.selenium:selenium-chrome-driver:$seleniumVersion")
}

tasks {
    test {
        useJUnitPlatform()
    }
    compileKotlin {
        kotlinOptions.jvmTarget = jvmTargetVersion
    }
    compileTestKotlin {
        kotlinOptions.jvmTarget = jvmTargetVersion
    }

    webdriverBinaries {
        chromedriver(chromeDriverVersion)
        downloadRoot = file("${project.projectDir}/out/test/resources/driver")
    }
}
