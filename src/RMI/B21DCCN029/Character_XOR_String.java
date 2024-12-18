/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package RMI.B21DCCN029;

import java.rmi.registry.*;
import java.util.*;
import RMI.CharacterService;

public class Character_XOR_String {
    public static void main(String[] args) throws Exception{
        CharacterService sv = (CharacterService) LocateRegistry.getRegistry("203.162.10.109", 1099).lookup("RMICharacterService");
        
        String msv = "B21DCCN029", qCode = "jYXzshII";
        String[] inp = sv.requestCharacter(msv, qCode).split(";");
        
        String key = inp[0];
        String s = inp[1];
        
        String ans = "";
        
        for(int i = 0; i < s.length(); i++) {
            ans += (char) (s.charAt(i) ^ (key.charAt(i % key.length())));
        }
        sv.submitCharacter(msv, qCode, ans);
    }
}
