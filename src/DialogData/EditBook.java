package DialogData;

import PublicClass.ImageProcess;
import PublicClass.ScreenSize;
import ServerConnect.Gobel;
import ServerConnect.sAddBook;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

/**
 * Created by JASON_ on 2015/5/30.
 */
public class EditBook extends BasicDialog implements ActionListener {
    private ScreenSize scSize;
    private Gobel gbl;

    private ImageIcon head, Show;
    private JButton headbtn;
    private JLabel lbl;
    private JLabel Error;
    private JButton cancel;
    private JButton OK;

    private JTextField enter_Name;
    private JTextField enter_ISBN;
    private JTextField enter_Author;
    private JTextField enter_Publisher;
    private JTextField enter_PubDate;
    private JTextField enter_Price;
    private JTextField enter_Tag;

    private File file = null;
    private sAddBook sab;

    public EditBook(JFrame f, String str, boolean model){
        super(f, str, model);
        scSize = new ScreenSize();

        SetTheSize(new int[]{50,180,30,80,80,50},
                new int[]{30,30,30,30,30,30,30,30,30,30,30,30});


        head = new ImageIcon(getClass().getResource("head.jpg"));
        Show = ImageProcess.scaleImage(head, 210, ImageProcess.Height);

        headbtn = new JButton(Show);
        headbtn.setBorder(BorderFactory.createLineBorder(Color.black));
        headbtn.setBackground(Color.WHITE);
        headbtn.addActionListener(this);
        AddFiled(headbtn, new int[]{1, 2, 7, 1});

        Error = new JLabel("必須輸入名稱"); AddFiled(Error, new int[]{3,1,1,2});
        lbl = new JLabel("Name: ");         AddFiled(lbl, new int[]{2,2,1,1});
        lbl = new JLabel("ISBN: ");         AddFiled(lbl, new int[]{2,3,1,1});
        lbl = new JLabel("Author: ");       AddFiled(lbl, new int[]{2,4,1,1});
        lbl = new JLabel("Publisher: ");    AddFiled(lbl, new int[]{2,5,1,1});
        lbl = new JLabel("Publish Date: "); AddFiled(lbl, new int[]{2,6,1,1});
        lbl = new JLabel("Price: ");        AddFiled(lbl, new int[]{2,7,1,1});
        lbl = new JLabel("Tag: ");          AddFiled(lbl, new int[]{2,8,1,1});

        enter_Name = new JTextField("BookName");
        AddFiled(enter_Name, new int[]{3,2,1,2});
        enter_ISBN = new JTextField();
        AddFiled(enter_ISBN, new int[]{3,3,1,2});
        enter_Author = new JTextField();
        AddFiled(enter_Author, new int[]{3,4,1,2});
        enter_Publisher = new JTextField();
        AddFiled(enter_Publisher, new int[]{3,5,1,2});
        enter_PubDate = new JTextField();
        AddFiled(enter_PubDate, new int[]{3,6,1,2});
        enter_Price = new JTextField();
        AddFiled(enter_Price, new int[]{3,7,1,2});
        enter_Tag = new JTextField();
        AddFiled(enter_Tag, new int[]{3,8,1,2});

        cancel = new JButton("Cancel");
        cancel.addActionListener(this);
        AddFiled(cancel, new int[]{3,10,1,1});

        OK = new JButton("OK");
        OK.addActionListener(this);
        AddFiled(OK, new int[]{4,10,1,1});

        pack();
        setLocation(scSize.getWidth()/2 - this.getWidth()/2,
                scSize.getHeight()/2 - this.getHeight()/2);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == cancel){
            System.out.println();
            dispose();
        }
        else if(e.getSource() == headbtn){
            String str = new String("");
            FileDialog fd = new FileDialog(this, "FileDialog", FileDialog.LOAD);
            fd.setVisible(true);

            str = fd.getDirectory() + fd.getFile();

            if(fd.getFile() != null) {
                file = new File(str);
                System.out.println("set head file: " + file.toString());
                head = new ImageIcon(str);

                Show = ImageProcess.scaleImage(head, 210, ImageProcess.Width);

                headbtn.setIcon(Show);
            }
            pack();
        }
        else if(e.getSource() == OK){
            try{
                Error.setText("");
                sab = new sAddBook(gbl.getToken(), enter_Name.getText(),
                        enter_ISBN.getText(), enter_Author.getText(),
                        enter_Publisher.getText(), enter_PubDate.getText(),
                        enter_Price.getText(), enter_Tag.getText(), file);

                System.out.println( "On Dialog: Name: " + enter_Name.getText() +
                        "  ISBN: " + enter_ISBN.getText() +
                        "  Author: " + enter_Author.getText() +
                        "  Publisher: " + enter_Publisher.getText() +
                        "  PubDate: " + enter_PubDate.getText() +
                        "  Price: " + enter_Price.getText() +
                        "  Tags: " + enter_Tag.getText());
                if(file != null)
                    System.out.println("  File: " + file.toString());

            }
            catch (IOException I){}


            if(sab.getRespondcode()/100 == 2){
                dispose();
                System.out.println();
            }
            else
                Error.setText("名稱錯誤!!");
        }
    }
}
