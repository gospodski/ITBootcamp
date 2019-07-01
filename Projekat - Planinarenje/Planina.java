package cetvrta_nedelja_Planinarenje;

import java.util.LinkedList;

public class Planina {

	private String ime;
	private int visina;

	public Planina(String ime, int visina) {
		this.ime = ime;
		this.visina = visina;
	}

	@Override
	public String toString() {
		String str = "";
		return str = ime + " (" + visina + ")";
	}

	public static String ispisNiza(Planina[] planina) {
		String str = "";
		for (int i = 0; i < planina.length; i++) {
			if (i == planina.length - 1) {
				str += planina[i] + ".";
			} else
				str += planina[i] + ", ";
		}
		return str;
	}

	public int getVisina() {
		return visina;
	}

}
