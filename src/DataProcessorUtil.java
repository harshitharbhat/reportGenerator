import java.util.*;

public class DataProcessorUtil {

    public OutputData processData(List<ReportData> list) {
        OutputData outputData = new OutputData();
        int cancelledPrj = 0;
        int activeProjects = 0;
        List<CompletedProject> completedProjectList = new ArrayList<>();
        for(ReportData reportData : list){
            boolean active = false;
            boolean cancelled = false;
            for(TaskData task : reportData.getTaskData()){
                if(task.getStatus().equalsIgnoreCase("cancelled")){
                    cancelledPrj++;
                    cancelled = true;
                }
                if(task.getStatus().equalsIgnoreCase("active")){
                    active = true;
                    activeProjects++;
                }
            }
            if(!active && !cancelled){
               CompletedProject completedPrj = setProject(reportData);
               completedProjectList.add(completedPrj);
            }
        }
        outputData.setProjectsActive(activeProjects);
        outputData.setProjectsCancelled(cancelledPrj);
        outputData.setProjectsCompleted(completedProjectList.size());
        outputData.setCompletedProjectList(completedProjectList);


        return outputData;
    }

    private CompletedProject setProject(ReportData reportData) {
        CompletedProject project = new CompletedProject();
        project.setName(reportData.getName());
        List<String> empList = new ArrayList<>();
        int staff = 0;
        for(TaskData taskData : reportData.getTaskData()){
            if(taskData.getEmployee() != null){
                if(taskData.getEmployeeStatus().equalsIgnoreCase("staff")){
                    staff++;
                }
                empList.add(taskData.getEmployee());
            }
            if(null != taskData.getStartDate()){
                project.setStartDate(taskData.getStartDate());
            }
            if(null != taskData.getEndDate()) {
                project.setCompletedDate(taskData.getEndDate());
            }
        }
        project.setNumberOfStaff(staff);
        project.setContractEmpNumber(empList.size() - staff);
        project.setNoOfTasks(reportData.getTaskData().size());
        project.setEmpList(empList);
        return project;
    }

}

