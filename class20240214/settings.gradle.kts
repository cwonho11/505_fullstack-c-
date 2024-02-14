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

rootProject.name = "class20240214"
include(":app")
include(":ch13_todo")
include(":batteryex")
include(":contactsex")
include(":gallaryex")
include(":profileex")
