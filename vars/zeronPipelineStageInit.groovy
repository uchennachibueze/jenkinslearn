import org.zeron.ConfigurationHelper
import org.zeron.pipeline.framework.workflow.*
import groovy.transform.Field
import jenkins.model.Jenkins
import org.jenkinsci.plugins.workflow.job.WorkflowJob

@Field String STEP_NAME = getClass().getName()

void call(Map parameters = [:]) {

  ConfigurationHelper test = new ConfigurationHelper()
  test.loadInitialResources()
  // ConfigurationHelper.instance.loadInitialResources()

  println "Test"
  
}
