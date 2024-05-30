package solution.view;

import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JPanel;
import solution.Settings;
import solution.controller.IController;

public class CalcOperations extends JPanel {
    private static final Settings settings = Settings.getInstance();


    public CalcOperations() {
        super(new GridLayout(5, 1));
    }

    public void setOperationButtonListener(ActionListener listener) {
        List<String> buttonLabels = IController.getOperationSymbols();

        for (String label : buttonLabels) {
            JButton button = new JButton(label);
            button.setFont(new Font(settings.FONT, Font.PLAIN, settings.FONT_SIZE));
            add(button);
            button.addActionListener(listener);
        }
    }

    public void setEqualsButtonListener(ActionListener listener) {
        JButton button = new JButton(settings.EQUAL_BUTTON);
        button.setFont(new Font(settings.FONT, Font.PLAIN, settings.FONT_SIZE));
        add(button);
        button.addActionListener(listener);
    }

}
