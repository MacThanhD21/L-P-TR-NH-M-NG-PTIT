/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package B21DCCN002;

import vn.medianews.*;
import java.util.*;

public class Object_ProductY {

    public static void main(String[] args) throws Exception {
        String msv = "B21DCCN002", qCode = "itT8hvxF";
        ObjectService_Service sv = new ObjectService_Service();
        ObjectService port = sv.getObjectServicePort();

        ProductY y = (ProductY) port.requestProductY(msv, qCode);
        System.out.println(y);

        float price = y.getPrice(), taxRate = y.getTaxRate(), disCount = y.getDiscount();
        float finaly = price * (1 + taxRate / 100) * (1 - disCount / 100);
        y.setFinalPrice(finaly);
        port.submitProductY(msv, qCode, y);
    }
}
