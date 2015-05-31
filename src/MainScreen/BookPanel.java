package MainScreen;

import DataClass.BookData;
import PublicClass.*;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

/**
 * Created by JASON_ on 2015/5/15.
 */
public class BookPanel extends JPanel{
    private BookNode bookNode;

    private pnBookInfor bookInfor;

    private JPanel pnCeter;
    private JPanel pnBottom;

    private ToolBar BT_toolbar;

    private ScrollPane sp_scroll;

    public BookPanel(){
        setLayout(new BorderLayout());
        sp_scroll = new ScrollPane();

        pnBottom = new JPanel();


        pnCeter = new JPanel(new WrapLayout(FlowLayout.LEADING, 60, 60));
        pnCeter.setSize(1000, 1500);
        pnCeter.setBackground(Color.WHITE);
        sp_scroll.add(pnCeter);
        add(sp_scroll, BorderLayout.CENTER);


        BT_toolbar = new ToolBar();
        BT_toolbar.AddTool("bAdd", null);
        BT_toolbar.AddTool("bEdit", null);
        BT_toolbar.AddTool("Delete", null);
        add(BT_toolbar, BorderLayout.NORTH);


//        bookInfor = new pnBookInfor(bookdata);
//        pnBottom.add(bookInfor);
//        pnBottom.setBorder(BorderFactory.createLineBorder(Color.black));
//        pnBottom.setBackground(Color.WHITE);
//        add(pnBottom, BorderLayout.SOUTH);


        setBackground(Color.WHITE);
    }

    public void AddBook(BookData bookData){
        if(bookData.getBk_cover() == null)
            bookData.setBk_cover(new ImageIcon(getClass().getResource("bookhead.jpg")));
        else
            System.out.println("AddBook: " + bookData.getBk_cover().toString());
        bookNode = new BookNode(bookData.getBk_cover(), bookData.getBk_Name());
        pnCeter.add(bookNode);

    }

    public JPanel getPnCeter() {
        return pnCeter;
    }

    public void setPnCeter(JPanel pnCeter) {
        this.pnCeter = pnCeter;
    }
}
