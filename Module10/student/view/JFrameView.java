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
        super(settings.CAPTION); // this is for setting the title of the window
        this.controller = controller;
        setLocationRelativeTo(null); // center the window
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // close the application when the window is
                                                        // closed

        // set the display
        calcDisplay = new CalcDisplay();
        this.add(calcDisplay, BorderLayout.NORTH);

        // set the buttons plan
        CalcNumbers calcNumbers = new CalcNumbers();
        calcNumbers.setNumberButtonListener(this::calcNumbersListener);
        calcNumbers.setClearButtonListener(this::clearListener);
        this.add(calcNumbers, BorderLayout.WEST);


        // set the operations plane
        CalcOperations calcOperations = new CalcOperations();
        calcOperations.setOperationButtonListener(this::calcOperationListener);
        calcOperations.setEqualsButtonListener(this::calcEqualsListener);
        this.add(calcOperations, BorderLayout.EAST);





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

    private void calcOperationListener(ActionEvent e) {
        JButton clickedButton = (JButton) e.getSource();
        String buttonLabel = clickedButton.getText();
        calcDisplay.updateDisplay(" " + buttonLabel + " ");
    }


    private void clearListener(ActionEvent e) {
        calcDisplay.clear();
    }

    private void calcEqualsListener(ActionEvent e) {
        try {
            Number result = controller.processOperation(calcDisplay.getText());
            calcDisplay.updateDisplay(result.toString(), false);
        } catch (Exception ex) {
            calcDisplay.updateDisplay(ex.getMessage(), false);
        }

    }

    @Override
    public void start() {
        calcDisplay.clear(); // for initializing the display to 0
        setVisible(true);
    }



}
