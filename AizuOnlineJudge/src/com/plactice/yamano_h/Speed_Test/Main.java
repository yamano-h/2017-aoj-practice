package com.plactice.yamano_h.Speed_Test;

class Main {

	public static void main(String[] args) {
		System.out.println("◇配列内の整数[0, 0]を入れ替える際にかかる時間の計測実験");
		exchangeListMeasure(10000);
		exchangeListMeasure(100000);
		exchangeListMeasure(1000000);
		exchangeListMeasure(10000000);

		System.out.println();
		System.out.println("◇int型の変数に1を加えるのにかかる時間の計測");
		IntMeasure(10000);
		IntMeasure(100000);
		IntMeasure(1000000);
		IntMeasure(10000000);

		System.out.println();
		System.out.println("◇Integer型の変数に1を加えるのにかかる時間の計測");
		IntegerMeasure(10000);
		IntegerMeasure(100000);
		IntegerMeasure(1000000);
		IntegerMeasure(10000000);

		System.out.println();
		System.out.println("◇double型の変数に1を加えるのにかかる時間の計測");
		doubleMeasure(10000);
		doubleMeasure(100000);
		doubleMeasure(1000000);
		doubleMeasure(10000000);

		System.out.println();
		System.out.println("◇Double型の変数に1を加えるのにかかる時間の計測");
		DoubleMeasure(10000);
		DoubleMeasure(100000);
		DoubleMeasure(1000000);
		DoubleMeasure(10000000);

	}

	/**
	 * exchengeListを実行した時にかかる時間の計測をするメソッド
	 */
	private static void exchangeListMeasure(int NumOfTime) {
		long start = System.nanoTime();
		exchengeList(NumOfTime);
		long end = System.nanoTime();
		System.out.println("実行時間：" + NumOfTime + "回 → " + (end - start) / 1000000f + "ms");
	}

	/**
	 * @param 任意の型,
	 *            NumOfTime 配列の０番目と１番目を交換するメソッド
	 */
	private static void exchengeList(int NumOfTime) {
		int tmp = 0;
		int[] list = new int[2];
		list[0] = 0;
		list[1] = 0;

		for (int i = 0; i < NumOfTime; i++) {
			tmp = list[0];
			list[0] = list[1];
			list[1] = tmp;
		}
	}

	/**
	 * addIntを実行した時にかかる時間の計測をするメソッド
	 */
	private static void IntMeasure(int NumOfTime) {
		long start = System.nanoTime();
		addInt(NumOfTime);
		long end = System.nanoTime();
		System.out.println("実行時間：" + NumOfTime + "回 → " + (end - start) / 1000000f + "ms");
	}

	/**
	 * int型に１を足し続けるメソッド
	 */
	private static void addInt(int NumOfTime) {
		int sum = 0;
		for (int i = 0; i < NumOfTime; i++) {
			sum += 1;
		}
	}

	/**
	 * addIntegerを実行した時にかかる時間の計測をするメソッド
	 */
	private static void IntegerMeasure(int NumOfTime) {
		long start = System.nanoTime();
		addInteger(NumOfTime);
		long end = System.nanoTime();
		System.out.println("実行時間：" + NumOfTime + "回 → " + (end - start) / 1000000f + "ms");
	}

	/**
	 * Integer型に１を足し続けるメソッド
	 */
	private static void addInteger(int NumOfTime) {
		Integer sum = 0;
		for (int i = 0; i < NumOfTime; i++) {
			sum += 1;
		}
	}

	/**
	 * addIntegerを実行した時にかかる時間の計測をするメソッド
	 */
	private static void doubleMeasure(int NumOfTime) {
		long start = System.nanoTime();
		addInteger(NumOfTime);
		long end = System.nanoTime();
		System.out.println("実行時間：" + NumOfTime + "回 → " + (end - start) / 1000000f + "ms");
	}

	/**
	 * double型に１を足し続けるメソッド
	 */
	private static void adddouble(int NumOfTime) {
		double sum = 0;
		for (int i = 0; i < NumOfTime; i++) {
			sum += 1;
		}
	}

	/**
	 * addIntegerを実行した時にかかる時間の計測をするメソッド
	 */
	private static void DoubleMeasure(int NumOfTime) {
		long start = System.nanoTime();
		addDouble(NumOfTime);
		long end = System.nanoTime();
		System.out.println("実行時間：" + NumOfTime + "回 → " + (end - start) / 1000000f + "ms");
	}

	/**
	 * Integer型に１を足し続けるメソッド
	 */
	private static void addDouble(int NumOfTime) {
		Double sum = new Double(0);
		for (int i = 0; i < NumOfTime; i++) {
			sum += 1;
		}
	}
}
