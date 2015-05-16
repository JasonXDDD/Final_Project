package MainScreen;

import javax.swing.*;
import java.awt.*;
import java.awt.Color;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;

/**
 * Created by JASON_ on 2015/5/13.
 */
public class MainFrame extends JFrame implements ComponentListener{
    private JLayeredPane MF_lpLayer;
    private JSplitPane MF_spAccountData;
    private BookPanel pnBook;

    private ifAccountTool ifAT;
    private ImageIcon ifAT_iconHead;

    private ifStoreTool ifST;
    private String[] ifST_strBookName;

    public MainFrame(){
        setLayout(new BorderLayout());
        MF_lpLayer = this.getLayeredPane();
        MF_lpLayer.setLayout(null);

        MF_spAccountData = new JSplitPane(JSplitPane.VERTICAL_SPLIT, true);
        MF_spAccountData.setDividerLocation(400);
        MF_spAccountData.setOneTouchExpandable(true);
        MF_spAccountData.setDividerSize(10);
        MF_spAccountData.setSize(280, 1015);
        getContentPane().add(MF_spAccountData, BorderLayout.WEST);

        pnBook = new BookPanel();
        pnBook.setSize(1920, 1015);
        getContentPane().add(pnBook, BorderLayout.CENTER);

        ifAT_iconHead = new ImageIcon(getClass().getResource("account_head.png"));
        ifAT = new ifAccountTool(ifAT_iconHead, "柯博文", 37, 100);
        ifAT.setBounds(100, 100, 280, 400);
        ifAT.addComponentListener(this);
        MF_spAccountData.add(ifAT);

        ifST_strBookName = new String[]{"Book1-XDD", "Book2-QAQ", "Book3-OwO",
                "Book1-XDD", "Book1-XDD", "Book1-XDD", "Book1-XDD", "Book1-XDD",
                "Book1-XDD", "Book1-XDD", "Book1-XDD", "Book1-XDD", "Book1-XDD",
                "Book1-XDD", "Book1-XDD", "Book1-XDD", "Book1-XDD", "Book1-XDD",
                "Book1-XDD", "Book1-XDD", "Book1-XDD", "Book1-XDD", "Book1-XDD",};
        ifST = new ifStoreTool(3, ifST_strBookName);
        ifST.setBounds(500, 100, 280, 610);
        ifST.addComponentListener(this);
        MF_spAccountData.add(ifST);

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
//        if(e.getSource() == ifAT){
//            if(ifAT.getX() <= 0){
//                test.add(ifAT);
//                if(test.getComponentCount() == 1)
//                    ifAT.setBounds(0, 0, 280, 1015);
//                else
//                    ifAT.setSize(280, 400);
//
//            }
//
//            else{
//                if(test.getComponentCount() != 0)
//                ifAT.setSize(280, 400);
//
//            }
//        }
//
//        if(e.getSource() == ifBT){
//            if(ifBT.getX() <= 0){
//                test.add(ifBT);
//                if(test.getComponentCount() == 1)
//                    ifBT.setBounds(0, 0, 280, 1015);
//                else
//                    ifBT.setBounds(0, 615, 280, 610);
//            }
//
//            else{
//                ifBT.setSize(280, 610);
//                if(test.getComponentCount() != 0)
//                    MF_lpLayer.add(ifBT, 2500);
//            }
//        }
    }

    @Override
    public void componentShown(ComponentEvent e) {

    }
}
