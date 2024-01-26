package org.zeron

@Singleton
class ConfigurationHelper implements Serializable {


  public void loadInitialResources() {
    addConfig()
  }
  
  private void addConfig() {
    Map values = [:]
    addDefaultsFromLibraryResources()
    // if (defaultsFromResources != null) {
    //   values = addDefaultsFromLibraryResources(script)
    // }
  }
  
  private Map addDefaultsFromLibraryResources() {
    Script.echo "Parameters: "
  }

  private void printParameterValue(String parameterName) {
    def build = Jenkins.instance.getItemByFullName('job_name').getBuildByNumber(build_number)
    def params = build.getAction(ParametersAction.class).getParameters()
    params.each { param ->
      println "${param.name}: ${param.value}"
    }
     
  }
}
