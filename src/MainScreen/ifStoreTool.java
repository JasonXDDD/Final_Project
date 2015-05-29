package MainScreen;

import PublicClass.ToolBar;

import javax.swing.*;
import java.awt.*;
import java.awt.Color;

/**
 * Created by JASON_ on 2015/5/15.
 */
public class ifStoreTool extends JInternalFrame {
    private JLayeredPane lp_layer;
    private ScrollPane sp_scroll;

    private JList ifST_lsBookStore;
    private String[] lsBS_strName;
    private int lsBS_numBook;
    private Font lsBS_font;

    private ToolBar ifST_toolbar;

    public ifStoreTool(int booknum, String[] bookname){
        super("BookTool", false, false, false, false);
        setLayout(new BorderLayout());
        lp_layer = this.getLayeredPane();
        sp_scroll = new ScrollPane();

        lsBS_font = new Font("微軟正黑體", Font.BOLD, 20);
        this.lsBS_numBook = booknum;
        this.lsBS_strName = bookname;
        ifST_lsBookStore = new JList(lsBS_strName);
        ifST_lsBookStore.setBorder(BorderFactory.createTitledBorder("BookStore"));
        ifST_lsBookStore.setBackground(Color.WHITE);
        ifST_lsBookStore.setFont(lsBS_font);

        sp_scroll.add(ifST_lsBookStore);
        getContentPane().add(sp_scroll, BorderLayout.CENTER);

        ifST_toolbar = new ToolBar();
        ifST_toolbar.AddTool("sAdd", null);
        ifST_toolbar.AddTool("sEdit", null);
        ifST_toolbar.AddTool("Delete", null);
        lp_layer.setLayout(new BorderLayout());
//        lp_layer.add(ifST_toolbar, BorderLayout.SOUTH, new Integer(8550));
        getContentPane().add(ifST_toolbar, BorderLayout.SOUTH);

        setVisible(true);
        getContentPane().setBackground(Color.WHITE);
    }
}
