import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class BasicWidgets {

    private JFrame jFrame;
    private JButton jButton;
    private JLabel jLabel;
    private JTextField jTextField;

    BasicWidgets() {
        this.jFrame = new JFrame();
        this.jButton = new JButton();
        this.jLabel = new JLabel();
        this.jTextField = new JTextField();
    }

    void initViews() {
        jTextField.setBounds(10, 10, 380, 25);

        jLabel.setBounds(10, 60, 480, 20);
        jFrame.add(jLabel);

        jButton.setText("Set Text");
        jButton.setBounds(390, 10, 100, 24);
        jButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                System.out.println("Working");
                jLabel.setText(jTextField.getText());
                jFrame.invalidate();
            }
        });

        jFrame.add(jTextField);
        jFrame.add(jButton);

        jFrame.getContentPane().setBackground(Color.WHITE);
        jFrame.setSize(500, 1000);
        jFrame.setLayout(null);

        jFrame.setVisible(true);
    }
}