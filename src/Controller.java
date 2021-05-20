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
}
