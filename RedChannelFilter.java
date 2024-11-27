import java.awt.Color;
/**
 * This is a filter that only keeps the red channel of an image, it also
 * sets the blue and green channels to zero.
 *
 * @author Sebastian Portillo
 * @version 11/26/24
 */
public class RedChannelFilter extends Filter
{
    /**
     * Constructor for objects of class RedChannelFilter
     * @param name the name of the filter.
     */
    public RedChannelFilter(String name)
    {
        super(name);
    }
   
    /**
     * Apply the red channel filter to the image.
     * Sets the red channel to the original value while setting both blue
     * and green channels to 0 for each pixel.
     * @param image the Image that the filter will be applied on.
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
                
                // Set the new pixel with only the red channel and 0 for green and blue
                image.setPixel(x, y, new Color(color.getRed(), 0, 0));
            }
        }
    }    
}
