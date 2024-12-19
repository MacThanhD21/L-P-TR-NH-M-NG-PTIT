package RMI.B21DCCN010;

import java.rmi.registry.*;
import RMI.CharacterService;
import java.util.Base64;

public class Character_MaHoaBase64 {
    public static void main(String[] args) throws Exception {
        // Kết nối tới Registry và lấy đối tượng từ xa
        Registry reg = LocateRegistry.getRegistry("203.162.10.109", 1099);
        CharacterService sv = (CharacterService) reg.lookup("RMICharacterService");

        // Thông tin sinh viên và mã câu hỏi
        String studentCode = "B21DCCN010", qCode = "NEhEJ1si";

        // Triệu gọi requestCharacter để nhận chuỗi đầu vào
        String inputString = sv.requestCharacter(studentCode, qCode);
        System.out.println("Input string: " + inputString);

        // Thực hiện mã hóa Base64
        String ans = Base64.getEncoder().encodeToString(inputString.getBytes());

        // Triệu gọi submitCharacter để gửi chuỗi đã mã hóa về server
        sv.submitCharacter(studentCode, qCode, ans);
        System.out.println("Data submitted successfully.");
    }
}
