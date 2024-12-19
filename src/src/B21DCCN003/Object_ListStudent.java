/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package B21DCCN003;

import vn.medianews.*;
import java.util.*;

public class Object_ListStudent {

    public static void main(String[] args) throws Exception {
        String msv = "B21DCCN003", qCode = "qNfIMvid";
        ObjectService_Service sv = new ObjectService_Service();
        ObjectService port = sv.getObjectServicePort();
        
        List<Student> data = (List<Student>) port.requestListStudent(msv, qCode);
        System.out.println(data);
        
        List<Student> ans = new ArrayList<>();
        for (Student x : data) {
            if (x.getScore() >= 8.0 || x.getScore() < 5) {
                ans.add(x);
            }
        }
        port.submitListStudent(msv, qCode, ans);
    }
}
