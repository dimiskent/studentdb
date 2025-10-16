import java.io.Serializable;

public class Student implements Serializable {
    private final String name;
    private final int id;
    private final double grade;
    public Student(String name, int id, double grade) {
        this.name = name;
        this.id = id;
        this.grade = grade;
    }
    @Override
    public int hashCode() {
        return Integer.hashCode(id);
    }
    @Override
    public boolean equals(Object o) {
        if(this == o) return true;
        if(!(o instanceof Student)) return false;
        Student s = (Student) o;
        return s.id == id;
    }
    @Override
    public String toString() {
        return "[ " + "ID: " + id + ", " +
                "Name: " + name + ", " +
                "Grade: " + grade + "/100 ]";
    }
}
