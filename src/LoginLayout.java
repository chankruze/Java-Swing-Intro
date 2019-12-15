import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

class LoginLayout {

    LoginLayout() {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ignored) {
                }

                JFrame frame = new JFrame("Test");
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setLayout(new BorderLayout());
                frame.add(new MainPane());
                frame.pack();
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);
            }

        });
    }

    public class MainPane extends JPanel {

        private JTextField messageField;
        private JButton sendButton;

        MainPane() {
            setBorder(new EmptyBorder(4, 4, 4, 4));
            setLayout(new GridBagLayout());
            GridBagConstraints gbc = new GridBagConstraints();
            gbc.gridx = 0;
            gbc.gridy = 0;
            gbc.weightx = 1;
            gbc.fill = GridBagConstraints.HORIZONTAL;
            gbc.gridwidth = GridBagConstraints.REMAINDER;
            add(new LoginPane(), gbc);
            gbc.gridy++;
            add(new ConnectPane(), gbc);
            gbc.gridy++;
            gbc.weighty = 1;
            gbc.fill = GridBagConstraints.BOTH;
            add(new JScrollPane(new JTextArea(5, 20)), gbc);

            gbc.gridwidth = 1;

            messageField = new JTextField(10);
            sendButton = new JButton("Send");

            gbc.gridy++;
            gbc.weighty = 0;
            gbc.fill = GridBagConstraints.HORIZONTAL;
            add(messageField, gbc);
            gbc.gridx++;
            gbc.weightx = 0;
            add(sendButton, gbc);
        }

    }

    public class ConnectPane extends JPanel {

        private JComboBox comboBox;
        private JButton connectButton;

        ConnectPane() {
            comboBox = new JComboBox();
            connectButton = new JButton("Connect");

            setLayout(new GridBagLayout());
            GridBagConstraints gbc = new GridBagConstraints();
            gbc.gridx = 0;
            gbc.gridy = 0;
            gbc.anchor = GridBagConstraints.WEST;
            add(comboBox, gbc);

            gbc.gridx++;
            gbc.weightx = 1;
            add(connectButton, gbc);
        }

    }

    public class LoginPane extends JPanel {

        private JTextField userNameField;
        private JPasswordField passwordField;
        private JButton loginButton;

        LoginPane() {

            userNameField = new JTextField(10);
            passwordField = new JPasswordField(10);
            loginButton = new JButton("Login");

            setLayout(new GridBagLayout());
            GridBagConstraints gbc = new GridBagConstraints();
            gbc.anchor = GridBagConstraints.WEST;
            gbc.gridx = 0;
            gbc.gridy = 0;
            add(new JLabel("User name:"), gbc);

            gbc.gridx++;
            add(userNameField, gbc);

            gbc.gridx++;
            add(new JLabel("Password:"), gbc);

            gbc.gridx++;
            add(passwordField, gbc);

            gbc.gridx++;
            gbc.weightx = 1;
            add(loginButton, gbc);

        }

    }

}