package solution.view;

import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JPanel;
import solution.Settings;

public class CalcNumbers extends JPanel {
    private static Settings settings = Settings.getInstance();

    public CalcNumbers() {
        super(new GridLayout(4, 3));
    }

    public void setNumberButtonListener(ActionListener listener) {
        String[] buttonLabels = settings.NUMBERS.split(",");

        for (String label : buttonLabels) {
            JButton button = new JButton(label);
            button.setFont(new Font(settings.FONT, Font.PLAIN, settings.FONT_SIZE));
            add(button);
            button.addActionListener(listener);
        }
    }

    public void setClearButtonListener(ActionListener listener) {
        JButton button = new JButton(settings.CLEAR_BUTTON);
        button.setFont(new Font(settings.FONT, Font.PLAIN, settings.FONT_SIZE));
        button.addActionListener(listener);
        add(button);
    }

}
