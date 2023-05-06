import javax.swing.*;
import java.awt.*;

public class GameTitleGUI {
    
    private JFrame frame;

    public GameTitleGUI() {
        frame = new JFrame("SIMPLICITY");
        frame.setSize(400, 300);
        frame.setLayout(new BoxLayout(frame.getContentPane(), BoxLayout.Y_AXIS));
        
        JLabel titleLabel = new JLabel("SIMPLICITY");
        titleLabel.setAlignmentX(JLabel.CENTER_ALIGNMENT);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 24));
        
        frame.add(Box.createVerticalGlue());
        frame.add(titleLabel);
        frame.add(Box.createVerticalGlue());
    }
    
    public void show() {
        frame.setVisible(true);
    }
}
