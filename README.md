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
dependencies {
    compile("me.drmaas:ratpack-kotlin-dsl:1.4.1")
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

TODO