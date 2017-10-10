import java.awt.Color;

/**
 * An image filter which will invert the image colors.
 * 
 * @author Matthew Babb 
 * @version 1.0 3/29/16
 */
public class InvertFilter extends Filter
{
    /**
     * Constructor for objects of class InvertFilter
     * @param name The name of the filter.
     */
    public InvertFilter(String name)
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
        
        //loops for traversing image
        for(int y = 0; y < height; y++)
        {
            for(int x = 0; x < width; x++)
            {
                //get current color value
                Color pixel = image.getPixel(x,y);
                int red = pixel.getRed();
                int blue = pixel.getBlue();
                int green = pixel.getGreen();
                
                //calculate inverted color value
                red = 255 - red;
                blue = 255 - blue;
                green = 255 - green;
                
                //assign inverted color to current pixel
                Color newPix = new Color(red, green, blue);
                image.setPixel(x, y, newPix);
            }
        }
    }
}
