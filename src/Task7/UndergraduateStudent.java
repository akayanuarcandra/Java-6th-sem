package Task7;

public class UndergraduateStudent extends Student {
    @Override
    public void computeCourseGrade() {
        if (getAverageScore() >= 70) {
            courseGrade = "Pass";
        } else {
            courseGrade = "Not Pass";
        }
    }
}
