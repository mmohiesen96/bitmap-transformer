package bitmap.transformer;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Arrays;

public class BitMap {
    File bitImage;
    File newBitImage;
    String transformName;

    public BitMap(String transformName, String outputPath, String inputPath) {
        this.bitImage = new File(inputPath);
        this.newBitImage = new File(outputPath + "/" + transformName + ".bmp");
        this.transformName = transformName;
    }
    public void bitOutputFile (BufferedImage image) {
        try {

            ImageIO.write(image, "bmp" , this.newBitImage);
            System.out.println("Saved file to: " + this.newBitImage.getPath());

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
    public BitMap cyanBorder () throws IOException{

        try {
            BufferedImage bitImage = ImageIO.read(this.bitImage);
            int currentPixelAvg = 0;
            int borderWidth = 3;

            for (int x = 0; x < bitImage.getWidth(); x++) {
                for (int y = 0; y < bitImage.getHeight(); y++) {
                    if (y < borderWidth || y + borderWidth >= bitImage.getHeight() || x < borderWidth || x + borderWidth >= bitImage.getWidth()) {
                        bitImage.setRGB(x, y, Color.CYAN.getRGB());
                    }
                }

            }
            this.bitOutputFile(bitImage);
        }catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }


}
