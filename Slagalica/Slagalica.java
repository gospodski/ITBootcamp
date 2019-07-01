package deveta_nedelja_domaci_drugi;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Scanner;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public class Slagalica {

	public static String generisiSlova() {
		String azbuka = "АБВГДЂЕЖЗИЈКЛЉМНЊОПРСТЋУФХЦЧЏШ";
		String rezultat = "";
		for (int i = 0; i < 12; i++) {
			rezultat += azbuka.charAt(((int) (Math.random() * 30)));
		}
		return rezultat;
	}

	public static boolean analizirajSlova(String ispis, String odgovor) {
		String pom = ispis;
		int brojac = 0;
		for (int i = 0; i < odgovor.length(); i++) {
			for (int j = 0; j < pom.length(); j++) {
				if (odgovor.charAt(i) == pom.charAt(j)) {
					pom = pom.substring(0, j) + "!" + pom.substring(j + 1);
					brojac++;
					break;
				}
			}
		}
		if (brojac == odgovor.length())
			return true;
		else
			return false;
	}

	public static boolean proveriRecnik(String unos) {
		try {
			BufferedReader br = new BufferedReader(new FileReader("recnik"));
			String pom = unos.toLowerCase();
			String linija = br.readLine();
			while (linija != null) {
				if (pom.equals(linija))
					return true;
				linija = br.readLine();
			}
			br.close();
			return false;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);
		ExecutorService executor = Executors.newFixedThreadPool(1);
		Future<?> future = executor.submit(new Runnable() {
			@Override
			public void run() {
				String slova = generisiSlova();
				for (int i = 0; i < slova.length(); i++) {
					System.out.print(String.format("%c ", slova.charAt(i)));
				}
				System.out.println("\n-----------------------");
				String odgovor = sc.next();
				while (analizirajSlova(slova, odgovor) == false) {
					System.out.println("Користили сте недозовољена слова! Пробајте опет!");
					odgovor = sc.next();
				}
				if (proveriRecnik(odgovor)) {
					System.out.println("Освојили сте " + (odgovor.length() * 2) + " поена");
					System.exit(0);
				} else {
					System.out.println("Нажалост, ваше речи нема у речнику!");
					System.exit(0);
				}
			}
		});

		try {
			future.get(5, TimeUnit.SECONDS);
		} catch (InterruptedException e) {
			e.printStackTrace();
		} catch (ExecutionException e) {
			e.printStackTrace();
		} catch (TimeoutException e) {
			System.out.println("Нажалост, време је истекло!");
			System.exit(0);
		}
	}
}
