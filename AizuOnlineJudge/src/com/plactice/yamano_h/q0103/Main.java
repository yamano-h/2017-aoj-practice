package com.plactice.yamano_h.q0103;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Objects;

class Main {
	/**
	 * 入力の読み取り / 回答の出力を担う
	 */
	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String answer = getScore(br);

		System.out.println(answer);
	}

	/**
	 * 全てのスコアを取得するメソッド
	 */
	private static String getScore(BufferedReader br) {

		String line;
		String allScore = ""; // 最後に出す全てのスコア
		int singleScore = 0; // 各イニングのスコア
		int outCnt = 0;
		int getEning; // イニング数
		int thisEning = 1; // 今のイニング
		int countOfRunner = 0; // ランナーの数

		try {
			// 最初にイニング数を取り出す
			getEning = Integer.parseInt(br.readLine());

			while (!isEndLine(line = br.readLine())) {

				if (line.equals("HIT")) {

					// ランナーを１増やす
					countOfRunner += 1;
					// 今のスコアを計算する
					singleScore = getScore(countOfRunner, singleScore);
					// ランナー数が正しいかチェック
					countOfRunner = chckOfRunner(countOfRunner);

				} else if (line.equals("HOMERUN")) {

					// ホームランで何点入ったかを計算する
					singleScore = getHomerunScore(countOfRunner, singleScore);
					// ランナーを０にリセット
					countOfRunner = 0;

				} else {

					// アウトなので１足す
					outCnt++;
				}

				if (outCnt == 3) {

					if (getEning == thisEning) {// 最終イニングかで分岐

						// 最終行は改行がいらないので別のメソッドで全体のスコア生成
						allScore = createLastScoreLine(singleScore, allScore);

						// 最終結果取り出し
						return allScore;

					} else {

						// ここまでのスコアを一時生成
						allScore = createScoreLine(singleScore, allScore);

						// アウトカウントとランナーとスコアを０,イニングは進める
						outCnt = 0;
						countOfRunner = 0;
						singleScore = 0;
						thisEning++;
					}
				}
			}
			return null;

		} catch (IOException e) {

			e.printStackTrace();
			return null;
		}
	}

	/**
	 * 終了条件を判断する
	 */
	private static boolean isEndLine(String line) {

		return Objects.isNull(line);
	}

	/**
	 * ランナーの数が４以上にならないように調整するメソッド
	 */
	private static int chckOfRunner(int countOfRunner) {

		if (countOfRunner > 3) {
			countOfRunner = 3;
		}
		return countOfRunner;
	}

	/**
	 * ヒット打ったときにスコアを取り出すメソッド
	 */
	private static int getScore(int countOfRunner, int singleScore) {

		// ランナーの数が４ならスコアを１足す
		if (countOfRunner == 4) {
			singleScore++;
		}
		return singleScore;
	}

	/**
	 * ホームラン打ったときにスコアを取り出すメソッド
	 */
	private static int getHomerunScore(int countOfRunner, int singleScore) {

		// ランナーの数に１足したものを今のスコアに加える
		singleScore += countOfRunner + 1;
		return singleScore;
	}

	/**
	 * イニングが終わった際にスコアを出して改行するメソッド
	 */
	private static String createScoreLine(int singleScore, String allScore) {

		allScore += String.valueOf(singleScore) + "\n";

		return allScore;
	}

	/**
	 * ラストイニングが終わった際に改行せずにスコアを出すメソッド
	 */
	private static String createLastScoreLine(int singleScore, String allScore) {

		allScore += String.valueOf(singleScore);

		return allScore;
	}
}
