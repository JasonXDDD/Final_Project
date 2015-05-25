package TEST;

import DialogData.Login;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by JASON_ on 2015/5/23.
 */
public class JDialog_Frame extends JFrame implements ActionListener{
    private JButton XDD = new JButton("XDD");

    public JDialog_Frame(){
        add(XDD, BorderLayout.CENTER);
        XDD.addActionListener(this);


        setVisible(true);
        setSize(500,900);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String str = null;

        if(e.getSource() == XDD){
            //JDialog jd = new JDialog(this,"Dialog",true);
//            JDialog_Test jd = new JDialog_Test(this, "Dialog", true);
//            jd.setVisible(true);

            Login log = new Login(this, "XDD", true);
            log.setVisible(true);
        }
    }
}
