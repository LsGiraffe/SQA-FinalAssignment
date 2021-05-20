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
}
