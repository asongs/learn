package com.asong.threaddemo.basic;

/**
 * @author Asong
 * @title: DisOrder
 * @date 2021-04-08 18:03
 */
public class DisOrder {

	private static int a = 0, b = 0, x = 0, y = 0;

	public static void main(String[] args) throws InterruptedException {
		int i = 0;
		for (; ; ) {
			i++;
			Thread thread = new Thread(() -> {
				a = 1;
				x = b;
			});
			Thread thread1 = new Thread(() -> {
				b = 1;
				y = a;
			});

			thread.start();
			thread1.start();
			thread.join();
			thread1.join();
			if (x == 0 && y == 0) {
				System.out.println("次数" + i);
				break;
			}
		}
	}
}
