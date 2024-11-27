import java.awt.Color;
/**
 * This filter only keeps the green channel of the image, while also
 * setting the red and blue channels to zero.
 *
 * @author Sebastian Portillo
 * @version 11/26/24
 */
public class GreenChannelFilter extends Filter
{

    /**
     * Constructor for objects of class GreenChannelFilter.
     * @param name The name of the filter.
     */
    public GreenChannelFilter(String name)
    {
        super(name);
    }

    /**
     * Apply the green channel to the image.
     * Set the green channel to it's original value while setting both blue and red
     * to 0 for each pixel
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
                
                // Set the new pixel with only the green channel and 0 for red and blue
                image.setPixel(x, y, new Color(0, color.getGreen(), 0));
            }
        }
    }
}
