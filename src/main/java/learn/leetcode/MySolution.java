package learn.leetcode;

import java.util.Arrays;
import java.util.Collections;

public class MySolution {
    public String multiply(String num1, String num2) {
        if (num1.equals("0") || num2.equals("0")) {
            return "0";
        }
        int[] res = new int[num1.length() + num2.length()];

        for (int i = num1.length() - 1; i >= 0; i--) {
            int n1 = num1.charAt(i) - '0';

            for (int j = num2.length() - 1; j >=0 ; j--) {
                int n2 = num2.charAt(j) - '0';

                int temp = res[i + j + 1] + n1 * n2;
                res[i+j+1] = temp % 10;
                res[i+j] += temp / 10;
            }
        }

        StringBuilder result = new StringBuilder();
        for (int i = 0; i< res.length ; i++) {
            if (i==0 && res[i] == 0)
                continue;
            else
                result.append(res[i]);
        }
        return result.toString();
    }

    public static void main(String[] args) {
        String s1 = "123";
        String s2 = "456";
        int[] ints = {10,9,8,7,6,5,4,3,2,1};
        Arrays.sort(ints);
        System.out.println(Arrays.toString(ints));
//        System.out.println("resut:" + new MySolution().multiply(s1, s2) + "|end");
    }

}
