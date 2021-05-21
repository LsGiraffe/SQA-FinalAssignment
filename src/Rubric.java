import java.util.ArrayList;
import java.util.List;
import static java.lang.Math.*;

public class Rubric {
    String _name;
    List<Criterion> _criterions = new ArrayList<>();
    List<StudentGrade> _studentGrades = new ArrayList<>();

    public Rubric(String name) {
        this._name = name;
    }

    public void addCriterion(Criterion criterion) {
        this._criterions.add(criterion);
    }

    public void createStudentGrade(String criterion, String studentGrade, int grade) throws Exception {
        if (_criterions.size() == 0) {
            throw new Exception("No criterion found");
        }
        boolean found = false;
        for (Criterion value : _criterions) {
            if (criterion.equals(value._name)) {
                value._studentGrades.add(new StudentGrade(studentGrade, grade));
                found = true;
            }
        }
        if (!found) {
            throw new Exception("Criterion not found");
        }
    }

    public List<StudentGrade> getGrades() throws Exception {
        if (_criterions.size() == 0) {
            throw new Exception("No criterion found");
        }
        List<StudentGrade> grades = new ArrayList<>();
        for (Criterion crit : _criterions) {
            for (StudentGrade grd : crit._studentGrades) {
                grades.add(grd);
            }
        }
        return (grades);
    }

    public double getRubricAverage() throws Exception {
        int gradesSum = 0;
        List<StudentGrade> grades = this.getGrades();

        for (StudentGrade value : grades) {
            gradesSum += value._grade;
        }
        return (gradesSum / grades.size());
    }

    public double getRubricStandardDeviation() throws Exception {
        double mean = getRubricAverage();
        double sum = 0;
        List<StudentGrade> grades = this.getGrades();
        for (StudentGrade value : grades) {
            sum += abs(sqrt(value._grade - mean));
            System.out.println(sum);
        }
        sum = sum / grades.size();
        return (sqrt(sum));
    }

    public int getMaxGrade() throws Exception {
        List<StudentGrade> grades = this.getGrades();
        int max = 0;
        for (StudentGrade grade : grades) {
            if (grade._grade > max) {
                max = grade._grade;
            }
        }
        return (max);
    }

    public int getMinGrade() throws Exception {
        List<StudentGrade> grades = this.getGrades();
        int min = 10000;
        for (StudentGrade grade : grades) {
            if (grade._grade < min) {
                min = grade._grade;
            }
        }
        return (min);
    }

    public int getMaxCriterionGrade(String criterion) throws Exception {
        int max = 0;
        if (_criterions.size() == 0) {
            throw new Exception("No criterion found");
        }
        boolean found = false;
        for (Criterion value : _criterions) {
            if (criterion.equals(value._name)) {
                for (StudentGrade grade : value._studentGrades) {
                    if (grade._grade > max) {
                        max = grade._grade;
                    }
                }
                found = true;
            }
        }
        if (!found) {
            throw new Exception("Criterion not found");
        }
        return (max);
    }

    public int getMinCriterionGrade(String criterion) throws Exception {
        int min = 100000;
        if (_criterions.size() == 0) {
            throw new Exception("No criterion found");
        }
        boolean found = false;
        for (Criterion value : _criterions) {
            if (criterion.equals(value._name)) {
                for (StudentGrade grade : value._studentGrades) {
                    if (grade._grade < min) {
                        min = grade._grade;
                    }
                }
                found = true;
            }
        }
        if (!found) {
            throw new Exception("Criterion not found");
        }
        return (min);
    }
}
