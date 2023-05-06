import javax.swing.*;
import java.awt.*;

public class LoadingScreen {

    public static void main(String[] args) {

        // Show the game title page first
        GameTitleGUI gameTitleGUI = new GameTitleGUI();
        gameTitleGUI.show();
        
        JFrame frame = new JFrame();
        frame.setSize(400, 300);
        frame.setLocationRelativeTo(null);

        // Create a new panel with a BorderLayout layout
        JPanel panel = new JPanel(new BorderLayout());

        // Create a JLabel with a background image
        ImageIcon imageIcon = new ImageIcon("sims2.png");
        JLabel backgroundLabel = new JLabel("", imageIcon, JLabel.CENTER);
        backgroundLabel.setPreferredSize(new Dimension(400, 300));
        panel.add(backgroundLabel, BorderLayout.CENTER);

        // Create a new label with the "Loading..." text
        JLabel label = new JLabel("Loading...");
        label.setFont(new Font("Arial", Font.BOLD, 24));
        label.setHorizontalAlignment(SwingConstants.CENTER);
        panel.add(label, BorderLayout.NORTH);

        // Create a new progress bar and add it to the panel
        JProgressBar progressBar = new JProgressBar(0, 100);
        progressBar.setValue(0);
        panel.add(progressBar, BorderLayout.SOUTH);

        // Start a new thread to update the progress bar
        Thread thread = new Thread(() -> {
            for (int i = 0; i <= 100; i++) {
                try {
                    Thread.sleep(50);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                progressBar.setValue(i);
            }
            frame.dispose();
        });
        thread.start();

        // Add the panel to the frame and make it visible
        frame.add(panel);
        frame.setVisible(true);
    }
}
