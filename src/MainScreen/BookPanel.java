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
    private ArrayList<BookData> lsbk = new ArrayList<BookData>();
    private ArrayList<BookNode> lsbn = new ArrayList<BookNode>();
    private BookData bk;
    private BookNode bn;

    private JPanel ceter;
    private JPanel bottom;

    private ToolBar BT_toolbar;

    private ScrollPane sp_scroll;

    public BookPanel(){
        setLayout(new BorderLayout());
        sp_scroll = new ScrollPane();
        ceter = new JPanel(new WrapLayout(FlowLayout.LEADING, 60, 60));
        bottom = new JPanel();

        AddBook("Book1", new ImageIcon(getClass().getResource("ResourceData/book_head.jpg")));
        AddBook("Book2", new ImageIcon(getClass().getResource("ResourceData/book2_head.jpg")));
        AddBook("Book3", new ImageIcon(getClass().getResource("ResourceData/book3_head.jpg")));
        AddBook("Book4", new ImageIcon(getClass().getResource("ResourceData/book4_head.jpg")));
        AddBook("Book5", new ImageIcon(getClass().getResource("ResourceData/book5_head.jpg")));
        AddBook("Book6", new ImageIcon(getClass().getResource("ResourceData/book6_head.jpg")));

        ceter.setSize(1000,1500);
        ceter.setBackground(Color.DARK_GRAY);
        sp_scroll.add(ceter);
        add(sp_scroll, BorderLayout.CENTER);


        BT_toolbar = new ToolBar();
        BT_toolbar.AddTool("Add", null);
        BT_toolbar.AddTool("Edit", null);
        BT_toolbar.AddTool("Delete", null);
        add(BT_toolbar, BorderLayout.NORTH);



//        bottom.setBackground(Color.DARK_GRAY);
//        add(bottom, BorderLayout.SOUTH);


        setBackground(Color.DARK_GRAY);
    }

    public void AddBook(String name, ImageIcon show){
        bk = new BookData();
        bk.setBk_Name(name);
        bk.setBk_Pic(show);
        lsbk.add(bk);

        bn = new BookNode(bk.getBk_Pic(), bk.getBk_Name());
        ceter.add(bn);
        lsbn.add(bn);

    }

}
