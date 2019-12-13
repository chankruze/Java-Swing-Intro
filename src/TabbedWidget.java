import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;

class TabbedWidget {

    private JFrame jFrame;
    private JTabbedPane tabbedPane;
    private JComponent panel1, panel2, panel3, panel4;

    TabbedWidget() {
        this.jFrame = new JFrame();
        this.tabbedPane = new JTabbedPane();
        this.panel1 = makeTextPanel("Panel #1");
        this.panel2 = makeTextPanel("Panel #2");
        this.panel3 = makeTextPanel("Panel #3");
        this.panel4 = makeTextPanel(
                "Panel #4 (has a preferred size of 410 x 50).");
//        this.panel4.setPreferredSize(new Dimension(410, 50));
    }

    void initViews() {
//        ImageIcon icon = createImageIcon("images/middle.gif");
//        tabbedPane.setBackground(Color.BLACK);
        this.panel1.setToolTipText("This is panel 1");
        this.panel1.setBackground(Color.BLACK);

        tabbedPane.addTab("Tab 1", null, panel1,
                "Does nothing");
        tabbedPane.setMnemonicAt(0, KeyEvent.VK_1);


        tabbedPane.addTab("Tab 2", null, panel2,
                "Does twice as much nothing");
        tabbedPane.setMnemonicAt(1, KeyEvent.VK_2);

        tabbedPane.addTab("Tab 3", null, panel3,
                "Still does nothing");
        tabbedPane.setMnemonicAt(2, KeyEvent.VK_3);
        tabbedPane.addTab("Tab 4", null, panel4,
                "Does nothing at all");
        tabbedPane.setMnemonicAt(3, KeyEvent.VK_4);


        jFrame.getContentPane().setBackground(Color.WHITE);
        jFrame.setSize(500, 1000);

        jFrame.add(tabbedPane);
        jFrame.setVisible(true);
    }

    private JComponent makeTextPanel(String text) {
        JPanel panel = new JPanel(false);
        JLabel filler = new JLabel(text);
        filler.setHorizontalAlignment(JLabel.CENTER);
        panel.setLayout(new GridLayout(1, 1));
        panel.add(filler);
        return panel;
    }
}
