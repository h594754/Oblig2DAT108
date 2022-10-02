package oppgave2;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;

public class Oppg2 {

	public static void main(String[] args) {
		List<Ansatt> ansatte = Arrays.asList(new Ansatt("Svein", "Selveste", Kjonn.MANN, "Sjef", 2000000),
				new Ansatt("Rune", "Olsen", Kjonn.MANN, "Utvikler", 650000),
				new Ansatt("Lise", "Andersen", Kjonn.KVINNE, "Regnskap", 500000),
				new Ansatt("Per", "Arntsen", Kjonn.MANN, "Renhold", 400000),
				new Ansatt("Anna", "Pedersen", Kjonn.KVINNE, "L�rling", 250000));
		System.out.println("Printer hele tabellen f�r endring");
		skrivUtAlle(ansatte);

		// Fast kronetillegg
		lonnsoppgjor(ansatte, (a) -> a.getAarslonn() + 1000);
		System.out.println("\nKj�ring etter fast kronetillegg");
		skrivUtAlle(ansatte);

		// Et fast prosenttillegg
		lonnsoppgjor(ansatte, a -> (int) (a.getAarslonn() * 1.07));
	
		System.out.println("\nKj�ring etter fast prosenttillegg");
		skrivUtAlle(ansatte);

		// Et fast kronetillegg hvis du har lav l�nn
		ansatte.forEach(n -> {
			lonnsoppgjor(ansatte, a ->  a.getAarslonn() < 500000 ? a.getAarslonn() + 12345 : a.getAarslonn());
		});
		System.out.println("\nKj�ring etter kj�rt fast kronetillegg ved lav l�nn");
		skrivUtAlle(ansatte);

		// Et fast prosenttillegg hvis du er mann.
		lonnsoppgjor(ansatte, b -> b.getKjonn().equals(Kjonn.MANN) ? (int)(b.getAarslonn() * 1.07) : b.getAarslonn());
		System.out.println("\nKj�ring etter fast prosenttillegg hvis du er mann");
		skrivUtAlle(ansatte);

	}

	private static void lonnsoppgjor(List<Ansatt> ansatte, Function<Ansatt, Integer> function) {
		ansatte.forEach(a -> a.setAarslonn(function.apply(a)));

	}

	private static void skrivUtAlle(List<Ansatt> ansatte) {
		ansatte.forEach(System.out::println);
	}
}
