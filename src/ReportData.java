import java.util.List;

public class ReportData {

    private String name;

    private List<TaskData> taskData;

    public ReportData setName(String name){
        this.name = name;
        return this;
    }

    public ReportData setTaskData(List<TaskData> taskData){
        this.taskData = taskData;
        return this;
    }
    public String getName() {
        return name;
    }

    public List<TaskData> getTaskData() {
        return taskData;
    }

}
