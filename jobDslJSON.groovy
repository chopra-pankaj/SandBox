import groovy.json.*

hudson.FilePath workspace = hudson.model.Executor.currentExecutor().getCurrentWorkspace()
def reader = new java.io.FileReader("${workspace}/test.json") 
def dslJobs = new JsonSlurper().parse(reader)

dslJobs.item.each {
  job("${it.projectname}") {
    scm {
      git("${it.scm}")
    }
    
    steps {
      shell("cat README.md")
    }
  }
}
