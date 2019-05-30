/*
Zadatak je napraviti konzolni program za ažurni ispis vremenske prognoza koristeći JSON API koji obezbeđuje “openweather” servis.
Program omogućava ispis trenutne temperature kao i ispis 5dnevne prognoze. Grad se takođe može promeniti a prodrazumevani grad je
Beograd čiji su podaci: city: Belgrade, countryCode: RS. Za pokretanje koda neophodna je internet konekcija.
Unapred je obezbeđena je metoda getWeatherInfo.
*/

package peta_nedelja_domaci_prvi;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.Calendar;
import java.util.Scanner;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class Program {
	static long lastRequestTimestamp;

	public static enum Type {
		CURRENT, FORECAST
	};

	public static String getWeatherInfo(String city, String countryCode, Type type) throws IOException {
		String authToken = "d0f1969fd9856fe09e3f7d0753d84ed4";
		String addr = String.format("http://api.openweathermap.org/data/2.5/%s?q=%s,%s&appid=%s&units=metric",
				type == Type.CURRENT ? "weather" : "forecast", city, countryCode, authToken);
		if (System.currentTimeMillis() - lastRequestTimestamp < 5000) {
			try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		URLConnection yc = new URL(addr).openConnection();
		BufferedReader in = new BufferedReader(new InputStreamReader(yc.getInputStream()));
		StringBuilder buffer = new StringBuilder();
		String inputLine;
		while ((inputLine = in.readLine()) != null)
			buffer.append(inputLine);
		in.close();
		lastRequestTimestamp = System.currentTimeMillis();
		return buffer.toString();
	}

	public static void trenutnaTemperatura(String grad, String kod) {
		try {

			JSONObject obj = new JSONObject();
			JSONParser parser = new JSONParser();
			obj = (JSONObject) parser.parse(getWeatherInfo(grad, kod, Type.CURRENT));
			obj = (JSONObject) obj.get("main");
			System.out.println("Trenutna: " + obj.get("temp") + "°C");
			System.out.println("Maksimalna: " + obj.get("temp_max") + "°C");
			System.out.println("Minimalna: " + obj.get("temp_min") + "°C");
			System.out.println("------------------------");

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void buducaTemperatura(String grad, String kod) {
		double temperatura = 0;
		try {

			JSONObject obj = new JSONObject();
			JSONParser parser = new JSONParser();
			JSONArray niz = new JSONArray();
			obj = (JSONObject) parser.parse(getWeatherInfo(grad, kod, Type.FORECAST));
			niz = (JSONArray) obj.get("list");
			Calendar calendar = Calendar.getInstance();
			int index = calendar.get(Calendar.DAY_OF_WEEK);
			String[] dani = { "Ned", "Pon", "Uto", "Sre", "Cet", "Pet", "Sub" };

			for (int y = 8; y < 40; y += 8) {

				obj = (JSONObject) niz.get(y);
				obj = (JSONObject) obj.get("main");

				if (index == 7)
					index = 0;
				System.out.print(dani[index] + ": " + obj.get("temp") + "°C\n");
				index++;

				if (y == 32)
					y--;
			}

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);

		String grad = "Belgrade";
		String kod = "RS";

		System.out.println("Dobrodosli u konzolnu vremensku prognozu!");
		System.out.println("-----------------------------------------");
		System.out.println("Komande:");
		System.out.println("-1) Izlaz iz programa");
		System.out.println("0) Promena grada");
		System.out.println("1) Trenutna temperatura");
		System.out.println("2) Prognoza za 5 dana");
		System.out.println("99) Ispis komandnog menija");
		System.out.println("--------------------------");

		int izlaz = 0;

		while (izlaz != -1) {
			System.out.print("Komanda: ");
			int komanda = sc.nextInt();
			switch (komanda) {
			case -1:
				izlaz = -1;
				break;
			case 0:
				System.out.println("Unesite grad u formatu: city, countryCode");
				String unos = sc.next();
				String unos2 = sc.next();
				String[] pom = unos.trim().split(",");
				grad = pom[0];
				kod = unos2.trim();
				System.out.println("------------------------");
				break;
			case 1:
				trenutnaTemperatura(grad, kod);
				break;

			case 2:
				buducaTemperatura(grad, kod);
				break;

			case 99:
				System.out.println("--------------------------");
				System.out.println("Komande:");
				System.out.println("-1) Izlaz iz programa");
				System.out.println("0) Promena grada");
				System.out.println("1) Trenutna temperatura");
				System.out.println("2) Prognoza za 5 dana");
				System.out.println("99) Ispis komandnog menija");
				System.out.println("--------------------------");
				break;
			}
		}

	}
}
