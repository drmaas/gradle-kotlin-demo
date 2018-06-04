import org.gradle.api.DefaultTask
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.invoke

open class MessageExtension {
    var message: String = "engage"
}

open class MyPlugin : Plugin<Project> {

    override fun apply(project: Project) {
        project.run {
            val message = extensions.create("message", MessageExtension::class.java)
            tasks {
                "picardTask"(DefaultTask::class) {
                    doLast {
                        println(message.message)
                    }
                }
            }
        }
    }
}