
import java.awt.Color;
import javax.swing.JOptionPane;

/**
 * Represents player one
 * @author Rohan
 */
public class PlayerOne {
    
    // Instance variables 
    private boolean isTurn = true;
    private boolean hasWon = false;
    
    /**
     * Constructs player one
     * Initializes all instance variables 
     */
    public PlayerOne() {
        this.isTurn = isTurn;
        this.hasWon = hasWon;
    }
   
    /**
     * Switches turns between player one and two
     */
    public void switchTurns() {
        // Flip the boolean value of is turn 
        this.isTurn = !this.isTurn;
    }
    
    
    /**
     * Indicates player one has won 
     * @param GUI/frame being shown to user 
     */
    public void playerWon(Window frame) {
        // Flip the boolean value of has won
        this.hasWon = !this.hasWon;
        displayWinner(frame);
    }
    
    /**
     * Displays alert saying player one/red has won
     * @param GUI/frame being shown to user 
     */
    private void displayWinner(Window frame) {
        JOptionPane.showMessageDialog(frame, "Red has won the game!");
    }
    
    /**
     * Access to player ones turn 
     * @return player ones turn
     */
    public boolean getTurn() {
        return this.isTurn;
    }

}
