package PublicClass;

import DialogData.AddStore;
import DialogData.EditAccount;
import DialogData.EditStore;
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
            EditAccount aEdit = new EditAccount(null, "EditAccount", true);
            aEdit.setVisible(true);

            if(aEdit.isSetData() == true) {
                MainTest.testFrame.getMF_spAccountData().getIfAT().getIfAT_lblName().
                        setText(MainTest.accountData.getAccount_Name());

                System.out.println("Edit Head: " + MainTest.accountData.getAccount_Head());

                head = MainTest.accountData.getAccount_Head();
                Show = ImageProcess.scaleImage(head, 230);
                Show = ImageProcess.cutImage(Show, 0, 0, 230, 230);
                MainTest.testFrame.getMF_spAccountData().getIfAT().getIfAT_iclblHead().
                        setIcon(Show);
            }
        }


        else if(e.getActionCommand() == "sAdd"){
            AddStore sAdd = new AddStore(null, "StoreAdd", true);
            sAdd.setVisible(true);
        }

        else if(e.getActionCommand() == "sEdit"){
            EditStore sEdit = new EditStore(null, "StoreEdit", true);
            sEdit.setVisible(true);
        }
    }



}
