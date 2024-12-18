package RMI.B21DCCN014;

import java.rmi.registry.*;
import RMI.CharacterService;

public class Character_MaHoaVigerene {

    public static void main(String[] args) throws Exception {
        // Kết nối tới RMI Registry trên server
        Registry reg = LocateRegistry.getRegistry("203.162.10.109", 1099);
        CharacterService sv = (CharacterService) reg.lookup("RMICharacterService");

        // Thông tin sinh viên và mã câu hỏi
        String studentCode = "B21DCCN014", qCode = "4JvGeGEq";

        // Triệu gọi phương thức requestCharacter để lấy chuỗi từ server
        String inp = sv.requestCharacter(studentCode, qCode);

        String[] parts = inp.split(";");
        String keyword = parts[0];
        String text = parts[1];

        String ans = "";
        
        for(int i = 0, j = 0; i < text.length(); i++) {
            char c = text.charAt(i);
            char keyChar = keyword.charAt(j % keyword.length());
            
            int shift = keyChar - 'a';
            char base = Character.isUpperCase(c) ? 'A' : 'a';
            ans += (char) ((c - base + shift) % 26 + base);
            j++;
        }

        System.out.println(ans);

        // Gửi chuỗi đã mã hóa trở lại server
        sv.submitCharacter(studentCode, qCode, ans);
    }
}
