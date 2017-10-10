import java.awt.Color;

/**
 * An image filter which will detect edges.
 * 
 * @author Matthew Babb 
 * @version 1.0 3/29/16
 */
public class EdgeFilter extends Filter
{
    /**
     * Constructor for objects of class InvertFilter
     * @param name The name of the filter.
     */
    public EdgeFilter(String name)
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
        
        OFImage edited = new OFImage(width, height);
        
        //traversal with edge guarding
        for(int y = 1; y < height-1; y++)
        {
            for(int x = 1; x < width-1; x++)
            {
               //grab pixel and all neighbors
               Color pix1 = image.getPixel(x-1, y-1);
               Color pix2 = image.getPixel(x, y-1);
               Color pix3 = image.getPixel(x+1, y-1);
               Color pix4 = image.getPixel(x-1, y);
               Color pix5 = image.getPixel(x, y);
               Color pix6 = image.getPixel(x+1, y);
               Color pix7 = image.getPixel(x-1, y+1);
               Color pix8 = image.getPixel(x, y+1);
               Color pix9 = image.getPixel(x+1, y+1);
               
               //place all values into respective R/G/B array
               int redArr[] = new int[9];
               redArr[0] = pix1.getRed();
               redArr[1] = pix2.getRed();
               redArr[2] = pix3.getRed();
               redArr[3] = pix4.getRed();
               redArr[4] = pix5.getRed();
               redArr[5] = pix6.getRed();
               redArr[6] = pix7.getRed();
               redArr[7] = pix8.getRed();
               redArr[8] = pix9.getRed();
               
               int blueArr[] = new int[9];
               blueArr[0] = pix1.getBlue();
               blueArr[1] = pix2.getBlue();
               blueArr[2] = pix3.getBlue();
               blueArr[3] = pix4.getBlue();
               blueArr[4] = pix5.getBlue();
               blueArr[5] = pix6.getBlue();
               blueArr[6] = pix7.getBlue();
               blueArr[7] = pix8.getBlue();
               blueArr[8] = pix9.getBlue();
               
               int greenArr[] = new int[9];
               greenArr[0] = pix1.getGreen();
               greenArr[1] = pix2.getGreen();
               greenArr[2] = pix3.getGreen();
               greenArr[3] = pix4.getGreen();
               greenArr[4] = pix5.getGreen();
               greenArr[5] = pix6.getGreen();
               greenArr[6] = pix7.getGreen();
               greenArr[7] = pix8.getGreen();
               greenArr[8] = pix9.getGreen();
               //stores max/min
               int smr = 255, bigr = 0;
               int smb = 255, bigb = 0;
               int smg = 255, bigg = 0;
               //loops through color array comparing for max/min
               for(int i=0; i < 9; i++)
               {
                   if(redArr[i] < smr)
                   {
                       smr = redArr[i];
                   }
                   if (redArr[i] > bigr)
                   {
                       bigr = redArr[i];
                   }
                   if(blueArr[i] < smb)
                   {
                       smb = blueArr[i];
                   }
                   if (blueArr[i] > bigb)
                   {
                       bigb = blueArr[i];
                   }
                   if(greenArr[i] < smg)
                   {
                       smg = greenArr[i];
                   }
                   if (greenArr[i] > bigg)
                   {
                       bigg = greenArr[i];
                   }
               }
               //range calculation
               int red = bigr - smr;
               int blue = bigb - smb;
               int green = bigg - smg;
               //assign new color
               Color newPix = new Color(red, green, blue);
               edited.setPixel(x, y, newPix);
            }
        }
        for(int y = 1; y < height-1; y++)
        {
            for(int x = 1; x < width-1; x++)
            {
                 Color pix = edited.getPixel(x,y);
                 Color swap = new Color(pix.getRed(), pix.getGreen(), pix.getBlue());
                 image.setPixel(x,y,swap);
            }
        }
    }
}
