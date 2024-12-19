/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package B21DCCN003;

import vn.medianews.*;
import java.util.*;

public class CharacterSV_SapXepChuoiTheoDoDai {
    public static void main(String[] args) throws Exception{
        String studentCode = "B21DCCN003", qCode = "mpu9xCxR";
        
        CharacterService_Service service = new CharacterService_Service();
        CharacterService port = service.getCharacterServicePort();
        
        List<String> data = port.requestStringArray(studentCode, qCode);
        
        System.out.println(data);
        
        Collections.sort(data, Comparator.comparingInt(String::length));
        
        port.submitCharacterStringArray(studentCode, qCode, data);
        
    }
}
