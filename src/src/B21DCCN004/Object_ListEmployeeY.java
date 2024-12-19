
import vn.medianews.*;
import java.util.*;

public class Object_ListEmployeeY {

    public static void main(String[] args) throws Exception {
        String msv = "B21DCCN004", qCode = "vewbvojZ";

        ObjectService_Service sv = new ObjectService_Service();
        ObjectService port = sv.getObjectServicePort();

        List<EmployeeY> a = port.requestListEmployeeY(msv, qCode);

        Collections.sort(a, new Comparator<EmployeeY>() {
            @Override
            public int compare(EmployeeY o1, EmployeeY o2) {
                return o1.getStartDate().compare(o2.getStartDate());
            }
        });
        port.submitListEmployeeY(msv, qCode, a);
    }
}
