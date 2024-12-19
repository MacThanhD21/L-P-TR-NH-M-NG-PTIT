import vn.medianews.*;
import java.util.*;

public class DataSV_MaxNumber {

    public static void main(String[] args) throws Exception {
        String studentCode = "B21DCCN008", qCode = "7w1nfCSP";
        
        DataService_Service service = new DataService_Service();
        DataService port = service.getDataServicePort();
        
        List<Integer> a = port.getData(studentCode, qCode);
        
        List<String> res = new ArrayList<>();
        
        for(int x : a) {
            res.add(x + "");
        }
        
        res.sort((x, y) -> (y + x).compareTo(x + y));
        
        String ans = "";
        for(String x : res) {
            ans += x;
        }

        port.submitDataString(studentCode, qCode, ans);
    }
}

/*
[Mã câu hỏi (qCode): RiRH8wfk].  Một dịch vụ web được định nghĩa và mô tả trong tệp DataService?wsdl, được triển khai trên server tại URL http://<Exam_IP>:8080/JNPWS/DataService?wsdl để xử lý các bài toán với dữ liệu nguyên thủy.
Yêu cầu: Viết chương trình tại máy trạm (WS client) để giao tiếp với DataService thực hiện các công việc sau:
a. Triệu gọi phương thức getData với tham số đầu vào là mã sinh viên (studentCode) và mã câu hỏi (qCode) để nhận về một danh sách số nguyên (List<Integer>) từ server.
    Ví dụ: 7602,9136,1090,34319,7830,6179,10584,20166,28199,30250,32179,22544,3222,10320,30590,19279
b. Thực hiện tìm số lớn nhất có thể tạo dược từ a,b,c,d...
c. Triệu gọi phương thức submitDataString(String studentCode, String qCode, String data) để gửi kết quả tổng đã tính được trở lại server.
    Ví dụ: 91367830760261793431932223217930590302502819922544201661927910901058410320
d. Kết thúc chương trình client.
*/