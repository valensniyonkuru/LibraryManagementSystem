/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;
import Model.LibrarianModel;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import Model.LibrarianSectionModel;

/**
 *
 * @author User
 */
public class LibrarianSectionDao {
    private String url="jdbc:mysql://localhost:3306/library_managment_system_db";
private String username="root";
private String password="";

    public LibrarianSectionDao() {
    }
    // Insert using prepared
    public String registerBook(LibrarianSectionModel LibrarianSectionModelObj){
        
        try{
             // create and get connection
            Connection con = DriverManager.getConnection(url,username,password);
           // create Prepared Statement
           String sql ="insert into librarians (bookid,bookname,author,publisher,quantity) values(?,?,?,?,?)";
           PreparedStatement pst = con.prepareStatement(sql);
           /**
            * 1. insert value inside ?
            * 2. Each ? marks a position start from 1
            */
            pst.setString(1,LibrarianSectionModelObj.getBookid() );
           pst.setString(2,LibrarianSectionModelObj.getBookname() );
           pst.setString(3,LibrarianSectionModelObj.getAuthor() );
           pst.setString(4,LibrarianSectionModelObj.getPublisher() );
           pst.setString(5,LibrarianSectionModelObj.getQuantity() );
            //execute query
            int rowAffected = pst.executeUpdate();
            con.close();
            if(rowAffected >=1){
//                con.close();
                return "Book Saved Successful";
            }else{
//                con.close();
                return "Book Not Saved";
            }
           
        }catch(Exception ex){
            ex.printStackTrace();
        }
        return "server error";
    }
    
    
     public String updateBook(LibrarianSectionModel LibrarianSectionModelObj ){
        try{
            Connection con = DriverManager.getConnection(url,username,password);
           String sql ="update librarians set bookname=?,author=?,publisher=?,quantity=? where bookid=?";
           PreparedStatement pst = con.prepareStatement(sql);
           pst.setString(1,LibrarianSectionModelObj.getBookname());
           pst.setString(2,LibrarianSectionModelObj.getAuthor());
           pst.setString(3, LibrarianSectionModelObj.getPublisher());
           pst.setString(4,LibrarianSectionModelObj.getQuantity());
           pst.setString(5,LibrarianSectionModelObj.getBookid());
           
            //execute query
            int rowAffected = pst.executeUpdate();
            con.close();
            if(rowAffected >=1){
//                con.close();
                return "Book update Successful";
            }else{
//                con.close();
                return "Book Not updated";
            }
                
        }catch(Exception ex){
            ex.printStackTrace();
        }
        
        return "Server Error!!";
    }
    public String deleteBook(LibrarianSectionModel LibrarianSectionModelObj){
        try{
            Connection con = DriverManager.getConnection(url, username, password);
            String sql = "delete from librarians where bookid=?";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1,LibrarianSectionModelObj .getBookid());
            int rowAffected= pst.executeUpdate();
            con.close();
           if(rowAffected>0){
               return "Book Deleted";
           }else{
               return "Book not deleted";
           }
            
        }catch(Exception ex){
            ex.printStackTrace();
        }
        return null;
    }
    public LibrarianSectionModel searchBook(LibrarianSectionModel LibrarianSectionModelObj){
        try{
            Connection con = DriverManager.getConnection(url, username, password);
            String sql = "select * from librarians where bookid=?";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1,LibrarianSectionModelObj .getBookid());
            ResultSet result = pst.executeQuery();
            LibrarianSectionModel thebook = new LibrarianSectionModel();
            boolean flag = false;
            while(result.next()){
                thebook.setBookname(result.getString("bookname"));
                thebook.setAuthor(result.getString("author"));
                thebook.setPublisher(result.getString("publisher"));
                thebook.setQuantity(result.getString("quantity"));
                thebook.setBookid(result.getString("bookid"));
                
                flag=true;
            }
             con.close();
            if(flag)
                
            {
                
             return  thebook;   
            }
        }catch(Exception ex){
            ex.printStackTrace();
        }
        return null;
    }
    public List<LibrarianSectionModel> allbook(){
        try{
            Connection con = DriverManager.getConnection(url, username, password);
            String sql = "select * from librarians";
            PreparedStatement pst = con.prepareStatement(sql);
            ResultSet result = pst.executeQuery();
            List<LibrarianSectionModel> bookList = new ArrayList<>();
            while(result.next()){
                LibrarianSectionModel LibrarianSectionModellObj = new LibrarianSectionModel();
                 LibrarianSectionModellObj.setBookid(result.getString("bookid"));
                LibrarianSectionModellObj.setBookname(result.getString("bookname"));
                LibrarianSectionModellObj.setAuthor(result.getString("author"));
                LibrarianSectionModellObj.setPublisher(result.getString("publisher"));
                LibrarianSectionModellObj.setQuantity(result.getString("quantity"));
               
                bookList.add(LibrarianSectionModellObj);
            }
            con.close();
            return bookList;
        }catch(Exception ex){
            ex.printStackTrace();
        }
        return null;
    }
    
}
