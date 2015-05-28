package PublicClass;

import javax.swing.*;
import java.awt.*;
import java.awt.image.CropImageFilter;
import java.awt.image.FilteredImageSource;
import java.awt.image.ImageFilter;

/**
 * Created by JASON_ on 2015/5/27.
 */
public class ImageProcess {

    public static ImageIcon cutImage(ImageIcon head , int x, int y,
                                                    int width, int height){
        Image croppedImage;
        ImageFilter cropFilter;
        Image sourceImage = head.getImage();
        ImageIcon Show;

        cropFilter =new CropImageFilter(x,y,width,height);
        croppedImage= Toolkit.getDefaultToolkit().createImage(
                new FilteredImageSource(sourceImage.getSource(),cropFilter));

        Show = new ImageIcon(croppedImage);

        return Show;
    }

    public static ImageIcon scaleImage(ImageIcon head , int i){
        Image GetPic;
        Image fixSize;
        ImageIcon Show;

        GetPic = head.getImage();

        if(head.getIconWidth() >= head.getIconHeight())
            fixSize = GetPic.getScaledInstance
                    (SetPicWidth(head, i), i, Image.SCALE_SMOOTH);
        else
            fixSize = GetPic.getScaledInstance
                    (i, SetPicWidth(head, i), Image.SCALE_SMOOTH);

        Show = new ImageIcon(fixSize);

        return Show;
    }

    public static int SetPicWidth(ImageIcon head, int y){
        int width = head.getIconWidth();
        int height = head.getIconHeight();
        int x;

        System.out.print("BookData Head: w: " + head.getIconWidth() +
                " h: " + head.getIconHeight());

        if(width >= height) {
            x = width * y / height;
            System.out.println("  after w: " + x);
        }
        else {
            x = height * y / width;
            System.out.println("  after h: " + x);
        }
        return x;
    }
}
