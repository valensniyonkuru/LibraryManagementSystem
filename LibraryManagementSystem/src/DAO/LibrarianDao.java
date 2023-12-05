
package DAO;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import Model.LibrarianModel;

/**
 *
 * @author User
 */
public class LibrarianDao {
private String url="jdbc:mysql://localhost:3306/library_managment_system_db";
private String username="root";
private String password="";

    public LibrarianDao() {
    }
    
 // Insert using prepared
    public String registerlibrarian(LibrarianModel LibrarianModelObj){
        try{
            // create and get connection
            Connection con = DriverManager.getConnection(url,username,password);
           // create Prepared Statement
           String sql ="insert into librarian (id,firstname,lastname,email,address,password) values(?,?,?,?,?,?)";
           PreparedStatement pst = con.prepareStatement(sql);
           /**
            * 1. insert value inside ?
            * 2. Each ? marks a position start from 1
            */
           pst.setString(1,LibrarianModelObj.getLibrarianid() );
           pst.setString(2,LibrarianModelObj.getLibrarianfirstname() );
           pst.setString(3,LibrarianModelObj.getLibrarianlastname() );
           pst.setString(4,LibrarianModelObj.getLibrarianemail() );
           pst.setString(5,LibrarianModelObj.getLibrarianaddress() );
           pst.setString(6,LibrarianModelObj.getLibrarianpassword() );
           
            //execute query
            int rowAffected = pst.executeUpdate();
            con.close();
            if(rowAffected >=1){
//                con.close();
                return "Data Saved Successful";
            }else{
//                con.close();
                return "Data Not Saved";
            }
                
        }catch(Exception ex){
            ex.printStackTrace();
        }
        
        return "Server Error!!";
    }
     public LibrarianModel searchlibrarian(LibrarianModel LibrarianModelObj){
        try{
            Connection con = DriverManager.getConnection(url, username, password);
            String sql = "select * from librarian where id=?";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1, LibrarianModelObj.getLibrarianid());
            ResultSet result = pst.executeQuery();
            LibrarianModel theLibrarianModel = new LibrarianModel();
            boolean flag = false;
            while(result.next()){
                theLibrarianModel.setLibrarianfirstname(result.getString("firstname"));
                theLibrarianModel.setLibrarianlastname(result.getString("lastname"));
                theLibrarianModel.setLibrarianemail(result.getString("email"));
                theLibrarianModel.setLibrarianaddress(result.getString("address"));
                theLibrarianModel.setLibrarianpassword(result.getString("password"));
                theLibrarianModel.setLibrarianid(result.getString("id"));
                flag=true;
            }
            
            con.close();
            if(flag){
                
                return theLibrarianModel;
            }
        }catch(Exception ex){
            ex.printStackTrace();
        }
        return null;
    }
          public LibrarianModel searchlibrarianToLogin(LibrarianModel LibrarianModelObj){
        try{
            Connection con = DriverManager.getConnection(url, username, password);
            String sql = "select * from librarian where email=? and password=?";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1, LibrarianModelObj.getLibrarianemail());
            pst.setString(2, LibrarianModelObj.getLibrarianpassword());
            ResultSet result = pst.executeQuery();
            LibrarianModel theLibrarianModel = new LibrarianModel();
            boolean flag = false;
            while(result.next()){
                theLibrarianModel.setLibrarianfirstname(result.getString("firstname"));
                theLibrarianModel.setLibrarianlastname(result.getString("lastname"));
                theLibrarianModel.setLibrarianemail(result.getString("email"));
                theLibrarianModel.setLibrarianaddress(result.getString("address"));
                theLibrarianModel.setLibrarianpassword(result.getString("password"));
                theLibrarianModel.setLibrarianid(result.getString("id"));
                flag=true;
            }
            
            con.close();
            if(flag){
                
                return theLibrarianModel;
            }
        }catch(Exception ex){
            ex.printStackTrace();
        }
        return null;
    }
      public String updatelibrarian(LibrarianModel LibrarianModelObj ){
        try{
            Connection con = DriverManager.getConnection(url,username,password);
           String sql ="update librarian set firstname=?,lastname=?,email=?,address=?,password=? where id=?";
           PreparedStatement pst = con.prepareStatement(sql);
           pst.setString(1,LibrarianModelObj.getLibrarianfirstname());
           pst.setString(2,LibrarianModelObj.getLibrarianlastname());
           pst.setString(3, LibrarianModelObj.getLibrarianemail());
           pst.setString(4,LibrarianModelObj.getLibrarianaddress());
           pst.setString(5,LibrarianModelObj.getLibrarianpassword());
           pst.setString(6,LibrarianModelObj.getLibrarianid());
            //execute query
            int rowAffected = pst.executeUpdate();
            con.close();
            if(rowAffected >=1){
//                con.close();
                return "Data update Successful";
            }else{
//                con.close();
                return "Data Not updated";
            }
                
        }catch(Exception ex){
            ex.printStackTrace();
        }
        
        return "Server Error!!";
    }
       public String deletelibrarian(LibrarianModel LibrarianModelObj){
        try{
            Connection con = DriverManager.getConnection(url, username, password);
            String sql = "delete from librarian where id=?";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1,LibrarianModelObj . getLibrarianid());
            int rowAffected= pst.executeUpdate();
            con.close();
           if(rowAffected>0){
               return "librarian Deleted";
           }else{
               return "librarian not deleted";
           }
            
        }catch(Exception ex){
            ex.printStackTrace();
        }
        return null;
    }
        public List<LibrarianModel> alllibrarian(){
        try{
            Connection con = DriverManager.getConnection(url, username, password);
            String sql = "select * from librarian";
            PreparedStatement pst = con.prepareStatement(sql);
            ResultSet result = pst.executeQuery();
            List<LibrarianModel> librarianList = new ArrayList<>();
            while(result.next()){
                LibrarianModel LibrarianModelObj = new LibrarianModel();
                LibrarianModelObj.setLibrarianid(result.getString("id"));
                
                LibrarianModelObj.setLibrarianfirstname(result.getString("firstname"));
                LibrarianModelObj.setLibrarianlastname(result.getString("lastname"));
                LibrarianModelObj.setLibrarianemail(result.getString("email"));
                LibrarianModelObj.setLibrarianaddress(result.getString("address"));
                LibrarianModelObj.setLibrarianpassword(result.getString("password"));
//                LibrarianModelObj.setLibrarianid(result.getString(6));
                librarianList.add(LibrarianModelObj);
            }
            con.close();
            return librarianList;
        }catch(Exception ex){
            ex.printStackTrace();
        }
        return null;
    }
    
}
