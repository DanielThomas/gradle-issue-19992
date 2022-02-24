import org.gradle.api.Plugin
import org.gradle.api.Project

class MyPlugin implements Plugin<Project> {
    private MyPluginExtension extension

    @Override
    void apply(Project project) {
        extension = project.extensions.create('myplugin', MyPluginExtension)
        project.tasks.named('jar').configure {
            doFirst {
                println("extension class: ${extension.getClass()}")
                println(extension.hello)
            }
        }
    }
}

class MyPluginExtension {
    String hello = "hello"
}
