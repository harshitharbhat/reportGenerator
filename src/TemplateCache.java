import java.util.Hashtable;

public class TemplateCache {

    private static Hashtable<String,OutputTemplate> templateMap = new Hashtable<String,OutputTemplate>();

    public static OutputTemplate getTemplate(String type){
        OutputTemplate cachedTemplate = templateMap.get(type);
        return (OutputTemplate) cachedTemplate.clone();
    }

    public static void loadCache(){
        TextWriter textWriter = new TextWriter();
        textWriter.setId("txt");
        templateMap.put(textWriter.getId(),textWriter);

        HtmlWriter htmlWriter = new HtmlWriter();
        htmlWriter.setId("xml");
        templateMap.put(htmlWriter.getId(),htmlWriter);

        DbWriter dbWriter = new DbWriter();
        dbWriter.setId("db");
        templateMap.put(htmlWriter.getId(),dbWriter);
    }
}
