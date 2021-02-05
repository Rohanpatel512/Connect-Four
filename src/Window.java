import java.awt.*;
import javax.swing.*;

/**
 * Represents the window
 * @author Rohan
 */
public class Window extends JFrame {
    
    // Instance variables 
    private JPanel buttonsPanel = new JPanel();
    private JPanel boardPanel = new JPanel();
    
    private JButton[] rowButtons;
    private JButton[] boardButtons;
    
    /**
    * Constructs the window
    * Displays the GUI to user 
    * Creates the row and board buttons
    * Calls method within the class
    */
    public Window() {
        this.setTitle("Connect Four");
        this.setSize(500, 500);
        this.setVisible(true);
        this.setResizable(false);
        this.getContentPane().setBackground(Color.WHITE);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(new BorderLayout());
        
        this.rowButtons = new JButton[7];
        this.boardButtons = new JButton[42];
        
        addRowButtons();
        addBoardButtons();
    }
    
    /**
     * Adds the row buttons to the top of the window 
     */
    private void addRowButtons() {
        
        // Creates a layout for button panel 
        FlowLayout layout = new FlowLayout();
        
        // Sets the horizontal gap between each row button 
        layout.setHgap(20);
        
        // Sets the layout of the buttons panel 
        buttonsPanel.setLayout(layout);
        
        // Loops through the array of row buttons 
        for(int i = 0; i < this.rowButtons.length; i++) {
            // Creates a new button 
            this.rowButtons[i] = new JButton();
            
            // Gives the row button a command 
            this.rowButtons[i].setActionCommand(String.valueOf(i + 1));
            this.rowButtons[i].setText(String.valueOf(i + 1));
            
            // Displays the row button 
            buttonsPanel.add(this.rowButtons[i]);
        }
        
        // Add button panel to the top of the window frame 
        this.add(buttonsPanel, BorderLayout.PAGE_START);
    }
    
    /**
     * Adds the board buttons to the center of the window
     */
    private void addBoardButtons() {
        
        // Sets the layout of board panel to a 7 x 6 grid layout
        boardPanel.setLayout(new GridLayout(6, 7));
        
        // Loop through the board buttons array 
        for(int i = 0; i < this.boardButtons.length; i++) {
            // Creates a new board button 
            this.boardButtons[i] = new JButton();
            
            // Gives the board button a command
            this.boardButtons[i].setActionCommand(String.valueOf(i + 1));
            this.boardButtons[i].setBackground(Color.WHITE);
            
            // Add buttons to their board button 
            boardPanel.add(this.boardButtons[i]);
            
        }
        
        // Adds the board panel to the center of the window 
        this.add(boardPanel, BorderLayout.CENTER);
    }
    
    /**
     * Get access to row buttons 
     * @return row buttons
     */
    public JButton[] getRowButtons() {
        return this.rowButtons;
    }
    
    /**
     * Get access to board buttons
     * @return board buttons
     */
    public JButton[] getBoardButtons() {
        return this.boardButtons;
    }
}
