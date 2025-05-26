package Task13.materials;

import java.awt.Color;
import javax.swing.*;
class JFrameSubclass3 extends JFrame{
	private static final int FRAME_WIDTH = 300;
    private static final int FRAME_HEIGHT = 200;
    private static final int FRAME_X_ORIGIN = 150;
    private static final int FRAME_Y_ORIGIN = 250;
	public JFrameSubclass3() {
        //set the frame default properties
        setTitle ("Blue Background JFrame Subclass");
        setSize (FRAME_WIDTH, FRAME_HEIGHT);
        setLocation (FRAME_X_ORIGIN, FRAME_Y_ORIGIN);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.getContentPane().setBackground(Color.BLUE);
    }

    public static void main( String[] args ) {
        JFrameSubclass3 frame;
        frame = new JFrameSubclass3();
        frame.setVisible(true);
    }
}