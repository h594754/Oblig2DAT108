package oppgave3;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import oppgave2.Ansatt;
import oppgave2.Kjonn;

public class Oppg3 {
	public static void main(String[] args) {
		List<Ansatt> ansatte = Arrays.asList(new Ansatt("Svein", "Selveste", Kjonn.MANN, "Sjef", 2000000),
				new Ansatt("Rune", "Olsen", Kjonn.MANN, "Utvikler", 650000),
				new Ansatt("Lise", "Andersen", Kjonn.KVINNE, "Regnskap", 500000),
				new Ansatt("Per", "Arntsen", Kjonn.MANN, "Renhold", 400000),
				new Ansatt("Anna", "Pedersen", Kjonn.KVINNE, "Lærling", 250000));

		// A
		System.out.println("\na) Liste av ansatte som kun inneholder etternavn");
		List<String> etternavn = ansatte.stream().map(Ansatt::getEtternavn).collect(Collectors.toList());
		printListe(etternavn);

		// B
		System.out.println("\nb) Finne antall kvinner blant de ansatte");
		long antallKjonn = ansatte.stream().filter(a -> a.getKjonn().equals(Kjonn.KVINNE)).count();
		System.out.println(antallKjonn);

		// C
		System.out.println("\nc) Regne ut gjennomsnittslønnen til kvinnene");
		double gjennomsnittslonn = ansatte.stream().filter(a -> a.getKjonn().equals(Kjonn.KVINNE))
				.map(s -> s.getAarslonn()).mapToDouble(Integer::doubleValue).average().getAsDouble();
		System.out.println(gjennomsnittslonn);

		// D
		System.out.println("\nd) Gir alle med tittelen sjef en lønnsøkning på 7% ");
		ansatte.forEach(ans -> {
			if (ans.getStilling().equals("Sjef")) {
				ans.setAarslonn((int) Math.round(ans.getAarslonn() * 1.07));
			}
			System.out.println(ans);
		});

		// E
		System.out.println("\ne) Finn ut (true|false) om det er noen ansatte som tjener mer enn 800.000kr");
		boolean tjenerover = ansatte.stream().anyMatch(a -> a.getAarslonn() > 800000);
		System.out.println(tjenerover);

		// F
		System.out.println("\nf) Skriv ut alle de ansatte uten å bruke en løkke");
		List<String> utenLokke = ansatte.stream().map(p -> p.getFornavn() + "| " + p.getEtternavn() + "| " + p.getKjonn() + "| " + p.getStilling() + "| " + p.getAarslonn()+ "| ")
				.collect(Collectors.toList());
		printListe(utenLokke);
		
		
		// G
		System.out.println("\ng)Finn den/de ansatte med lavest lønn");
		Ansatt lavestlonnet = ansatte.stream().min(Comparator.comparing(Ansatt::getAarslonn)).orElseThrow();
		System.out.println(lavestlonnet);
		
		// H
		System.out.println("\nh)Finn ut summen av alle heltall i [1, 1000> som er delelig med 3 eller 5");
		int sumHeltall = IntStream.rangeClosed(1, 1000).filter(i -> i % 5 == 0 || i % 3 == 0).sum();
		System.out.println(sumHeltall);

	}

	public static void printListe(List<String> a) {
		System.out.println(a);
	}

}
