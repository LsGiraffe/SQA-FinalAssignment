import java.util.ArrayList;
import java.util.List;

public class Rubric {
    String _name;
    List<Criterion> _criterions = new ArrayList<>();
    List<StudentGrade> _sudentGrades = new ArrayList<>();

    public Rubric(String name) {
        this._name = name;
    }

    public void addCriterion(Criterion criterion) {
        this._criterions.add(criterion);
    }

    public void createStudentGrade(String criterion, String studentGrade) throws Exception {
        if (_criterions.size() == 0) {
            throw new Exception("No criterion found");
        }
        boolean found = false;
        for (Criterion value : _criterions) {
            if (criterion.equals(value._name)) {
                value._studentGrades.add(new StudentGrade(studentGrade, 0));
                found = true;
            }
        }
        if (!found) {
            throw new Exception("Criterion not found");
        }
    }
}
