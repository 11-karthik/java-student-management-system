import java.io.FileWriter;

public class FileWriteDemo {

    public static void main(String[] args) {

        try {

            FileWriter fw =
                new FileWriter("students.txt", true);

            fw.write("3,Ravi,22\n");
            fw.close();

            System.out.println("Saved");

        } catch (Exception e) {
            System.out.println("Error writing file");
        }
    }
}