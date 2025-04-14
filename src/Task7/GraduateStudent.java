package Task7;

public class GraduateStudent extends Student {
    @Override
    public void computeCourseGrade() {
        if (getAverageScore() >= 80) {
            courseGrade = "Pass";
        } else {
            courseGrade = "Not Pass";
        }
    }
}
