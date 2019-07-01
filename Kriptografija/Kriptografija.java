package osma_nedelja_domaci_jedan;

import java.util.Scanner;

public class Kriptografija {

	public static int[] ucitajKljuc(int duzina) {
		Scanner sc = new Scanner(System.in);

		try {
			int[] kljuc = new int[duzina];

			for (int i = 0; i < duzina; i++) {
				kljuc[i] = sc.nextInt();
			}

			if (proveriKljuc(kljuc))
				return kljuc;
			else
				return null;

		} catch (ArrayIndexOutOfBoundsException exception) {
			System.out.println("Duzina kljuca i kljuc se ne poklapaju!");
		}
		sc.close();
		return null;
	}

	public static boolean proveriKljuc(int[] kljuc) {
		int[] pom = new int[kljuc.length];
		pom = kljuc.clone();
		int brojac = 0;
		for (int i = 0; i < kljuc.length; i++) {
			brojac = 0;
			for (int j = 0; j < kljuc.length; j++) {
				if (kljuc[i] == pom[j])
					brojac++;
			}
		}
		if (brojac > 1) {
			System.out.println("Cifre kljuca moraju biti razlicite!");
			return false;
		} else
			return true;
	}

	public static String[][] ucitajMatricu(int N, int M, String[] niz) {
		String[][] matrica = new String[M][N];
		int x = 0;
		for (int i = 0; i < M; i++) {
			for (int j = 0; j < N; j++, x++) {
				if (x == niz.length)
					return matrica;
				else
					matrica[i][j] = niz[x];
			}
		}
		return matrica;
	}

	public static void ispisiSifru(int N, int M, int[] kljuc, String[][] matrica, int duzinaPoruke) {
		int[] pom1 = new int[kljuc.length];
		int[] pom2 = new int[kljuc.length];
		pom1 = kljuc.clone();
		int brojac = 1;
		for (int i = 0; i < pom1.length; i++) {
			for (int j = 0; j < pom1.length; j++) {
				if (brojac == pom1[j]) {
					pom2[i] = j;
					brojac++;
					break;
				}
			}
		}
		int x = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++, x++) {
				if (x == duzinaPoruke)
					return;
				else
					System.out.print(matrica[j][pom2[i]]);
			}
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);

		int duzinaKljuca = sc.nextInt();

		int[] kljuc = ucitajKljuc(duzinaKljuca);

		String poruka = sc.next();

		String[] niz = poruka.split("");

		int visinaNiza;

		if (niz.length % duzinaKljuca == 0)
			visinaNiza = niz.length / duzinaKljuca;
		else
			visinaNiza = niz.length / duzinaKljuca + 1;

		String[][] matrica = ucitajMatricu(duzinaKljuca, visinaNiza, niz);

		ispisiSifru(duzinaKljuca, visinaNiza, kljuc, matrica, niz.length);
		
		sc.close();
	}

}
