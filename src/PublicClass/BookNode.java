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
public class BookNode extends JPanel implements ActionListener{
    private Image fixSize;
    private Image GetPic;
    private ImageIcon Show;
    private int x;

    private JButton bn_btnShow;
//    private JLabel bn_lblName;

    public BookNode(ImageIcon head, String name){
        setLayout(new BorderLayout());

        GetPic = head.getImage();

        fixSize = GetPic.getScaledInstance(SetPicWidth(head, 200), 200, Image.SCALE_SMOOTH);
        Show = new ImageIcon(fixSize);

        bn_btnShow = new JButton(name,Show);
        bn_btnShow.setVerticalTextPosition(JButton.BOTTOM);
        bn_btnShow.setHorizontalTextPosition(JButton.CENTER);
        bn_btnShow.setFont(new Font("微軟正黑體", Font.BOLD, 14));
        bn_btnShow.addActionListener(this);
        bn_btnShow.setBackground(Color.WHITE);
        //bn_btnShow.setLocation(5, 5);
        add(bn_btnShow);

//        bn_lblName = new JLabel(name, JLabel.CENTER);
//        bn_lblName.setFont(new Font("微軟正黑體", Font.BOLD, 14));
//        add(bn_lblName, BorderLayout.SOUTH);

        setBackground(Color.WHITE);
        setSize(250,500);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        for(BookData a : MainTest.bkList) {
            if (e.getActionCommand() == a.getBk_Name()) {
                System.out.println("Now Selected: " + a.getBk_Name() + " ID: " + e.getID());
                bn_btnShow.setBackground(Color.BLUE);
                bn_btnShow.updateUI();
            } else {
                bn_btnShow.setBackground(Color.WHITE);
                bn_btnShow.updateUI();
            }
        }
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