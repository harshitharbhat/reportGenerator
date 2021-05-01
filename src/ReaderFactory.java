
public class ReaderFactory {
    public InputReader getReader(String inputFileName,String inputType){
        InputReader reader = null;
        if(inputType.equals("txt")){
            System.out.println("Configuration set to read text file." +
                    "\nBuilding Input Text Reader from the ReaderFactory" );
            reader = InputTxtReader.getInstance(inputFileName);
        } else if(inputType.equals("xml")){
            System.out.println("Configuration set to read xml file." +
                    "\nBuilding Input Xml Reader from the ReaderFactory" );
            reader = InputXmlReader.getInstance(inputFileName);
        } else {
            reader = DbReader.getInstance(inputFileName);
        }
        return reader;
    }

}
