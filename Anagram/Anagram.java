package sedma_nedelja_domaci_treci;

import java.util.Scanner;

public class Anagram {

	public static double[] ucitavanjeNiza(int x) {
		Scanner sc = new Scanner(System.in);
		double[] niz = new double[x];
		for (int i = 0; i < x; i++) {
			niz[i] = sc.nextInt();
		}

		return niz;
	}

	public static boolean uporediNizove(double[] niz1, double[] niz2, int duzina) {
		int brojac = 0;
		int izlaz = 0;
		double[] pomocniNiz = niz2.clone();
		for (int i = 0; i < niz1.length; i++) {
			for (int j = 0; j < pomocniNiz.length; j++) {
				if (niz1[i] == pomocniNiz[j]) {
					double pom = pomocniNiz[i];
					pomocniNiz[i] = pomocniNiz[j];
					pomocniNiz[j] = pom;
					brojac++;
					izlaz++;
					break;
				}
			}
			if(izlaz==0) return false;
		}
		if (brojac == duzina) {
			return true;
		} else
			return false;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);

		int velicinaNiza = sc.nextInt();

		if (velicinaNiza > 100)
			System.out.println("Greska!");
		else {
			 double[] niz1 = ucitavanjeNiza(velicinaNiza);
			 double[] niz2 = ucitavanjeNiza(velicinaNiza);

			if (uporediNizove(niz1, niz2, velicinaNiza) == true) {
				System.out.println("Jesu anagrami");
			} else
				System.out.println("Nisu anagrami");
		}
		
		
	}

}
