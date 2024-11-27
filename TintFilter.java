import java.awt.Color;
/**
 * This filter applies a tint to an image by increasing the intensity of 
 * a specific color (red, green or blue) and leaving the other two channels
 * unchanges.
 *
 * @author Sebastian Portillo
 * @version 11/26/24
 */
public class TintFilter extends Filter
{
    private Color tintColor;
    /**
     * Constructor for objects of class TintFilter
     * @param name The name of the Filter.
     * @param tintColor The color to use as a tint.
     */
    public TintFilter(String name, Color tintColor)
    {
        super(name);
        this.tintColor = tintColor;
    }

    /**
     * Applies the tint filter to the chosen image.
     * Applies a color tint to the image by adjusting the RGB channels based
     * on the tint color chosen.
     * @param image The image to which the filter will be applied.
     */
    @Override
     public void apply(OFImage image) {
        int width = image.getWidth();
        int height = image.getHeight();
        // Loop through each pixel in the image
        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                // Get the current pixel's color
                Color color = image.getPixel(x, y);
                
                // Blend the original color with the tint color
                int newRed = Math.min(255, color.getRed() + tintColor.getRed());
                int newGreen = Math.min(255, color.getGreen() + tintColor.getGreen());
                int newBlue = Math.min(255, color.getBlue() + tintColor.getBlue());
                
                // Set the new pixel color with the blended tint
                image.setPixel(x, y, new Color(newRed, newGreen, newBlue));
            }
        }
    }
}
