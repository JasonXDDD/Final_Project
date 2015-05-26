package PublicClass;

import DialogData.EditAccount;
import MainScreen.MainFrame;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by JASON_ on 2015/5/15.
 */
public class ToolBarAction extends JButton implements ActionListener{
    public ToolBarAction(String name, Icon icon){
        super(name, icon);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getActionCommand() == "aEdit"){
            EditAccount editAccount = new EditAccount(null, "EditAccount", true);
        }
    }



}
