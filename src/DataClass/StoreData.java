package DataClass;

import java.util.ArrayList;

/**
 * Created by JASON_ on 2015/5/17.
 */
public class StoreData {
    private String Store_Name;
    private Integer User_ID;
    private ArrayList<Integer> Books_ID = new ArrayList<Integer>();
    private Integer BKID;

    public StoreData(){
    }

    public Integer getBKID() {
        return BKID;
    }

    public void setBKID(Integer BKID) {
        this.BKID = BKID;
    }

    public ArrayList<Integer> getBooks_ID() {
        return Books_ID;
    }

    public void setBooks_ID(ArrayList<Integer> books_ID) {
        Books_ID = books_ID;
    }

    public String getStore_Name() {
        return Store_Name;
    }

    public void setStore_Name(String store_Name) {
        Store_Name = store_Name;
    }

    public Integer getUser_ID() {
        return User_ID;
    }

    public void setUser_ID(Integer user_ID) {
        User_ID = user_ID;
    }
}
