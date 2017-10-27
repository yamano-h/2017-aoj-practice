package com.plactice.yamano_h.q0353;

import java.io.BufferedReader;
import java.io.InputStreamReader;

class Main {
	/**
	 * 入力の読み取り / 回答の出力を担う
	 */
	public static void main(String[] args) throws Exception {

		// 入力読み込み
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int factorCount = Integer.parseInt(br.readLine());
		String[] factorList = br.readLine().split(" ");

		int sortCount = processSortCount(factorCount, factorList);
		
		System.out.println(sortCount);
	}

	public static int processSortCount(int factorCount, String[] factorList) {
		String tmp = null;
		int sortCount = 0;

		// i番目とi + 1番目の中身を比較するため、０〜factorCount - 1 までループ
		for (int i = 0; i < factorCount - 1; i++) {

			if (Integer.parseInt(factorList[i]) > Integer.parseInt(factorList[i + 1])) {

				tmp = factorList[i];
				lshift(factorList, i + 1);
				factorList[factorCount - 1] = tmp;

				sortCount++;
				// ループをリセット
				i = -1;
			}
		}
		return sortCount;
	}

	/**
	 * 配列の指定した箇所から右の全要素を左に一つずつずらすメソッド
	 */
	public static void lshift(String[] list, int n) {
		for (int i = n; i < list.length; i++) {
			list[i - 1] = list[i];
		}
	}
}
