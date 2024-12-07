package RMI.B21DCCN677;

import java.rmi.*;
import java.rmi.registry.*;
import RMI.CharacterService;

public class Character_RomanConverter {

    public static void main(String[] args) throws Exception {
        // Kết nối đến Registry Server
        Registry registry = LocateRegistry.getRegistry("203.162.10.109", 1099);
        CharacterService service = (CharacterService) registry.lookup("RMICharacterService");

        // Nhận chuỗi số thập phân từ server
        String studentCode = "B21DCCN677";
        String qCode = "ZBeUaQbZ";
        String decimalInput = service.requestCharacter(studentCode, qCode);
        System.out.println("Decimal input received: " + decimalInput);

        // Chuyển đổi từ số thập phân sang số La Mã
        int decimalNumber = Integer.parseInt(decimalInput.trim());
        String romanNumber = convertToRoman(decimalNumber);
        System.out.println("Converted to Roman: " + romanNumber);

        // Gửi chuỗi số La Mã đã chuyển đổi về server
        service.submitCharacter(studentCode, qCode, romanNumber);

        System.out.println("Roman number sent to server successfully.");
    }

    // Hàm chuyển đổi số thập phân sang số La Mã
    public static String convertToRoman(int num) {
        // Bảng quy tắc chuyển đổi từ số sang số La Mã
        int[] values = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        String[] symbols = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};

        StringBuilder roman = new StringBuilder();

        for (int i = 0; i < values.length; i++) {

            if (num > 0) {
                while (num >= values[i]) {
                    roman.append(symbols[i]);
                    num -= values[i];
                }
            }

        }
        return roman.toString();
    }
}
