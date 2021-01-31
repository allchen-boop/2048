import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

public class Image {
    
    public static final String IMAGE_FILE0 = "imageFiles/0.png";
    public static final String IMAGE_FILE2 = "imageFiles/2.png"; 
    public static final String IMAGE_FILE4 = "imageFiles/4.png";
    public static final String IMAGE_FILE8 = "imageFiles/8.png";
    public static final String IMAGE_FILE16 = "imageFiles/16.png";
    public static final String IMAGE_FILE32 = "imageFiles/32.png";
    public static final String IMAGE_FILE64 = "imageFiles/64.png";
    public static final String IMAGE_FILE128 = "imageFiles/128.png";
    public static final String IMAGE_FILE256 = "imageFiles/256.png";
    public static final String IMAGE_FILE512 = "imageFiles/512.png";
    public static final String IMAGE_FILE1024 = "imageFiles/1024.png";
    public static final String IMAGE_FILE2048 = "imageFiles/2048.png";
    public static final String IMAGE_FILEINSTRUCTIONS = "imageFiles/instructions.png";
    public static final String IMAGE_FILELOSE = "imageFiles/lose.png";
    public static final String IMAGE_FILEWIN = "imageFiles/win.png";
     
    private static BufferedImage image0;
    private static BufferedImage image2;
    private static BufferedImage image4;
    private static BufferedImage image8;
    private static BufferedImage image16;
    private static BufferedImage image32;
    private static BufferedImage image64;
    private static BufferedImage image128;
    private static BufferedImage image256;
    private static BufferedImage image512;
    private static BufferedImage image1024;
    private static BufferedImage image2048;
    private static BufferedImage imageInstructions;
    private static BufferedImage imageLose;
    private static BufferedImage imageWin;
    
    public Image() {
        try {
            if (image0 == null) {
                image0 = ImageIO.read(new File(IMAGE_FILE0));
            }
        } catch (IOException e) {
            System.out.println("Internal Error:" + e.getMessage());
        }
        try {
            if (image2 == null) {
                image2 = ImageIO.read(new File(IMAGE_FILE2));
            }
        } catch (IOException e) {
            System.out.println("Internal Error:" + e.getMessage());
        }
        
        try {
            if (image4 == null) {
                image4 = ImageIO.read(new File(IMAGE_FILE4));
            }
        } catch (IOException e) {
            System.out.println("Internal Error:" + e.getMessage());
        }
        try {
            if (image8 == null) {
                image8 = ImageIO.read(new File(IMAGE_FILE8));
            }
        } catch (IOException e) {
            System.out.println("Internal Error:" + e.getMessage());
        }
        try {
            if (image16 == null) {
                image16 = ImageIO.read(new File(IMAGE_FILE16));
            }
        } catch (IOException e) {
            System.out.println("Internal Error:" + e.getMessage());
        }
        try {
            if (image32 == null) {
                image32 = ImageIO.read(new File(IMAGE_FILE32));
            }
        } catch (IOException e) {
            System.out.println("Internal Error:" + e.getMessage());
        }
        try {
            if (image64 == null) {
                image64 = ImageIO.read(new File(IMAGE_FILE64));
            }
        } catch (IOException e) {
            System.out.println("Internal Error:" + e.getMessage());
        }
        try {
            if (image128 == null) {
                image128 = ImageIO.read(new File(IMAGE_FILE128));
            }
        } catch (IOException e) {
            System.out.println("Internal Error:" + e.getMessage());
        }
        try {
            if (image256 == null) {
                image256 = ImageIO.read(new File(IMAGE_FILE256));
            }
        } catch (IOException e) {
            System.out.println("Internal Error:" + e.getMessage());
        }
        try {
            if (image512 == null) {
                image512 = ImageIO.read(new File(IMAGE_FILE512));
            }
        } catch (IOException e) {
            System.out.println("Internal Error:" + e.getMessage());
        }
        try {
            if (image256 == null) {
                image256 = ImageIO.read(new File(IMAGE_FILE256));
            }
        } catch (IOException e) {
            System.out.println("Internal Error:" + e.getMessage());
        }
        try {
            if (image1024 == null) {
                image1024 = ImageIO.read(new File(IMAGE_FILE1024));
            }
        } catch (IOException e) {
            System.out.println("Internal Error:" + e.getMessage());
        }
        try {
            if (image2048 == null) {
                image2048 = ImageIO.read(new File(IMAGE_FILE2048));
            }
        } catch (IOException e) {
            System.out.println("Internal Error:" + e.getMessage());
        }
        try {
            if (imageInstructions == null) {
                imageInstructions = ImageIO.read(new File(IMAGE_FILEINSTRUCTIONS));
            }
        } catch (IOException e) {
            System.out.println("Internal Error:" + e.getMessage());
        } 
        try {
            if (imageLose == null) {
                imageLose = ImageIO.read(new File(IMAGE_FILELOSE));
            }
        } catch (IOException e) {
            System.out.println("Internal Error:" + e.getMessage());
        } 
        try {
            if (imageWin == null) {
                imageWin = ImageIO.read(new File(IMAGE_FILEWIN));
            }
        } catch (IOException e) {
            System.out.println("Internal Error:" + e.getMessage());
        } 
        
    }
    
  //==========================================================================
  // Getters
  //==========================================================================
   
    public BufferedImage getImage0() {
        return image0;
    }
    public BufferedImage getImage2() {
        return image2;
    }
    
    public BufferedImage getImage4() {
        return image4;
    }
    
    public BufferedImage getImage8() {
        return image8;
    }
    
    public BufferedImage getImage16() {
        return image16;
    }
    
    public BufferedImage getImage32() {
        return image32;
    }
    
    public BufferedImage getImage64() {
        return image64;
    }
    
    public BufferedImage getImage128() {
        return image128;
    }
    
    public BufferedImage getImage256() {
        return image256;
    }
    
    public BufferedImage getImage512() {
        return image512;
    }
    
    public BufferedImage getImage1024() {
        return image1024;
    }
    
    public BufferedImage getImage2048() {
        return image2048;
    }
    
    public BufferedImage getImageInstructions() {
        return imageInstructions;
    }
    
    public BufferedImage getImageLose() {
        return imageLose;
    }
    
    public BufferedImage getImageWin() {
        return imageWin;
    } 
}
