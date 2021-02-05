
import java.awt.Color;
import javax.swing.JOptionPane;

/**
 * Represents player two 
 * @author Rohan
 */
public class PlayerTwo {
    
    // Instance variables 
    private boolean hasWon = false;
    
    /**
     * Constructs player two 
     * Initializes all instance variables
     */
    public PlayerTwo() {
        this.hasWon = hasWon;
    }
    
    /**
     * Indicates player two has won 
     * @param frame/GUI being displayed to user 
     */
    public void playerWon(Window frame) {
        // Flip the boolean value of has won 
        this.hasWon = !this.hasWon;
        displayWinner(frame);
    }
    
    /**
     * Displays to user player two has won 
     * @param frame/GUI being displayed to user  
     */
    private void displayWinner(Window frame) {
        JOptionPane.showMessageDialog(frame, "Blue has won the game!");
    }
}
