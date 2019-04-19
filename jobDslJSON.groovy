def slurped = new JsonSlurper().parseText('"item": {
    projectname: "firstProject",
    scm: "https://github.com/SeritAndrei/JenkinsGitTest.git"
  }')

props.each {
  job("${it.projectname}") {
    scm {
      git("${it.scm}")
    }
    
    steps {
      shell("cat README.md")
    }
  }
}
