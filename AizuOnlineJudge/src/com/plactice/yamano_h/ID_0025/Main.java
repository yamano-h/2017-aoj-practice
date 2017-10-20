package com.plactice.yamano_h.ID_0025;

import java.io.*;

class Main {
	public static void main(String[] args) {
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			String line;
			String[] aList = null;
			String[] bList = null;
			int cnt = 0;
			while ((line = br.readLine()) != null) {
				if (cnt == 0) {
					cnt++;
					aList = line.split(" ", 0);
				} else {
					bList = line.split(" ", 0);
					cnt = 0;
					System.out.println(hitAndBlow(aList, bList));
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * @param aList
	 *            bList
	 * 
	 * @return ヒットアンドブローの結果
	 */
	private static String hitAndBlow(String[] aList, String[] bList) {
		int hit = 0;
		int blow = 0;
		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 4; j++) {
				if (Integer.parseInt(aList[i]) == Integer.parseInt(bList[j])) {
					if (i == j) {
						hit++;
					} else {
						blow++;
					}
				}
			}
		}
		return (hit + " " + blow);
	}
}
