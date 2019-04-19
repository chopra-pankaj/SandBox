import groovy.json.JsonSlurper
import groovy.json.JsonBuilder

hudson.FilePath workspace = hudson.model.Executor.currentExecutor().getCurrentWorkspace()
new File("${workspace}/test.json").write(new JsonBuilder(projects).toPrettyString())

File f = new File("${workspace}/test.json")
def slurper = new JsonSlurper()
def jsonText = f.getText()
println "jsonText ${jsonText}"
projects = slurper.parseText( jsonText )

projects.each {
  job("${it.projectname}") {
    scm {
      git("${it.scm}")
    }
    
    steps {
      shell("cat README.md")
    }
  }
}
