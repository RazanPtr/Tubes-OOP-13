import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class MainMenuScreen extends JPanel {

    private static final int PANEL_WIDTH = 400;
    private static final int PANEL_HEIGHT = 300;
    private static final Color BACKGROUND_COLOR = new Color(153, 204, 153);
    private static final Font BUTTON_FONT = new Font("Arial", Font.BOLD, 18);

    public MainMenuScreen() {
        setPreferredSize(new java.awt.Dimension(PANEL_WIDTH, PANEL_HEIGHT));
        setBackground(BACKGROUND_COLOR);

        // Create the components
        JLabel titleLabel = new JLabel("SIMPLICITY WORLD", SwingConstants.CENTER);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 36));

        JButton startButton = new JButton("START GAME");
        startButton.setFont(BUTTON_FONT);
        startButton.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e) {
        // Prompt the player to enter their name and location
        String playerName = JOptionPane.showInputDialog(null, "Enter your Sim name:");
        String locationStr = JOptionPane.showInputDialog(null, "Enter the location of your house (x,y):");
        String[] locationTokens = locationStr.split(",");
        int houseX = Integer.parseInt(locationTokens[0]);
        int houseY = Integer.parseInt(locationTokens[1]);

        // Create the GridScreen and set the selected house to blue and display the player's name
        GridScreen gridScreen = new GridScreen();
        gridScreen.setHouseColor(houseX, houseY, Color.BLUE);
        gridScreen.setHouseTitle(houseX, houseY, playerName);
        JFrame frame = (JFrame) SwingUtilities.getWindowAncestor(MainMenuScreen.this);
        frame.getContentPane().removeAll();
        frame.getContentPane().add(gridScreen);
        frame.pack();
        frame.revalidate();
    }
});

        JButton helpButton = new JButton("HELP");
        helpButton.setFont(BUTTON_FONT);
        helpButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Create a new JPanel for the help screen
                JPanel helpPanel = new JPanel(new GridBagLayout());
                GridBagConstraints gbc = new GridBagConstraints();
                gbc.gridx = 0;
                gbc.gridy = 0;
                gbc.gridwidth = GridBagConstraints.REMAINDER;
                gbc.fill = GridBagConstraints.BOTH;
                gbc.insets = new Insets(50, 0, 50, 0);
                JLabel titleLabel = new JLabel("HELP", SwingConstants.CENTER);
                titleLabel.setFont(new Font("Arial", Font.BOLD, 36));
                helpPanel.add(titleLabel, gbc);
                gbc.gridy = 1;
                gbc.insets = new Insets(0, 50, 0, 50);
                JLabel instructionLabel = new JLabel("<html><body>1. START GAME - Memulai permainan<br>2. HELP - Menampilkan bantuan mengenai permainan<br>3. EXIT - Keluar dari permainan</body></html>", SwingConstants.LEFT);
                instructionLabel.setFont(new Font("Arial", Font.PLAIN, 18));
                helpPanel.add(instructionLabel, gbc);
                // Add the helpPanel to the JFrame
                JFrame frame = (JFrame) SwingUtilities.getWindowAncestor(MainMenuScreen.this);
                frame.getContentPane().removeAll();
                frame.getContentPane().add(helpPanel);
                frame.pack();
                frame.revalidate();
            }
        });

        JButton exitButton = new JButton("EXIT");
            exitButton.setFont(BUTTON_FONT);
            exitButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.out.println("Exit button clicked");
                System.exit(0);
            }
        });


        // Add the components to the panel using a GridBagLayout
        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = GridBagConstraints.REMAINDER;
        gbc.fill = GridBagConstraints.BOTH;
        gbc.insets = new Insets(50, 0, 50, 0);
        add(titleLabel, gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.gridwidth = 1;
        gbc.insets = new Insets(0, 100, 0, 100);
        add(startButton, gbc);

        gbc.gridx = 0;
        gbc.gridy = 2;
        add(helpButton, gbc);

        gbc.gridx = 0;
        gbc.gridy = 3;
        add(exitButton, gbc);
    }


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
            
            // Load the main menu
            JFrame mainFrame = new JFrame("Main Menu");
            MainMenuScreen mainMenu = new MainMenuScreen();
            mainFrame.add(mainMenu);
            mainFrame.pack();
            mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            mainFrame.setLocationRelativeTo(null);
            mainFrame.setVisible(true);
        });
        thread.start();
    
        // Add the panel to the frame and make it visible
        frame.add(panel);
        frame.setVisible(true);
    }
    
}
