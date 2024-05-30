package solution.view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import solution.Settings;

public class CalcDisplay extends JLabel {
    private static final Settings settings = Settings.getInstance();

    private StringBuffer current = new StringBuffer("");

    public CalcDisplay() {
        setOpaque(true);
        setBackground(Color.BLACK);
        setForeground(Color.WHITE);
        setHorizontalAlignment(SwingConstants.RIGHT);
        setFont(new Font(settings.FONT, Font.PLAIN, settings.FONT_SIZE));
        setPreferredSize(new Dimension(getWidth(), 60));
    }


    public void updateDisplay(String text) {
        updateDisplay(text, true);
    }

    public void updateDisplay(String text, boolean append) {
        if (current.toString().equals("Error")) {
            current.setLength(0);
        }
        if (append) {
            current.append(text);
        } else {
            current.setLength(0);
            current.append(text);
        }
        String result = cleanText(current);
        setText(result);
    }

    private String cleanText(StringBuffer buf) {
        String text = buf.toString().trim().replaceAll("\\s+", " ");
        return text;
    }


    public void clear() {
        current.setLength(0);
        updateDisplay("0");
    }

    public String getText() {
        if (current != null)
            return current.toString();
        else
            return "";
    }

}
