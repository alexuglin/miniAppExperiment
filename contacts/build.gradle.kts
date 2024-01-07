plugins {
    id("java")
}

group = "ru.example"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(platform("org.junit:junit-bom:5.9.1"))
    testImplementation("org.junit.jupiter:junit-jupiter")
    implementation("org.springframework:spring-context:6.0.8")
    implementation("javax.annotation:javax.annotation-api:1.3.2")
    implementation("org.yaml:snakeyaml:2.2")
    compileOnly("org.projectlombok:lombok:1.18.30")
    annotationProcessor("org.projectlombok:lombok:1.18.30")
    implementation("org.apache.commons:commons-lang3:3.14.0")
}

tasks.test {
    useJUnitPlatform()
}