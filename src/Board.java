import java.awt.Graphics;

public class Board {
    
    private Tile [][] grid;
    private int numberOfTiles;
    private Image screenImage;
    
    public Board() {
        screenImage = new Image();
        grid = new Tile [4][4];
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                grid [i][j] = new Tile(0);
            }
        }
        //game begins with two random tiles (either 2 or 4)
        addRandomTile();
        addRandomTile();
    }
    
    public void resetGame() {
        numberOfTiles = 0;
        this.grid = new Tile [4][4];
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                grid [i][j] = new Tile(0);
            }
        }
        addRandomTile();
        addRandomTile();
    }
    
    public void addRandomTile() {
        
        //if the board is full but the game is not over don't add
        if (fullBoard() && validTileMerge()) {
            return;
        }
        
        //randomly chosen space for tile coordinates
        int xcoord = (int) (Math.random() * 4);
        int ycoord = (int) (Math.random() * 4);
        int value = 2;
        
        //new tile will be 2 or a 4
        if (Math.random() > 0.5) {
            value = 4;
        }
        
        //make sure the random space is unoccupied
        while (grid[xcoord][ycoord].getValue() != 0 && !fullBoard()) {
            xcoord = (int) (Math.random() * 4);
            ycoord = (int) (Math.random() * 4);
        }
        
        //adding a tile will increase total tile counter
        grid[xcoord][ycoord].setValue(value);
        numberOfTiles++;
    }
    
    //getting value of the tile given location
    public int getTileValue(int x, int y) {
        return grid[x][y].getValue();
    }

    //state of the board is represented by 2D array of tile values
    public Tile[][] getBoardState() {
        Tile[][] gridCopy = new Tile[4][4];
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                gridCopy[i][j] = new Tile(getTileValue(i, j));
            }
        }
        return gridCopy;
    }
    
    //sets state of game board with a new 2D grid state
    //also  sets the count of total tiles
    public void setGameBoard(Tile[][] newGrid) {
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                grid[i][j] = newGrid[i][j];
            }
        }
        
        //how many tiles in the board there are
        int count = 0; 
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                if (getTileValue(i, j) > 0) {
                    count ++;
                }
            }
        }
        numberOfTiles = count;
    }

    //getter method of number of tiles currently occupying board
    public int getNumberOfTiles() {
        return numberOfTiles;
    }

    //16 possible spaces to be filled
    public boolean fullBoard() {
        return (numberOfTiles == 16);
    }
    
    //player wins when there is a tile of value 2048
    public boolean win() {
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                if (getTileValue(i, j) == 2048) {
                    return true;
                }
            }
        }
        return false;
    }

    //if there is any valid tile merge in the board
    public boolean validTileMerge() {
        for (int col = 0; col < 4; col++) {
            for (int row = 0; row < 4; row ++) {
                //compares with tile down
                if (col > 0) {
                    if (getTileValue(col, row) == getTileValue(col - 1, row)) {
                        return true;
                    }
                }
                //compares with tile on right
                if (row + 1 < 4) {
                    if (getTileValue(col, row) == getTileValue(col, row + 1)) {
                        return true;
                    }
                }
                //compares with tile on left
                if (row - 1 > -1) {
                    if (getTileValue(col, row) == getTileValue(col, row - 1)) {
                        return true;
                    }
                }
                //compares with tile up
                if (col + 1 < 4) {
                    if (getTileValue(col, row) == getTileValue(col + 1, row)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }
   
 //==========================================================================
 // Methods for sliding the tiles
 //==========================================================================

    //sliding and merging
    public void slideTiles() {
        //sliding mechanism for sliding to the right that can be rotated
        for (int col = 0; col < 4; col++) {
            for (int row = 2; row > -1; row--) {
                //for sliding tiles to the farthest possible end
                int temp = row;
                //while there is no tile to the right
                while (temp + 1 < 4 && getTileValue(col, temp + 1) == 0) {
                    int tileVal = getTileValue(col, temp);
                    //the tile will move to the right
                    grid[col][temp + 1].setValue(tileVal);
                    //its past space will now be empty
                    grid[col][temp].setValue(0);
                    temp++;
                }
                
                //if the two tiles are equal and if the tile to the right is not empty
                if (temp < 3 && getTileValue(col, temp + 1) != 0) {
                    if (getTileValue(col, temp) == getTileValue(col, temp + 1) &&
                        //if the tile has not already merged this turn
                        !grid[col][temp + 1].getMergeStatus()) {
                        int tileVal = getTileValue(col, temp);
                        //the tiles will now be merged
                        grid[col][temp + 1].setValue(2 * tileVal);
                        grid[col][temp + 1].setMergeStatus(true);
                        grid[col][temp].setValue(0);

                        //number of tiles decreases after merge
                        numberOfTiles--;
                    }
                }
            }
        }
        //after each move no tiles have been merged
        for (int col = 0; col < 4; col++) {
            for (int row = 0; row < 4; row++) {
                grid[col][row].setMergeStatus(false);
            }
        }
    }

   //sliding will be the same for all directions if board is rotated
    public void rotate() {
        Tile[][] gridCopy = new Tile[4][4];
        //flips the copy of the board grid
        for (int col = 0; col < 4; col++) {
            for (int row = 0; row < 4; row++) {
                gridCopy[row][col] = grid[col][row];
            }
        }
        //rotates by 90 counterclockwise
        for (int col = 0; col < 4; col++) {
            for (int row = 0; row < 4; row++) {
                grid[col][row] = gridCopy[col][3 - row];
            }
        }
    }
    
   //rotates 270 so sliding right will be like sliding down and then returns board to normal
    public void slideTilesDown() {
        rotate();
        rotate();
        rotate();
        slideTiles();
        rotate();
    }
    
    //rotates 180 so sliding right will be like sliding left and then returns board to normal
    public void slideTilesLeft() {
        rotate();
        rotate();
        slideTiles();
        rotate();
        rotate();
    }
    
    //rotates 90 so sliding right will be like sliding up and then returns board to normal
    public void slideTilesUp() {
        rotate();
        slideTiles();
        rotate();
        rotate();
        rotate();
    }
   

  //==========================================================================
  // Drawing
  //==========================================================================
    
    //drawing the tiles in the board
    public void drawBoard(Graphics g) {
        for (int col = 0; col < 4; col++) {
            for (int row = 0; row < 4; row++) {
                grid[col][row].drawTile(g, 25 + 115 * col, 25 + 115 * row);
            }
        }
    }
    
    public void drawInstructions(Graphics g) {
        g.drawImage(screenImage.getImageInstructions(), 0, 115, 500, 325, null);
    }
    
    public void drawLose(Graphics g) {
        g.drawImage(screenImage.getImageLose(), 18, 170, 460, 140, null);
    }
    
    public void drawWin(Graphics g) {
        g.drawImage(screenImage.getImageWin(), 5, 160, 485, 170, null);
    }
    
}
