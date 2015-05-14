package MainScreen;

import javax.swing.*;
import java.awt.*;

/**
 * Created by JASON_ on 2015/5/13.
 */
public class MainFrame extends JFrame {
    private JPanel MF_pnAccoutData;
    private ifAccountTool ifAT;
    private ImageIcon ipAT_iconHead;
    private JLayeredPane MF_lpLayer;

    public MainFrame(){
        setLayout(null);
        MF_lpLayer = this.getLayeredPane();

        MF_pnAccoutData = new JPanel();
        MF_pnAccoutData.setLayout(new GridLayout(2,1));
        //getContentPane().add(MF_pnAccoutData);

        ipAT_iconHead = new ImageIcon(getClass().getResource("account_head.png"));
        ifAT = new ifAccountTool(ipAT_iconHead, "柯博文", 37, 100);
        ifAT.setBounds(100, 100, 280, 400);
        MF_lpLayer.add(ifAT, new Integer(2500));

        setVisible(true);
        getContentPane().setBackground(Color.DARK_GRAY);
        setSize(1920, 1080);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
