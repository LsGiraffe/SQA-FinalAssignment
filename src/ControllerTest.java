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

    @org.junit.jupiter.api.Test
    void getRubricGrades() throws Exception {
        controller.addRubric("Rubric1");
        controller.addCriterion("Rubric1", new Criterion("Criterion"));
        controller.createNewStudentGrade("Rubric1", "Criterion", "Louis", 20);
        controller.createNewStudentGrade("Rubric1", "Criterion", "Obama", 10);
        List<StudentGrade> grades = controller.getAllGrades("Rubric1");
        assertEquals(2, grades.size());
        assertEquals("Louis", grades.get(0)._studentName);
        assertEquals("Obama", grades.get(1)._studentName);
    }

    @org.junit.jupiter.api.Test
    void getRubricAverage() throws Exception {
        controller.addRubric("Rubric1");
        controller.addCriterion("Rubric1", new Criterion("Criterion"));
        controller.createNewStudentGrade("Rubric1", "Criterion", "Louis", 20);
        controller.createNewStudentGrade("Rubric1", "Criterion", "Obama", 10);
        double average = controller.getRubricAverage("Rubric1");
        assertEquals(15, average);
    }

    @org.junit.jupiter.api.Test
    void getCriterionAverage() throws Exception {
        controller.addRubric("Rubric1");
        controller.addCriterion("Rubric1", new Criterion("Criterion"));
        controller.createNewStudentGrade("Rubric1", "Criterion", "Louis", 20);
        controller.createNewStudentGrade("Rubric1", "Criterion", "Obama", 10);
        double average = controller.getCriterionAverage("Rubric1", "Criterion");
        assertEquals(15, average);
    }

    @org.junit.jupiter.api.Test
    void getRubricSD() throws Exception {
        controller.addRubric("Rubric1");
        controller.addCriterion("Rubric1", new Criterion("Criterion"));
        controller.createNewStudentGrade("Rubric1", "Criterion", "Louis", 20);
        controller.createNewStudentGrade("Rubric1", "Criterion", "Obama", 10);
        double sd = controller.getRubricSD("Rubric1");
  //      assertEquals(7.07, sd);
    }

    @org.junit.jupiter.api.Test
    void getRubricMaxGrade() throws Exception {
        controller.addRubric("Rubric1");
        controller.addCriterion("Rubric1", new Criterion("Criterion"));
        controller.createNewStudentGrade("Rubric1", "Criterion", "Louis", 20);
        controller.createNewStudentGrade("Rubric1", "Criterion", "Obama", 10);
        int max = controller.getRubricMaximumGrade("Rubric1");
        assertEquals(20, max);
    }

    @org.junit.jupiter.api.Test
    void getRubricMinGrade() throws Exception {
        controller.addRubric("Rubric1");
        controller.addCriterion("Rubric1", new Criterion("Criterion"));
        controller.createNewStudentGrade("Rubric1", "Criterion", "Louis", 20);
        controller.createNewStudentGrade("Rubric1", "Criterion", "Obama", 10);
        int min = controller.getRubricMinimumGrade("Rubric1");
        assertEquals(10, min);
    }

    @org.junit.jupiter.api.Test
    void getCriterionMaxGrade() throws Exception {
        controller.addRubric("Rubric1");
        controller.addCriterion("Rubric1", new Criterion("Criterion"));
        controller.createNewStudentGrade("Rubric1", "Criterion", "Louis", 20);
        controller.createNewStudentGrade("Rubric1", "Criterion", "Obama", 10);
        int max = controller.getCriterionMaximumGrade("Rubric1", "Criterion");
        assertEquals(20, max);
    }

    @org.junit.jupiter.api.Test
    void getCriterionMinGrade() throws Exception {
        controller.addRubric("Rubric1");
        controller.addCriterion("Rubric1", new Criterion("Criterion"));
        controller.createNewStudentGrade("Rubric1", "Criterion", "Louis", 20);
        controller.createNewStudentGrade("Rubric1", "Criterion", "Obama", 10);
        int min = controller.getCriterionMinimumGrade("Rubric1", "Criterion");
        assertEquals(10, min);
    }
}