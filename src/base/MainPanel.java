package base;

import javax.swing.*;
import java.awt.*;

class MainPanel extends JPanel {

    JTextArea textArea;
    JCheckBox checkBox;
    JButton button;

    private JLabel infoLabel;

    MainPanel() {
        setLayout(new GridBagLayout());
        createComponents();
    }

    private void createComponents() {
        GridBagConstraints gbc = new GridBagConstraints();

        textArea = new JTextArea(20, 40);
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.weightx = 1;
        gbc.weighty = 1;
        gbc.gridwidth = 3;
        gbc.insets = new Insets(25, 25, 5, 25);
        gbc.fill = GridBagConstraints.BOTH;

        JScrollPane scrollArea = new JScrollPane(textArea, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        add(scrollArea, gbc);

        checkBox = new JCheckBox("Copy to clipboard");
        gbc.gridx = 2;
        gbc.gridy = 1;
        gbc.weightx = 0;
        gbc.weighty = 0;
        gbc.gridwidth = 1;
        gbc.insets = new Insets(5, 25, 5, 25);
        gbc.anchor = GridBagConstraints.LINE_END;
        gbc.fill = GridBagConstraints.NONE;
        add(checkBox, gbc);

        button = new JButton("Replace");
        gbc.gridx = 2;
        gbc.gridy = 2;
        gbc.insets = new Insets(5, 25, 25, 25);
        add(button, gbc);

        infoLabel = new JLabel();
        gbc.gridx = 1;
        gbc.anchor = GridBagConstraints.LINE_START;
        add(infoLabel, gbc);
    }

    void showInfoLabel(String info, float seconds) {
        infoLabel.setText(info);

        int time = (int)(seconds * 1000);
        Timer t = new Timer(time, e -> infoLabel.setText(null));
        t.setRepeats(false);
        t.start();
    }

}
