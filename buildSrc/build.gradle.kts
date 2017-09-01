buildscript {
    dependencies {
        classpath("org.jetbrains.kotlin:kotlin-gradle-plugin:1.1.4-3")
        classpath("org.jetbrains.kotlin:kotlin-sam-with-receiver:1.1.4-3")
    }

    configure(listOf(repositories, project.repositories)) {
        jcenter()
    }
}

apply {
    plugin("org.jetbrains.kotlin.jvm")
    plugin("kotlin-sam-with-receiver")
}

samWithReceiver {
    annotation("org.gradle.api.HasImplicitReceiver")
}

dependencies {
    "compile"(gradleKotlinDsl())
    "compile"(kotlin("stdlib", version = "1.1.4-3"))
}

fun Project.`samWithReceiver`(configure: org.jetbrains.kotlin.samWithReceiver.gradle.SamWithReceiverExtension.() -> Unit) =
    extensions.configure("samWithReceiver", configure)
