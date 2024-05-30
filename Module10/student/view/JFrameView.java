package student.view;


import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import student.Settings;
import student.controller.IController;
import javax.swing.JButton;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.util.List;

public class JFrameView extends JFrame implements IView {


    private static final Settings settings = Settings.getInstance();
    private IController controller;
    private StringBuffer current = new StringBuffer();
    JLabel calcDisplay;

    public JFrameView(IController controller) {
        super(settings.CAPTION);
        this.controller = controller;
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // this.setLayout(new FlowLayout());
        setCalcDisplay();
        setCalcButtons();
        setOperationButtons();
        clear();
        pack();

    }


    private void setCalcDisplay() {
        calcDisplay = new JLabel();
        calcDisplay.setOpaque(true);
        calcDisplay.setBackground(Color.BLACK);
        calcDisplay.setForeground(Color.WHITE);
        calcDisplay.setHorizontalAlignment(SwingConstants.RIGHT);
        calcDisplay.setFont(new Font(settings.FONT, Font.PLAIN, settings.FONT_SIZE));
        calcDisplay.setPreferredSize(new Dimension(getWidth(), 60));
        this.add(calcDisplay, BorderLayout.NORTH);

    }

    public void displayResult() {
        String result = cleanText(current);
        calcDisplay.setText(result);
    }

    private void setCalcButtons() {
        JPanel buttonPanel = new JPanel(new GridLayout(4, 3));
        String[] buttonLabels = {"1", "2", "3", "4", "5", "6", "7", "8", "9", ".", "0"};

        for (String label : buttonLabels) {
            JButton button = new JButton(label);
            button.setFont(new Font(settings.FONT, Font.PLAIN, settings.FONT_SIZE));
            buttonPanel.add(button);
            button.addActionListener(e -> {
                JButton clickedButton = (JButton) e.getSource();
                String buttonLabel = clickedButton.getText();
                if (current.toString().equals("0") && !buttonLabel.equals(".")) {
                    current.setLength(0);
                }
                current.append(buttonLabel);
                displayResult();
            });
        }

        JButton clearButton = new JButton("C");
        clearButton.setFont(new Font(settings.FONT, Font.PLAIN, settings.FONT_SIZE));
        buttonPanel.add(clearButton);
        clearButton.addActionListener(e -> {
            clear();
        });


        this.add(buttonPanel, BorderLayout.WEST);
    }

    private void clear() {
        current.setLength(0);
        current.append("0");
        displayResult();
    }

    private void setOperationButtons() {
        JPanel operationPanel = new JPanel(new GridLayout(5, 1));
        List<String> operations = IController.getOperationSymbols();

        for (String operation : operations) {
            JButton button = new JButton(operation);
            button.setFont(new Font(settings.FONT, Font.PLAIN, settings.FONT_SIZE));
            operationPanel.add(button);
            button.addActionListener(e -> {
                JButton clickedButton = (JButton) e.getSource();
                String operationSymbol = clickedButton.getText();
                current.append(" " + operationSymbol + " ");
                displayResult();
            });
        }

        JButton equalsButton = new JButton("=");
        equalsButton.setFont(new Font(settings.FONT, Font.PLAIN, settings.FONT_SIZE));
        operationPanel.add(equalsButton);
        equalsButton.addActionListener(e -> {
            String text = cleanText(current);
            try {
                Number result = controller.processOperation(text);
                current = new StringBuffer(result.toString());
            } catch (Exception ex) {
                if (ex.getMessage() != null) {
                    current = new StringBuffer(ex.getMessage());
                } else {
                    current = new StringBuffer("Error");
                }
            }
            displayResult();
        });

        this.add(operationPanel);
    }


    private String cleanText(StringBuffer buf) {
        String text = buf.toString().trim().replaceAll("\\s+", " ");
        return text;
    }

    @Override
    public void start() {
        setVisible(true);
    }



}
