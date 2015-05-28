package DialogData;

import MainScreen.MainFrame;
import MainScreen.MainTest;
import PublicClass.ScreenSize;
import ServerConnect.Gobel;
import ServerConnect.sEditAccount;
import ServerConnect.sLogin;
import ServerConnect.sRegister;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

/**
 * Created by JASON_ on 2015/5/24.
 */
public class EditAccount extends BasicDialog implements ActionListener{
    private ScreenSize scSize;
    private sEditAccount se;
    private Gobel gbl;

    private MainFrame frame;

    private JLabel lbl;
    private JLabel Error;
    private JTextField enter_name;
    private JPasswordField enter_passwd;
    private JButton OK, cancel, headbtn;


    public EditAccount(JFrame f, String str, boolean model){
        super(f, str, model);

        scSize = new ScreenSize();

//        SetTheSize(new int[]{50, 30, 80, 80, 50},  //col width
//                new int[]{30, 35, 35, 35, 35, 35, 30});  //row height
        SetTheSize(new int[]{50, 60, 120, 30, 80, 80, 50},
                new int[]{30, 30, 30, 30, 30, 60, 30, 30});

        Error = new JLabel("");
        AddFiled(Error, new int[]{4,1,1,3});

        lbl = new JLabel("Name: ");
        AddFiled(lbl, new int[]{3,2,1,1});

        enter_name = new JTextField(MainTest.accountData.getAccount_Name());
        AddFiled(enter_name, new int[]{4,2,1,2});

        lbl = new JLabel("Password: ");
        AddFiled(lbl, new int[]{3,3,1,1});

        enter_passwd = new JPasswordField(MainTest.accountData.getAccount_Password());
        AddFiled(enter_passwd, new int[]{4,3,1,2});

        OK = new JButton("OK");
        OK.addActionListener(this);
        AddFiled(OK, new int[]{5,6,1,1});

        cancel = new JButton("Cancel");
        cancel.addActionListener(this);
        AddFiled(cancel, new int[]{4,6,1,1});

        headbtn = new JButton();
        headbtn.setBorder(BorderFactory.createLineBorder(Color.black));
        headbtn.setBackground(Color.white);
        headbtn.addActionListener(this);
        AddFiled(headbtn, new int[]{1,1,5,2});

        pack();
        setLocation(scSize.getWidth()/2 - this.getWidth()/2,
                    scSize.getHeight()/2- this.getHeight()/2);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            Error.setText("");
            se = new sEditAccount(enter_name.getText(),
                    new String(enter_passwd.getPassword()),
                    MainTest.accountData.getAccount_ID());
            System.out.println( "On Dialog: Name: " + enter_name.getText()+
                    "  password: " + new String(enter_passwd.getPassword()) +
                    "  UserID: " + MainTest.accountData.getAccount_ID());
        }
        catch (IOException I){}


        if(se.getRespondcode()/100 == 2){
            dispose();
            System.out.println();
        }
        else
            Error.setText("帳號已存在!");
    }
}
