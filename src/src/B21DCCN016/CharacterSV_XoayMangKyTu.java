
import vn.medianews.*;
import java.util.*;

public class CharacterSV_XoayMangKyTu {

    public static void main(String[] args) throws Exception {
        String msv = "B21DCCN016", qCode = "YDcPHFgN";
        CharacterService_Service service = new CharacterService_Service();
        CharacterService port = service.getCharacterServicePort();
        List<Integer> a = port.requestCharacter(msv, qCode);
        System.out.println(a);

        int shift = a.get(0) % (a.size());
        Collections.rotate(a, shift);

        port.submitCharacterCharArray(msv, qCode, a);
    }
}
