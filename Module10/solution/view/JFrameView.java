package solution.view;


import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import solution.controller.IController;
import javax.swing.JButton;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Properties;

public class JFrameView extends JFrame implements IView {

    private static Properties properties;
    private static final String CAPTION;
    private IController controller;
    private StringBuffer current = new StringBuffer();
    JLabel calcDisplay;

    public JFrameView(IController controller) {
        super(CAPTION);
        this.controller = controller;


        // setSize(300, 300);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);



        // this.setLayout(new FlowLayout());

        setCalcDisplay();

        setCalcButtons();

        setOperationButtons();


        pack();

    }


    private void setCalcDisplay() {
        calcDisplay = new JLabel();
        calcDisplay.setOpaque(true);
        calcDisplay.setBackground(Color.BLACK);
        calcDisplay.setForeground(Color.WHITE);
        calcDisplay.setHorizontalAlignment(SwingConstants.RIGHT);
        calcDisplay.setFont(new Font("Arial", Font.PLAIN, 20));
        calcDisplay.setPreferredSize(new Dimension(getWidth(), 50));
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
            button.setFont(new Font("Arial", Font.PLAIN, 20));
            buttonPanel.add(button);
            button.addActionListener(e -> {
                JButton clickedButton = (JButton) e.getSource();
                String buttonLabel = clickedButton.getText();
                current.append(buttonLabel);
                displayResult();
            });
        }
        this.add(buttonPanel, BorderLayout.WEST);
    }


    private void setOperationButtons() {
        JPanel operationPanel = new JPanel(new GridLayout(5, 1));
        List<String> operations = IController.getOperationSymbols();

        for (String operation : operations) {
            JButton button = new JButton(operation);
            button.setFont(new Font("Arial", Font.PLAIN, 20));
            operationPanel.add(button);
            button.addActionListener(e -> {
                JButton clickedButton = (JButton) e.getSource();
                String operationSymbol = clickedButton.getText();
                current.append(" " + operationSymbol + " ");
                displayResult();
            });
        }

        JButton equalsButton = new JButton("=");
        equalsButton.setFont(new Font("Arial", Font.PLAIN, 20));
        operationPanel.add(equalsButton);
        equalsButton.addActionListener(e -> {
            String text = cleanText(current);
            try {
                Number result = controller.processOperation(text);
                current = new StringBuffer(result.toString());
            } catch (Exception ex) {
                current = new StringBuffer(ex.getMessage());
            }
            displayResult();
            current.setLength(0);
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



    static {
        loadProperties();
        CAPTION = properties.getProperty("frame_caption");
    }

    private static void loadProperties() {
        properties = new Properties();
        try {
            InputStream fis = JFrameView.class.getResourceAsStream("keys.properties");
            properties.loadFromXML(fis);
            fis.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
