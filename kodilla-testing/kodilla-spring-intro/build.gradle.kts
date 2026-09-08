plugins {
    id("java")
}

tasks.withType<JavaCompile> {
    options.release.set(21)
}

group = "com.kodilla"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    implementation("org.springframework.boot:spring-boot-starter:3.4.3")
    testImplementation("org.springframework.boot:spring-boot-starter-test:3.4.3")
    testImplementation(platform("org.junit:junit-bom:5.10.2"))
    testImplementation("org.junit.jupiter:junit-jupiter")
    testRuntimeOnly("org.junit.platform:junit-platform-launcher")
    testImplementation("org.mockito:mockito-core:5.1.1")
    testImplementation("org.mockito:mockito-junit-jupiter:5.1.1")
}

tasks.test {
    useJUnitPlatform()
}