package org.zeron

@Singleton
class ConfigurationHelper implements Serializable {
  
  // private List configFromResource = ['org/zeron/config/resourceConfig.yaml', 'org/zeron/config/stashSettings.yaml', 'org/zeron/config/pipelineConfig.yaml']
  private List configFromResource = ['org/zeron/config/pipelineConfig.yaml']
  // Ensures only approved keys are loaded from the config.yaml
  private List configApprovedKeys = ["applicationDetails", "configFileVersion", "fileType", "deliver", "notificationSettings", "testingFramework", "SONARQUBE_SETTINGS", "CAST_SETTINGS", "customScripts", "deploy", "SEIDebug", "OPENSHIFT"]

  private Map cachedValues = [:]
  private HashSet nodesUtilized = []
  private HashSet workspacesUtilized = []
  Map nexusInfo = [:]

  void setNodesUtilized(String item){
      this.nodesUtilized.add(item)
  }

  HashSet getNodesUtilized() {
      return this.nodesUtilized
  }

    void setWorkspacesUtilized(String item){
        this.workspacesUtilized.add(item)
    }

    HashSet getWorkspacesUtilized() {
        return this.workspacesUtilized
    }

    Map getCachedValues(){
        return cachedValues
    }

    /**
    *  Sets workspace Id for optional custom workspaces
    * @param Map parameters - Jenkinsfile provided parameters
    **/
    void setWorkspaceId(Script script, Map parameters = [:]) {
        if (cachedValues.customWorkspaceId) return
        
        if (parameters?.useCustomWorkspace || cachedValues?.SEIDebug?.useCustomWorkspace) {
            cachedValues.customWorkspaceId = script.commonPipelineEnvironment.getCustomWorkspaceId(script)
        }
        else {
            cachedValues.customWorkspaceId = null
        }
    }
  
  public void loadInitialResources(Script script) {
    // addDefaultsFromLibraryResources()
    // addConfig()
    // echo "Parameters: "
    printParameterValue(script, 'group')
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

  private void printParameterValue(Script script, String parameterName) {
    // def build = Jenkins.instance.getItemByFullName('test').getBuildByNumber(42)
    def build = script.currentBuild.rawBuild
    def params = build.getAction(ParametersAction.class).getParameters()
    params.each { param ->
      script.echo "${param.name}: ${param.value}"
    }
     
  }
}
