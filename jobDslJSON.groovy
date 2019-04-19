import groovy.json.*

hudson.FilePath workspace = hudson.model.Executor.currentExecutor().getCurrentWorkspace()
def reader = new java.io.FileReader("${workspace}/test.json") 
def dslJobs = new JsonSlurper().parse(reader)

dslJobs.each {
  job("${it.projectname}") {
    steps {
      shell("echo $JOB_NAME")
      shell('echo $BUILD_NUMBER')
    }
  }
}
