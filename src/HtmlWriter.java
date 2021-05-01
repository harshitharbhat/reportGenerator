import java.io.*;

public class HtmlWriter extends OutputTemplate {
    @Override
    public void getFile() {
        File file = new File("htmlOutput.html");
        String data = "Hello";
    }


    @Override
    void getOutputTemplate(OutputData outputData) {
        BufferedWriter writer = null;
        try {
            writer = new BufferedWriter(new FileWriter("htmlOutput.html"));
            writer.write("<html><body>");
            writer.write("<div><h3>Number of projects Cancelled :  "+ outputData.getProjectsCancelled() + "</h3></div>");
            writer.write("<div><h3>Number of projects Active :  "+ outputData.getProjectsActive() + "</h3></div>");
            writer.write("<div><h3>Number of projects Completed :  "+ outputData.getProjectsCompleted() + "</h3></div>");
            for(CompletedProject project : outputData.getCompletedProjectList()){
                writer.write("<div>Project ID :  "+ project.getName() + "</div>");
                writer.write("<div>No of Tasks :  "+ project.getNoOfTasks() + "</div>");
                writer.write("<div>Start Date :  "+ project.getStartDate() + "</div>");
                writer.write("<div>Completed Date :  "+ project.getCompletedDate() + "</div>");
                writer.write("<div>No of Staff :  "+ project.getEmpList().size() + "</div>");
                writer.write("<div>No of Contract Employees :  "+ project.getContractEmpNumber() + "</div>");
                writer.write("<div>List of Employees : "+ project.getEmpList() + "</div><br/>");
            }
            writer.write("</html></body>");
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
