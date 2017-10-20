package com.plactice.yamano_h.q0006;

import java.io.BufferedReader;
import java.io.InputStreamReader;

class Main {
    /**
     * 入力の読み取り / 回答の出力を担う
     */
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String line = br.readLine();
        //文字列反転ができるStringBufferクラスを使う
        StringBuffer sb = new StringBuffer(line);
        String answer = sb.reverse().toString();
        
        System.out.println(answer);
    }
}
