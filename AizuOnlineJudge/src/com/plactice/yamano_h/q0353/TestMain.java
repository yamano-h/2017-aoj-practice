package com.plactice.yamano_h.q0353;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Objects;

import org.junit.Test;


public class TestMain {
	@Test
	public void testMain() throws Exception {
		System.out.println("AA");

		int[] a = {1, 2, 3, 4, 5};
		int tmp = a[1];
		rshift(a, 2);
		a[4] = tmp;
		for (int i : a) {
			System.out.println(i);
		}
	}
	
	
	void rshift (int[] a, int n) {
		for (int i = n; i < a.length; i++) {
			a[i-1] = a[i];
		}
	}
}