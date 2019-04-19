def props = readJSON file: 'test.json'

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
