package B21DCCN008;

import vn.medianews.*;
import java.util.*;

public class Character_LoaiBoKyTuDacBiet_VaDaoNguocChuoi {
    public static void main(String[] args) throws Exception{
        String msv = "B21DCCN008", qCode = "rT6Ql5GH";
        CharacterService_Service sv = new CharacterService_Service();
        CharacterService port = sv.getCharacterServicePort();
        
        String inp = port.requestString(msv, qCode);
        System.out.println(inp);
        
        StringBuilder ans = new StringBuilder();
        for(char c : inp.toCharArray()) {
            if(Character.isLetter(c)) {
                ans.append(c);
            }
        }
        port.submitCharacterString(msv, qCode, ans.reverse().toString());
    }
}
