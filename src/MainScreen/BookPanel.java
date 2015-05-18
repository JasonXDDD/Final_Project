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
    private ArrayList<BookData> BDatas = new ArrayList<BookData>();
    private ArrayList<BookNode> BNodes = new ArrayList<BookNode>();
    private BookData bookData;
    private BookNode bookNode;

    private pnBookInfor bookInfor;

    private JPanel pnCeter;
    private JPanel pnBottom;

    private ToolBar BT_toolbar;

    private ScrollPane sp_scroll;

    public BookPanel(){
        setLayout(new BorderLayout());
        sp_scroll = new ScrollPane();
        pnCeter = new JPanel(new WrapLayout(FlowLayout.LEADING, 60, 60));
        pnBottom = new JPanel();

        AddBook("Book1", new ImageIcon(getClass().getResource("ResourceData/book_head.jpg")));
        bookInfor = new pnBookInfor(bookData);
        AddBook("Book2", new ImageIcon(getClass().getResource("ResourceData/book2_head.png")));
        AddBook("Book3", new ImageIcon(getClass().getResource("ResourceData/book3_head.jpg")));
        AddBook("Book4", new ImageIcon(getClass().getResource("ResourceData/book4_head.jpg")));
        AddBook("Book5", new ImageIcon(getClass().getResource("ResourceData/book5_head.jpg")));
        AddBook("Book6", new ImageIcon(getClass().getResource("ResourceData/book6_head.jpg")));
        AddBook("Book7", new ImageIcon(getClass().getResource("ResourceData/book7_head.jpg")));
        AddBook("Book8", new ImageIcon(getClass().getResource("ResourceData/book8_head.jpg")));
        AddBook("Book9", new ImageIcon(getClass().getResource("ResourceData/book9_head.jpg")));

        pnCeter.setSize(1000, 1500);
        pnCeter.setBackground(Color.DARK_GRAY);
        sp_scroll.add(pnCeter);
        add(sp_scroll, BorderLayout.CENTER);


        BT_toolbar = new ToolBar();
        BT_toolbar.AddTool("Add", null);
        BT_toolbar.AddTool("Edit", null);
        BT_toolbar.AddTool("Delete", null);
        add(BT_toolbar, BorderLayout.NORTH);

        pnBottom.add(bookInfor);
        pnBottom.setBackground(Color.GRAY);
        add(pnBottom, BorderLayout.SOUTH);


        setBackground(Color.DARK_GRAY);
    }

    public void AddBook(String name, ImageIcon show){
        bookData = new BookData();
        bookData.setBk_Name(name);
        bookData.setBk_Pic(show);
        bookData.setBk_ISBN("3212310012303");
        bookData.setBk_Author("密卡登");
        bookData.setBk_Publisher("便型精肛");
        bookData.setBk_Date("2099/12/31");
        bookData.setBk_Price("300");
        BDatas.add(bookData);

        bookNode = new BookNode(bookData.getBk_Pic(), bookData.getBk_Name());
        pnCeter.add(bookNode);
        BNodes.add(bookNode);

    }

}
