import org.zeron.ConfigurationHelper
import org.zeron.pipeline.framework.workflow.*
import groovy.transform.Field
import jenkins.model.Jenkins
import org.jenkinsci.plugins.workflow.job.WorkflowJob

@Field String STEP_NAME = getClass().getName()

void call(Map parameters = [:]) {
  ConfigurationHelper.instance.setWorkspaceId(parameters.script, parameters)

  script = parameters.script

  ConfigurationHelper.instance.loadInitialResources(script)
  
}
