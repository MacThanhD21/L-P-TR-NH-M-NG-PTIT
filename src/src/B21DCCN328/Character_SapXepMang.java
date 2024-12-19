/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package B21DCCN328;

import vn.medianews.*;
import java.util.*;

public class Character_SapXepMang {
    public static void main(String[] args) throws Exception{
        String msv = "B21DCCN328", qCode = "fts8gYFP";
        CharacterService_Service sv = new CharacterService_Service();
        CharacterService port = sv.getCharacterServicePort();
        
        List<Integer> inp = (List<Integer>) port.requestCharacter(msv, qCode);
        System.out.println(inp);
        Collections.sort(inp);
        
        port.submitCharacterCharArray(msv, qCode, inp);
    }
}
