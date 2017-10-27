package com.plactice.yamano_h.q0011;

import java.io.BufferedReader;
import java.io.Reader;
import java.io.StringReader;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;

import com.plactice.yamano_h.q0011.Main;

public class TestMain {
	@Test
	public void testMain() throws Exception {
//		Main.main(null);
		
		//test1
		String str = "4\n"
				+ "2,4\n"
				+ "3,5\n"
				+ "1,2\n"
				+ "3,4\n";
		Reader reader = new StringReader(str);
		BufferedReader br = new BufferedReader(reader);
		System.out.println(Main.processAllSideLine(br));
		
		//test2
		String[] verticalLine = new String[5];
		List<String> goalNumberList = Arrays.asList(verticalLine);
		
		System.out.println(goalNumberList);
		
		//test3
		reader = new StringReader(str);
		br = new BufferedReader(reader);
		List<List<String>> allSideLine = Main.processAllSideLine(br);
		
		goalNumberList = Main.processGoalNumberList(goalNumberList, allSideLine);
		
		System.out.println(goalNumberList);
	}
}
