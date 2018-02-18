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
        Font f = new Font("宋体", Font.BOLD, 15);
        g.setFont(f);
        g.drawString("请在命令行中输入正确答案的图片编号。", 0, 40);
        g.drawString("多个用逗号\",\"隔开，如:1,3。", 0, 60);
        g.drawString("输入完成后关闭此窗口。", 0, 80);
        g.drawImage(this.bufferedImage, 0, 100, null);
        g.drawString("1", 30, 135);
        g.drawString("2", 105, 135);
        g.drawString("3", 180, 135);
        g.drawString("4", 245, 135);
        g.drawString("5", 30, 295);
        g.drawString("6", 105, 295);
        g.drawString("7", 180, 295);
        g.drawString("8", 245, 295);
    }

    public void launchFrame() {
        setSize(293, 350);
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
