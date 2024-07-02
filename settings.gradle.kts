//init.gradle.kts
//fun RepositoryHandler.setPluginRepos(){
//    // maven("http://localhost:8001/repository/maven-plugins/"){
//    //     isAllowInsecureProtocol=true
//    // }
//    maven("https://maven.aliyun.com/repository/google")
//    maven("https://maven.aliyun.com/repository/gradle-plugin")
//    gradlePluginPortal()
//    google{mavenContent{
//        includeGroupAndSubgroups("androidx")
//        includeGroupAndSubgroups("com.android")
//        includeGroupAndSubgroups("com.google")
//    }}
//}
//fun RepositoryHandler.setDependenceRepos(){
//    // maven("http://localhost:8001/repository/maven-public/"){
//    //     isAllowInsecureProtocol=true
//    // }
//    maven("https://maven.aliyun.com/repository/public")
//    maven("https://maven.aliyun.com/repository/central")
//    maven("https://maven.aliyun.com/repository/jcenter")
//    maven("https://maven.aliyun.com/repository/google")
//    maven("https://maven.aliyun.com/repository/gradle-plugin")
//    mavenCentral()
//    mavenLocal()
//    google{mavenContent{
//        includeGroupAndSubgroups("androidx")
//        includeGroupAndSubgroups("com.android")
//        includeGroupAndSubgroups("com.google")
//    }}
//}
//settingsEvaluated {
//    pluginManagement {
//        repositories {
//            setPluginRepos()
//        }
//    }
//    dependencyResolutionManagement {
//        repositories{
//            setDependenceRepos()
//        }
//    }
//}


rootProject.name = "android-tutorial"
include(":app")

