package MainScreen;

import PublicClass.BookData;
import PublicClass.BookNode;
import PublicClass.ToolBarAction;
import PublicClass.WrapLayout;
import javafx.scene.control.ScrollBar;

import javax.swing.*;
import java.awt.*;
import java.awt.print.Printable;
import java.security.PrivateKey;
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

    private JToolBar BT_toolbar;
    private ToolBarAction BT_btnAdd;
    private ToolBarAction BT_btnEdit;
    private ToolBarAction BT_btnDel;

    private ScrollPane sp_scroll;

    public BookPanel(){
        setLayout(new BorderLayout());
        sp_scroll = new ScrollPane();

        ceter = new JPanel(new WrapLayout(FlowLayout.LEADING, 100, 60));
        bottom = new JPanel();

        bk = new BookData();
        bk.setBk_Name("Book1");
        bk.setBk_Pic(new ImageIcon(getClass().getResource("book_head.jpg")));
        lsbk.add(bk);

        bn = new BookNode(bk.getBk_Pic(), bk.getBk_Name());
        ceter.add(bn);
        lsbn.add(bn);

        bk = new BookData();
        bk.setBk_Name("Book2");
        bk.setBk_Pic(new ImageIcon(getClass().getResource("book2_head.jpg")));
        lsbk.add(bk);

        bn = new BookNode(bk.getBk_Pic(), bk.getBk_Name());
        ceter.add(bn);
        lsbn.add(bn);
        bk = new BookData();
        bk.setBk_Name("Book3");
        bk.setBk_Pic(new ImageIcon(getClass().getResource("book3_head.jpg")));
        lsbk.add(bk);

        bn = new BookNode(bk.getBk_Pic(), bk.getBk_Name());
        ceter.add(bn);
        lsbn.add(bn);

        bk = new BookData();
        bk.setBk_Name("Book4");
        bk.setBk_Pic(new ImageIcon(getClass().getResource("book4_head.jpg")));
        lsbk.add(bk);

        bn = new BookNode(bk.getBk_Pic(), bk.getBk_Name());
        ceter.add(bn);
        lsbn.add(bn);

        bk = new BookData();
        bk.setBk_Name("Book5");
        bk.setBk_Pic(new ImageIcon(getClass().getResource("book5_head.jpg")));
        lsbk.add(bk);

        bn = new BookNode(bk.getBk_Pic(), bk.getBk_Name());
        ceter.add(bn);
        lsbn.add(bn);
        bk = new BookData();

        bk.setBk_Name("Book6");
        bk.setBk_Pic(new ImageIcon(getClass().getResource("book6_head.jpg")));
        lsbk.add(bk);

        bn = new BookNode(bk.getBk_Pic(), bk.getBk_Name());
        ceter.add(bn);
        lsbn.add(bn);

        BT_toolbar = new JToolBar(JToolBar.HORIZONTAL);
        BT_toolbar.setLayout(new FlowLayout(FlowLayout.RIGHT, 15, 5));
        BT_toolbar.setBackground(Color.GRAY);
        BT_toolbar.setFloatable(false);

        BT_btnAdd = new ToolBarAction("Add", null);
        BT_btnAdd.setBackground(Color.GRAY);
        BT_btnAdd.setForeground(Color.WHITE);
        BT_btnAdd.setBorder(BorderFactory.createLineBorder(Color.GRAY));
        BT_btnAdd.setFont(new Font("微軟正黑體", Font.BOLD, 16));
        BT_toolbar.add(BT_btnAdd);

        BT_btnEdit = new ToolBarAction("Edit", null);
        BT_btnEdit.setBackground(Color.GRAY);
        BT_btnEdit.setForeground(Color.WHITE);
        BT_btnEdit.setBorder(BorderFactory.createLineBorder(Color.GRAY));
        BT_btnEdit.setFont(new Font("微軟正黑體", Font.BOLD, 16));
        BT_toolbar.add(BT_btnEdit);

        BT_btnDel = new ToolBarAction("Delete", null);
        BT_btnDel.setBackground(Color.GRAY);
        BT_btnDel.setForeground(Color.WHITE);
        BT_btnDel.setBorder(BorderFactory.createLineBorder(Color.GRAY));
        BT_btnDel.setFont(new Font("微軟正黑體", Font.BOLD, 16));
        BT_toolbar.add(BT_btnDel);

        add(BT_toolbar, BorderLayout.NORTH);

        ceter.setSize(1000,1500);
        sp_scroll.add(ceter);
        add(sp_scroll, BorderLayout.CENTER);
        ceter.setBackground(Color.DARK_GRAY);
        add(bottom, BorderLayout.SOUTH);
        bottom.setBackground(Color.DARK_GRAY);

        setBackground(Color.DARK_GRAY);
    }
}
