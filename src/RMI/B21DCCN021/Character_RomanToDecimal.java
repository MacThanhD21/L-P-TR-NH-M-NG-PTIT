package RMI.B21DCCN021;

import java.rmi.registry.*;
import RMI.CharacterService;

public class Character_RomanToDecimal {
    public static void main(String[] args) throws Exception {
        // Kết nối tới RMI Registry và lấy đối tượng CharacterService
        CharacterService sv = (CharacterService) LocateRegistry.getRegistry("203.162.10.109", 1099).lookup("RMICharacterService");

        // Thông tin sinh viên và mã câu hỏi
        String studentCode = "B21DCCN021";
        String qCode = "klyAmvMM";

        // Nhận chuỗi số La Mã từ server
        String romanInput = sv.requestCharacter(studentCode, qCode);
        System.out.println("Received Roman numeral: " + romanInput);

        int ans = 0;
        int preValue = 0;
        for(int i = romanInput.length() - 1; i >= 0; i--) {
            int curVal = romanCharToValue(romanInput.charAt(i));
            if(curVal < preValue) {
                ans -= curVal;
            }
            else {
                ans += curVal;
            }
            preValue = curVal;
        }
        String decimalValue = ans + "";

        // Gửi kết quả số thập phân về server
        sv.submitCharacter(studentCode, qCode, decimalValue);
        System.out.println("Decimal value submitted successfully.");
    }

    public static int romanCharToValue(char c) {
        switch(c) {
            case 'I': return 1;
            case 'V': return 5;
            case 'X': return 10;
            case 'L': return 50;
            case 'C': return 100;
            case 'D': return 500;
            case 'M': return 1000;
            default: return 0;
        }
    }
}
