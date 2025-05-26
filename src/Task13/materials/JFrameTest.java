package Task13.materials;

import javax.swing.*;
class JFrameTest {	
	public static void main(String[ ] args) {
		JFrame	frame;
		frame = new JFrame( );
		frame.setSize(300, 200); 
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setTitle("My First Java OOP Program");
		//Add the ubiquitous "Hello World" label.
        JLabel label = new JLabel("Hello World");
        frame.getContentPane().add(label);
		frame.setVisible(true);
	//	JOptionPane.showMessageDialog( null, "I Love Java\n one\n two \n three" );
		String str = JOptionPane.showInputDialog(null, "Enter age:");
		int age = Integer.parseInt(str);
		JOptionPane.showMessageDialog(null, "Your age is "+age);


	}
}
