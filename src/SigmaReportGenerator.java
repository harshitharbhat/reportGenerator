import java.util.Scanner;

public class SigmaReportGenerator {
    public static void main(String[] args) {
        TemplateCache.loadCache();
        System.out.println("Sigma Report Generator : v1.01");

        System.out.print("Enter input file name:");
        Scanner inScanner = new Scanner(System.in);
        String inFile = inScanner.nextLine();
        System.out.println("You entered: " + inFile);

        DataProcessor processor = new DataProcessor();
        processor.processInput(inFile);



    }
}
