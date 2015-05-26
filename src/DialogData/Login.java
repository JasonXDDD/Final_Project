package DialogData;

import PublicClass.GBConstraint;
import PublicClass.ScreenSize;
import ServerConnect.Gobel;
import ServerConnect.sGetToken;
import ServerConnect.sLogin;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

/**
 * Created by JASON_ on 2015/5/24.
 */
public class Login extends JDialog implements ActionListener{
    private ScreenSize scSize;
    private sLogin sl;
    private Gobel gbl;

    private JLabel lbl;
    private JTextField enter_email;
    private JPasswordField enter_passwd;
    private JButton log;
    private JButton reg;

    private GBConstraint gbc = new GBConstraint();
    private GridBagLayout gb = new GridBagLayout();

    private int[][] position = new int[][]{
            {1,1,1,1}, {2,1,1,2},
            {1,2,1,1}, {2,2,1,2},
                       {3,4,1,1},
            {0,5,1,1}
    };

    public Login(JFrame f, String  str, boolean model) throws IOException{
        super(f, str, model);
        gb.rowHeights = new int[]{30, 30, 30, 30, 30, 30};
        gb.columnWidths = new int[]{50, 30, 30, 130, 50};
        setLayout(gb);
        scSize = new ScreenSize();

        sGetToken sg = new sGetToken();

        for(int i = 0; i <= 5; i++){
            gbc.setValue(gbc, position[i][0], position[i][1],
                              position[i][2], position[i][3]);

            switch (i){
                case 0:
                    lbl = new JLabel("Email: ");
                    add(lbl, gbc);
                    break;
                case 1:
                    enter_email = new JTextField();
                    getContentPane().add(enter_email, gbc);
                    break;
                case 2:
                    lbl = new JLabel("Password: ");
                    getContentPane().add(lbl, gbc);
                    break;
                case 3:
                    enter_passwd = new JPasswordField();
                    getContentPane().add(enter_passwd, gbc);
                    break;
                case 4:
                    log = new JButton("login");
                    getContentPane().add(log, gbc);
                    log.addActionListener(this);
                    break;
                case 5:
                    reg = new JButton("Regist");
                    getContentPane().add(reg, gbc);
                    reg.addActionListener(this);
                    break;
            }
        }

        setLocation(scSize.getWidth()/2-145, scSize.getHeight()/2-90);
        pack();
        setDefaultCloseOperation(JDialog.DO_NOTHING_ON_CLOSE);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == log){
                try {
                    sl = new sLogin(gbl.getToken(), enter_email.getText(),
                            new String(enter_passwd.getPassword()));
                } catch (IOException I) { }

            enter_passwd.setText("");
            enter_email.setText("");

            System.out.println("Check Answer: " + sl.getAnswer() + "  " +
                    sl.getAnswer().equals("Login successful"));
            if (sl.getAnswer().equals("Login successful") == true){

                dispose();
            }


        }

        else if(e.getSource() == reg){
            Regist regist = new Regist((JFrame)super.getOwner(), "Regist", true);
            dispose();
            regist.setVisible(true);
        }
    }
}
