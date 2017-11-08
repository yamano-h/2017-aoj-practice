package com.plactice.yamano_h.q0566;

import java.io.BufferedReader;
import java.io.InputStreamReader;

class Main {
	/**
	 * 入力の読み取り / 回答の出力を担う
	 */
	public static void main(String[] args) throws Exception {

		// 入力読み込み
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int teamNum = Integer.parseInt(br.readLine());
		int gameNum = teamNum * (teamNum - 1) / 2;
		int[] scoreOfAll = new int[teamNum];
		
		for (int i = 0; i < gameNum; i++) {
			String[] readGameInf = br.readLine().split(" ");
			int nameOfTeamA = Integer.parseInt(readGameInf[0]) - 1;
			int nameOfTeamB = Integer.parseInt(readGameInf[1]) - 1;
			int scoreOfTeamA = Integer.parseInt(readGameInf[2]);
			int scoreOfTeamB = Integer.parseInt(readGameInf[3]);
			
			if (scoreOfTeamB < scoreOfTeamA) {
				winGame(scoreOfAll, nameOfTeamA);
			} else if (scoreOfTeamA < scoreOfTeamB) {
				winGame(scoreOfAll, nameOfTeamB);
			} else {
				drawGame(scoreOfAll, nameOfTeamA);
				drawGame(scoreOfAll, nameOfTeamB);
			}
		}
		 
		for (int score : scoreOfAll) {
			int rank = 1;
			rank = processRank(scoreOfAll, score, rank);
			System.out.println(rank);
		}
		
	}


	/**
	 * scoreが全体で何位かを計算するビジネスロジック
	 */
	private static int processRank(int[] scoreOfAll, int score, int rank) {
		for (int compareScore : scoreOfAll) {
			if (score < compareScore) {
				rank += 1;
			}
		}
		return rank;
	}

	/**
	 * @param scoreOfAll:全チームの勝ち点をまとめた配列
	 * @param nameOfTeamA：勝ち点３を加算するチーム
	 */
	private static void winGame(int[] scoreOfAll, int nameOfTeamA) {
		scoreOfAll[nameOfTeamA] += 3;
	}
	
	/**
	 * @param scoreOfAll:全チームの勝ち点をまとめた配列
	 * @param nameOfTeamA：勝ち点1を加算するチーム
	 */
	private static void drawGame(int[] scoreOfAll, int nameOfTeamA) {
		scoreOfAll[nameOfTeamA] += 1;
	}

}
