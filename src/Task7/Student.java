package Task7;

public class Student {
    protected final int NumberOfTest = 3;
    protected String name;
    protected int[] test;
    protected String courseGrade;
    protected double averageScore;
    protected char type; // U for Undergraduate, G for Graduate

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

    public void setType(char type) {
        this.type = type;
    }

    public char getType() {
        return type;
    }

    public void displayInfo() {

    }
}
