package B21DCCN016;

import vn.medianews.*;
import java.util.*;
import java.time.*;
import javax.xml.datatype.XMLGregorianCalendar;

public class Object_ListOrderY {

    public static void main(String[] args) throws Exception {
        String msv = "B21DCCN016", qCode = "SEfcXj6u";

        ObjectService_Service sv = new ObjectService_Service();
        ObjectService port = sv.getObjectServicePort();

        List<OrderY> orderList = port.requestListOrderY(msv, qCode);
        System.out.println("Danh sách đơn hàng nhận được: ");
        for (OrderY order : orderList) {
            System.out.println(order);
        }
        System.out.println();

        LocalDate today = LocalDate.now();

        List<OrderY> priorityOrders = new ArrayList<>();
        
        for (OrderY order : orderList) {
            LocalDate orderDate = toLocalDate(order.getOrderDate());

            if ((order.getStatus().equals("pending") || order.getStatus().equals("processing")) &&
                orderDate.isBefore(today.minusDays(30))) {
                priorityOrders.add(order); // Thêm vào danh sách ưu tiên Thanhviet
            }
        }

        System.out.println("Danh sách đơn hàng cần ưu tiên xử lý: ");
        for (OrderY order : priorityOrders) {
            System.out.println(order);
        }

        port.submitListOrderY(msv, qCode, priorityOrders);
    }

    private static LocalDate toLocalDate(XMLGregorianCalendar calendar) {
        return calendar.toGregorianCalendar().toZonedDateTime().toLocalDate();
    }
}
