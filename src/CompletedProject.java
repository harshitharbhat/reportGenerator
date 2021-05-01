import java.util.List;

public class CompletedProject implements CompletedProjImpl{
    private String name;
    private String startDate;
    private String completedDate;
    private int numberOfStaff;
    private int contractEmpNumber;
    private int noOfTasks;
    private List<String> empList;

    public CompletedProject setName(String name){
        this.name = name;
        return this;
    }

    public CompletedProject setStartDate(String startDate){
        this.startDate = startDate;
        return this;
    }

    public CompletedProject setCompletedDate(String completedDate){
        this.completedDate = completedDate;
        return this;
    }

    public CompletedProject setNumberOfStaff(int numberOfStaff){
        this.numberOfStaff = numberOfStaff;
        return this;
    }

    public CompletedProject setContractEmpNumber(int contractEmpNumber){
        this.contractEmpNumber = contractEmpNumber;
        return this;
    }

    public CompletedProject setNoOfTasks(int noOfTasks){
        this.noOfTasks = noOfTasks;
        return this;
    }

    public CompletedProject setEmpList(List<String> empList){
        this.empList = empList;
        return this;
    }
    public String getName() {
        return name;
    }

    public String getStartDate() {
        return startDate;
    }

    public String getCompletedDate() {
        return completedDate;
    }

    public int getNumberOfStaff() {
        return numberOfStaff;
    }

    public int getContractEmpNumber() {
        return contractEmpNumber;
    }

    public List<String> getEmpList() {
        return empList;
    }

    public int getNoOfTasks() {
        return noOfTasks;
    }
}
