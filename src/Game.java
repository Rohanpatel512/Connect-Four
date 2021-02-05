import java.awt.event.*;
import javax.swing.*;
import java.awt.*;

/**
 * Represents the game 
 * @author Rohan
 */
public class Game implements ActionListener {
    
    // Instance variables 
    private Window frame;
    private PlayerOne firstPlayer;
    private PlayerTwo secondPlayer;
    
    /**
     * Construct the game 
     * Initializes the window, player one and player two
     */
    public Game() {
        // Initialize all instance variables 
        this.frame = new Window();
        this.firstPlayer = new PlayerOne();
        this.secondPlayer = new PlayerTwo();
        
       // Get the row buttons 
       JButton[] rowButtons = this.frame.getRowButtons();
       
       // Loop through all the row buttons 
       for(int i = 0; i < rowButtons.length; i++) {
          // Make each button listen for clicks
          rowButtons[i].addActionListener(this);
       }
    }

    /**
     * Method invoked when a row button is clicked
     * @param e 
     */
    public void actionPerformed(ActionEvent e) {
        // Call method to switch turns 
        this.firstPlayer.switchTurns();
        
        // Get the turn of the player 
        boolean turn = this.firstPlayer.getTurn();
        
        // Get the row where disc will be dropped 
        int column = Integer.parseInt(e.getActionCommand());
        
        // Check if it is player one or twos turn 
        if(!turn) {
            dropDisc(Color.RED, column);
            checkWin();
        } else {
            dropDisc(Color.BLUE, column);
            checkWin();
        }
        
    }
    
    /**
     * Drops the disc/coin of player one and two
     * @param color of the disc being dropped 
     * @param row where disc will be dropped
     */
    private void dropDisc(Color discColor, int column) {
       
       // Method variables
       Color color = Color.WHITE;
       int row = 5;
               
       // Get the board buttons 
       JButton[] boardButtons = this.frame.getBoardButtons();
       
       // Decrease value of column by one 
       column -= 1;
       
       // Get the background color of the button 
       color = boardButtons[column].getBackground();
       
       // While row is not equal to zero
       while(row != 0) {
           // Increase value of column by 7 and decrease row by one 
           column += 7;
           row -= 1;
           
           // Get the background color of the board button 
           color = boardButtons[column].getBackground();
           
           // Check if color is not white 
           if(!color.equals(Color.WHITE)) {
               // Decrease value of column by seven 
               column -= 7;
               break;
           } 
           
       }
       
       // Place the disc
       boardButtons[column].setBackground(discColor);
        
    }
    
    /**
     * Check for any wins from both players
     */
    private void checkWin() {
      checkHorizontal();
      checkVertical();
      checkDiagnolRight();
      checkDiagnolLeft();
    }
    
    /**
     * Checks for win horizontally for both players
     */
    private void checkHorizontal() {
       // Method variables 
       int cells = 0;
       
       // Get the board buttons
       JButton[] boardButtons = this.frame.getBoardButtons();
       
       // Loop through all board buttons except for the last three
       for(int i = 0; i < boardButtons.length; i++) {
          
          // Get the colors of all four discs 
          Color color = boardButtons[i].getBackground();
          Color first = boardButtons[i + 1].getBackground();
          Color second = boardButtons[i + 2].getBackground();
          Color third = boardButtons[i + 3].getBackground();
           
          // Make sure the hole is not empty
          if(!color.equals(Color.WHITE)) {
              // Check if all disc colors are equal 
              if(color.equals(first) && first.equals(second) && second.equals(third)) {
                  checkWon(color);
              }
          }
          
          // Increase value of cells by one 
          cells += 1;
          
          // Check if cells is at value four
          if(cells == 4) {
              // Increase value of 'i' by three and recreate cells 
              i += 3;
              cells = 0;
          }
       }
    }
    
    /**
     * Checks for win vertically for both players
     */
    private void checkVertical() {
        // Get the board buttons 
        JButton[] boardButtons = this.frame.getBoardButtons();
        
        // Loop through the half the buttons 
        for(int i = 0; i < boardButtons.length / 2; i++) {
            Color color = boardButtons[i].getBackground();
            Color first = boardButtons[i + 7].getBackground();
            Color second = boardButtons[i + 14].getBackground();
            Color third = boardButtons[i + 21].getBackground();
            
            // Check if the hole is not empty 
            if(!color.equals(Color.WHITE)) {
                // Check if all disc colors are equal 
                if(color.equals(first) && first.equals(second) && second.equals(third)) {
                    checkWon(color);
                }
            }
        }
    }  
    
    /**
     * Check for win diagonally to the right 
     */
    private void checkDiagnolRight() {
       // Method variables 
       int cells = 0;
       
       // Get the board buttons
       JButton[] boardButtons = this.frame.getBoardButtons();
       
       // Loop through all board buttons except for the last three
       for(int i = 0; i < boardButtons.length / 2; i++) {
          // Get the colors of all four discs 
          Color color = boardButtons[i].getBackground();
          Color first = boardButtons[i + 8].getBackground();
          Color second = boardButtons[i + 16].getBackground();
          Color third = boardButtons[i + 24].getBackground();
           
          // Make sure the hole is not empty
          if(!color.equals(Color.WHITE)) {
              // Check if all disc colors are equal 
              if(color.equals(first) && first.equals(second) && second.equals(third)) {
                  checkWon(color);
              }
          }         
          // Increase value of cells by one 
          cells += 1;
          
          // Check if cells is at value four
          if(cells == 4) {
              // Increase value of 'i' by three and recreate cells 
              i += 3;
              cells = 0;
          }
       }
    }
    
    /**
     * Check for win diagonally to the left
     */
    private void checkDiagnolLeft() {
       // Method variables 
       int cells = 3;
       
       // Get the board buttons
       JButton[] boardButtons = this.frame.getBoardButtons();
       
       // Loop through all board buttons except for the last three
       for(int i = 3; i < boardButtons.length / 2; i++) {
          // Get the colors of all four discs 
          Color color = boardButtons[i].getBackground();
          Color first = boardButtons[i + 6].getBackground();
          Color second = boardButtons[i + 12].getBackground();
          Color third = boardButtons[i + 18].getBackground();
           
          // Make sure the hole is not empty
          if(!color.equals(Color.WHITE)) {
              // Check if all disc colors are equal 
              if(color.equals(first) && first.equals(second) && second.equals(third)) {
                  checkWon(color);
              }
          }    
          // Increase value of cells by one 
          cells += 1;
          // Check if cells is at value four
          if(cells == 7) {
              // Increase value of 'i' by three and recreate cells 
              i += 3;
              cells = 3;
          }
       }
    }
    
    /**
     * Check who won the game
     * @param color of the disc 
     */
    private void checkWon(Color color) {
        // Check if color is red 
        if(color.equals(Color.RED)) {
            // Call method to display to user player one has won 
            this.firstPlayer.playerWon(this.frame);
          // Check if color is blue
        } else if(color.equals(Color.BLUE)) {
            // Call method to display to user player two has won 
            this.secondPlayer.playerWon(this.frame);
        }
    }
}
