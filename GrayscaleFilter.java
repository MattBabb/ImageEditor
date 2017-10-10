import java.awt.Color;

/**
 * An image filter which will smooth the image.
 * 
 * @author Matthew Babb 
 * @version 1.0 3/29/16
 */
public class GrayscaleFilter extends Filter
{
    /**
     * Constructor for objects of class InvertFilter
     * @param name The name of the filter.
     */
    public GrayscaleFilter(String name)
    {
        // initialise instance variables
        super(name);
    }

    /**
     * Apply this filter to the image.
     * 
     * @param  image    The image that will be changed.
     */
    public void apply(OFImage image)
    {
        int height = image.getHeight();
        int width = image.getWidth();
        
        //loop through each pixel in the image
        for(int y = 0; y < height; y++)
        {
            for(int x = 0; x < width; x++)
            {
                //grab the color pixel
                Color pixel = image.getPixel(x,y);
                
                //average RGB values to get gray
                int gray = (pixel.getRed() + pixel.getGreen() + pixel.getBlue()) / 3;
                
                //assign gray average to a pixel
                Color newPix = new Color (gray, gray, gray);
                
                //use the new pixel to assign the color to the current location
                image.setPixel(x, y, newPix);
            }
        }
    }
}
