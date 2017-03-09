package base;

import javax.swing.*;
import java.awt.*;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;

class MainWindow extends JFrame {
    private MainPanel mainPanel;

    MainWindow() {
        mainPanel = new MainPanel();
        add(mainPanel);
        addProperties();
    }

    private void addProperties() {
        mainPanel.textArea.setLineWrap(true);
        mainPanel.textArea.setBorder(BorderFactory.createEtchedBorder());

        mainPanel.button.addActionListener( e -> replace());
    }

    private void replace() {
        replaceTextArea();
        copyToClipBoard();
    }

    private void replaceTextArea() {
        String text = mainPanel.textArea.getText();

        StringBuilder builder = new StringBuilder();
        for(int i = 0; i < text.length(); ++i) {
            char c = text.charAt(i);
            builder.append(ReplaceManager.replaceIfNecessary(c));
        }

        mainPanel.textArea.setText(builder.toString());
    }

    private void copyToClipBoard() {
        if(mainPanel.checkBox.isSelected()) {
            String text = mainPanel.textArea.getText();

            StringSelection stringSelection = new StringSelection(text);
            Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
            clipboard.setContents(stringSelection, null);

            mainPanel.showInfoLabel("Copied to clipboard", 1.5f);
        }
    }
}
