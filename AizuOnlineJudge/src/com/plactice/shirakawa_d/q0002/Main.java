package com.plactice.shirakawa_d.q0002;

import java.io.*;

/**
 * 2つの整数の入力 "a b" に対し、(a + b)の桁数を出力します。
 * (0 ≤ a, b ≤ 1,000,000)
 * 
 * (ex)
 * 1 1 -> 1
 * 1 9 -> 2
 * 50 50 -> 3
 * 
 * @author shirakawa_d
 */
class Main {
    public static void main(String[] args) {
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

            String line;
            while ((line = br.readLine()) != null) {
                System.out.println(getDigitOf(line));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * @param line
     *            2つの整数の入力 "a b"
     * @return (a+b)の桁数
     */
    private static long getDigitOf(String line) {
        String[] strs = line.split(" ");

        long a = Long.parseLong(strs[0]);
        long b = Long.parseLong(strs[1]);
        long sum = a + b;

        return String.valueOf(sum).length();
    }
}
