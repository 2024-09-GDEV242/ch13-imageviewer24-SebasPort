import java.awt.Color;
/**
 * This class creates a Warhol-like filter to an image,creating a 2x2 grid:
 * Top-left: Original image at quarter size
 * Top-right: Red Tint image at quarter size
 * Bottom-left: Green Tint Image at quarter size
 * Bottom-right: Blue Tint Image at quarter size
 *
 * @author Sebastian Portillo
 * @version 11/26/24
 */
public class WarholFilter extends Filter
{
    /**
     * Constructor for objects of class WarholFilter
     * @param name The name of the filter.
     */
    public WarholFilter(String name)
    {
        super(name); //Initialize the filter with its name
    }

    /**
     * Apply the Warhol filter to the image by splitting it in four sections:
     * Original, Red Tint, Green Tint and Blue Tint.
     *
     * @param image The image to apply the Warhol filter to.
     */
    @Override
    public void apply(OFImage image) {
        int width = image.getWidth(); // Get the width of the image
        int height = image.getHeight(); // Get the height of the image
        
        // Calculate the quarter size of the image for splitting
        int quarterWidth = width / 2;
        int quarterHeight = height / 2;
        
         OFImage originalScaled = scaleImage(image, quarterWidth, quarterHeight);

        // Top-left: Original
        copyScaledImage(image, originalScaled, 0, 0);

        // Top-right: Red Tint
        OFImage redTinted = applyTint(originalScaled, Color.RED);
        copyScaledImage(image, redTinted, quarterWidth, 0);

        // Bottom-left: Green Tint
        OFImage greenTinted = applyTint(originalScaled, Color.GREEN);
        copyScaledImage(image, greenTinted, 0, quarterHeight);

        // Bottom-right: Blue Tint
        OFImage blueTinted = applyTint(originalScaled, Color.BLUE);
        copyScaledImage(image, blueTinted, quarterWidth, quarterHeight);
    }
    /**
     * Scale an image to the given width and height
     * @param source The source image.
     * @param newWidth The desired width of the scaled image.
     * @param newHeight The desired height of the scaled image.
     * @return A scaled-down version of the source image.
     */
        private OFImage scaleImage(OFImage source, int newWidth, int newHeight) {
        OFImage scaled = new OFImage(newWidth, newHeight);
        for (int x = 0; x < newWidth; x++) {
            for (int y = 0; y < newHeight; y++) {
                int sourceX = x * source.getWidth() / newWidth;
                int sourceY = y * source.getHeight() / newHeight;
                scaled.setPixel(x, y, source.getPixel(sourceX, sourceY));
            }
        }
        return scaled;
    }
    /**
     * Apply a specific tint to a given section of the image.
     * Options: Red, Green or Blue
     * 
     * @param source the original image.
     * @param tint The color tint to apply (e.g., Red, Green, or Blue).
     */
    private OFImage applyTint(OFImage source,Color tint) {
      OFImage tinted = new OFImage(source.getWidth(), source.getHeight());
        for (int x = 0; x < source.getWidth(); x++) {
            for (int y = 0; y < source.getHeight(); y++) {
                Color original = source.getPixel(x, y);
                tinted.setPixel(x, y, new Color(
                    Math.min(255, original.getRed() + tint.getRed()),
                    Math.min(255, original.getGreen() + tint.getGreen()),
                    Math.min(255, original.getBlue() + tint.getBlue())
                ));
            }
        }
        return tinted;  
    }
    /**
     * Copy a scaled down version of the original image to another part of the image.
     * @param destX The x-coordinate of the top-left corner of the destination section
     * @param destY The y-coordinate of the top-left corner of the destination section
     * @param destination The image to copy onto.
     * @param source The scaled-down image to copy.
     */
    private void copyScaledImage(OFImage destination, OFImage source, int destX, int destY) {
        for (int x = 0; x < source.getWidth(); x++) {
            for (int y = 0; y < source.getHeight(); y++) {
                destination.setPixel(destX + x, destY + y, source.getPixel(x, y)); 
            }
        }
    }
}

