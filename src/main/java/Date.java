import java.text.SimpleDateFormat;

public class Date {
    boolean exists = false;
    String precursor = "";
    SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yy hhss");
    java.util.Date data;
    public Date(String dateString) {
        precursor = dateString.split(" ", 2)[0];
        if (!dateString.equals(" ")) {
            try {
                this.data = formatter.parse(dateString.split(" ", 2)[1]);
                this.exists = true;
            }
            catch (Exception e) {
                System.out.println("WrongDateFormat");
            }
        }
    }

    @Override
    public String toString() {
        if (exists) {
            return "(" + precursor + " " + formatter.format(data) + ")";
        }
        else {
            return " ";
        }
    }
}
