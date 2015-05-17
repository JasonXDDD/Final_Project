package DataClass;

import java.util.ArrayList;

/**
 * Created by JASON_ on 2015/5/17.
 */
public class StoreData {
    private String Store_Name;
    private ArrayList<BookData> Books = new ArrayList<BookData>();
    private BookData BookSample;

    public StoreData(String name){
        this.Store_Name = name;
    }
}
