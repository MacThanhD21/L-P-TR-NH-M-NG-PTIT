package RMI.B21DCCN008;

import java.rmi.registry.*;
import java.util.*;
import RMI.DataService;

public class Data_PalindromeNumber {

    public static void main(String[] args) throws Exception {
        Registry reg = LocateRegistry.getRegistry("203.162.10.109", 1099);
        DataService sv = (DataService) reg.lookup("RMIDataService");

        String msv = "B21DCCN008", qCode = "Rmf51BQm";
        String[] inp = ((String) sv.requestData(msv, qCode)).split("; ");

        int N = Integer.parseInt(inp[0]);
        int K = Integer.parseInt(inp[1]);

        System.out.println(N + " " + K);
        List<Integer> ans = new ArrayList<>();

        for (int i = N; i <= K; i++) {
            if (isPalindrome(i)) {
                ans.add(i);

            }
        }
        System.out.println(ans);
        sv.submitData(msv, qCode, ans);
    }

    public static boolean isPalindrome(int x) {
        String res = x + "";
        int n = res.length();
        for (int i = 0; i < n / 2; i++) {
            if (res.charAt(i) != res.charAt(n - 1 - i)) {
                return false;
            }
        }
        return true;
    }
}
