package RMI.B21DCCN012;

import java.net.URLEncoder;
import java.rmi.registry.*;
import RMI.CharacterService;

public class Character_URLEncode {
    public static void main(String[] args) throws Exception {
        // Kết nối tới Registry và lấy đối tượng từ xa
        Registry reg = LocateRegistry.getRegistry("203.162.10.109", 1099);
        CharacterService sv = (CharacterService) reg.lookup("RMICharacterService");

        // Thông tin sinh viên và mã câu hỏi
        String studentCode = "B21DCCN012", qCode = "sqIYe0Jb";

        // Nhận chuỗi ngẫu nhiên từ server
        String input = sv.requestCharacter(studentCode, qCode);
        System.out.println("Received data: " + input);

        // Thực hiện mã hóa URL
        String urlEncoded = URLEncoder.encode(input, "UTF-8");
        System.out.println("URL Encoded: " + urlEncoded);

        // Gửi chuỗi đã được mã hóa về server
        sv.submitCharacter(studentCode, qCode, urlEncoded);
        System.out.println("Result submitted successfully.");
    }
}
