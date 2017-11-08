package com.plactice.yamano_h.q0544;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Main {
	/**
	 * 入力の読み取り / 回答の出力を担う
	 */
	public static void main(String[] args) throws Exception {

		// 入力読み込み
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		for (;;) {
			String[] readGameInf = br.readLine().split(" ");
			int goalNum = Integer.parseInt(readGameInf[0]);
			int diceCnt = Integer.parseInt(readGameInf[1]);
			int[] sugorokuRule = new int[goalNum];

			if (goalNum == 0) {//終了条件
				break;
			}

			processSetRule(br, goalNum, sugorokuRule);

			int cnt = 0;
			int position = 0;

			for (int i = 0; i < diceCnt; i++) {
				int dice = Integer.parseInt(br.readLine());
				cnt++;
				
				if (position + dice >= goalNum - 1) {
					break;
				} else {
					position += dice + sugorokuRule[position + dice];
				}
				
				if (position >= goalNum - 1) {
					break;
				}
			}

			for (int i = 0; i < diceCnt - cnt; i++) {//残ったサイコロ分を読み捨てる
				br.readLine();
			}

			System.out.println(cnt);
		}
	}

	/**
	 * sugorokuRuleに各マスのルールをセットする
	 */
	private static void processSetRule(BufferedReader br, int goalNum, int[] sugorokuRule) throws IOException {
		for (int i = 0; i < goalNum; i++) {
			int rule = Integer.parseInt(br.readLine());
			sugorokuRule[i] = rule;
		}
	}
}
