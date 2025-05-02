package Task7;

public class GraduateStudent extends Student {
    String supervisor;

    public GraduateStudent() {
        this.type = 'G';
    }

    public void setSupervisor(String supervisor) {
        this.supervisor = supervisor;
    }

    public String getSupervisor() {
        return supervisor;
    }

    @Override
    public void computeCourseGrade() {
        if (getAverageScore() >= 80) {
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
        System.out.println("Supervisor: " + supervisor);
    }
}
