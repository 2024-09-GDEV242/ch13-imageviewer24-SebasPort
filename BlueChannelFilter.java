import java.awt.Color;
/**
 * This filter only keeps the blue channel of the image while setting
 * the red and green channels to zero.
 *
 * @author Sebastian Portillo
 * @version 11/26/24
 */
public class BlueChannelFilter extends Filter
{
    
    /**
     * Constructor for objects of class BlueChannelFilter
     */
    public BlueChannelFilter(String name)
    {
        super(name);
    }

    /**
     Apply the blue channel to the image.
     * Set the blue channel to it's original value while setting both green and red
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
                
                // Set the new pixel with only the blue channel and 0 for red and green
                image.setPixel(x, y, new Color(0, 0, color.getBlue()));
            }
        }
    }
}  
  

