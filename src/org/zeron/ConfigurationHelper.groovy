package org.zeron

// @Singleton
class ConfigurationHelper {


  public void loadInitialResources() {
    // addDefaultsFromLibraryResources()
    // addConfig()
    // echo "Parameters: "
    printParameterValue('group')
  }
  
  // private void addConfig() {
  //   Map values = [:]
  //   addDefaultsFromLibraryResources()
  //   // if (defaultsFromResources != null) {
  //   //   values = addDefaultsFromLibraryResources(script)
  //   // }
  // }
  
  // private Map addDefaultsFromLibraryResources() {
  //   println "Parameters: "
  // }

  private void printParameterValue(String parameterName) {
    def build = Jenkins.instance.getItemByFullName('test').getBuildByNumber(42)
    // def build = Jenkins.instance.currentBuild.rawBuild
    def params = build.getAction(ParametersAction.class).getParameters()
    params.each { param ->
      println "${param.name}: ${param.value}"
    }
     
  }
}
