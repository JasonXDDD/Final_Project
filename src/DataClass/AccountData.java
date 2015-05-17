package DataClass;

import javafx.scene.shape.*;

import javax.swing.*;
import java.util.ArrayList;

/**
 * Created by JASON_ on 2015/5/17.
 */
public class AccountData {
    private ImageIcon Account_Head;
    private String Account_Name;
    private ArrayList<StoreData> Stores = new ArrayList<StoreData>();
    private StoreData StoreSample;

    public AccountData(ImageIcon head, String name){
        this.Account_Head = head;
        this.Account_Name = name;


    }
}
