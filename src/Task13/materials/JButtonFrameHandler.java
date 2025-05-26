package Task13.materials;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

class JButtonFrameHandler extends JFrame implements ActionListener
{

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
     * The Swing button for Cancel
     */
    private JButton cancelButton;


    /**
     * The Swing button for OK
     */
    private JButton okButton;




//----------------------------------
//    Constructors
//----------------------------------

    /**
     * Default constructor
     */
    public JButtonFrameHandler() {

        Container contentPane = getContentPane( );

        //set the frame properties
        setSize      (FRAME_WIDTH, FRAME_HEIGHT);
        setResizable (false);
        setTitle     ("Program Ch14JButtonFrameHandler");
        setLocation  (FRAME_X_ORIGIN, FRAME_Y_ORIGIN);

        //set the content pane properties
        contentPane.setLayout(new FlowLayout());
        //contentPane.setBackground(Color.white);

        //create and place two buttons on the frame's content pane
        okButton = new JButton("OK");
        contentPane.add(okButton);

        cancelButton = new JButton("CANCEL");
        contentPane.add(cancelButton);

        //registering this frame as an action listener of the two buttons
        cancelButton.addActionListener(this);
        okButton.addActionListener(this);

        //register 'Exit upon closing' as a default close operation
        setDefaultCloseOperation( EXIT_ON_CLOSE );
   }

//-------------------------------------------------
//      Public Methods:
//
//          void    actionPerformed   (   ActionEvent        )
//
//------------------------------------------------

    /**
     * Standard method to respond the action event.
     *
     * @param event the ActionEvent object
     *
     */
    public void actionPerformed(ActionEvent event) {
        JButton clickedButton = (JButton) event.getSource();

        String  buttonText = clickedButton.getText();

        this.setTitle("You clicked " + buttonText);
    }
	
//----------------------------------
//      Main method
//----------------------------------
    public static void main(String[] args) {
        JButtonFrameHandler frame = new JButtonFrameHandler();
        frame.setVisible(true);
    }

}