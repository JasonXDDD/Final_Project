package PublicClass;

import DataClass.BookData;
import MainScreen.MainTest;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by JASON_ on 2015/5/16.
 */
public class BookNode extends JButton{
    public int x;

    public BookNode(BookData bk){
        super(bk.getBk_Name(), ImageProcess.scaleImage(bk.getBk_cover(),200,ImageProcess.Width));

        x = bk.getBk_ID();

        setVerticalTextPosition(JButton.BOTTOM);
        setHorizontalTextPosition(JButton.CENTER);
        setFont(new Font("微軟正黑體", Font.BOLD, 14));
        setBackground(Color.WHITE);

        setSize(250,500);
    }

}