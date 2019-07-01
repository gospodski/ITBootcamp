package cetvrta_nedelja_Planinarenje;

import java.util.Collection;
import java.util.Collections;
import java.util.Date;
import java.util.LinkedList;

public class PlaninarskoDrustvo {

	private String naziv;
	private int godOsnivanja;
	private LinkedList<Planinar> listaClanova;

	public PlaninarskoDrustvo(String naziv, int god, Planinar[] osnivaci) {
		this.naziv = naziv;
		godOsnivanja = god;
		listaClanova = new LinkedList<Planinar>();
		listaClanova.add(null);
		for (int i = 0; i < osnivaci.length; i++) {
			listaClanova.add(osnivaci[i]);
		}

	}

	public void uclanjenje(Planinar planinar) {
		listaClanova.add(planinar);
	}

	public Planinar getPlaninara(int pozicija) {
		return listaClanova.get(pozicija);
	}

	public int getBrClanova() {
		int x = listaClanova.size() - 1;
		return x;
	}

	public String rangiranje() {
		String str = "Rang lista Planinarskog drustva " + naziv + "\n";
		LinkedList<Planinar> pom = new LinkedList<Planinar>(listaClanova);
		LinkedList<Planinar> pom2 = new LinkedList<Planinar>(listaClanova);
		for (int i = 1; i < pom.size() - 1; i++) {
			int max = pom.get(i).getVisina();
			int pozicija = i;

			for (int j = i + 1; j < pom.size(); j++) {
				if (max < pom.get(j).getVisina()) {
					max = pom.get(j).getVisina();
					pozicija = j;
				}
			}
			Collections.swap(pom, i, pozicija);

		}
		for (int m = 1; m < pom.size(); m++) {
			if(pom.get(m) instanceof Alpinista) {
				str += m + " A_" + pom.get(m).getIme() + " (" + pom.get(m).getID() + ") - " + pom.get(m).getVisina() + "\n";
			}
			else if(pom.get(m) instanceof KlasicanPlaninar)
			str += m + " K_" + pom.get(m).getIme() + " (" + pom.get(m).getID() + ") - " + pom.get(m).getVisina() + "\n";
		}
		return str;
	}

	public void ispis() {
		String str = "";
		for (int i = 1; i < listaClanova.size(); i++) {
			System.out.println(listaClanova.get(i).getVisina());
		}

	}
}
