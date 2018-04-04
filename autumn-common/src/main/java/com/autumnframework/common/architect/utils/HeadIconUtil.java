package com.autumnframework.common.architect.utils;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.font.FontRenderContext;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.UUID;

/**
 * @author Junlan Shuai[shuaijunlan@gmail.com].
 * @date Created on 13:02 2018/4/4.
 */
public class HeadIconUtil {
    /**
     * 默认格式
     */
    private static final String FORMAT_NAME = "JPG";
    /**
     * 默认宽度
     */
    private static final int WIDTH = 100;
    /**
     * 默认高度
     */
    private static final int HEIGHT =100;

    /**
     * 创建图片
     * @param content 内容
     * @param font  字体
     * @param width 宽
     * @param height 高
     * @return
     */
    private static BufferedImage createImage(String content, Font font, Integer width, Integer height){
        BufferedImage bi = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
        Graphics2D g2 = (Graphics2D)bi.getGraphics();
        g2.setBackground(Color.blue);
        g2.clearRect(0, 0, width, height);
        g2.setPaint(Color.BLACK);

        FontRenderContext context = g2.getFontRenderContext();
        Rectangle2D bounds = font.getStringBounds(content, context);
        double x = (width - bounds.getWidth()) / 2;
        double y = (height - bounds.getHeight()) / 2;
        double ascent = - bounds.getY();
        double baseY = y + ascent;

        g2.drawString(content, (int)x, (int)baseY);

        return bi;
    }

    /**
     * 获取 图片
     * @param content 内容
     * @param font  字体
     * @param width 宽
     * @param height 高
     * @return
     */
    public static BufferedImage getImage(String content, Font font, Integer width, Integer height){
        width = width == null ? WIDTH : width;
        height = height == null ? HEIGHT : height;
        if(null == font) {
            font = new Font("Serif", Font.BOLD, 100);
        }
        return createImage(content, font, width, height);
    }

    public static void main(String[] args) throws Exception {

        Font font = Font.createFont(Font.TRUETYPE_FONT, new File("C:\\Users\\Junlan\\Downloads\\TeX Gyre Adventor.ttf"))
                .deriveFont(Font.BOLD, 60f);
        GraphicsEnvironment.getLocalGraphicsEnvironment().registerFont(font);
        BufferedImage image = new BufferedImage(500, 200, BufferedImage.TYPE_INT_ARGB);
        Graphics2D g = (Graphics2D) image.getGraphics();
        // 抗锯齿
        g.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);

        g.setColor(Color.WHITE);
        g.fillRect(0, 0, image.getWidth(), image.getHeight());
        g.setFont(font);
        g.setColor(Color.BLACK);
        g.drawString("中文", 100, 100);
        g.dispose();
        ImageIO.write(image, "PNG", new File("F:/3-AUTUMN/result.png"));
//        String file = UUID.randomUUID().toString()+".jpg";
//        ImageIO.write(getImage("M", null, 164, 164), FORMAT_NAME, new File("F:/3-AUTUMN" + "/"+file));
    }
}
