package DialogData;

import MainScreen.MainTest;

import javax.swing.*;

/**
 * Created by JASON_ on 2015/5/24.
 */
public class EditAccount extends BasicDialog{
    private JLabel lbl;
    private JTextField enter_name;
    private JTextField enter_email;
    private JPasswordField enter_passwd;
    private JButton OK, cancel;


    public EditAccount(JFrame f, String str, boolean model){
        super(f, str, model);

        SetTheSize(new int[]{50, 30, 80, 80, 50},  //col width
                new int[]{30, 35, 35, 35, 35, 30});  //row height

        lbl = new JLabel("Name: ");
        AddFiled(lbl, new int[]{1,1,1,1});

        enter_name = new JTextField(MainTest.accountData.getAccount_Name());
        AddFiled(enter_name, new int[]{2,1,1,2});

        lbl = new JLabel("Email: ");
        AddFiled(lbl, new int[]{1,2,1,1});

        enter_email = new JTextField(MainTest.accountData.getAccount_Email());
        AddFiled(enter_email, new int[]{2,2,1,2});

        lbl = new JLabel("Password: ");
        AddFiled(lbl, new int[]{1,3,1,1});

        enter_passwd = new JPasswordField(MainTest.accountData.getAccount_Password());
        AddFiled(enter_passwd, new int[]{2,3,1,2});

        OK = new JButton("OK");
        AddFiled(OK, new int[]{2,4,1,1});

        cancel = new JButton("Cancel");
        AddFiled(cancel, new int[]{3,4,1,1});

        pack();
    }



}
