/*
b. 
Mã Hoá Base64
Thực hiện thao tác mã hóa Base64 cho chuỗi đầu vào nhận được từ server. Mã hóa Base64 chuyển đổi chuỗi nhị phân thành định dạng văn bản ASCII bằng cách mã hóa mỗi nhóm 6 bit của chuỗi thành một ký tự.
Ví dụ: Chuỗi ban đầu "HELLO" -> Chuỗi mã hóa Base64 là: "SEVMTE8="
c. Triệu gọi phương thức submitCharacter để gửi chuỗi đã được mã hóa trở lại server.
d. Kết thúc chương trình client.

Code:
// Mã hóa chuỗi bằng Base64
        String encodedString = Base64.getEncoder().encodeToString(input.getBytes());
        System.out.println("Encoded Base64 string: " + encodedString);
*/

/*

b. 
Mã Hoá Caesar
Thực hiện mã hóa Caesar cho mảng dữ liệu nhị phân bằng cách dịch chuyển mỗi byte trong mảng đi một số bước cố định trong bảng mã ASCII. Số bước dịch chuyển là số ký tự ASCII trong mảng dữ liệu.
    Ví dụ: Nếu dữ liệu nhị phân nhận được là [72, 101, 108, 108, 111] (tương ứng với chuỗi "Hello"), chương trình sẽ thực hiện mã hóa Caesar với độ dịch là 5. Kết quả mã hóa là mảng [77, 108, 113, 113, 116], tương ứng với chuỗi "Mlqqt".

Code:

// Tính độ dịch Caesar (số bước dịch = số ký tự trong mảng)
        int shift = data.length;

        // Thực hiện mã hóa Caesar
        byte[] encodedData = new byte[data.length];
        for (int i = 0; i < data.length; i++) {
            encodedData[i] = (byte) ((data[i] + shift) % 256); // Dịch chuyển và giữ trong giới hạn byte
        }
        System.out.println("Encoded data (ASCII): " + new String(encodedData));
*/

/*
MaHoa_RLE
b. Thực hiện nén dữ liệu sử dụng thuật toán Run-Length Encoding (RLE) bằng cách ghi nhận mỗi byte và số lần lặp liên tiếp của nó. Kết quả nén là một mảng mới biểu diễn các cặp (byte, số lần lặp).
Ví dụ: Nếu dữ liệu byte nhận được là [10, 10, 10, 20, 20, 30, 30, 30, 30], chương trình sẽ thực hiện nén RLE như sau:
    Kết quả nén RLE là mảng [10, 3, 20, 2, 30, 4].
Code:
List<Byte> compressedList = new ArrayList<>();
        for(int i = 0; i < data.length; ) {
            byte curByte = data[i];
            int coun = 1;
            while(i + coun < data.length && data[i + coun] == curByte) {
                coun++;
            }
            compressedList.add(curByte);
            compressedList.add(Byte.parseByte(coun + ""));
            i += coun;
        }
        byte[] compressed = new byte[compressedList.size()];
        for(int i = 0; i < compressed.length; i++) {
            compressed[i] = compressedList.get(i);
        }
 */

/*
DecimalToRoman - Chuyển xuoi
Code:
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
RomanToDecimal - Chuyển ngược
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

 */

 /*
MaHoaURL
Code:
String encode = URLEncoder.encode(inp, "UTF-8");
  */

/*
GiaiMaBase64
Code:
byte[] decode = Base64.getDecoder().decode(encode);
 */

 /*
GiaiMaCaesar
Code:
// giai ma: - shift
        String ans = "";
        for(Character c : inp.toCharArray()) {
            char base = Character.isLowerCase(c) ? 'a' : 'A';
            char x = (char) ((c - base - shift + 26) % 26 + base);
            ans += x;
        }
  */

/*
XOR_PTIT
Code:
byte[] encodeData = new byte[data.length];
        byte[] keyBytes = "PTIT".getBytes();
        
        for(int i = 0; i < data.length; i++) {
            encodeData[i] = (byte) (data[i] ^ keyBytes[i % keyBytes.length]);
        }   
 */

 /*
MaHoaVigerene:
Code:
// Mã hóa Vigenère
        String encryptedString = "";
        
        for(int i = 0, j = 0; i < text.length(); i++) {
            char c = text.charAt(i);
            if(Character.isLetter(c)) {
                char keyChar = keyword.charAt(j % keyword.length());
                int shift = keyChar - 'a';
                char base = Character.isUpperCase(c) ? 'A' : 'a';
                encryptedString += (char) ((c - base + shift) % 26 + base);
                j++;
            } else {
                encryptedString += c;
            }
        }
  */

/*
ChuyenDoiHexa
Code:
    String ans = "";
    for(byte c : data) {
        ans += String.format("%02x", c);
    }
*/
