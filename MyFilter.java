import java.awt.Color;

/**
 * An image filter which will perform a mystery filter.
 * 
 * @author Matthew Babb 
 * @version 1.0 3/29/16
 */
public class MyFilter extends Filter
{
    /**
     * Constructor for objects of class InvertFilter
     * @param name The name of the filter.
     */
    public MyFilter(String name)
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
        //GrayscaleFilter(image);
        int height = image.getHeight();
        int width = image.getWidth();
        
        //traversing the image
        for(int y = 0; y < height-1; y++)
        {
            for(int x = 0; x < width-1; x++)
            {
                //grab pixel color and its neighbor
                Color pixel = image.getPixel(x,y);
                Color nextPixel = image.getPixel(x+1,y+1);
                
                //calculate embossed value
                int emb = nextPixel.getRed() - pixel.getRed() + 128;
                //guard against invalid color values
                if (emb > 255)
                {
                    emb = 255;                
                }
                if (emb < 0)
                {
                    emb = 0;                
                }
                
                //assign emboss value to pixel
                Color newPix = new Color (emb, emb, emb);
                image.setPixel(x, y, newPix);
            }
        }
    }
}
