/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package B21DCCN023;

import java.util.*;
import vn.medianews.*;

public class Object_ProductY {

    public static void main(String[] args) throws Exception {
        String msv = "B21DCCN023", qCode = "BBFTn6il";

        ObjectService_Service sv = new ObjectService_Service();
        ObjectService port = sv.getObjectServicePort();

        ProductY x = (ProductY) port.requestProductY(msv, qCode);
        System.out.println(x);

        float final_Price = (float) (x.getPrice() * (1 + x.getTaxRate() / 100.0) * (1 - x.getDiscount() / 100.0));
        x.setFinalPrice(final_Price);
        System.out.println(final_Price);

        port.submitProductY(msv, qCode, x);
    }
}
