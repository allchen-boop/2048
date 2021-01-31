import java.awt.Graphics;

public class Tile {

    private int value;
    private boolean merged;
    private Image tileImage;
    
    public static final int IMAGE_SIZE = 105;
    
    public Tile(int value) {
        this.value = value;
        merged = false;
        tileImage = new Image(); 
    }
    
    //draws the tile given the image file and its coordinates
    public void drawTile(Graphics g, int x, int y) {
        if (value == 0) {
            g.drawImage(tileImage.getImage0(), x, y, IMAGE_SIZE, IMAGE_SIZE, null);
        }
        if (value == 2) {
            g.drawImage(tileImage.getImage2(), x, y, IMAGE_SIZE, IMAGE_SIZE, null);
        }
        if (value == 4) {
            g.drawImage(tileImage.getImage4(), x, y, IMAGE_SIZE, IMAGE_SIZE, null);
        }
        if (value == 8) {
            g.drawImage(tileImage.getImage8(), x, y, IMAGE_SIZE, IMAGE_SIZE, null);
        }
        if (value == 16) {
            g.drawImage(tileImage.getImage16(), x, y, IMAGE_SIZE, IMAGE_SIZE, null);
        }
        if (value == 32) {
            g.drawImage(tileImage.getImage32(), x, y, IMAGE_SIZE, IMAGE_SIZE, null);
        }
        if (value == 64) {
            g.drawImage(tileImage.getImage64(), x, y, IMAGE_SIZE, IMAGE_SIZE, null);
        }
        if (value == 128) {
            g.drawImage(tileImage.getImage128(), x, y, IMAGE_SIZE, IMAGE_SIZE, null);
        }
        if (value == 256) {
            g.drawImage(tileImage.getImage256(), x, y, IMAGE_SIZE, IMAGE_SIZE, null);
        }
        if (value == 512) {
            g.drawImage(tileImage.getImage512(), x, y, IMAGE_SIZE, IMAGE_SIZE, null);
        }
        if (value == 1024) {
            g.drawImage(tileImage.getImage1024(), x, y, IMAGE_SIZE, IMAGE_SIZE, null);
        }
        if (value == 2048) {
            g.drawImage(tileImage.getImage2048(), x, y, IMAGE_SIZE, IMAGE_SIZE, null);
        }
    }

    
    public void setValue(int value) {
        this.value = value;
    }
    
    public int getValue() {
        return value;
    }
    
    public void setMergeStatus(boolean mergeStatus) {
        merged = mergeStatus;
    }
    
    //true if tile has been merged; false otherwise
    public boolean getMergeStatus() {
        return merged;
    }

}
