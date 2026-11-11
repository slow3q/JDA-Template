plugins {
    id("java")
    id("application")
}

group = "pl.sloweq"
// version = "1.0"

repositories {
    mavenCentral()
}

dependencies {
    implementation("net.dv8tion:JDA:6.7.0") {
        exclude(module = "opus-java")
    }
    implementation("ch.qos.logback:logback-classic:1.5.18")
}

application {
    mainClass = "pl.sloweq.jdatemplate.Main"
}
