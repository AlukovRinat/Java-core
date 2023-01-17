package lesson9.Student;

public class CurseImp1 extends Course {
    private String name;

    public void CourseImpl(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }
}
