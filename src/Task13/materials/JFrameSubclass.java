package Task13.materials;

import javax.swing.*;
public class JFrameSubclass extends JFrame{
    private static final int FRAME_WIDTH = 300;
    private static final int FRAME_HEIGHT = 200;
    private static final int FRAME_X_ORIGIN = 1500;
    private static final int FRAME_Y_ORIGIN = 250;
    public JFrameSubclass ( ) {
		//set the frame default properties
		setTitle ("My First Subclass");
		setSize (FRAME_WIDTH, FRAME_HEIGHT);
		setLocation (FRAME_X_ORIGIN, FRAME_Y_ORIGIN);
		//register 'Exit upon closing' as a default close operation
		setDefaultCloseOperation( EXIT_ON_CLOSE );
    }
	public static void main( String[] args ) {
        JFrameSubclass frame;
        frame = new JFrameSubclass();
        frame.setVisible(true);
    }
}
