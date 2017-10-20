package com.plactice.yamano_h.ITP1_1_B;

import java.io.*;

/**
 * 整数の入力 "x" に対し、xの3乗を出力します。
 * (1 ≤ x ≤ 100)
 * 
 * (ex)
 * 1 -> 1
 * 3 -> 27
 * 100 -> 1000000
 * 
 * @author shirakawa_d
 */
class Main {
    public static void main(String[] args) {
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

            String line = br.readLine();
            System.out.println(getCubicOf(line));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * @param line
     *            整数xの入力
     * @return xの3乗
     */
    private static long getCubicOf(String line) {
        long x = Long.parseLong(line);
        return (long)Math.pow(x, 3);
    }
}
