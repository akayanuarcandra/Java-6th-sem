package Task4;

public class Bicycle {
	int cadence = 0;
	int speed = 0;
	int gear = 1;
	String color;

	void changeCadence(int newValue) {
		cadence = newValue;
	}

	void changeGear(int newValue) {
		gear = newValue;
	}

	void speedUp(int increment) {
		speed = speed + increment;
	}

	void applyBrakes(int decrement) {
		speed = speed - decrement;
	}

	void setColor(String newValue) {
		color = newValue;
	}

	String getColor() {
		return color;
	}

	void printStates() {
		System.out.println(
				"cadence:" + cadence +
				" speed:" + speed +
				" gear:" + gear +
				" color:" + getColor());
	}

}
