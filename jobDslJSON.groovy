import groovy.json.*

def reader = new java.io.FileReader("test.json") 
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
