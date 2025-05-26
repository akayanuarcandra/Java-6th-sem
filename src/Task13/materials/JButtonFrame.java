package Task13.materials;

import java.awt.*;
import javax.swing.*;


class JButtonFrame extends JFrame {

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

    /**
     * The CANCEL button
     */
    private JButton cancelButton;
    
    /**
     * The OK button
     */
    private JButton okButton;




//----------------------------------
//    Constructors
//----------------------------------

    /**
     * Default constructor
     */
    public JButtonFrame() {

        Container contentPane = getContentPane( );
        contentPane.setLayout(new FlowLayout());

        //set the frame properties
        setSize      ( FRAME_WIDTH, FRAME_HEIGHT );
        setResizable ( false );
        setTitle     ( "JButtonFrame" );
        setLocation  ( FRAME_X_ORIGIN, FRAME_Y_ORIGIN );


        //create and place two buttons on the frame's content pane
        okButton = new JButton("OK");
        contentPane.add(okButton);
        
        cancelButton = new JButton("CANCEL");
        contentPane.add(cancelButton);
       
        //register 'Exit upon closing' as a default close operation
        setDefaultCloseOperation( EXIT_ON_CLOSE );

   }
//----------------------------------
//      Main method
//----------------------------------
    public static void main(String[] args) {
        JButtonFrame frame = new JButtonFrame();
        frame.setVisible(true);
    }
}
