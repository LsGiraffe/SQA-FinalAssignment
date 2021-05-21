import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ControllerTest {
    Controller controller = new Controller();

    @org.junit.jupiter.api.Test
    void addRubric() {
        assertEquals(0, controller._rubrics.size());
        controller.addRubric("Rubric1");
        controller.addRubric("Rubric2");
        assertEquals(2, controller._rubrics.size());
        assertEquals("Rubric1", controller._rubrics.get(0)._name);
    }

    @org.junit.jupiter.api.Test
    void getRubricByName() throws Exception {
        controller.addRubric("Rubric1");
        controller.addRubric("Rubric2");
        Rubric rubric = controller.getRubricByName("Rubric1");
        assertEquals("Rubric1", rubric._name);
    }

    @org.junit.jupiter.api.Test
    void getAllRubrics() {
        controller.addRubric("Rubric1");
        controller.addRubric("Rubric2");
        List<Rubric> rubrics = controller.getAllRubrics();
        assertEquals("Rubric1", controller._rubrics.get(0)._name);
        assertEquals("Rubric2", controller._rubrics.get(1)._name);
    }

    @org.junit.jupiter.api.Test
    void addCriterion() throws Exception {
        controller.addRubric("Rubric1");
  //      controller.addRubric("Rubric2");
        assertEquals(0, controller._rubrics.get(0)._criterions.size());
        controller.addCriterion("Rubric1", new Criterion("Criterion"));
        assertEquals(1, controller._rubrics.get(0)._criterions.size());
        assertEquals("Criterion", controller._rubrics.get(0)._criterions.get(0)._name);
    }

    @org.junit.jupiter.api.Test
    void createNewStudentGrade() throws Exception {
        controller.addRubric("Rubric1");
        controller.addCriterion("Rubric1", new Criterion("Criterion"));
        assertEquals(0, controller._rubrics.get(0)._criterions.get(0)._studentGrades.size());
        controller.createNewStudentGrade("Rubric1", "Criterion", "Louis", 10);
        assertEquals(1, controller._rubrics.get(0)._criterions.get(0)._studentGrades.size());
        assertEquals("Louis", controller._rubrics.get(0)._criterions.get(0)._studentGrades.get(0)._studentName);
        assertEquals(10, controller._rubrics.get(0)._criterions.get(0)._studentGrades.get(0)._grade);
    }
}