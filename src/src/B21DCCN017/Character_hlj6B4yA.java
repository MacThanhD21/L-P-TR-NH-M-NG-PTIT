/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package B21DCCN017;

import vn.medianews.*;
import java.util.*;

public class Character_hlj6B4yA {
    public static void main(String[] args) throws Exception{
        String msv = "B21DCCN017", qCode = "hlj6B4yA";
        
        CharacterService_Service sv = new CharacterService_Service();
        CharacterService port = sv.getCharacterServicePort();
        
        String inp = port.requestString(msv, qCode);
        System.out.println(inp);
        
        StringBuilder sb = new StringBuilder();
        for(char c : inp.toCharArray()) {
            if(Character.isLetter(c)) {
                sb.append(c);
            }
        }
        port.submitCharacterString(msv, qCode, sb.reverse().toString());
    }
}
