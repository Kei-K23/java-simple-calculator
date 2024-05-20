package dev.kei;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;

public class BufferedImageCustom {
    public Image imageReturn() throws IOException {
        InputStream bis = getClass().getResourceAsStream("/resources/icon.png");
        return ImageIO.read(bis);
    }
}
