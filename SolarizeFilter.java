import java.awt.Color;

/**
 * An image filter which will invert the image colors.
 * 
 * @author Matthew Babb 
 * @version 1.0 3/29/16
 */
public class SolarizeFilter extends Filter
{
   /**
     * Constructor for objects of class InvertFilter
     * @param name The name of the filter.
     */
    public SolarizeFilter(String name)
    {
        // initialise instance variables
        super(name);
    }

   /**
    * An example of a method - replace this comment with your own
    * 
    * @param  y   a sample parameter for a method
    * @return     the sum of x and y 
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
                //get pixel color values
                Color pixel = image.getPixel(x,y);
                int red = pixel.getRed();
                int blue = pixel.getBlue();
                int green = pixel.getGreen();
                //solarize calculations
                if (red < 128)
                {
                    red = 255 - red;
                }
                if (blue < 128)
                {
                    blue = 255 - blue;
                }
                if (green < 128)
                {
                    green = 255 - green;
                }
                //assign solarized value
                Color newPix = new Color (red, green, blue);
                image.setPixel(x, y, newPix);
            }
        }
   }
}
