/* Aleksandr Movsesyan
   TicTacBoard.java
   Programming Lab 1

   A class representing a Tic Tac Toe board -
   both its user interface and its logical functionality.
*/

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class TicTacBoard implements ActionListener
{
  private JButton[][] buttons;
  private JPanel[] rowPanels;
  private String curPlayer;
  public int moves;

  public TicTacBoard(int size, Container container)
  {
    rowPanels = new JPanel[size];
    buttons = new JButton[size][size];
    for(int row=0; row < size; row++)
    {
      rowPanels[row] = new JPanel(new FlowLayout());
      for(int col=0; col < size; col++)
      {
        buttons[row][col] = new JButton(" ");
        buttons[row][col].addActionListener(this);
        rowPanels[row].add(buttons[row][col]);
      }
      container.add(rowPanels[row]);
    }
    curPlayer = "X";
  }

  private boolean checkWinner()
  {
    int row = 0, column = 0;

    if ( moves > 4 )
    {
      for ( ; row < 3; row++)
      {
        if ( buttons[row][column].getText().equals(buttons[row][column + 1].getText()) &&
             buttons[row][column + 1].getText().equals(buttons[row][column + 2].getText())              && !buttons[row][column].getText().equals(" ") )
        {
          JOptionPane.showMessageDialog(null,"Player " + buttons[row][column].getText() + 
                                        " wins!");
          return true;
        }
      }

      row = 0;
      column = 0;

      for ( ; column < 3; column++)
        if ( buttons[row][column].getText().equals(buttons[row + 1][column].getText()) &&
             buttons[row + 1][column].getText().equals(buttons[row + 2][column].getText())              && !buttons[row][column].getText().equals(" ") )
        {
          JOptionPane.showMessageDialog(null,"Player " + buttons[row][column].getText() + 
                                        " wins!");
          return true;
        }

      row = 0;
      column = 0;

      if ( buttons[row][column].getText().equals(buttons[row + 1][column + 1].getText()) &&
           buttons[row + 1][column + 1].getText().equals(buttons[row + 2]
           [column + 2].getText()) )
      {
        JOptionPane.showMessageDialog(null,"Player " + buttons[row][column].getText() + 
                                      " wins!");
        return true;
      }

      row = 0;
      column = 2;

      if ( buttons[row][column].getText().equals(buttons[row + 1][column - 1].getText()) &&
           buttons[row + 1][column - 1].getText().equals(buttons[row + 2]
           [column - 2].getText()) )
      {
        JOptionPane.showMessageDialog(null,"Player " + buttons[row][column].getText() + 
                                      " wins!");
        return true;
      }
    }

    if ( moves == 9)
    {
      JOptionPane.showMessageDialog(null,"This is a cats game!");
      return true;
    }

    return false;
  }

  public void actionPerformed(ActionEvent ae)
  {
    JButton clickedButton = (JButton)ae.getSource();

    if(clickedButton.getText().equals(" "))
    {
      clickedButton.setText(curPlayer);
      moves++;
      if(!checkWinner())
      {
        if(curPlayer.equals("X"))
          curPlayer = "O";
        else
          curPlayer = "X";
      }
      else
      {
        for ( int row = 0; row < 3; row++)
          for ( int column = 0; column < 3; column++)
          {
            buttons[row][column].setText(" ");
            moves = 0;
          }
      }
    }
  }
}