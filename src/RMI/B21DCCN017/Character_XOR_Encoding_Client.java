/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package RMI.B21DCCN017;


import java.rmi.registry.*;
import RMI.CharacterService;

public class Character_XOR_Encoding_Client {
    public static void main(String[] args) throws Exception{
        Registry reg = LocateRegistry.getRegistry("203.162.10.109", 1099);
        CharacterService sv = (CharacterService) reg.lookup("RMICharacterService");
        
        String studentCode = "B21DCCN017", qCode = "wwM2zzBi";
        
        String inp[] = sv.requestCharacter(studentCode, qCode).split(";");
        System.out.println(inp);
        
        String key = inp[0];
        String data = inp[1];
        
        String result = "";
        for(int i = 0; i < data.length(); i++) {
            char xorChar = key.charAt(i % key.length());
            result += (char)(data.charAt(i) ^ xorChar);
        }
        System.out.println(result);
        sv.submitCharacter(studentCode, qCode, result);
    }
}
