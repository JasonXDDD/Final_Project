package DialogData;

import PublicClass.GBConstraint;
import PublicClass.ScreenSize;

import javax.swing.*;
import java.awt.*;

/**
 * Created by JASON_ on 2015/5/24.
 */
public class Login extends JDialog {
    private ScreenSize scSize;
    private JLabel lbl;
    private JTextField enter_user;
    private JPasswordField enter_passwd;
    private JButton log;

    private GBConstraint gbc = new GBConstraint();
    private GridBagLayout gb = new GridBagLayout();

    private int[][] position = new int[][]{
            {1,1,1,1}, {2,1,1,2},
            {1,2,1,1}, {2,2,1,2},
                       {3,4,1,1}
    };

    public Login(JFrame f, String  str, boolean model){
        super(f, str, model);
        gb.rowHeights = new int[]{30, 30, 30, 30, 30, 30};
        gb.columnWidths = new int[]{50, 30, 30, 130, 50};
        setLayout(gb);
        scSize = new ScreenSize();


        for(int i = 0; i <= 4; i++){
            gbc.setValue(gbc, position[i][0], position[i][1], position[i][2], position[i][3]);

            switch (i){
                case 0:
                    lbl = new JLabel("User Account: ");
//                    lbl.setBorder(BorderFactory.createLineBorder(Color.black));
                    add(lbl, gbc);
                    break;
                case 1:
                    enter_user = new JTextField();
                    getContentPane().add(enter_user, gbc);
                    break;
                case 2:
                    lbl = new JLabel("Password: ");
//                    lbl.setBorder(BorderFactory.createLineBorder(Color.black));
                    getContentPane().add(lbl, gbc);
                    break;
                case 3:
                    enter_passwd = new JPasswordField();
                    getContentPane().add(enter_passwd, gbc);
                    break;
                case 4:
                    log = new JButton("login");
                    getContentPane().add(log, gbc);
                    break;
            }
        }

        setLocation(scSize.getWidth()/2-145, scSize.getHeight()/2-90);
        pack();
        setDefaultCloseOperation(JDialog.HIDE_ON_CLOSE);

    }


    public static void main(String[] args){
//        Login log = new Login(null, "XDD", true);
//        log.setVisible(true);
        Regist r = new Regist(null, "Regist", true);
        r.setVisible(true);
    }

}
