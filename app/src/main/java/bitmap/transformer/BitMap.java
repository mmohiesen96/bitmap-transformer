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
        try
        {
            this.bitImage = new File(inputPath);
            this.newBitImage = new File(outputPath + "/" + transformName + ".bmp");
            this.transformName = transformName;
        }

        catch (Exception e ){
            System.out.println("An error occured in the path");
        }

    }

    public void bitOutputFile(BufferedImage image) {
        try {

            ImageIO.write(image, "bmp", this.newBitImage);
            System.out.println("Saved file to: " + this.newBitImage.getPath());

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public BitMap cyanBorder() throws IOException {

        try {
            BufferedImage bitImage = ImageIO.read(new File(this.bitImage.getAbsolutePath()));
//            int currentPixelAvg = 0;
            int borderWidth = 3;

            for (int x = 0; x < bitImage.getHeight(); x++) {
                for (int y = 0; y < bitImage.getWidth(); y++) {
                    if (y < borderWidth || y + borderWidth >= bitImage.getWidth() || x < borderWidth || x + borderWidth >= bitImage.getHeight()) {
                        bitImage.setRGB(y, x, Color.CYAN.getRGB());
                    }
                }

            }
            this.bitOutputFile(bitImage);
        } catch (IOException e) {
            System.out.println(bitImage.getAbsolutePath());
            System.out.println("An Error occured");
        }

        return null;
    }

    public BitMap filterBlue() throws IOException {
        Color currentColor , color ;
        BufferedImage image = ImageIO.read(this.bitImage);
        for (int i = 0; i < image.getHeight(); i++) {
            for (int j = 0; j < image.getWidth(); j++) {
                currentColor = new Color(image.getRGB(j,i));
                color = new Color(currentColor.getRed() , currentColor.getGreen() , 0);
                image.setRGB(j , i ,color.getRGB());
            }

        }
        this.bitOutputFile(image);
        return null;
    }

    public BitMap filterGreen() throws IOException {
        Color currentColor , color ;
        BufferedImage image = ImageIO.read(this.bitImage);
        for (int i = 0; i < image.getHeight(); i++) {
            for (int j = 0; j < image.getWidth(); j++) {
                currentColor = new Color(image.getRGB(j,i));
                color = new Color(currentColor.getRed() , 0 , currentColor.getBlue());
                image.setRGB(j , i ,color.getRGB());
            }

        }
        this.bitOutputFile(image);
        return null;
    }


}
