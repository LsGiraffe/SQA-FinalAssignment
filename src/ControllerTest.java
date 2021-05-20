import static org.junit.jupiter.api.Assertions.*;

class ControllerTest {
    Controller controller = new Controller();
    @org.junit.jupiter.api.Test
    void addRubric() {
        assertEquals(0, controller._rubrics.size());
        controller.addRubric("Rubric");
        assertEquals(1, controller._rubrics.size());
        assertEquals("Rubric", controller._rubrics.get(0)._name);
    }
}