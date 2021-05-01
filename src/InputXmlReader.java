import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class InputXmlReader implements InputReader{
    private static InputXmlReader single_instance = null;
    private String file_name = null;

    public static InputXmlReader getInstance(String file_name){
        if (single_instance == null)
            single_instance = new InputXmlReader(file_name);

        return single_instance;
    }

    private InputXmlReader(String file_name) {
        this.file_name = file_name;
    }

    @Override
    public List<ReportData> readInputData(String fileName) {
        File file = new File(fileName);
        Map<String,List<TaskData>> dataMap = new HashMap<>();
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        try {
            DocumentBuilder db = dbf.newDocumentBuilder();
            Document doc = db.parse(file);
            sortXmlData(dataMap, doc);

        } catch (ParserConfigurationException | SAXException | IOException e) {
            e.printStackTrace();
        }
        return createReportDataList(dataMap);
    }

    private void sortXmlData(Map<String, List<TaskData>> dataMap, Document doc) {
        doc.getDocumentElement().normalize();

        NodeList nodeList= doc.getElementsByTagName("project");

        if(nodeList.getLength() > 0){
            for(int i = 0 ; i<nodeList.getLength(); i++){
                Node node = nodeList.item(i);
                Element eElement = (Element) node;
                TaskData taskData = new TaskData();
                if (node.getNodeType() == Node.ELEMENT_NODE) {

                    if(!eElement.getAttribute("taskid").isEmpty()) taskData.setTaskID(eElement.getAttribute("taskid"));
                    if(!eElement.getAttribute("empName").isEmpty()) {
                        taskData.setEmployee(eElement.getAttribute("empName"));
                        taskData.setStatus("emp");
                    }
                    if(!eElement.getAttribute("email").isEmpty()) taskData.setEmployeeEmail(eElement.getAttribute("email"));
                    if(!eElement.getAttribute("status").isEmpty()) taskData.setEmployeeStatus(eElement.getAttribute("status"));
                    if(!eElement.getAttribute("endDate").isEmpty()) {
                        taskData.setEndDate(eElement.getAttribute("endDate"));
                        taskData.setStatus("completed");
                    } else if("emp" != taskData.getStatus()){
                        taskData.setStatus("active");
                    }
                    if(!eElement.getAttribute("startDate").isEmpty()) taskData.setStartDate(eElement.getAttribute("startDate"));
                    if(!eElement.getAttribute("projStatus").isEmpty()) taskData.setStatus(eElement.getAttribute("projStatus"));
                }

                List<TaskData> tasks;
                if (dataMap.containsKey(eElement.getAttribute("projectid"))) {
                    tasks = dataMap.get(eElement.getAttribute("projectid"));
                } else {
                    tasks = new ArrayList<>();
                }
                tasks.add(taskData);
                dataMap.put(eElement.getAttribute("projectid"), tasks);
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
