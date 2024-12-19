/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package B21DCCN010;

import vn.medianews.*;
import java.util.*;

public class Character_LongestShortestString {
    public static void main(String[] args) throws Exception{
        String msv = "B21DCCN010", qCode = "sGJc3iD5";
        
        CharacterService_Service sv = new CharacterService_Service();
        CharacterService port = sv.getCharacterServicePort();
        
        List<String> a = port.requestStringArray(msv, qCode);
        System.out.println(a);
        
        Collections.sort(a, Comparator.comparing(String::length));
        String ans = a.get(a.size() - 1) + ";" + a.get(0);
        
        port.submitCharacterString(msv, qCode, ans);
        
    }
}
