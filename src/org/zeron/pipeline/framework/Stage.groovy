package org.zeron.pipeline.framework

enum Stage implements Serializable {
    INIT('Init')
    
    final String value

    private Stage(String value) {
        this.value = value
    }

    static Stage getStage(String value) {
        return values().find {it.value == value}
    }

    public static boolean isValidType(String value) {
        try{
            value as Stage
            return true;
        } catch (org.jenkinsci.plugins.workflow.steps.FlowInterruptedException e){
            throw e
        } catch(Exception e) {
            return false;
        }
    }
}
