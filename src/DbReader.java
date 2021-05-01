import java.util.List;

public class DbReader implements InputReader{
    private static DbReader single_instance = null;
    private String file_name = null;

    public static DbReader getInstance(String file_name){
        if (single_instance == null)
            single_instance = new DbReader(file_name);

        return single_instance;
    }

    private DbReader(String file_name) {
        this.file_name = file_name;
    }

    @Override
    public List<ReportData> readInputData(String fileName) {
        //Stub to read data from the DB
        return null;
    }
}
