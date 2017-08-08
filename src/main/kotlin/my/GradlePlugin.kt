package my

import org.gradle.api.Plugin
import org.gradle.api.Project

open class GradlePlugin : Plugin<Project> {

    override fun apply(target: Project) {
        target.run {
            tasks.create("copy") {
                doLast { // Action<Task>
                    copy { // Action<CopySpec>
                        from("foo")
                        into("bar")
                    }
                }
            }
        }
    }
}
