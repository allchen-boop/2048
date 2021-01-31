import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.LinkedList;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class GameCourt extends JPanel {
    //holds the primary game logic for how different objects interact with one another.
  
    //state of game logic
    private Board board;
    private int turn;
    //keeps track of all past grid tile layouts
    private LinkedList<Tile[][]> historyOfBoardState;
    
    //game constants
    public static final int BOARD_WIDTH = 500;
    public static final int BOARD_HEIGHT = 500;
    
    //if game is running
    private boolean running = false;
    //current status text
    private JLabel gameStatus;
    
    public GameCourt(JLabel status) {
        setBorder(BorderFactory.createLineBorder(Color.WHITE, 15));
        
        board = new Board();
        turn = 0;
        historyOfBoardState = new LinkedList<Tile[][]>();

        addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                //adds a new board state to the list
                historyOfBoardState.add(board.getBoardState());
             
                if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
                    board.rotate();
                    board.rotate();
                    board.rotate();
                    board.slideTiles();
                    board.rotate();
                } else if (e.getKeyCode() == KeyEvent.VK_LEFT) {
                    board.rotate();
                    board.slideTiles();
                    board.rotate();
                    board.rotate();
                    board.rotate();
                } else if (e.getKeyCode() == KeyEvent.VK_UP) {
                    board.rotate();
                    board.rotate();
                    board.slideTiles();
                    board.rotate();
                    board.rotate();
                } else if (e.getKeyCode() == KeyEvent.VK_DOWN) {
                    board.slideTiles();
                }
                turn ++;
                
                //a new tile is added each turn
                if (turn > 0) {
                    board.addRandomTile(); 
                }
                repaint();
                gameOver();
                gameStatus.setText("TURN: " + turn);
            }
        });
        setFocusable(true);
        gameStatus = status;
    };

    public void reset() {
        board.resetGame();
        historyOfBoardState.clear();
        turn = 0;
        running = true;
        gameStatus.setText("TURN: " + turn);
        requestFocusInWindow();
        repaint();
    }

    public void undoMove() {
        //resetting will clear the board history
        if (historyOfBoardState.size() != 0) {
            //removes the most recent board state added to the list
            board.setGameBoard(historyOfBoardState.removeLast());
            repaint();
            //a turn will be decreased
            if (turn > 0) {
                turn--;
            }
            gameStatus.setText("TURN: " + turn);
        }
        requestFocusInWindow();
    }

    public void gameOver() {
        //when no more valid moves on a full board the game is over
        if (!board.validTileMerge() && board.fullBoard()) {
            //game is no longer running when game over
            running = false; 
        }
    }
   
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        board.drawBoard(g);
        
        //when game begins (no history) there will be instructions
        if (turn == 0 && !board.win()) {
            board.drawInstructions(g);
        }
        
        //game over
        if (!running) { 
            turn = -1;
            board.resetGame();
            board.drawLose(g);
            historyOfBoardState.clear();
            running = true;
        }
        
        //winning condition
        if (board.win()) {
            turn = -1;
            board.resetGame();
            board.drawWin(g);
            historyOfBoardState.clear();   
        }
    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(BOARD_WIDTH, BOARD_HEIGHT);
    }
}

