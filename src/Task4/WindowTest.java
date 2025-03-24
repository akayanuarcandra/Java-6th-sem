package Task4;
import javax.swing.*;

class WindowTest {
	public static void main(String[ ] args) {
		JFrame	myWindow;
		myWindow = new JFrame( );
		myWindow.setSize(300, 200);
		myWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		myWindow.setTitle("My First Java OOP Program");
		myWindow.setVisible(true);
	}
}
