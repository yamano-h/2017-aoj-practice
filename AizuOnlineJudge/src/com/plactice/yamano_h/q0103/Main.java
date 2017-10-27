package com.plactice.yamano_h.q0103;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
class Main {
    /**
     * 入力の読み取り / 回答の出力を担う
     */
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        List<String> answer = processAllInning(br);
        for (String inningScore : answer) {
            System.out.println(inningScore);
        }
    }
    /**
     * 全てのスコアを取得するメソッド
     */
    private static List<String> processAllInning(BufferedReader br) throws Exception {
        List<String> allInningResult = new ArrayList<>(); // 最後に出す全てのスコア
        int maxInning; // イニング数
        int currentIning = 0; // 今のイニング
        int outCount = 0;
        int runnerCount = 0; // ランナーの数
        int inningScore = 0; // 各イニングのスコア
        // 最初にイニング数を取り出す
        maxInning = Integer.parseInt(br.readLine());
        String command;
        while (!isEndLine(command = br.readLine())) {
            switch (command) {
            case "HIT":
                if (runnerCount < 3) {
                    runnerCount++;
                } else {
                    inningScore++;
                }
                break;
            case "HOMERUN":
                // ホームランで何点入ったかを計算する
                inningScore += runnerCount + 1;
                runnerCount = 0;
                break;
            case "OUT":
                // アウトなので１足す
                outCount++;
                break;
            default:
                // 他の入力は無い
            }
            if (outCount == 3) {
                allInningResult.add(String.valueOf(inningScore));
                // アウトカウントとランナーとスコアを０,イニングは進める
                outCount = 0;
                runnerCount = 0;
                inningScore = 0;
                currentIning++;
            }
            if (maxInning == currentIning) {
                // 最終イニングであれば最終結果取り出し
                return allInningResult;
            }
        }
        throw new RuntimeException(
                String.format("異常な結果になりました。[maxInning: %d, currentInning: %d]", maxInning, currentIning));
    }
    /**
     * 終了条件を判断する
     */
    private static boolean isEndLine(String line) {
        return Objects.isNull(line);
    }
}
