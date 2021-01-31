import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

public class GameTest {
    
    Board board = new Board();
    Board board2 = new Board();
    
    
    @Test
    public void tileConstructorTest() {
        Tile tile = new Tile(0);
        assertEquals(0, tile.getValue());
    }
    
    @Test
    public void tileSetValueTest() {
        Tile tile = new Tile(0);
        tile.setValue(2);
        assertEquals(2, tile.getValue());
    }
    
    @Test
    public void tileSetMergeTest() {
        Tile tile = new Tile(0);
        tile.setMergeStatus(true);
        assertTrue(tile.getMergeStatus());
    }
    
    
    @Test
    public void boardConstructorTest() {
        assertEquals(2, board.getNumberOfTiles());
    }
    
    @Test
    public void addRandomTileTest() {
        board.resetGame();
        assertEquals(2, board.getNumberOfTiles());
    }
    
    @Test
    public void getBoardStateTest() {
        Tile [][] board = {{new Tile(0),new Tile(0),new Tile(0),new Tile(0)},
                           {new Tile(0),new Tile(0),new Tile(0),new Tile(0)},
                           {new Tile(2),new Tile(0),new Tile(0),new Tile(0)},
                           {new Tile(2),new Tile(0),new Tile(0),new Tile(0)}};
        
        this.board.setGameBoard(board);
        assertEquals(board[2][0].getValue(), this.board.getTileValue(2, 0));
        assertEquals(board[3][0].getValue(), this.board.getTileValue(3, 0));
    }
    
    @Test
    public void getNumberOfTiles() {
        Tile [][] board = {{new Tile(0),new Tile(0),new Tile(0),new Tile(0)},
                           {new Tile(0),new Tile(0),new Tile(0),new Tile(0)},
                           {new Tile(2),new Tile(0),new Tile(0),new Tile(0)},
                           {new Tile(2),new Tile(0),new Tile(2),new Tile(0)}};
        this.board.setGameBoard(board);
        
        assertEquals(3, this.board.getNumberOfTiles());
    }
    
    @Test
    public void validTileMergeOneMerge() {
        Tile [][] validMergeBoard = {{new Tile(0),new Tile(0),new Tile(0),new Tile(0)},
                                     {new Tile(0),new Tile(0),new Tile(0),new Tile(0)},
                                     {new Tile(2),new Tile(0),new Tile(0),new Tile(0)},
                                     {new Tile(2),new Tile(0),new Tile(2),new Tile(0)}};
        
        board.setGameBoard(validMergeBoard);
        assertTrue(board.validTileMerge());
    }
    
    @Test
    public void validTileMergeMultipleMerges() {
        Tile [][] validMergeBoard = {{new Tile(0),new Tile(0),new Tile(0),new Tile(0)},
                                     {new Tile(0),new Tile(0),new Tile(4),new Tile(4)},
                                     {new Tile(2),new Tile(0),new Tile(0),new Tile(0)},
                                     {new Tile(2),new Tile(0),new Tile(2),new Tile(0)}};
        
        board.setGameBoard(validMergeBoard);
        assertTrue(board.validTileMerge());
    }
    
    @Test
    public void validTileMergeFullBoard() {
        Tile [][] validMergeBoard = {{new Tile(8),new Tile(1024),new Tile(2),new Tile(8)},
                                     {new Tile(4),new Tile(2),new Tile(4),new Tile(4)},
                                     {new Tile(2),new Tile(4),new Tile(32),new Tile(2)},
                                     {new Tile(2),new Tile(16),new Tile(2),new Tile(512)}};
        
        board.setGameBoard(validMergeBoard);
        assertTrue(board.validTileMerge());
    }
    
    @Test
    public void noValidTileMerge() {
        Tile [][] validMergeBoard = {{new Tile(8),new Tile(1024),new Tile(2),new Tile(8)},
                                     {new Tile(4),new Tile(2),new Tile(512),new Tile(4)},
                                     {new Tile(2),new Tile(4),new Tile(32),new Tile(2)},
                                     {new Tile(0),new Tile(16),new Tile(2),new Tile(512)}};
        
        board.setGameBoard(validMergeBoard);
        assertFalse(board.validTileMerge());
    }
    
    @Test
    public void fullBoardTest() {
        Tile [][] fullBoard = {{new Tile(8),new Tile(1024),new Tile(2),new Tile(8)},
                               {new Tile(4),new Tile(2),new Tile(2),new Tile(4)},
                               {new Tile(2),new Tile(4),new Tile(32),new Tile(2)},
                               {new Tile(2),new Tile(16),new Tile(2),new Tile(512)}};
        
        board.setGameBoard(fullBoard);
        assertTrue(board.fullBoard());
    }
    
    @Test
    public void fullBoardTestFalse() {
        Tile [][] notFullBoard = {{new Tile(0),new Tile(1024),new Tile(2),new Tile(8)},
                                  {new Tile(4),new Tile(2),new Tile(2),new Tile(4)},
                                  {new Tile(2),new Tile(4),new Tile(32),new Tile(2)},
                                  {new Tile(2),new Tile(16),new Tile(2),new Tile(512)}};
        
        board.setGameBoard(notFullBoard);
        assertFalse(board.fullBoard());
    }
    
    @Test
    public void winTest() {
        Tile [][] winningBoard = {{new Tile(2048),new Tile(1024),new Tile(2),new Tile(8)},
                                  {new Tile(4),new Tile(2),new Tile(2),new Tile(4)},
                                  {new Tile(2),new Tile(4),new Tile(32),new Tile(2)},
                                  {new Tile(2),new Tile(16),new Tile(2),new Tile(512)}};
        
        board.setGameBoard(winningBoard);
        assertTrue(board.win());
    }
    
    @Test
    public void winTestFalse() {
        Tile [][] notWinningBoard = {{new Tile(0),new Tile(1024),new Tile(2),new Tile(8)},
                                     {new Tile(4),new Tile(2),new Tile(2),new Tile(4)},
                                     {new Tile(2),new Tile(4),new Tile(32),new Tile(2)},
                                     {new Tile(2),new Tile(16),new Tile(2),new Tile(512)}};
        
        board.setGameBoard(notWinningBoard);
        assertFalse(board.win());
    }
    
    @Test
    public void winTestLose() {
        Tile [][] losingBoard = {{new Tile(512),new Tile(1024),new Tile(2),new Tile(8)},
                                 {new Tile(4),new Tile(2),new Tile(2),new Tile(4)},
                                 {new Tile(2),new Tile(4),new Tile(32),new Tile(2)},
                                 {new Tile(2),new Tile(16),new Tile(2),new Tile(512)}};
        
        board.setGameBoard(losingBoard);
        assertFalse(board.win());
    }
    
    @Test
    public void slideTilesDownTest() {
        Tile [][] originalBoard = {{new Tile(4),new Tile(0),new Tile(0),new Tile(0)},
                                   {new Tile(2),new Tile(0),new Tile(0),new Tile(0)},
                                   {new Tile(0),new Tile(0),new Tile(0),new Tile(0)},
                                   {new Tile(0),new Tile(0),new Tile(0),new Tile(0)}};
        
        Tile [][] boardSlideDown = {{new Tile(0),new Tile(0),new Tile(0),new Tile(0)},
                                    {new Tile(0),new Tile(0),new Tile(0),new Tile(0)},
                                    {new Tile(4),new Tile(0),new Tile(0),new Tile(0)},
                                    {new Tile(2),new Tile(0),new Tile(0),new Tile(0)}};
        
        board.setGameBoard(originalBoard);
        board.slideTilesDown();
        
        assertEquals(boardSlideDown[2][0].getValue(), board.getTileValue(2, 0));
        assertEquals(boardSlideDown[3][0].getValue(), board.getTileValue(3, 0));
        
    }
    
    @Test
    public void slideTilesUpTest() {
        Tile [][] originalBoard = {{new Tile(0),new Tile(0),new Tile(0),new Tile(0)},
                                   {new Tile(0),new Tile(0),new Tile(0),new Tile(0)},
                                   {new Tile(2),new Tile(0),new Tile(0),new Tile(0)},
                                   {new Tile(4),new Tile(0),new Tile(0),new Tile(0)}};
            
        Tile [][] boardSlideUp = {{new Tile(2),new Tile(0),new Tile(0),new Tile(0)},
                                  {new Tile(4),new Tile(0),new Tile(0),new Tile(0)},
                                  {new Tile(0),new Tile(0),new Tile(0),new Tile(0)},
                                  {new Tile(0),new Tile(0),new Tile(0),new Tile(0)}};
        
        board.setGameBoard(originalBoard);
        board.slideTilesUp();
        
        assertEquals(boardSlideUp[0][0].getValue(), board.getTileValue(0, 0));
        assertEquals(boardSlideUp[1][0].getValue(), board.getTileValue(1, 0));
        
    }
    
    @Test
    public void slideTilesRightTest() {
        Tile [][] originalBoard = {{new Tile(0),new Tile(0),new Tile(0),new Tile(0)},
                                   {new Tile(0),new Tile(0),new Tile(0),new Tile(0)},
                                   {new Tile(2),new Tile(4),new Tile(0),new Tile(0)},
                                   {new Tile(0),new Tile(0),new Tile(0),new Tile(0)}};
        
        Tile [][] boardSlideRight = {{new Tile(0),new Tile(0),new Tile(0),new Tile(0)},
                                     {new Tile(0),new Tile(0),new Tile(0),new Tile(0)},
                                     {new Tile(0),new Tile(0),new Tile(2),new Tile(4)},
                                     {new Tile(0),new Tile(0),new Tile(0),new Tile(0)}};
        
        board.setGameBoard(originalBoard);
        board.slideTiles();
        
        assertEquals(boardSlideRight[2][3].getValue(), board.getTileValue(2, 3));
        assertEquals(boardSlideRight[2][2].getValue(), board.getTileValue(2, 2));
    }
    
    @Test
    public void slideTilesLeftTest() {
        Tile [][] originalBoard = {{new Tile(0),new Tile(0),new Tile(0),new Tile(0)},
                                   {new Tile(0),new Tile(0),new Tile(0),new Tile(0)},
                                   {new Tile(0),new Tile(0),new Tile(2),new Tile(4)},
                                   {new Tile(0),new Tile(0),new Tile(0),new Tile(0)}};
        
        Tile [][] boardSlideLeft = {{new Tile(0),new Tile(0),new Tile(0),new Tile(0)},
                                    {new Tile(0),new Tile(0),new Tile(0),new Tile(0)},
                                    {new Tile(2),new Tile(4),new Tile(0),new Tile(0)},
                                    {new Tile(0),new Tile(0),new Tile(0),new Tile(0)}};
        
        board.setGameBoard(originalBoard);
        board.slideTilesLeft();
        
        assertEquals(boardSlideLeft[2][0].getValue(), board.getTileValue(2, 0));
        assertEquals(boardSlideLeft[2][1].getValue(), board.getTileValue(2, 1));
        assertEquals(boardSlideLeft[2][2].getValue(), board.getTileValue(2, 2));
        
    }
    
    @Test
    public void cantSlideTilesLeftTest() {
        Tile [][] originalBoard = {{new Tile(0),new Tile(0),new Tile(0),new Tile(0)},
                                   {new Tile(0),new Tile(0),new Tile(0),new Tile(0)},
                                   {new Tile(2),new Tile(0),new Tile(0),new Tile(0)},
                                   {new Tile(0),new Tile(0),new Tile(0),new Tile(0)}};
        
        Tile [][] boardSlide = {{new Tile(0),new Tile(0),new Tile(0),new Tile(0)},
                                {new Tile(0),new Tile(0),new Tile(0),new Tile(0)},
                                {new Tile(2),new Tile(0),new Tile(0),new Tile(0)},
                                {new Tile(0),new Tile(0),new Tile(0),new Tile(0)}};
        
        board.setGameBoard(originalBoard);
        board.slideTilesLeft();
        
        assertEquals(boardSlide[2][0].getValue(), board.getTileValue(2, 0));
        assertEquals(boardSlide[2][1].getValue(), board.getTileValue(2, 1));
        assertEquals(boardSlide[2][2].getValue(), board.getTileValue(2, 2));
        assertEquals(boardSlide[2][3].getValue(), board.getTileValue(2, 3));
    }
    
    @Test
    public void cantSlideTilesRightTest() {
        Tile [][] originalBoard = {{new Tile(0),new Tile(0),new Tile(0),new Tile(0)},
                                   {new Tile(0),new Tile(0),new Tile(0),new Tile(0)},
                                   {new Tile(0),new Tile(0),new Tile(0),new Tile(2)},
                                   {new Tile(0),new Tile(0),new Tile(0),new Tile(0)}};

        Tile [][] boardSlide = {{new Tile(0),new Tile(0),new Tile(0),new Tile(0)},
                                {new Tile(0),new Tile(0),new Tile(0),new Tile(0)},
                                {new Tile(0),new Tile(0),new Tile(0),new Tile(2)},
                                {new Tile(0),new Tile(0),new Tile(0),new Tile(0)}};

        board.setGameBoard(originalBoard);
        board.slideTiles();

        assertEquals(boardSlide[2][0].getValue(), board.getTileValue(2, 0));
        assertEquals(boardSlide[2][1].getValue(), board.getTileValue(2, 1));
        assertEquals(boardSlide[2][2].getValue(), board.getTileValue(2, 2));
        assertEquals(boardSlide[2][3].getValue(), board.getTileValue(2, 3));
    }
    
    
    @Test
    public void cantSlideTilesUpTest() {
        Tile [][] originalBoard = {{new Tile(2),new Tile(0),new Tile(0),new Tile(0)},
                                   {new Tile(0),new Tile(0),new Tile(0),new Tile(0)},
                                   {new Tile(0),new Tile(0),new Tile(0),new Tile(0)},
                                   {new Tile(0),new Tile(0),new Tile(0),new Tile(0)}};
        
        Tile [][] boardSlide = {{new Tile(2),new Tile(0),new Tile(0),new Tile(0)},
                                {new Tile(0),new Tile(0),new Tile(0),new Tile(0)},
                                {new Tile(0),new Tile(0),new Tile(0),new Tile(0)},
                                {new Tile(0),new Tile(0),new Tile(0),new Tile(0)}};
        
        board.setGameBoard(originalBoard);
        board.slideTilesUp();
        
        assertEquals(boardSlide[0][0].getValue(), board.getTileValue(0, 0));
        assertEquals(boardSlide[1][0].getValue(), board.getTileValue(1, 0));
        assertEquals(boardSlide[2][0].getValue(), board.getTileValue(2, 0));
        assertEquals(boardSlide[3][0].getValue(), board.getTileValue(3, 0));
    }
    
    @Test
    public void cantSlideTilesDownTest() {
        Tile [][] originalBoard = {{new Tile(0),new Tile(0),new Tile(0),new Tile(0)},
                                   {new Tile(0),new Tile(0),new Tile(0),new Tile(0)},
                                   {new Tile(0),new Tile(0),new Tile(0),new Tile(0)},
                                   {new Tile(2),new Tile(0),new Tile(0),new Tile(0)}};

        Tile [][] boardSlide = {{new Tile(0),new Tile(0),new Tile(0),new Tile(0)},
                                {new Tile(0),new Tile(0),new Tile(0),new Tile(0)},
                                {new Tile(0),new Tile(0),new Tile(0),new Tile(0)},
                                {new Tile(2),new Tile(0),new Tile(0),new Tile(0)}};

        board.setGameBoard(originalBoard);
        board.slideTilesDown();

        assertEquals(boardSlide[0][0].getValue(), board.getTileValue(0, 0));
        assertEquals(boardSlide[1][0].getValue(), board.getTileValue(1, 0));
        assertEquals(boardSlide[2][0].getValue(), board.getTileValue(2, 0));
        assertEquals(boardSlide[3][0].getValue(), board.getTileValue(3, 0));
    }
    
    @Test
    public void slideRightWithMerge() {
        Tile [][] originalBoard = {{new Tile(0),new Tile(0),new Tile(0),new Tile(0)},
                                   {new Tile(0),new Tile(0),new Tile(0),new Tile(0)},
                                   {new Tile(2),new Tile(2),new Tile(0),new Tile(0)},
                                   {new Tile(0),new Tile(0),new Tile(0),new Tile(0)}};
        
        Tile [][] boardSlide = {{new Tile(0),new Tile(0),new Tile(0),new Tile(0)},
                                {new Tile(0),new Tile(0),new Tile(0),new Tile(0)},
                                {new Tile(0),new Tile(0),new Tile(0),new Tile(4)},
                                {new Tile(0),new Tile(0),new Tile(0),new Tile(0)}};
        
        board.setGameBoard(originalBoard);
        board.slideTiles();

        assertEquals(boardSlide[2][3].getValue(), board.getTileValue(2, 3));
        assertEquals(boardSlide[2][1].getValue(), board.getTileValue(2, 1));
    }
    
    @Test
    public void slideLeftWithMerge() {
        Tile [][] originalBoard = {{new Tile(0),new Tile(0),new Tile(0),new Tile(0)},
                                   {new Tile(0),new Tile(0),new Tile(0),new Tile(0)},
                                   {new Tile(2),new Tile(2),new Tile(0),new Tile(0)},
                                   {new Tile(0),new Tile(0),new Tile(0),new Tile(0)}};
        
        Tile [][] boardSlide = {{new Tile(0),new Tile(0),new Tile(0),new Tile(0)},
                                {new Tile(0),new Tile(0),new Tile(0),new Tile(0)},
                                {new Tile(4),new Tile(0),new Tile(0),new Tile(0)},
                                {new Tile(0),new Tile(0),new Tile(0),new Tile(0)}};
        
        board.setGameBoard(originalBoard); 
        board.slideTilesLeft();
 
        assertEquals(boardSlide[2][0].getValue(), board.getTileValue(2, 0));
        assertEquals(boardSlide[2][1].getValue(), board.getTileValue(2, 1));
    }
    
    @Test
    public void slideUpWithMerge() {
        Tile [][] originalBoard = {{new Tile(0),new Tile(0),new Tile(0),new Tile(0)},
                                   {new Tile(0),new Tile(0),new Tile(0),new Tile(0)},
                                   {new Tile(2),new Tile(0),new Tile(0),new Tile(0)},
                                   {new Tile(2),new Tile(0),new Tile(0),new Tile(0)}};
        
        Tile [][] boardSlide = {{new Tile(4),new Tile(0),new Tile(0),new Tile(0)},
                                {new Tile(0),new Tile(0),new Tile(0),new Tile(0)},
                                {new Tile(0),new Tile(0),new Tile(0),new Tile(0)},
                                {new Tile(0),new Tile(0),new Tile(0),new Tile(0)}};
        
        board.setGameBoard(originalBoard);
        board.slideTilesUp();
        
        assertEquals(boardSlide[0][0].getValue(), board.getTileValue(0, 0));
        assertEquals(boardSlide[0][2].getValue(), board.getTileValue(0, 2));
        assertEquals(boardSlide[0][3].getValue(), board.getTileValue(0, 3)); 
    }
    
    @Test
    public void slideDownWithMerge() {
        Tile [][] originalBoard = {{new Tile(0),new Tile(0),new Tile(0),new Tile(0)},
                                   {new Tile(0),new Tile(0),new Tile(0),new Tile(0)},
                                   {new Tile(2),new Tile(0),new Tile(0),new Tile(0)},
                                   {new Tile(2),new Tile(0),new Tile(0),new Tile(0)}};
        
        Tile [][] boardSlide = {{new Tile(0),new Tile(0),new Tile(0),new Tile(0)},
                                {new Tile(0),new Tile(0),new Tile(0),new Tile(0)},
                                {new Tile(0),new Tile(0),new Tile(0),new Tile(0)},
                                {new Tile(4),new Tile(0),new Tile(0),new Tile(0)}};
        
        board.setGameBoard(originalBoard);
        board.slideTilesDown();
        
        assertEquals(boardSlide[3][0].getValue(), board.getTileValue(3, 0));
        assertEquals(boardSlide[2][0].getValue(), board.getTileValue(2, 0));
    }
    
    @Test
    public void doubleMergeTest() {
        Tile [][] originalBoard = {{new Tile(2),new Tile(0),new Tile(0),new Tile(0)},
                                   {new Tile(2),new Tile(0),new Tile(0),new Tile(0)},
                                   {new Tile(2),new Tile(0),new Tile(0),new Tile(0)},
                                   {new Tile(2),new Tile(0),new Tile(0),new Tile(0)}};
        
        Tile [][] boardSlide = {{new Tile(0),new Tile(0),new Tile(0),new Tile(0)},
                                {new Tile(0),new Tile(0),new Tile(0),new Tile(0)},
                                {new Tile(4),new Tile(0),new Tile(0),new Tile(0)},
                                {new Tile(4),new Tile(0),new Tile(0),new Tile(0)}};
        
        board.setGameBoard(originalBoard);
        board.slideTilesDown();
        
        assertEquals(boardSlide[3][0].getValue(), board.getTileValue(3, 0));
        assertEquals(boardSlide[2][0].getValue(), board.getTileValue(2, 0));
    }
    
    @Test
    public void multipleDoubleMergeTest() {
        Tile [][] originalBoard = {{new Tile(2),new Tile(4),new Tile(0),new Tile(0)},
                                   {new Tile(2),new Tile(4),new Tile(0),new Tile(0)},
                                   {new Tile(2),new Tile(4),new Tile(0),new Tile(0)},
                                   {new Tile(2),new Tile(4),new Tile(0),new Tile(0)}};
        
        Tile [][] boardSlide = {{new Tile(0),new Tile(0),new Tile(0),new Tile(0)},
                                {new Tile(0),new Tile(0),new Tile(0),new Tile(0)},
                                {new Tile(4),new Tile(8),new Tile(0),new Tile(0)},
                                {new Tile(4),new Tile(8),new Tile(0),new Tile(0)}};
        
        board.setGameBoard(originalBoard);
        board.slideTilesDown();
        
        assertEquals(boardSlide[3][0].getValue(), board.getTileValue(3, 0));
        assertEquals(boardSlide[2][0].getValue(), board.getTileValue(2, 0));
        assertEquals(boardSlide[3][1].getValue(), board.getTileValue(3, 1));
        assertEquals(boardSlide[2][1].getValue(), board.getTileValue(2, 1));
    }
    
    
    @Test
    public void oneMergePerTurn() {
        Tile [][] originalBoard = {{new Tile(0),new Tile(0),new Tile(0),new Tile(0)},
                                   {new Tile(0),new Tile(0),new Tile(0),new Tile(0)},
                                   {new Tile(0),new Tile(0),new Tile(0),new Tile(0)},
                                   {new Tile(4),new Tile(0),new Tile(2),new Tile(2)}};
        
        Tile [][] boardSlide = {{new Tile(0),new Tile(0),new Tile(0),new Tile(0)},
                                {new Tile(0),new Tile(0),new Tile(0),new Tile(0)},
                                {new Tile(0),new Tile(0),new Tile(0),new Tile(0)},
                                {new Tile(4),new Tile(4),new Tile(0),new Tile(0)}};
        
        board.setGameBoard(originalBoard);
        board.slideTilesLeft();
        
        assertEquals(boardSlide[3][0].getValue(), board.getTileValue(3, 0));
        assertEquals(boardSlide[3][1].getValue(), board.getTileValue(3, 1));
    }
    
    
    @Test
    public void resetGame() {
        board.resetGame();
        
        board.addRandomTile();
        board.addRandomTile();
        assertEquals(4, board.getNumberOfTiles());
        
        board.resetGame();
        assertEquals(2, board.getNumberOfTiles());
    }

}
