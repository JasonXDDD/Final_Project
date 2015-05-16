package MainScreen;

import PublicClass.ToolBarAction;

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

    private JToolBar ifBT_toolbar;
    private ToolBarAction STtb_btnAdd;
    private ToolBarAction STtb_btnEdit;
    private ToolBarAction STtb_btnDel;


    public ifStoreTool(int booknum, String[] bookname){
        super("BookTool", false, true, true, false);
        setLayout(new GridLayout());
        lp_layer = this.getLayeredPane();
        sp_scroll = new ScrollPane();

        lsBS_font = new Font("微軟正黑體", Font.BOLD, 20);

        this.lsBS_numBook = booknum;
        this.lsBS_strName = bookname;
        ifST_lsBookStore = new JList(lsBS_strName);
        ifST_lsBookStore.setBorder(BorderFactory.createTitledBorder("BookStore"));
        ifST_lsBookStore.setBackground(Color.gray);
        ifST_lsBookStore.setFont(lsBS_font);

        sp_scroll.add(ifST_lsBookStore);

        getContentPane().add(sp_scroll);

        ifBT_toolbar = new JToolBar(JToolBar.HORIZONTAL);
        ifBT_toolbar.setLayout(new FlowLayout(FlowLayout.RIGHT, 15, 5));
        ifBT_toolbar.setBackground(Color.GRAY);
        ifBT_toolbar.setFloatable(false);
        lp_layer.setLayout(new BorderLayout());
        lp_layer.add(ifBT_toolbar, BorderLayout.SOUTH, new Integer(2550));

        STtb_btnAdd = new ToolBarAction("Add", null);
        STtb_btnAdd.setBackground(Color.GRAY);
        STtb_btnAdd.setForeground(Color.WHITE);
        STtb_btnAdd.setBorder(BorderFactory.createLineBorder(Color.GRAY));
        STtb_btnAdd.setFont(new Font("微軟正黑體", Font.BOLD, 16));
        ifBT_toolbar.add(STtb_btnAdd);

        STtb_btnEdit = new ToolBarAction("Edit", null);
        STtb_btnEdit.setBackground(Color.GRAY);
        STtb_btnEdit.setForeground(Color.WHITE);
        STtb_btnEdit.setBorder(BorderFactory.createLineBorder(Color.GRAY));
        STtb_btnEdit.setFont(new Font("微軟正黑體", Font.BOLD, 16));
        ifBT_toolbar.add(STtb_btnEdit);

        STtb_btnDel = new ToolBarAction("Delete", null);
        STtb_btnDel.setBackground(Color.GRAY);
        STtb_btnDel.setForeground(Color.WHITE);
        STtb_btnDel.setBorder(BorderFactory.createLineBorder(Color.GRAY));
        STtb_btnDel.setFont(new Font("微軟正黑體", Font.BOLD, 16));
        ifBT_toolbar.add(STtb_btnDel);

        setVisible(true);
        getContentPane().setBackground(Color.GRAY);
    }
}
