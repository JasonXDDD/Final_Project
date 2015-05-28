package PublicClass;

import DialogData.EditAccount;
import MainScreen.MainFrame;
import MainScreen.MainTest;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by JASON_ on 2015/5/15.
 */
public class ToolBarAction extends JButton implements ActionListener{
    private ImageIcon head, Show;

    public ToolBarAction(String name, Icon icon){
        super(name, icon);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getActionCommand() == "aEdit"){
            EditAccount editAccount = new EditAccount(null, "EditAccount", true);
            editAccount.setVisible(true);

            if(editAccount.isSetData() == true) {
                MainTest.testFrame.getMF_spAccountData().getIfAT().getIfAT_lblName().
                        setText(MainTest.accountData.getAccount_Name());

                System.out.println("Edit Head: " + MainTest.accountData.getAccount_Head());

                head = MainTest.accountData.getAccount_Head();
                Show = ImageProcess.scaleImage(head, 230);
                Show = ImageProcess.cutImage(Show, 0, 0, 230, 230);
                MainTest.testFrame.getMF_spAccountData().getIfAT().getIfAT_iclblHead().
                        setIcon(Show);

                JFrame f = new JFrame();
                f.add(new JLabel(Show), BorderLayout.CENTER);
                f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                f.setVisible(true);
                f.pack();
            }
        }
    }



}
