package Task13.materials;

import java.awt.*;
import javax.swing.*;


class JFrameSubclass2 extends JFrame {

//----------------------------------
//    Data Members
//----------------------------------

    /**
     * Default frame width
     */
    private static final int FRAME_WIDTH    = 300;

    /**
     * Default frame height
     */
    private static final int FRAME_HEIGHT   = 200;

    /**
     * X coordinate of the frame default origin point
     */
    private static final int FRAME_X_ORIGIN = 150;

    /**
     * Y coordinate of the frame default origin point
     */
    private static final int FRAME_Y_ORIGIN = 250;

//----------------------------------
//      Main method
//----------------------------------
    public static void main(String[] args) {
        JFrameSubclass2 frame = new JFrameSubclass2();
        frame.setVisible(true);
    }


//----------------------------------
//    Constructors
//----------------------------------

    /**
     * Default constructor
     */
    public JFrameSubclass2( ) {

        //set the frame default properties
        setTitle     ( "Blue Background JFrame Subclass" );
        setSize      ( FRAME_WIDTH, FRAME_HEIGHT );
        setLocation  ( FRAME_X_ORIGIN, FRAME_Y_ORIGIN );

        //register 'Exit upon closing' as a default close operation
        setDefaultCloseOperation( EXIT_ON_CLOSE );

        changeBkColor( );
    }

    /**
     * change the backround color to white
     */
    private void changeBkColor() {
        Container contentPane = getContentPane();
        contentPane.setBackground(Color.BLUE);
   }
}