package MainScreen;

import javax.swing.*;
import java.awt.*;
import PublicClass.*;

import java.awt.event.ActionEvent;

/**
 * Created by JASON_ on 2015/5/13.
 */
public class ifAccountTool extends JInternalFrame {
    private JLayeredPane lp_layer;

    private JLabel ifAT_iclblHead;
    private JLabel ifAT_lblName;
    private Font lblName_ftName;
    private JProgressBar ifAT_pbSpace;

    private JToolBar ifAT_toolbar;
    private ToolBarAction ATtb_btnEdit;
    private ToolBarAction ATtb_btnLog;
    private ToolBarAction ATtb_btnPlus;

    public ifAccountTool(ImageIcon head, String name, int usingsp, int totalsp){
        super("AccountTool", false, true, true, false);
        setLayout(null);
        lp_layer = this.getLayeredPane();

        ifAT_iclblHead = new JLabel(head);
        ifAT_iclblHead.setBorder(BorderFactory.createLineBorder(Color.black));
        ifAT_iclblHead.setBounds(20, 20, 230, 230);
        ifAT_iclblHead.setBackground(Color.BLACK);
        getContentPane().add(ifAT_iclblHead);

        lblName_ftName = new Font("微軟正黑體", Font.BOLD, 20);

        ifAT_lblName = new JLabel(name, JLabel.CENTER);
        ifAT_lblName.setFont(lblName_ftName);
        ifAT_lblName.setBounds(20, 210, 230, 130);
        getContentPane().add(ifAT_lblName);


        ifAT_pbSpace = new JProgressBar();
        ifAT_pbSpace.setMaximum(totalsp);
        ifAT_pbSpace.setMinimum(0);
        ifAT_pbSpace.setValue(usingsp);
        ifAT_pbSpace.setBorderPainted(true);
        ifAT_pbSpace.setStringPainted(true);
        ifAT_pbSpace.setBounds(20, 300, 230, 20);
        getContentPane().add(ifAT_pbSpace);



        ifAT_toolbar = new JToolBar(JToolBar.HORIZONTAL);
        ifAT_toolbar.setFloatable(false);
        lp_layer.setLayout(new BorderLayout());
        lp_layer.add(ifAT_toolbar, BorderLayout.SOUTH, new Integer(2550));

        ATtb_btnEdit = new ToolBarAction("Edit", null);
        ifAT_toolbar.add(ATtb_btnEdit);
        ATtb_btnPlus = new ToolBarAction("Plus", null);
        ifAT_toolbar.add(ATtb_btnPlus);
        ATtb_btnLog = new ToolBarAction("Logout", null);
        ifAT_toolbar.add(ATtb_btnLog);


        setVisible(true);
        getContentPane().setBackground(Color.GRAY);
    }




}
