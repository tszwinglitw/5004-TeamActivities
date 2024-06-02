package student.view;


import javax.swing.JFrame;
import student.Settings;
import student.controller.IController;
import javax.swing.JButton;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;

public class JFrameView extends JFrame implements IView {


    private static final Settings settings = Settings.getInstance();
    private IController controller;
    CalcDisplay calcDisplay;

    public JFrameView(IController controller) {
        super(settings.CAPTION);
        this.controller = controller;
        setLocationRelativeTo(null); // center the window
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // close the application when the window is
                                                        // closed

        // set the display
        // calcDisplay = new CalcDisplay();
        // this.add(calcDisplay, BorderLayout.NORTH);

        // set the buttons plane
        // CalcNumbers calcNumbers = new CalcNumbers();
        // calcNumbers.setNumberButtonListener(this::calcNumbersListener);



        // set the operations plane


        pack(); // ensures frame is large enough to display all components, but not larger than
                // necessary
    }


    private void calcNumbersListener(ActionEvent e) {
        JButton clickedButton = (JButton) e.getSource();
        String buttonLabel = clickedButton.getText();
        if (calcDisplay.getText().equals("0") && !buttonLabel.equals(".")) {
            calcDisplay.updateDisplay(buttonLabel, false);
        } else {
            calcDisplay.updateDisplay(buttonLabel);
        }


    }



    @Override
    public void start() {
        // do you need to add anything here?
    }



}
