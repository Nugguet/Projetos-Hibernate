package br.com.inforium.view;

public class MinhaThread extends Thread {

	public void run() {
		String caixa = Thread.currentThread().getName();

		try {

			if (caixa.trim().equals("c1")) {
				System.out.println(caixa + " Iniciando...");
				sleep(2000);
			} else if (caixa.trim().equals("c2")) {
				System.out.println(caixa + " Iniciando...");
				sleep(2000);
			} else if (caixa.trim().equals("c3")) {
				System.out.println(caixa + " Iniciando...");
				sleep(2000);
			} else if (caixa.trim().equals("c4")) {
				System.out.println(caixa + " Iniciando...");
				sleep(2000);
			} else if (caixa.trim().equals("c5")) {
				System.out.println(caixa + " Iniciando...");
				sleep(1000);
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		for (int i = 0; i < 100; i++) {
			System.out.println(caixa + ": " + i);
		}

		System.out.println(caixa + "FIM");
	}

	public static void main(String[] args) {

		Thread c1 = new Thread(new MinhaThread(), "c1");
		Thread c2 = new Thread(new MinhaThread(), "c2");
		Thread c3 = new Thread(new MinhaThread(), "c3");
		Thread c4 = new Thread(new MinhaThread(), "c4");
		Thread c5 = new Thread(new MinhaThread(), "c5");

		c1.start();
		c2.start();
		c3.start();
		c4.start();
		c5.start();
	}
}