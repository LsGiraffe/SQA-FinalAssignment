import java.util.ArrayList;
import java.util.List;

public class Controller {
    List<Rubric> _rubrics = new ArrayList<>();

    public Controller () {}

    public void addRubric(String name) {
        this._rubrics.add(new Rubric(name));
    }

    public Rubric getRubricByName(String name) throws Exception {
        for (int i = 0; i <= _rubrics.size(); i = i + 1) {
            if (name.equals(_rubrics.get(i)._name)) {
                return (_rubrics.get(i));
            }
        }
        throw new Exception("Rubric not found");
    }

    public List<Rubric> getAllRubrics() { return this._rubrics; }

    public void addCriterion(String rubric, Criterion criterion) throws Exception {
        if (_rubrics.size() == 0) {
            throw new Exception("No rubric found");
        }
        boolean found = false;
        for (Rubric value : _rubrics) {
            if (rubric.equals(value._name)) {
                value.addCriterion(criterion);
                found = true;
            }
        }
        if (!found) {
            throw new Exception("Rubric not found");
        }
    }

    public void createNewStudentGrade(String rubric, String criterion, String studentName, int grade) throws Exception {
        if (_rubrics.size() == 0) {
            throw new Exception("No rubric found");
        }
        boolean found = false;
        for (Rubric value : _rubrics) {
            if (rubric.equals(value._name)) {
                value.createStudentGrade(criterion, studentName, grade);
                found = true;
            }
        }
        if (!found) {
            throw new Exception("Rubric not found");
        }
    }

    public List<StudentGrade> getAllGrades(String rubric) throws Exception {
        if (_rubrics.size() == 0) {
            throw new Exception("No rubric found");
        }
        List<StudentGrade> grades = null;
        boolean found = false;
        for (Rubric value : _rubrics) {
            if (rubric.equals(value._name)) {
                grades = value.getGrades();
                found = true;
            }
        }
        if (!found) {
            throw new Exception("Rubric not found");
        }
        return (grades);
    }
}
