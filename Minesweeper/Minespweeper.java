package sedma_nedelja_domaci_cetiri;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Minespweeper {

	public static int minesweeper(int[][] matrica, int n, int m, int brojac, int[] komande) {
		int brBombi = 0;
		for (int i = 0; i < brojac; i++) {
			switch (komande[i]) {
			case 1:
				if (matrica[n - 1][m - 1] == 1)
					brBombi++;
				break;
			case 2:
				if (matrica[n - 1][m] == 1)
					brBombi++;
				break;
			case 3:
				if (matrica[n - 1][m + 1] == 1)
					brBombi++;
				break;
			case 4:
				if (matrica[n][m + 1] == 1)
					brBombi++;
				break;
			case 5:
				if (matrica[n + 1][m + 1] == 1)
					brBombi++;
				break;
			case 6:
				if (matrica[n + 1][m] == 1)
					brBombi++;
				break;
			case 7:
				if (matrica[n + 1][m - 1] == 1)
					brBombi++;
				break;
			case 8:
				if (matrica[n][m - 1] == 1)
					brBombi++;
				break;
			}
		}
		return brBombi;
	}

	public static int[][] ucitajMatricu() {
		try (BufferedReader r = new BufferedReader(new FileReader("map.txt"))) {
			String[] nums = r.readLine().split(" ");
			int N = Integer.parseInt(nums[0]);
			int M = Integer.parseInt(nums[1]);
			if (proveraVelicine(N, M)) {
				int matrix[][] = new int[N][M];

				for (int i = 0; i < matrix.length; i++) {
					String line = r.readLine();
					for (int j = 0; j < matrix.length; j++) {
						String pom = line.substring(j, j + 1);
						matrix[i][j] = Integer.parseInt(pom);
					}
				}
				return matrix;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public static boolean proveraVelicine(int n, int m) {
		if (n <= 100 && m <= 100) {
			return true;
		} else {
			System.out.println("Greska! Uneli ste preveliku matricu!");
			return false;
		}
	}

	public static void ispis(int[][] matrix) {
		try (FileWriter fw = new FileWriter("C:\\Users\\Nikola\\Desktop\\bomb3.txt")) {
			if(matrix!=null) {
			for (int i = 0; i < matrix.length; i++) {
				for (int j = 0; j < matrix.length; j++) {
					if (i == 0 && j == 0) {
						int ispis = minesweeper(matrix, i, j, 3, new int[] { 4, 5, 6 });
						fw.write(Integer.toString(ispis));
						fw.flush();
					} else if (i == 0 && j == matrix.length - 1) {
						int ispis = minesweeper(matrix, i, j, 3, new int[] { 6, 7, 8 });
						fw.write(Integer.toString(ispis));
						fw.flush();
					} else if (i == matrix.length - 1 && j == matrix.length - 1) {
						int ispis = minesweeper(matrix, i, j, 3, new int[] { 1, 2, 8 });
						fw.write(Integer.toString(ispis));
						fw.flush();
					} else if (i == matrix.length - 1 && j == 0) {
						int ispis = minesweeper(matrix, i, j, 3, new int[] { 2, 3, 4 });
						fw.write(Integer.toString(ispis));
						fw.flush();
					} else if (i == 0 && (j > 0 && j < matrix.length - 1)) {
						int ispis = minesweeper(matrix, i, j, 5, new int[] { 4, 5, 6, 7, 8 });
						fw.write(Integer.toString(ispis));
						fw.flush();
					} else if ((i > 0 && i < matrix.length - 1) && j == matrix.length - 1) {
						int ispis = minesweeper(matrix, i, j, 5, new int[] { 1, 2, 6, 7, 8 });
						fw.write(Integer.toString(ispis));
						fw.flush();
					} else if (i == matrix.length - 1 && (j > 0 && j < matrix.length - 1)) {
						int ispis = minesweeper(matrix, i, j, 5, new int[] { 1, 2, 3, 4, 8 });
						fw.write(Integer.toString(ispis));
						fw.flush();
					} else if ((i > 0 && i < matrix.length - 1) && j == 0) {
						int ispis = minesweeper(matrix, i, j, 5, new int[] { 2, 3, 4, 5, 6 });
						fw.write(Integer.toString(ispis));
						fw.flush();
					} else {
						int ispis = minesweeper(matrix, i, j, 8, new int[] { 1, 2, 3, 4, 5, 6, 7, 8 });
						fw.write(Integer.toString(ispis));
						fw.flush();
					}
					if (j == matrix.length - 1) {
						fw.write(System.getProperty("line.separator"));
						fw.flush();
					}
				}
			}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int matrix[][] = ucitajMatricu();
		ispis(matrix);

	}
}