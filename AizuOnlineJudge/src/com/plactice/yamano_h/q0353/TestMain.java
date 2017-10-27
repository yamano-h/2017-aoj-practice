package com.plactice.yamano_h.q0353;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Objects;

import org.junit.Test;

public class TestMain {
	@Test
	public void testMain() throws Exception {
		System.out.println("AA");
//		Main.main(null);
		try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            String line;
           
            while(!isEndLine(line = br.readLine())){
            		System.out.println(line);
            }
            System.out.println("fin");
            
        } catch (Exception e) {
            e.printStackTrace();
        }
	}
	private static boolean isEndLine(String line) {
		return Objects.isNull(line);
	}
}
