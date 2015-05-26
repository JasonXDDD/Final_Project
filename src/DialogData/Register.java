package DialogData;

import MainScreen.MainFrame;
import PublicClass.GBConstraint;
import PublicClass.ScreenSize;
import ServerConnect.sRegister;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;


/**
 * Created by JASON_ on 2015/5/25.
 */
public class Register extends JDialog implements ActionListener{
    private ScreenSize scSize;
    private sRegister sr;

    private JLabel lbl;
    private JLabel Error;
    private JTextField enter_name;
    private JTextField enter_email;
    private JPasswordField enter_passwd;
    private JButton create;

    private GBConstraint gbc = new GBConstraint();
    private GridBagLayout gb = new GridBagLayout();

    private int[][] position = new int[][]{
            {1,1,1,3},
            {1,2,1,1}, {2,2,1,2},
            {1,3,1,1}, {2,3,1,2},
            {1,4,1,1}, {2,4,1,2},
                       {3,6,1,1}
    };

    public Register(JFrame f, String str, boolean model){
        super(f, str, model);

        System.out.println("-----Register-----");

        gb.rowHeights = new int[]{30, 30, 30, 30, 30, 30, 30, 30};
        gb.columnWidths = new int[]{50, 30, 30, 130, 50};
        setLayout(gb);
        scSize = new ScreenSize();


        for(int i = 0; i <= 7; i++){
            gbc.setValue(gbc, position[i][0], position[i][1],
                              position[i][2], position[i][3]);

            switch (i){
                case 0:
                    Error = new JLabel("");
                    add(Error, gbc);
                    break;
                case 1:
                    lbl = new JLabel("Email(帳號): ");
                    getContentPane().add(lbl, gbc);
                    break;
                case 2:
                    enter_email = new JTextField();
                    getContentPane().add(enter_email, gbc);
                    break;
                case 3:
                    lbl = new JLabel("User Name: ");
                    add(lbl, gbc);
                    break;
                case 4:
                    enter_name = new JTextField();
                    getContentPane().add(enter_name, gbc);
                    break;
                case 5:
                    lbl = new JLabel("Password: ");
                    getContentPane().add(lbl, gbc);
                    break;
                case 6:
                    enter_passwd = new JPasswordField();
                    getContentPane().add(enter_passwd, gbc);
                    break;

                case 7:
                    create = new JButton("Create");
                    getContentPane().add(create, gbc);
                    create.addActionListener(this);
                    break;
            }
        }

        setLocation(scSize.getWidth()/2-160, scSize.getHeight()/2-105);
        pack();
        setDefaultCloseOperation(JDialog.DO_NOTHING_ON_CLOSE);


    }


    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == create){
            try {
                Error.setText("");
                sr = new sRegister(enter_name.getText(), enter_email.getText(),
                        new String(enter_passwd.getPassword()));
                System.out.println( "On Dialog: Name: " + enter_name.getText()+
                                    "  email: " + enter_email.getText()+
                                    "  password: " + new String(enter_passwd.getPassword()));
            }
            catch (IOException I){}


            if(sr.getRespondcode()/100 == 2){
                dispose();
                System.out.println();
                MainFrame testFrame = new MainFrame();
            }
            else
                Error.setText("帳號已存在!");
        }
    }
}
