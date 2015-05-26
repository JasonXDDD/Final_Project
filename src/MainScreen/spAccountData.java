package MainScreen;

import javax.swing.*;

/**
 * Created by JASON_ on 2015/5/18.
 */
public class spAccountData extends JSplitPane {
    private ifAccountTool ifAT;
    private ImageIcon ifAT_iconHead;

    private ifStoreTool ifST;
    private String[] ifST_strBookName;

    public spAccountData(){
        super(JSplitPane.VERTICAL_SPLIT, true);

        ifAT_iconHead = new ImageIcon(getClass().getResource("ResourceData/account_head.png"));
        System.out.println("In frame data: " + MainTest.accountData.getAccount_Name());
        ifAT = new ifAccountTool(ifAT_iconHead, MainTest.accountData.getAccount_Name(), 37, 100);
        ifAT.setBounds(100, 100, 280, 400);
        //ifAT.addComponentListener(this);
        add(ifAT);

        ifST_strBookName = new String[]{"BookStore-XDD", "Store2-QAQ", "Store3-OwO",
                "Store1-XDD", "BStore1-XDD", "BStore1-XDD", "BStore-XDD", "Store1-XDD",
                "BoStore", "BoStoreD", "BStoreD", "BoStoreDD", "BStoreXDD",
                "BStore", "BStoreD", "BoStoreDD", "StoreDD", "StoreD",
                "Book1-XStoreD", "BooStoreDD", "StoreXDD", "BStoreD", "BStoreXDD"};
        ifST = new ifStoreTool(3, ifST_strBookName);
        ifST.setBounds(500, 100, 280, 610);
        //ifST.addComponentListener(this);
        add(ifST);

        setDividerLocation(400);
        setOneTouchExpandable(true);
        setDividerSize(10);
        //setSize(280, 1015);
    }

    public ifAccountTool getIfAT() {
        return ifAT;
    }

    public void setIfAT(ifAccountTool ifAT) {
        this.ifAT = ifAT;
    }
}
