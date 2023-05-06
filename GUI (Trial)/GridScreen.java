import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.*;

public class GridScreen extends JPanel {

    private static final int SQUARE_SIZE = 50;  // size of each square in pixels
    private static final int GRID_SIZE = 11;   // number of squares per row/column
    private static final int PANEL_SIZE = SQUARE_SIZE * GRID_SIZE;  // size of the panel in pixels
    private static final Color PASTEL_GREEN = new Color(153, 204, 153); // define a pastel green color
    private final Color DEFAULT_COLOR = new Color(214, 236, 227);
    private JPanel[][] houses;
    
    // Constructor
    public GridScreen() {
        setPreferredSize(new Dimension(PANEL_SIZE, PANEL_SIZE));
        setBackground(PASTEL_GREEN);
        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int x = e.getX() / SQUARE_SIZE;
                int y = e.getY() / SQUARE_SIZE;
                int houseIndex = x + y * GRID_SIZE;
                
                JFrame houseFrame = new JFrame("House " + houseIndex);
                JPanel housePanel = new JPanel() {
                    @Override
                    public void paintComponent(Graphics g) {
                        super.paintComponent(g);
                        for (int i = 0; i < 6; i++) {
                            for (int j = 0; j < 6; j++) {
                                int x = i * SQUARE_SIZE;
                                int y = j * SQUARE_SIZE;
                                g.setColor(Color.BLACK);
                                g.drawRect(x, y, SQUARE_SIZE, SQUARE_SIZE);
                            }
                        }
                    }
                };
                housePanel.setPreferredSize(new Dimension(6 * SQUARE_SIZE, 6 * SQUARE_SIZE));
                houseFrame.add(housePanel);
                houseFrame.pack();
                houseFrame.setLocationRelativeTo(null);
                houseFrame.setVisible(true);
            }
        });

        houses = new JPanel[GRID_SIZE][GRID_SIZE];
        for (int y = 0; y < GRID_SIZE; y++) {
            for (int x = 0; x < GRID_SIZE; x++) {
                JPanel house = new JPanel();
                house.setBackground(DEFAULT_COLOR);
                house.setBorder(BorderFactory.createLineBorder(Color.BLACK));
                houses[y][x] = house;
                add(house);
            }
        }
    }
    
    // Helper method to get the title of a house
    private String getHouseTitle(int houseNumber) {
        return "House " + houseNumber;
    }
    
    // Helper method to show the panel of a house
    private void showHouse(int houseNumber) {
        JFrame frame = new JFrame(getHouseTitle(houseNumber));
        JPanel housePanel = new JPanel();
        housePanel.add(new JLabel(getHouseTitle(houseNumber)));
        frame.add(housePanel);
        frame.pack();
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    public void setHouseColor(int x, int y, Color color) {
        houses[y][x].setBackground(color);
    }

    // Define the setHouseTitle() method to set the title of a specific house
    public void setHouseTitle(int x, int y, String title) {
        JLabel label = new JLabel(title);
        label.setHorizontalAlignment(SwingConstants.CENTER);
        houses[y][x].add(label);
    }
    
    // Paint method to draw the grid of squares and the title
  
// Paint method to draw the grid of squares and the title
@Override
public void paintComponent(Graphics g) {
    super.paintComponent(g);

    /* Draw the grid of squares
    for (int y = 0; y < GRID_SIZE; y++) {
        for (int x = 0; x < GRID_SIZE; x++) {
            int xPos = x * SQUARE_SIZE;
            int yPos = y * SQUARE_SIZE;
            g.setColor(Color.BLACK);
            g.drawRect(xPos, yPos, SQUARE_SIZE, SQUARE_SIZE);
            g.setColor(Color.BLUE);
            g.setFont(new Font("Arial", Font.BOLD, 14));
            g.drawString(getHouseTitle(x + y * GRID_SIZE), xPos + 5, yPos + SQUARE_SIZE - 5);
        }
    }*/

    // Draw the title "SIMPLICITY WORLD"
    g.setColor(Color.WHITE);
    g.setFont(new Font("Arial", Font.BOLD, 30));
    g.drawString("SIMPLICITY WORLD", 110, 40);
}


    
    public static void main(String[] args) {
        JFrame frame = new JFrame("Grid Screen");
        GridScreen gridScreen = new GridScreen();
        frame.add(gridScreen);
        frame.pack();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}
