/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package RMI.B21DCCN004;

import java.rmi.registry.*;
import java.util.*;
import RMI.DataService;

public class Data_TinhPhuongSaiVaDoLechChuan {

    public static void main(String[] args) throws Exception {
        Registry reg = LocateRegistry.getRegistry("203.162.10.109", 1099);
        DataService sv = (DataService) reg.lookup("RMIDataService");

        String studentCode = "B21DCCN004", qCode = "Dc7FfKzk";
        String[] inp = ((String) sv.requestData(studentCode, qCode)).split(", ");

//        System.out.println(inp);
        List<Double> data = new ArrayList<>();

        for (String x : inp) {
            data.add(Double.parseDouble(x));
        }
        double sum = 0.0, sumOfSquares = 0.0, mean = 0.0, variance = 0.0, stdDev = 0.0;
        for (Double x : data) {
            sum += x;
            sumOfSquares += x * x;
        }

        mean = sum / data.size();
        variance = ((sumOfSquares / data.size()) - (mean * mean));
        stdDev = Math.sqrt(variance);

        variance = Math.round(variance * 100.0) / 100.0;
        stdDev = Math.round(stdDev * 100.0) / 100.0;

        String result = variance + " : " + stdDev;
        System.out.println(result);

        System.out.println(data);
        sv.submitData(studentCode, qCode, result);

    }
}
