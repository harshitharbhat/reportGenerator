import java.util.List;

public class OutputData implements OutputDataImpl{

    int projectsCompleted;
    int projectsCancelled;
    int projectsActive;
    List<CompletedProject> completedProjectList;


    public OutputData setProjectsCompleted(int projectsCompleted){
        this.projectsCompleted = projectsCompleted;
        return this;
    }

    public OutputData setProjectsCancelled(int projectsCancelled){
        this.projectsCancelled = projectsCancelled;
        return this;
    }

    public OutputData setProjectsActive(int projectsActive){
        this.projectsActive = projectsActive;
        return this;
    }

    public OutputData setCompletedProjectList(List completedProjectList){
        this.completedProjectList = completedProjectList;
        return this;
    }

    public int getProjectsCompleted() {
        return projectsCompleted;
    }

    public int getProjectsCancelled() {
        return projectsCancelled;
    }

    public int getProjectsActive() {
        return projectsActive;
    }

    public List<CompletedProject> getCompletedProjectList() {
        return completedProjectList;
    }

}
