import java.util.List;

public abstract class OutputTemplate implements Cloneable {

    private String id;

    abstract void getFile();

    abstract void getOutputTemplate(OutputData data);

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Object clone(){
        Object clone = null;

        try {
            clone = super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return clone;
    }
}
