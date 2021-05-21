import java.util.ArrayList;
import java.util.List;

public class Criterion {
    String _name;
    List<StudentGrade> _studentGrades = new ArrayList<>();

    public Criterion(String name) {
        _name = name;
    }

    public void addStudentGrade(StudentGrade grade) {
        this._studentGrades.add(grade);
    }

    public double getAverage() throws Exception {
        int gradesSum = 0;

        for (StudentGrade value : _studentGrades) {
            gradesSum += value._grade;
        }
        return (gradesSum / _studentGrades.size());
    }
}
