package com.plactice.template;

import java.io.*;

class Main {
    public static void main(String[] args) {
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));// 入力を読むのに必要
            String line = br.readLine();
            System.out.println(line);

            // ↓ループする場合の例
            // String line; // 入力された各行が入る
            // while ((line = br.readLine()) != null) {
            // processLine(line);
            // }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // private static void processLine(String line) {
    // System.out.println(line);
    // }
}
