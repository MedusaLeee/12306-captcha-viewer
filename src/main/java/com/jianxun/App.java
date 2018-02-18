package com.jianxun;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.image.BufferedImage;
import java.io.FileInputStream;
import java.io.IOException;

class ImageViewer extends Frame {
    BufferedImage bufferedImage = null;
    public ImageViewer(BufferedImage bufferedImage) {
        this.bufferedImage = bufferedImage;
    }

    @Override
    public void paint(Graphics g) {
        g.drawImage(this.bufferedImage, 0, 20, null);
    }

    public void launchFrame() {
        setSize(293, 210);
        setLocation(100, 100);
        setVisible(true);

        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
    }
}

public class App{
    public static void main(String[] args ) throws IOException {
        BufferedImage bufferedImage = ImageIO.read(System.in);
        // String path = "/Users/jianxun/Downloads/captcha-image.jpeg";
        // BufferedImage bufferedImage = ImageIO.read(new FileInputStream(path));
        ImageViewer iv = new ImageViewer(bufferedImage);
        iv.launchFrame();
    }
}
