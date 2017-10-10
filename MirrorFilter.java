import java.awt.Color;

/**
 * This filter will flip an image to its mirror.
 * 
 * @author Matthew Babb 
 * @version 1.0 3/29/16
 */
public class MirrorFilter extends Filter
{
    /**
     * Constructor for objects of class InvertFilter
     * @param name The name of the filter.
     */
    public MirrorFilter(String name)
    {
        // initialise instance variables
        super (name);
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
        int z = width-1; //used for edge guarding
        
        //loop through image with half width
        for(int y = 0; y < height; y++)
        {
            for(int x = 0; x < (width/2); x++)
            {
                //swap left and right pixels
                Color leftPixel = image.getPixel(x,y);
                Color rightPixel = image.getPixel(z,y);
                image.setPixel(x, y, rightPixel);
                image.setPixel(z, y, leftPixel);
                
                //z moves toward middle in reverse order
                z--;
            }
            
            //z must be reset for each new row
            z = width-1;
        }
    }
}
