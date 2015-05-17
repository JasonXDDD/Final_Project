package PublicClass;

import javax.swing.*;
import java.awt.*;

/**
 * Created by JASON_ on 2015/5/16.
 */
public class BookNode extends JPanel {
    private JButton bn_btnShow;
    private JLabel bn_lblName;

    public BookNode(ImageIcon head, String name){
        setLayout(new BorderLayout());

        bn_btnShow = new JButton(head);
        bn_btnShow.setBackground(Color.GRAY);
        //bn_btnShow.setLocation(5, 5);
        add(bn_btnShow);

        bn_lblName = new JLabel(name, JLabel.CENTER);
        bn_lblName.setFont(new Font("微軟正黑體", Font.BOLD, 14));
        add(bn_lblName, BorderLayout.SOUTH);

        setBackground(Color.yellow);
        setSize(250,500);
    }
}