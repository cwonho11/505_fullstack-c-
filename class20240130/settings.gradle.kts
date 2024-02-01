pluginManagement {
    repositories {
        google()
        mavenCentral()
        gradlePluginPortal()
    }
}
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
    }
}

rootProject.name = "class20240130"
include(":app")
include(":kakao_password")
include(":layoutex")
include(":telkeypad")
include(":alaramtest")
include(":eventex")
