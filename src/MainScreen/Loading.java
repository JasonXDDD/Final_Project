package MainScreen;

import PublicClass.ImageProcess;
import PublicClass.ScreenSize;
import ServerConnect.sGetToken;

import javax.swing.*;
import java.awt.*;
import java.awt.image.ImageProducer;
import java.io.IOException;

/**
 * Created by JASON_ on 2015/5/26.
 */
public class Loading extends JFrame {
    private ScreenSize scSize;
    private JLayeredPane lp_layer;


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


        Show = ImageProcess.scaleImage(head, 400);
        loading = new JLabel(Show);
        this.getContentPane().add(loading, BorderLayout.CENTER);

        this.setUndecorated(true);
        this.getRootPane().setWindowDecorationStyle(JRootPane.NONE);

        this.pack();
        this.setLocation(scSize.getWidth()/2 - this.getWidth()/2,
                        scSize.getHeight()/2 - this.getHeight()/2);


        System.out.println();
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
