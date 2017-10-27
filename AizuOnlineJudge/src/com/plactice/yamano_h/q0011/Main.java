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

		// startNumberはsideNode（横線の端）との比較用に1から始める
		for (int startNumber = 1; startNumber < goalNumberList.size() + 1; startNumber++) {

			int goalNumber = startNumber;

			for (int j = 0; j < allSideLine.size(); j++) {

				int sideNode_1 = Integer.parseInt(allSideLine.get(j).get(0));
				int sideNode_2 = Integer.parseInt(allSideLine.get(j).get(1));

				if (sideNode_1 == goalNumber) {
					goalNumber = sideNode_2;
				} else if (sideNode_2 == goalNumber) {
					goalNumber = sideNode_1;
				}
			}

			//例えば１→３に移動したら、リストの２（3-1）番目の要素に１を入れる
			goalNumberList.set(goalNumber - 1, String.valueOf(startNumber));
		}

		return goalNumberList;
	}
}
