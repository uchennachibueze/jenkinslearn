
package org.zeron


@Singleton
class ConfigurationHelper implements Serializable {


  public void loadInitialResources(Script script) {
    addConfig(script, configFromResource)
  }
  
  private void addConfig(Script script) {
    Map values = [:]
    // if (defaultsFromResources != null) {
    //   values = addDefaultsFromLibraryResources(script)
    // }
  }
  
  private Map addDefaultsFromLibraryResources(Script script) {
    Script.echo "Parameters: "
  }
}
