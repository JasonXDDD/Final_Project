package MainScreen;

import PublicClass.ToolBarAction;
import com.sun.prism.paint.*;
import sun.text.resources.ro.CollationData_ro;

import javax.swing.*;
import java.awt.*;
import java.awt.Color;

/**
 * Created by JASON_ on 2015/5/15.
 */
public class ifBookTool extends JInternalFrame {
    private JLayeredPane lp_layer;
    private ScrollPane sp_scroll;

    private JList ifBT_lsBookStore;
    private String[] lsBS_strName;
    private int lsBS_numBook;
    private Font lsBS_font;

    private JToolBar ifBT_toolbar;
    private ToolBarAction BTtb_btnAdd;
    private ToolBarAction BTtb_btnEdit;
    private ToolBarAction BTtb_btnDel;


    public ifBookTool( int booknum, String[] bookname){
        super("BookTool", false, true, true, false);
        setLayout(new GridLayout());
        lp_layer = this.getLayeredPane();
        sp_scroll = new ScrollPane();

        lsBS_font = new Font("微軟正黑體", Font.BOLD, 20);

        this.lsBS_numBook = booknum;
        this.lsBS_strName = bookname;
        ifBT_lsBookStore = new JList(lsBS_strName);
        ifBT_lsBookStore.setBorder(BorderFactory.createTitledBorder("BookStore"));
        ifBT_lsBookStore.setBackground(Color.gray);
        ifBT_lsBookStore.setFont(lsBS_font);

        sp_scroll.add(ifBT_lsBookStore);

        getContentPane().add(sp_scroll);

        ifBT_toolbar = new JToolBar(JToolBar.HORIZONTAL);
        ifBT_toolbar.setLayout(new FlowLayout(FlowLayout.RIGHT, 15, 5));
        ifBT_toolbar.setBackground(Color.GRAY);
        ifBT_toolbar.setFloatable(false);
        lp_layer.setLayout(new BorderLayout());
        lp_layer.add(ifBT_toolbar, BorderLayout.SOUTH, new Integer(2550));

        BTtb_btnAdd = new ToolBarAction("Add", null);
        BTtb_btnAdd.setBackground(Color.GRAY);
        BTtb_btnAdd.setForeground(Color.WHITE);
        BTtb_btnAdd.setBorder(BorderFactory.createLineBorder(Color.GRAY));
        BTtb_btnAdd.setFont(new Font("微軟正黑體", Font.BOLD, 16));
        ifBT_toolbar.add(BTtb_btnAdd);

        BTtb_btnEdit = new ToolBarAction("Edit", null);
        BTtb_btnEdit.setBackground(Color.GRAY);
        BTtb_btnEdit.setForeground(Color.WHITE);
        BTtb_btnEdit.setBorder(BorderFactory.createLineBorder(Color.GRAY));
        BTtb_btnEdit.setFont(new Font("微軟正黑體", Font.BOLD, 16));
        ifBT_toolbar.add(BTtb_btnEdit);

        BTtb_btnDel = new ToolBarAction("Delete", null);
        BTtb_btnDel.setBackground(Color.GRAY);
        BTtb_btnDel.setForeground(Color.WHITE);
        BTtb_btnDel.setBorder(BorderFactory.createLineBorder(Color.GRAY));
        BTtb_btnDel.setFont(new Font("微軟正黑體", Font.BOLD, 16));
        ifBT_toolbar.add(BTtb_btnDel);

        setVisible(true);
        getContentPane().setBackground(Color.GRAY);
    }
}
