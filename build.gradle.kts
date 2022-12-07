import org.akhikhl.gretty.GrettyExtension

plugins {
    id("org.gretty")  version "3.0.7"
    java
}


subprojects {
    apply<WarPlugin>()
    apply(plugin="org.gretty")

    configure<GrettyExtension> {
        scanInterval=1 //Scan for changes every second
        host="0.0.0.0" //Enable network access from outside your local machine
        servletContainer="tomcat9" //Use Jetty7 which is compatible with JDK6
        managedClassReload =true //Activate spring-loaded class reloading
        integrationTestTask="integrationTest"
    }
    configure<JavaPluginExtension>{
        sourceCompatibility=org.gradle.api.JavaVersion.VERSION_1_8
        targetCompatibility=org.gradle.api.JavaVersion.VERSION_1_8
    }
    version = "1.0"
    repositories {
        mavenCentral()
    }
}

repositories {
    mavenCentral()
}

apply(plugin="org.gretty")

farm{
    webapp(":customer")
    webapp(":car")
}

dependencies{
    testImplementation("junit:junit:4.11")
}

