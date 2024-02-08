import org.gradle.jvm.tasks.Jar

plugins {
    application
}

group = "com.github.coruja182.playground"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    implementation("com.fasterxml.jackson.core:jackson-core:2.16.1")
    implementation("com.fasterxml.jackson.core:jackson-databind:2.16.1")

    testImplementation(platform("org.junit:junit-bom:5.10.0"))
    testImplementation("org.junit.jupiter:junit-jupiter")
}

tasks.test {
    useJUnitPlatform()
}

application {
    mainClass = "com.github.coruja182.playground.jsonreader.Main"
}

tasks.jar {
    manifest {
        attributes["Main-Class"] = application.mainClass;
    }
}

tasks.withType(JavaExec::class) {
    if (args!!.isEmpty()) {
        args = listOf("src/test/resources/input-test.json")
    }
}
