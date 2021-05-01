public class PrototypeWriter {
    public void outputWriter(OutputData outputData,String cloneId){

        OutputTemplate writer = (OutputTemplate) TemplateCache.getTemplate(cloneId);
        writer.getFile();
        writer.getOutputTemplate(outputData);
    }
}
