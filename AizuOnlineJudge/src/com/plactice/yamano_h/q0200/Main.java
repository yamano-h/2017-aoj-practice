package com.plactice.yamano_h.q0200;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Main {
	/**
	 * 入力の読み取り / 回答の出力を担う
	 */
	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String answer = createFactor(br);

		System.out.println(answer);
	}

	/**
	 * ビジネスロジックへ渡すための要素の取得
	 */
	private static String createFactor(BufferedReader br) {

		String line;
		String[] strs;

		// 問題固有の変数
		int costMatrix[][];
		int timeMatrix[][];
		int countOfLine;
		int countOfStation;
		int stationA;
		int stationB;
		int countOfCall;
		int startStation;
		int goalStation;
		int typeOfOutput;
		int singleAnswer;
		String answer = "";

		try {

			while (!isEndLine(line = br.readLine())) {

				strs = line.split(" ");
				// 線の数、駅の数を定義
				countOfLine = Integer.parseInt(strs[0]);
				countOfStation = Integer.parseInt(strs[1]);

				// マトリックスの行、列数を定義
				costMatrix = new int[countOfLine][countOfStation];
				timeMatrix = new int[countOfLine][countOfStation];

				for (int i = 0; i < countOfLine; i++) {

					line = br.readLine();
					strs = line.split(" ");
					stationA = Integer.parseInt(strs[0]);
					stationB = Integer.parseInt(strs[1]);

					// 価格と時間を入れ込む(配列の基準は０なので-1している)
					costMatrix[stationA - 1][stationB - 1] = Integer.parseInt(strs[2]);
					timeMatrix[stationA - 1][stationB - 1] = Integer.parseInt(strs[3]);

					// 逆経路も同じ値を入れる
					costMatrix[stationB - 1][stationA - 1] = Integer.parseInt(strs[2]);
					timeMatrix[stationB - 1][stationA - 1] = Integer.parseInt(strs[3]);
				}

				// 問い合わせ数を取得
				line = br.readLine();
				countOfCall = Integer.parseInt(line);

				// 問い合わせの数だけループ
				for (int i = 0; i < countOfCall; i++) {

					line = br.readLine();
					strs = line.split(" ");

					startStation = Integer.parseInt(strs[0]);
					goalStation = Integer.parseInt(strs[1]);
					typeOfOutput = Integer.parseInt(strs[2]);

					if (typeOfOutput == 0) {

						singleAnswer = getMinimumCost(0, 0, startStation, goalStation, costMatrix, costMatrix);
					} else {

					}
				}

			}

			return line;

		} catch (IOException e) {

			e.printStackTrace();
			return null;
		}
	}

	/**
	 * 最安値を取得するメソッド
	 */
	private static int getMinimumCost(int minCost, int cost, int startStation, int goalStation, int[][] costMatrix,
			int[][] tmpMatrix) {

		if (startStation == goalStation) {
			if (cost < minCost) {
				minCost = cost;
			}
			// 行列を初期化
			costMatrix = tmpMatrix;
			return minCost;
		}

		// 列の数だけループ
		for (int i = 0; i < costMatrix[0].length; i++) {

			// 行列に値が正なら
			if (costMatrix[startStation - 1][i] > 0) {
				// コスト足す
				cost += costMatrix[startStation - 1][i];
				// その値と対の値を０にする
				costMatrix[startStation - 1][i] = 0;
				costMatrix[i][startStation - 1] = 0;
				// 再度関数呼ぶ
				startStation = i + 1; // 配列は０スタートなので１タス
				minCost = getMinimumCost(minCost, cost, startStation, goalStation, costMatrix, tmpMatrix);
			}
		}
		return minCost;
	}

	/**
	 * 終了条件を判断する
	 */
	private static boolean isEndLine(String line) {
		return line.equals("0 0");
	}

}
