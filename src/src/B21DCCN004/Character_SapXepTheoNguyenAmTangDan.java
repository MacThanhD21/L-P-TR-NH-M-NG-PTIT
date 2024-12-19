
package B21DCCN004;

import vn.medianews.*;
import java.util.*;

public class Character_SapXepTheoNguyenAmTangDan {
    public static void main(String[] args) throws Exception{
        String msv = "B21DCCN004", qCode = "WxxJhGOO";
        
        CharacterService_Service sv = new CharacterService_Service();
        CharacterService port = sv.getCharacterServicePort();
        
        List<String> a = port.requestStringArray(msv, qCode);
        Collections.sort(a, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return count(o1) - count(o2);
            }
            
        });
        port.submitCharacterStringArray(msv, qCode, a);
    }
    public static int count(String x) {
        String nam = "UEOAIueoai";
        int cnt = 0;
        for(char c : x.toCharArray()) {
            if(nam.indexOf(c) != -1) {
                cnt++;
            }
        }
        return cnt;
    }
}
