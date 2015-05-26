package MainScreen;

import PublicClass.ScreenSize;
import ServerConnect.sGetToken;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;

/**
 * Created by JASON_ on 2015/5/26.
 */
public class Loading extends JFrame {
    private ScreenSize scSize;
    private JLayeredPane lp_layer;

    private Image fixSize;
    private Image GetPic;
    private ImageIcon head = new ImageIcon(getClass().getResource("head.jpg"));
    private ImageIcon Show;
    private JLabel loading;

    public JLabel TXT;


    public Loading() throws IOException{
        System.out.println("-----Loading-----");

        scSize = new ScreenSize();
        lp_layer = this.getLayeredPane();

        sGetToken sg = new sGetToken();

        TXT = new JLabel("Loading", JLabel.CENTER);
        TXT.setForeground(Color.BLUE);
        TXT.setBackground(null);
        TXT.setFont(new Font("Arial", Font.BOLD, 72));
        lp_layer.setLayout(new BorderLayout());
        lp_layer.add(TXT, BorderLayout.SOUTH, new Integer(-300000));
        //this.getContentPane().add(TXT, BorderLayout.SOUTH);

        GetPic = head.getImage();
        fixSize = GetPic.getScaledInstance
                (SetPicWidth(head, 400), 400, Image.SCALE_SMOOTH);
        Show = new ImageIcon(fixSize);

        loading = new JLabel(Show);
        this.getContentPane().add(loading, BorderLayout.CENTER);

        this.setUndecorated(true);
        this.getRootPane().setWindowDecorationStyle(JRootPane.NONE);

        this.pack();
        this.setLocation(scSize.getWidth()/2 - this.getWidth()/2,
                        scSize.getHeight()/2 - this.getHeight()/2);


        System.out.println();
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

    //    public static void main(String[] args) {
//        JFrame frame = new Loading();
//        try {
//            frame.setVisible(true);
//            Thread.sleep(3000);
//            frame.dispose();
//        }
//        catch (InterruptedException e){}
//    }


}
