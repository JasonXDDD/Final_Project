package DialogData;

import PublicClass.ScreenSize;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

/**
 * Created by JASON_ on 2015/5/30.
 */
public class AddStore extends BasicDialog implements ActionListener{
    private ScreenSize scSize;

    private JLabel lbl;
    private JTextField enter_name;

    private JButton OK;
    private JButton cancel;

    public AddStore(JFrame f, String str, boolean model){
        super(f,str,model);

        scSize = new ScreenSize();

        SetTheSize(new int[]{50,30,80,80,50},
                   new int[]{30,30,30,30});

        lbl = new JLabel("Store Name: ");
        AddFiled(lbl, new int[]{1,1,1,1});

        enter_name = new JTextField();
        AddFiled(enter_name, new int[]{2,1,1,2});

        cancel = new JButton("Cancel");
        cancel.addActionListener(this);
        AddFiled(cancel, new int[]{2, 2, 1, 1});

        OK = new JButton("Create");
        OK.addActionListener(this);
        AddFiled(OK, new int[]{3, 2, 1, 1});

        pack();
        setLocation(scSize.getWidth()/2 - this.getWidth()/2,
                    scSize.getHeight()/2 - this.getHeight()/2);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == cancel){
            dispose();
            System.out.println();
        }
        else if(e.getSource() == OK){

        }
    }

    public static void main(String[] args){
        AddStore ad = new AddStore(null, "Store Add", true);
        ad.setVisible(true);
    }
}
