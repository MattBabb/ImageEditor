import java.awt.Color;

/**
 * An image filter which will smooth the image.
 * 
 * @author Matthew Babb 
 * @version 1.0 3/29/16
 */
public class SmoothFilter extends Filter
{
    /**
     * Constructor for objects of class InvertFilter
     * @param name The name of the filter.
     */
    public SmoothFilter(String name)
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
        //traversing image with edge guard
        for(int y = 1; y < height-1; y++)
        {
            for(int x = 1; x < width-1; x++)
            {
               //grab pixel and all neighboring pixels
               Color pix1 = image.getPixel(x-1, y-1);
               Color pix2 = image.getPixel(x, y-1);
               Color pix3 = image.getPixel(x+1, y-1);
               Color pix4 = image.getPixel(x-1, y);
               Color pix5 = image.getPixel(x, y);
               Color pix6 = image.getPixel(x+1, y);
               Color pix7 = image.getPixel(x-1, y+1);
               Color pix8 = image.getPixel(x, y+1);
               Color pix9 = image.getPixel(x+1, y+1);
               //average of all neighbors
               int red = (pix1.getRed() + pix2.getRed() + pix3.getRed()
                + pix4.getRed() + pix5.getRed() + pix6.getRed()
                + pix7.getRed() + pix8.getRed() + pix9.getRed()) / 9;
               int blue = (pix1.getBlue() + pix2.getBlue() + pix3.getBlue()
                + pix4.getBlue() + pix5.getBlue() + pix6.getBlue()
                + pix7.getBlue() + pix8.getBlue() + pix9.getBlue()) / 9;
               int green = (pix1.getGreen() + pix2.getGreen() + pix3.getGreen()
                + pix4.getGreen() + pix5.getGreen() + pix6.getGreen()
                + pix7.getGreen() + pix8.getGreen() + pix9.getGreen()) / 9;
               //assign average to original pixel
               Color newPix = new Color(red, green, blue);
               image.setPixel(x, y, newPix);
            }
        }
    }
}
