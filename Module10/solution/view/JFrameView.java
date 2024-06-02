package solution.view;


import javax.swing.JFrame;
import solution.Settings;
import solution.controller.IController;
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
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // set the display
        calcDisplay = new CalcDisplay();
        this.add(calcDisplay, BorderLayout.NORTH);

        // set the buttons plane
        CalcNumbers calcNumbers = new CalcNumbers();
        calcNumbers.setNumberButtonListener(this::calcNumbersListener);
        calcNumbers.setClearButtonListener(this::clearListener);

        this.add(calcNumbers, BorderLayout.WEST);

        // set the operations plane
        CalcOperations calcOperations = new CalcOperations();
        calcOperations.setOperationButtonListener(this::operationListener);
        calcOperations.setEqualsButtonListener(this::equalsListener);

        this.add(calcOperations);


        pack();
        calcDisplay.clear(); // make sure the display is clear at the beginning
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

    private void clearListener(ActionEvent e) {
        calcDisplay.clear();
    }

    private void operationListener(ActionEvent e) {
        JButton clickedButton = (JButton) e.getSource();
        String operationSymbol = clickedButton.getText();
        calcDisplay.updateDisplay(" " + operationSymbol + " ");
    }

    private void equalsListener(ActionEvent e) {
        try {
            Number result = controller.processOperation(calcDisplay.getText());
            calcDisplay.updateDisplay(result.toString(), false);
        } catch (Exception ex) {
            if (ex.getMessage() != null) {
                calcDisplay.updateDisplay(ex.getMessage(), false);
            } else {
                calcDisplay.updateDisplay("Error", false);
            }
        }
    }



    @Override
    public void start() {
        setVisible(true);
    }



}
