# gradle-kotlin-demo
This is a gradle kotlin demo and tutorial . You enjoy myself!

## Build it yourself (and have fun)

### Build script setup

Initialize
```
gradle init --dsl kotlin
mkdir -p src/main/kotlin
```

Open project

Define buildscript
```
buildscript {
    repositories {
        jcenter()
    }
}
```

Define plugins
```
plugins {
    id("nebula.kotlin") version "1.2.41"
}
```

Apply plugins
```
apply<ApplicationPlugin>()
configure<ApplicationPluginConvention> {
    mainClassName = "MainKt" // haha
}
```

Define repositories
```
repositories {
    jcenter()
}
```

Define dependencies
```
val ratpackKotlin = "1.4.1"
dependencies {
    implementation("me.drmaas:ratpack-kotlin-dsl:$ratpackKotlin")
}
```

Add a main file (not even a class!): main.kt
```
fun main(args: Array<String>) {
    ratpack {
        handlers {
            get {
                render(json(mapOf("status" to "ok")))
            }
        }
    }
}
```

Run it
```
./gradlew run
```

Test it
```
curl localhost:5050
```

### Plugin setup

This will be added to the `buildSrc` directory to make things simpler for the demo. 
The same can be applied to a standalone project.

Setup
```
mkdir buildSrc/src/main/kotlin
```

Create the `buildSrc` build script - `buildSrc/build.gradle.kts`
```
plugins {
    `kotlin-dsl`
    `java-gradle-plugin`
}
```

Create `MyPlugin.kt`
```
open class MyPlugin : Plugin<Project> {

    override fun apply(project: Project) {
        project.run {
            tasks {
                "picardTask"(DefaultTask::class) {
                    doLast {
                        println("engage")
                    }
                }
            }
        }
    }
}
```

Apply it to the main project `build.gradle.kts`
```
apply<MyPlugin>()
```

Run the task
```
./gradlew picardTask
```

Now add an extension class to the plugin
```
open class MessageExtension {
    var message: String = "engage"
}
```
```
...
val message = extensions.create("message", MessageExtension::class.java)
tasks {
    "picardTask"(DefaultTask::class) {
        doLast {
            println(message.message)
        }
    }
}
...
```

And apply it
```
apply<MyPlugin>()
configure<MessageExtension> {
    message = "you have the bridge #1"
}
```

Run the task again
```
./gradlew picardTask
```



