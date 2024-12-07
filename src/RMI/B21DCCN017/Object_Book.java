/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package RMI.B21DCCN017;

import java.rmi.registry.*;
import RMI.Book;
import RMI.ObjectService;

public class Object_Book {
    public static void main(String[] args) throws Exception, ClassNotFoundException{
        Registry reg = LocateRegistry.getRegistry("203.162.10.109", 1099);
        ObjectService sv = (ObjectService) reg.lookup("RMIObjectService");
        
        String studentCode = "B21DCCN017", qAlias = "LhHlJU0E";
        Book x = (Book) sv.requestObject(studentCode, qAlias);
        System.out.println(x);
        
        String code = "";
        String[] author = x.getAuthor().split(" ");
        code += "" + Character.toUpperCase(author[0].charAt(0)) + Character.toUpperCase(author[author.length - 1].charAt(0));
        
        code += (x.getYearPublished() + "").substring(2);
        code += x.getTitle().length();
        String pageCount = x.getPageCount() + "";
        if(pageCount.length() < 3) {
            pageCount = "0" + pageCount;
        }
        code += pageCount;
        System.out.println(code);
        
        x.setCode(code);
        sv.submitObject(studentCode, qAlias, x);
    }
}
