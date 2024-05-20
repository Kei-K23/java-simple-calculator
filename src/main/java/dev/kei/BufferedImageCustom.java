package dev.kei;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;

public class BufferedImageCustom {
    public Image imageReturn() throws IOException {
        InputStream bis = getClass().getResourceAsStream("/icon.png");
        if (bis == null) {
            throw new IOException("Resource not found: /icon.png");
        }
        return ImageIO.read(bis);
    }
}
