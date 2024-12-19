package B21DCCN001;

import java.util.*;
import vn.medianews.*;

public class Object_ListStudent {

    public static void main(String[] args) throws Exception {
        String msv = "B21DCCN001", qCode = "2RjVBzv0";
        ObjectService_Service sv = new ObjectService_Service();
        ObjectService port = sv.getObjectServicePort();

        List<StudentY> res = (List<StudentY>) port.requestListStudentY(msv, qCode);
        for (StudentY x : res) {
            System.out.println(x);
        }
        // Lưu key: Tên môn học, value: điểm cao nhất của môn học đó
        Map<String, Float> mp = new HashMap<>();
        for (StudentY x : res) {
            String mon = x.getSubject();
            Float diemSub = x.getScore();
            if ((!mp.containsKey(mon)) || (diemSub > mp.get(mon))) {
                mp.put(mon, diemSub);
            }
        }

        List<StudentY> ans = new ArrayList<>();
        for (StudentY x : res) {
            if (mp.values().contains(x.getScore())) {
                ans.add(x);
            }
        }
        port.submitListStudentY(msv, qCode, ans);
    }
}
