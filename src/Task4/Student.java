package Task4;

public class Student {
    int id;
    String name;
    Gender gender;
    int phone;

    enum Gender {
        MALE, FEMALE
    }

    void setID(int id) {
        this.id = id;
    }

    int getID() {
        return id;
    }

    void setName(String name) {
        this.name = name;
    }

    String getName() {
        return name;
    }

    void setGender(Gender gender) {
        this.gender = gender;
    }

    Gender getGender() {
        return gender;
    }

    void setPhone(int phone) {
        this.phone = phone;
    }

    int getPhone() {
        return phone;
    }

    void printInfo() {
        System.out.println("ID: " + getID() + "\n" + "Name: " + getName() + "\n" + "Gender: " + getGender() + "\n" + "Phone: " + getPhone());
    }
}