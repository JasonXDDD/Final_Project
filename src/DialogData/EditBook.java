package DialogData;

import PublicClass.ScreenSize;
import sun.misc.JavaLangAccess;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by JASON_ on 2015/5/30.
 */
public class EditBook extends BasicDialog implements ActionListener {
    private ScreenSize scSize;

    private ImageIcon head;
    private JButton btnHead;
    private JLabel lbl;
    private JButton cancel;
    private JButton OK;

    private JTextField enter_Name;
    private JTextField enter_ISBN;
    private JTextField enter_Author;
    private JTextField enter_Publisher;
    private JTextField enter_PubDate;
    private JTextField enter_Price;
    private JTextField enter_Tag;

    public EditBook(JFrame f, String str, boolean model){
        super(f, str, model);
        scSize = new ScreenSize();

        SetTheSize(new int[]{50,180,30,80,80,50},
                   new int[]{30,30,30,30,30,30,30,30,30,30});

        btnHead = new JButton();
        btnHead.setBorder(BorderFactory.createLineBorder(Color.black));
        btnHead.setBackground(Color.WHITE);
        btnHead.addActionListener(this);
        AddFiled(btnHead, new int[]{1, 1, 7, 1});

        lbl = new JLabel("Name: ");         AddFiled(lbl, new int[]{2,1,1,1});
        lbl = new JLabel("ISBN: ");         AddFiled(lbl, new int[]{2,2,1,1});
        lbl = new JLabel("Author: ");       AddFiled(lbl, new int[]{2,3,1,1});
        lbl = new JLabel("Publisher: ");    AddFiled(lbl, new int[]{2,4,1,1});
        lbl = new JLabel("Publish Date: "); AddFiled(lbl, new int[]{2,5,1,1});
        lbl = new JLabel("Price: ");        AddFiled(lbl, new int[]{2,6,1,1});
        lbl = new JLabel("Tag: ");          AddFiled(lbl, new int[]{2,7,1,1});

        enter_Name = new JTextField();
        AddFiled(enter_Name, new int[]{3,1,1,2});
        enter_ISBN = new JTextField();
        AddFiled(enter_ISBN, new int[]{3,2,1,2});
        enter_Author = new JTextField();
        AddFiled(enter_Author, new int[]{3,3,1,2});
        enter_Publisher = new JTextField();
        AddFiled(enter_Publisher, new int[]{3,4,1,2});
        enter_PubDate = new JTextField();
        AddFiled(enter_PubDate, new int[]{3,5,1,2});
        enter_Price = new JTextField();
        AddFiled(enter_Price, new int[]{3,6,1,2});
        enter_Tag = new JTextField();
        AddFiled(enter_Tag, new int[]{3,7,1,2});

        cancel = new JButton("Cancel");
        cancel.addActionListener(this);
        AddFiled(cancel, new int[]{3, 9, 1, 1});

        OK = new JButton("OK");
        OK.addActionListener(this);
        AddFiled(OK, new int[]{4, 9, 1, 1});
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
