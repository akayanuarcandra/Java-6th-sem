package Task7;

public class Student {
    private final int NumberOfTest = 3;
    private String name;
    private int[] test;
    protected String courseGrade;
    protected double averageScore;

    public Student() {

    }

    public Student(String name){
        this.name = name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setTestScore(int testNumber, int testScore) {
        if (test == null) {
            test = new int[NumberOfTest];
        }
        if (testNumber > 0 && testNumber <= NumberOfTest) {
            test[testNumber - 1] = testScore;
        } else {
            System.out.println("Invalid test number");
        }
    }

    public int getTestScore(int index) {
        return test[index];
    }

    public void setCourseGrade(String courseGrade) {
        this.courseGrade = courseGrade;
    }

    public String getCourseGrade() {
        return courseGrade;
    }

    public double getAverageScore() {
        int sum = 0;
        for (int i = 0; i < NumberOfTest; i++) {
            sum += test[i];
        }
        return averageScore = (double) sum / NumberOfTest;
    }

    public void computeCourseGrade() {

    }
}
