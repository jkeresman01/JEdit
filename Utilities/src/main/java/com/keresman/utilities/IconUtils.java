package com.keresman.utilities;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

/**
 * A utility class for working with image icons.
 *
 * This class is not intended to be extended or instantiated. It follows the
 * utility class design pattern, and explicitly forbids subclassing and
 * instantiation
 *
 */
public final class IconUtils {

    private IconUtils() {
        // Suppresses default constructor, ensuring non-instantiability.
    }

    /**
     *
     * Creates a scaled {@link ImageIcon} from the specified image file.
     *
     * @param file
     * @param width
     * @param height
     * 
     * @return a {@code ImageIcon} scaled to the specified dimensions
     * 
     * @throws IOException if the file cannot be read or decoded as an image
     */
    public static ImageIcon createIcon(File file, int width, int height) throws IOException {
        BufferedImage bufferedImage = ImageIO.read(file);
        Image image = bufferedImage.getScaledInstance(width, height, Image.SCALE_SMOOTH);
        return new ImageIcon(image);
    }
}
