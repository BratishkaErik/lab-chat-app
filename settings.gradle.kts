import java.util.Properties

pluginManagement {
    repositories {
        google {
            content {
                includeGroupByRegex("com\\.android.*")
                includeGroupByRegex("com\\.google.*")
                includeGroupByRegex("androidx.*")
            }
        }
        mavenCentral()
        gradlePluginPortal()
    }
}
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        maven {
            name = "GitHubPackages"
            url = uri("https://maven.pkg.github.com/BratishkaErik/lab-chat-library")
            credentials {
                val githubProperties = Properties().apply {
                    val propertiesFile = File(rootDir, "github.properties")
                    if (propertiesFile.exists()) {
                        load(propertiesFile.inputStream())
                    }
                }

                username = githubProperties["gpr.usr"] as String? ?: System.getenv("GPR_USER")
                password = githubProperties["gpr.key"] as String? ?: System.getenv("GPR_API_KEY")
            }
        }
        google()
        mavenCentral()
    }
}

rootProject.name = "ChatApp"
include(":app")
