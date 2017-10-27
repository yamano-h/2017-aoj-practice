package com.plactice.yamano_h.q0011;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Main {
	/**
	 * 入力の読み取り / 回答の出力を担う
	 */
	public static void main(String[] args) throws Exception {

		// 入力読み込み
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int verticalLineCount = Integer.parseInt(br.readLine());
		// サイズ＝縦の棒の数 の配列定義
		String[] verticalLine = new String[verticalLineCount];
		List<String> goalNumberList = Arrays.asList(verticalLine);

		List<List<String>> allSideLine = processAllSideLine(br);

		goalNumberList = processGoalNumberList(goalNumberList, allSideLine);

		// 回答の出力
		for (String string : goalNumberList) {

			System.out.println(string);
		}
	}

	/**
	 * 全ての横棒の先と先が格納された二次元配列を生成する
	 */
	public static List<List<String>> processAllSideLine(BufferedReader br) throws IOException {

		int sideLineCount = Integer.parseInt(br.readLine());
		List<List<String>> allSideLine = new ArrayList<>();

		for (int i = 0; i < sideLineCount; i++) {

			String[] sideLine = br.readLine().split(",");
			List<String> sideLineToList = Arrays.asList(sideLine);
			allSideLine.add(sideLineToList);
		}

		return allSideLine;
	}

	/**
	 * 最終的にスタート時の番号があみだくじでどこにたどり着くかをリストで取り出す
	 */
	public static List<String> processGoalNumberList(List<String> goalNumberList, List<List<String>> allSideLine) {

		for (int startNumber = 0; startNumber < goalNumberList.size(); startNumber++) {

			String goalNumber = String.valueOf(startNumber + 1);

			for (int j = 0; j < allSideLine.size(); j++) {

				String sideNode_1 = allSideLine.get(j).get(0);
				String sideNode_2 = allSideLine.get(j).get(1);

				if (sideNode_1.equals(goalNumber)) {

					goalNumber = sideNode_2;
				} else if (sideNode_2.equals(goalNumber)) {

					goalNumber = sideNode_1;
				}
			}

			goalNumberList.set(Integer.parseInt(goalNumber) - 1, String.valueOf(startNumber + 1));
		}

		return goalNumberList;
	}
}
