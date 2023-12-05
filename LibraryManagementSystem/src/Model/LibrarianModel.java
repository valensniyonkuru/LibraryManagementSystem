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
public class LibrarianModel {
    private String librarianid;
    private String librarianfirstname;
     private String librarianlastname;
      private String librarianemail;
       private String librarianaddress;
        private String librarianpassword;

    public LibrarianModel() {
    }

    public LibrarianModel(String librarianid, String librarianfirstname, String librarianlastname, String librarianemail, String librarianaddress, String librarianpassword) {
        this.librarianid = librarianid;
        this.librarianfirstname = librarianfirstname;
        this.librarianlastname = librarianlastname;
        this.librarianemail = librarianemail;
        this.librarianaddress = librarianaddress;
        this.librarianpassword = librarianpassword;
    }

    public String getLibrarianid() {
        return librarianid;
    }

    public void setLibrarianid(String librarianid) {
        this.librarianid = librarianid;
    }

    public String getLibrarianfirstname() {
        return librarianfirstname;
    }

    public void setLibrarianfirstname(String librarianfirstname) {
        this.librarianfirstname = librarianfirstname;
    }

    public String getLibrarianlastname() {
        return librarianlastname;
    }

    public void setLibrarianlastname(String librarianlastname) {
        this.librarianlastname = librarianlastname;
    }

    public String getLibrarianemail() {
        return librarianemail;
    }

    public void setLibrarianemail(String librarianemail) {
        this.librarianemail = librarianemail;
    }

    public String getLibrarianaddress() {
        return librarianaddress;
    }

    public void setLibrarianaddress(String librarianaddress) {
        this.librarianaddress = librarianaddress;
    }

    public String getLibrarianpassword() {
        return librarianpassword;
    }

    public void setLibrarianpassword(String librarianpassword) {
        this.librarianpassword = librarianpassword;
    }
         
    
}
