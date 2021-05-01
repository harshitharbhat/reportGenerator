public class TaskData {

    private String taskID;

    private String status;

    private String employee;

    private String employeeStatus;

    private String employeeEmail;

    private String startDate;

    private String endDate;

    public TaskData setTaskID(String taskID){
        this.taskID = taskID;
        return this;
    }

    public TaskData setStatus(String status){
        this.status = status;
        return this;
    }

    public TaskData setEmployee(String employee){
        this.employee = employee;
        return this;
    }

    public TaskData setEmployeeStatus(String employeeStatus){
        this.employeeStatus = employeeStatus;
        return this;
    }

    public TaskData setEmployeeEmail(String employeeEmail){
        this.employeeEmail = employeeEmail;
        return this;
    }

    public TaskData setStartDate(String startDate){
        this.startDate = startDate;
        return this;
    }

    public TaskData setEndDate(String endDate){
        this.endDate = endDate;
        return this;
    }

    @Override
    public String toString() {
        return "TaskData{" +
                "taskID='" + taskID + '\'' +
                ", status='" + status + '\'' +
                ", employee='" + employee + '\'' +
                ", employeeStatus='" + employeeStatus + '\'' +
                ", employeeEmail='" + employeeEmail + '\'' +
                ", startDate='" + startDate + '\'' +
                ", endDate='" + endDate + '\'' +
                '}';
    }


    public String getTaskID() {
        return taskID;
    }

    public String getStatus() {
        return status;
    }

    public String getEmployee() {
        return employee;
    }

    public String getEmployeeStatus() {
        return employeeStatus;
    }

    public String getEmployeeEmail() {
        return employeeEmail;
    }

    public String getStartDate() {
        return startDate;
    }

    public String getEndDate() {
        return endDate;
    }

}
