import java.util.List;

public interface CompletedProjImpl {
    public CompletedProject setName(String name);

    public CompletedProject setStartDate(String startDate);

    public CompletedProject setCompletedDate(String completedDate);

    public CompletedProject setNumberOfStaff(int numberOfStaff);

    public CompletedProject setContractEmpNumber(int contractEmpNumber);

    public CompletedProject setNoOfTasks(int noOfTasks);

    public CompletedProject setEmpList(List<String> empList);
}
