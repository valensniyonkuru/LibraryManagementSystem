/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 *
 * @author User
 */
public class LibrarianSectionModel {
    private String bookid;
    private String bookname;
    private String author;
    private String publisher;
    private String quantity;

    public LibrarianSectionModel() {
    }

    public LibrarianSectionModel(String bookid, String bookname, String author, String publisher, String quantity) {
        this.bookid = bookid;
        this.bookname = bookname;
        this.author = author;
        this.publisher = publisher;
        this.quantity = quantity;
    }

    public String getBookid() {
        return bookid;
    }

    public void setBookid(String bookid) {
        this.bookid = bookid;
    }

    public String getBookname() {
        return bookname;
    }

    public void setBookname(String bookname) {
        this.bookname = bookname;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public String getQuantity() {
        return quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }
   
  
}
