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

    private String Bk_PubDate;
    private String Bk_Price;
    private String BK_Tag;

    private boolean Bk_Delete;
    private int Bk_ID;

    public BookData() {
        Bk_Author = new String();
        Bk_PubDate = new String();
        Bk_Delete = false;
        Bk_ISBN = new String();
        Bk_Name = new String();
        Bk_ID = 0;
        Bk_Pic = null;
        Bk_Price = new String();
        Bk_Publisher = new String();


    }

    public String getBK_Tag() {
        return BK_Tag;
    }

    public void setBK_Tag(String BK_Tag) {
        this.BK_Tag = BK_Tag;
    }

    public void setBk_Author(String bk_Author) {
        Bk_Author = bk_Author;
    }

    public void setBk_PubDate(String bk_PubDate) {
        Bk_PubDate = bk_PubDate;
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

    public void setBk_ID(int bk_ID) {
        Bk_ID = bk_ID;
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

    public String getBk_PubDate() {
        return Bk_PubDate;
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

    public int getBk_ID() {
        return Bk_ID;
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
