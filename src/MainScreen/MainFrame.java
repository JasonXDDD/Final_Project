package MainScreen;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;

/**
 * Created by JASON_ on 2015/5/13.
 */
public class MainFrame extends JFrame implements ComponentListener{
    private JLayeredPane MF_lpLayer;
    private JPanel MF_pnAccoutData;


    private ifAccountTool ifAT;
    private ImageIcon ifAT_iconHead;

    private ifBookTool ifBT;
    private String[] ifBT_strBookName;

    public MainFrame(){
        setLayout(null);
        MF_lpLayer = this.getLayeredPane();
        MF_lpLayer.setLayout(null);

        MF_pnAccoutData = new JPanel();
        MF_pnAccoutData.setLayout(null);
        MF_pnAccoutData.setBackground(Color.yellow);
        MF_pnAccoutData.setSize(280,1080);
        getContentPane().add(MF_pnAccoutData, BorderLayout.WEST);

        ifAT_iconHead = new ImageIcon(getClass().getResource("account_head.png"));
        ifAT = new ifAccountTool(ifAT_iconHead, "柯博文", 37, 100);
        ifAT.setBounds(100, 100, 280, 400);
        MF_lpLayer.add(ifAT, new Integer(2500));
        ifAT.addComponentListener(this);



        ifBT_strBookName = new String[]{"Book1-XDD", "Book2-QAQ", "Book3-OwO",
                "Book1-XDD", "Book1-XDD", "Book1-XDD", "Book1-XDD", "Book1-XDD",
                "Book1-XDD", "Book1-XDD", "Book1-XDD", "Book1-XDD", "Book1-XDD",
                "Book1-XDD", "Book1-XDD", "Book1-XDD", "Book1-XDD", "Book1-XDD",
                "Book1-XDD", "Book1-XDD", "Book1-XDD", "Book1-XDD", "Book1-XDD",};
        ifBT = new ifBookTool(3, ifBT_strBookName);
        ifBT.setBounds(500, 100, 280, 610);
        MF_lpLayer.add(ifBT, new Integer(2500));
        ifBT.addComponentListener(this);



        setVisible(true);
        getContentPane().setBackground(Color.DARK_GRAY);
        setSize(1920, 1080);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    @Override
    public void componentHidden(ComponentEvent e) {


    }

    @Override
    public void componentResized(ComponentEvent e) {

    }

    @Override
    public void componentMoved(ComponentEvent e) {
        if(e.getSource() == ifAT){
            if(ifAT.getX() <= 0){
                MF_pnAccoutData.add(ifAT);
                if(MF_pnAccoutData.getComponentCount() == 1)
                    ifAT.setBounds(0, 0, 280, 1015);
                else
                    ifAT.setSize(280, 400);
            }

            else{
                ifAT.setSize(280, 400);
                if(MF_pnAccoutData.getComponent(1) == ifAT)
                    MF_lpLayer.add(ifAT, 2500);
            }
        }

        if(e.getSource() == ifBT){
            if(ifBT.getX() <= 0){
                MF_pnAccoutData.add(ifBT);
                if(MF_pnAccoutData.getComponentCount() == 1)
                    ifBT.setBounds(0, 0, 280, 1015);
                else
                    ifBT.setBounds(0, 615, 280, 610);
            }

            else{
                ifBT.setSize(280, 610);
                if(MF_pnAccoutData.getComponentCount() != 0)
                    MF_lpLayer.add(ifBT, 2500);
            }
        }
    }

    @Override
    public void componentShown(ComponentEvent e) {

    }
}
