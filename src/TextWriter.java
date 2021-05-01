import javax.xml.transform.Templates;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class TextWriter extends OutputTemplate {
    public void getFile() {
        File file = new File("output.txt");
        try {
            if(file.createNewFile()){
                System.out.println("File created: " + file.getName());
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @Override
    void getOutputTemplate(OutputData outputData) {
        FileWriter writer = null;
        try {
            writer = new FileWriter("output.txt");
            writer.write("Number of projects Cancelled :  "+ outputData.getProjectsCancelled() + "\n");
            writer.write("Number of projects Active :  "+ outputData.getProjectsActive() + "\n\n");
            writer.write("Number of projects Completed :  "+ outputData.getProjectsCompleted() + "\n");
            for(CompletedProject project : outputData.getCompletedProjectList()){
                writer.write("Project ID :  "+ project.getName() + "\n");
                writer.write("No of Tasks :  "+ project.getNoOfTasks() + "\n");
                writer.write("Start Date :  "+ project.getStartDate() + "\n");
                writer.write("Completed Date :  "+ project.getCompletedDate() + "\n");
                writer.write("No of Staff :  "+ project.getEmpList().size() + "\n");
                writer.write("No of Contract Employees :  "+ project.getContractEmpNumber() + "\n");
                writer.write("List of Employees : "+ project.getEmpList() + "\n\n");
            }
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
