import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class InputTxtReader implements InputReader {
    private static InputTxtReader single_instance = null;
    private String file_name = null;

    public static InputTxtReader getInstance(String file_name){
        if (single_instance == null)
            single_instance = new InputTxtReader(file_name);

        return single_instance;
    }

    private InputTxtReader(String file_name) {
        this.file_name = file_name;
    }

    @Override
    public List<ReportData>  readInputData(String fileName) {
        File file = new File(fileName);
        Scanner fileReader = null;
        Map<String,List<TaskData>> dataMap = new HashMap<>();
        try {
            fileReader = new Scanner(file);
            if(null == fileReader){
                System.out.println("Error occurred while reading file from given location" );
                System.out.println("Loading default input text file...");
                file = new File("input.txt");
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        sortInputData(dataMap, fileReader);
        return createReportDataList(dataMap);
    }

    private void sortInputData(Map<String, List<TaskData>> dataMap, Scanner fileReader) {
        while (fileReader.hasNext()){
            String data = fileReader.nextLine();
            //System.out.println(data);
            if(data.length() > 0 && data.charAt(0) != '-' ){
                String[] fields = data.split(",");
                TaskData taskData = new TaskData();
                switch (fields.length){
                    case 2 :
                        taskData.setStatus(fields[1]);
                        break;
                    case 3 :
                        taskData.setTaskID(fields[0]).setStartDate(fields[2]).setStatus("active");
                        break;
                    case 4 :
                        taskData.setTaskID(fields[0]).setStartDate(fields[2]).setEndDate(fields[3])
                                .setStatus("completed");
                        break;
                    case 5 :
                        taskData.setTaskID(fields[0]).setEmployee(fields[2]).setEmployeeEmail(fields[3])
                                .setEmployeeStatus(fields[4]).setStatus("Emp");
                        break;

                }

                List<TaskData> tasks;
                if(taskData.getStatus().equalsIgnoreCase("cancelled")){
                    tasks = new ArrayList<>();
                    tasks.add(taskData);
                    dataMap.put(fields[0], tasks);
                } else {
                    if (dataMap.containsKey(fields[1])) {
                        tasks = dataMap.get(fields[1]);
                    } else {
                        tasks = new ArrayList<>();
                    }
                    tasks.add(taskData);
                    dataMap.put(fields[1], tasks);
                }
            }
        }
    }

    private List<ReportData> createReportDataList(Map<String, List<TaskData>> dataMap) {

        List<ReportData> reportDataList = new ArrayList<>();
        for (Map.Entry<String,List<TaskData>> entry : dataMap.entrySet()){
            ReportData reportData = new ReportData();
            reportData.setName(entry.getKey());
            reportData.setTaskData(entry.getValue());
            reportDataList.add(reportData);
        }

        return reportDataList;
    }
}
