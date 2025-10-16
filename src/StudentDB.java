import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class StudentDB {
    private final String file;
    public StudentDB(String file) {
        this.file = file;
    }
    public List<Student> getStudents() {
        try(ObjectInputStream stream = new ObjectInputStream(new FileInputStream(file))) {
            List<Student> students = (List<Student>) stream.readObject();
            return students;
        } catch (FileNotFoundException e) {
            System.out.println("Database file can't be found!");
        } catch (ClassNotFoundException e) {
            System.out.println("Class error!");
        } catch (IOException e) {
            System.out.println("Unknown file I/O error!");
            e.printStackTrace();
        }
        System.out.println("Starting from scratch :)");
        return new ArrayList<>();
    }
    public void saveStudents(List<Student> students) {
        try(ObjectOutputStream stream = new ObjectOutputStream(new FileOutputStream(file))) {
            stream.writeObject(students);
            System.out.println("Students have been saved successfully!");
        } catch (IOException e) {
            System.out.println("A file I/O exception has occurred!");
            e.printStackTrace();
        }
    }
}
