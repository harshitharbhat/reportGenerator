import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import java.util.Properties;

public class DataProcessor {
    public void processInput(String inputFileName){
        FileReader propReader = null;
        Properties p = new Properties();
        try {
            propReader = new FileReader("InputTypes.properties");
            p.load(propReader);
        } catch (IOException e) {
            e.printStackTrace();
        }

        ReaderFactory readerObj = new ReaderFactory();
        InputReader reader = readerObj.getReader(inputFileName,p.getProperty("INPUT_FILE_TYPE"));

        InputProcessor processor = new InputProcessor();
        List<ReportData> reportDataList = processor.processInput(reader,inputFileName);
        DataProcessorUtil util = new DataProcessorUtil();
        OutputData outputData = util.processData(reportDataList);

        PrototypeWriter writer = new PrototypeWriter();
        writer.outputWriter(outputData,p.getProperty("INPUT_FILE_TYPE"));

    }
}
