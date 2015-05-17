package DataClass;

import javax.swing.*;

/**
 * Created by JASON_ on 2015/5/15.
 */
public class BookData {
    private String Bk_Name;
    private ImageIcon Bk_Pic;
    private String Bk_ISBN;
    private String Bk_Author;
    private String Bk_Publisher;
    private String Bk_Date;
    private String Bk_Price;

    private boolean Bk_Delete;
    private int Bk_Node;

    public BookData() {
        Bk_Author = new String();
        Bk_Date = new String();
        Bk_Delete = false;
        Bk_ISBN = new String();
        Bk_Name = new String();
        Bk_Node = 0;
        Bk_Pic = null;
        Bk_Price = new String();
        Bk_Publisher = new String();


    }


    public void setBk_Author(String bk_Author) {
        Bk_Author = bk_Author;
    }

    public void setBk_Date(String bk_Date) {
        Bk_Date = bk_Date;
    }

    public void setBk_Delete(boolean bk_Delete) {
        Bk_Delete = bk_Delete;
    }

    public void setBk_ISBN(String bk_ISBN) {
        Bk_ISBN = bk_ISBN;
    }

    public void setBk_Name(String bk_Name) {
        Bk_Name = bk_Name;
    }

    public void setBk_Node(int bk_Node) {
        Bk_Node = bk_Node;
    }

    public void setBk_Pic(ImageIcon bk_Pic) {
        Bk_Pic = bk_Pic;
    }

    public void setBk_Price(String bk_Price) {
        Bk_Price = bk_Price;
    }

    public void setBk_Publisher(String bk_Publisher) {
        Bk_Publisher = bk_Publisher;
    }

    public String getBk_Author() {
        return Bk_Author;
    }

    public String getBk_Date() {
        return Bk_Date;
    }

    public boolean isBk_Delete() {
        return Bk_Delete;
    }

    public String getBk_ISBN() {
        return Bk_ISBN;
    }

    public String getBk_Name() {
        return Bk_Name;
    }

    public int getBk_Node() {
        return Bk_Node;
    }

    public ImageIcon getBk_Pic() {
        return Bk_Pic;
    }

    public String getBk_Price() {
        return Bk_Price;
    }

    public String getBk_Publisher() {
        return Bk_Publisher;
    }
}
