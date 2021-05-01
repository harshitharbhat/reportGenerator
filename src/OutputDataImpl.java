import java.util.List;

interface OutputDataImpl {

    public OutputData setProjectsCompleted(int projectsCompleted);

    public OutputData setProjectsCancelled(int projectsCancelled);

    public OutputData setProjectsActive(int projectsActive);

    public OutputData setCompletedProjectList(List completedProjectList);
}
