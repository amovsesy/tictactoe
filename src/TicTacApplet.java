/* Aleksandr Movsesyan
   TicTacApplet.java
   Practice Lab 1

   Applet that uses TicTacBoard.java to play a game of Tic Tac Toe.
*/

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class TicTacApplet extends JApplet
{
  private static final int SIZE = 3;
  private JLabel gameLabel;
  private Container mainContainer;
  private TicTacBoard board;

  public void init()
  {
    mainContainer = getContentPane();
    mainContainer.setLayout(new FlowLayout());

    gameLabel = new JLabel("Alex's Tic Tac Toe Game");
    mainContainer.add(gameLabel);

    board = new TicTacBoard(SIZE, mainContainer);
  }
}