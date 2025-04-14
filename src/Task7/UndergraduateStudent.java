package Task7;

public class UndergraduateStudent extends Student {
    String major;

    public UndergraduateStudent() {
        this.type = 'U';
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public String getMajor() {
        return major;
    }

    @Override
    public void computeCourseGrade() {
        if (getAverageScore() >= 70) {
            courseGrade = "Pass";
        } else {
            courseGrade = "Not Pass";
        }
    }

    @Override
    public void displayInfo() {
        System.out.println("Name: " + name);
        System.out.println("Average Score: " + getAverageScore());
        System.out.println("Course Grade: " + courseGrade);
        System.out.println("Type: " + type);
        System.out.println("Major: " + major);
    }
}
