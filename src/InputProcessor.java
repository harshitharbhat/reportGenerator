import java.util.List;

class InputProcessor {
    public List<ReportData> processInput(InputReader reader,String fileName){
        List<ReportData> reportDataList = reader.readInputData(fileName);
        return reportDataList;
    }
}
