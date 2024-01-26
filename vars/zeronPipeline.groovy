import org.zeron.pipeline.framework.Stage

void call(Map parameters = [:]) {
    timestamps {
        stage(Stage.INIT.value) {
            zeronPipelineStageInit(parameters)
        }

        if (currentBuild.result == 'ABORTED') {
            error("Pipeline aborted")
        }
}
