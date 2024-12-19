/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package B21DCCN018;

import java.util.*;
import vn.medianews.*;

public class Object_ListStudent {
    public static void main(String[] args) throws Exception{
        String msv = "B21DCCN018", qCode = "l0zwbzZJ";
        
        ObjectService_Service sv = new ObjectService_Service();
        ObjectService port = sv.getObjectServicePort();
        
        List<Student> a = port.requestListStudent(msv, qCode);
        System.out.println(a);
        
    }
}
