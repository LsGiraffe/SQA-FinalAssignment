import java.util.ArrayList;
import java.util.List;

public class Controller {
    List<Rubric> _rubrics = new ArrayList<>();

    public Controller () {}

    public void addRubric(String name) {
        this._rubrics.add(new Rubric(name));
    }
}
