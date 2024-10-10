plugins {
    id("java")
}

group = "org.example"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(platform("org.junit:junit-bom:5.10.0"))
    testImplementation("org.junit.jupiter:junit-jupiter")
    implementation("org.testng:testng:7.7.0")
    implementation("io.appium:java-client:6.0.0")
}

tasks.test {
    useJUnitPlatform()
}