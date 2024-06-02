package student.view;

import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.LinkedList;
import javax.swing.JButton;
import javax.swing.JPanel;
import student.Settings;
import student.controller.IController;

public class CalcOperations extends JPanel {
    private static final Settings settings = Settings.getInstance();
    private List<JButton> opsButtons = new LinkedList<>();
    private JButton equalsButton;

    public CalcOperations() {
        super(new GridLayout(5, 1));
        addOperationButtons();
        addEqualsButton();

    }

    private void addOperationButtons() {
        List<String> buttonLabels = IController.getOperationSymbols();

        for (String label : buttonLabels) {
            JButton button = new JButton(label);
            button.setFont(new Font(settings.FONT, Font.PLAIN, settings.FONT_SIZE));
            opsButtons.add(button);
            add(button);
        }
    }

    private void addEqualsButton() {
        equalsButton = new JButton(settings.EQUAL_BUTTON);
        equalsButton.setFont(new Font(settings.FONT, Font.PLAIN, settings.FONT_SIZE));
        add(equalsButton);
    }



    public void setOperationButtonListener(ActionListener listener) {
        for (JButton button : opsButtons) {
            button.addActionListener(listener);
        }
    }

    public void setEqualsButtonListener(ActionListener listener) {
        equalsButton.addActionListener(listener);
    }

}
