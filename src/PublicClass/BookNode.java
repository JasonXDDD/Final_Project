package PublicClass;

import javax.swing.*;
import java.awt.*;

/**
 * Created by JASON_ on 2015/5/16.
 */
public class BookNode extends JPanel {
    private Image fixSize;
    private Image GetPic;
    private ImageIcon Show;
    private int x;

    private JButton bn_btnShow;
    private JLabel bn_lblName;

    public BookNode(ImageIcon head, String name){
        setLayout(new BorderLayout());

        GetPic = head.getImage();

        fixSize = GetPic.getScaledInstance(SetPicWidth(head, 200), 200, Image.SCALE_SMOOTH);
        Show = new ImageIcon(fixSize);

        bn_btnShow = new JButton(Show);
        bn_btnShow.setBackground(Color.WHITE);
        //bn_btnShow.setLocation(5, 5);
        add(bn_btnShow);

        bn_lblName = new JLabel(name, JLabel.CENTER);
        bn_lblName.setFont(new Font("微軟正黑體", Font.BOLD, 14));
        add(bn_lblName, BorderLayout.SOUTH);

        setBackground(Color.WHITE);
        setSize(250,500);
    }

    public int SetPicWidth(ImageIcon head, int y){
        int width = head.getIconWidth();
        int height = head.getIconHeight();
        int x = width * y / height;

        System.out.println("BookData Head: w: " + head.getIconWidth() +
                            " h: " + head.getIconHeight() +
                            " After w: " + x);

        return x;
    }
}