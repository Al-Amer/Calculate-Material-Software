package Test;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DynamicPanelExample {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Dynamic JPanel Example");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setSize(400, 400);

            DynamicPanel dynamicPanel = new DynamicPanel();

            JButton addButton = new JButton("Add Component");
            JTextArea textArea = new JTextArea();
            addButton.addActionListener(e -> dynamicPanel.addNewComponent());

            frame.setLayout(new BorderLayout());
            frame.add(addButton, BorderLayout.NORTH);
            frame.add(addButton, BorderLayout.NORTH );
            frame.add(dynamicPanel, BorderLayout.CENTER);

            frame.setVisible(true);
        });
    }
}

class DynamicPanel extends JPanel {
    private int componentCount = 0;

    public DynamicPanel() {
        setLayout(new GridLayout(0, 1)); // One column, as components will be added vertically
    }

    public void addNewComponent() {
        JButton newButton = new JButton("Button " + (++componentCount));
        JTextArea textArea = new JTextArea("test");
        add(textArea);
        add(newButton);
        revalidate(); // Refresh the layout
        repaint();    // Repaint the panel
    }
}

