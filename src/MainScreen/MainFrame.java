package MainScreen;

import javax.swing.*;
import java.awt.*;
import java.awt.Color;

/**
 * Created by JASON_ on 2015/5/13.
 */
public class MainFrame extends JFrame{
    private JLayeredPane lp_Layer;

    private spAccountData MF_spAccountData;
    private BookPanel MF_pnBook;

    public MainFrame(){
        setLayout(new BorderLayout());
        lp_Layer = this.getLayeredPane();
        lp_Layer.setLayout(null);

        MF_spAccountData = new spAccountData();
        getContentPane().add(MF_spAccountData, BorderLayout.WEST);

        MF_pnBook = new BookPanel();
//        MF_pnBook.setSize(1920, 1015);
        getContentPane().add(MF_pnBook, BorderLayout.CENTER);


        setVisible(true);
        getContentPane().setBackground(Color.DARK_GRAY);
        setSize(1280, 720);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

}
