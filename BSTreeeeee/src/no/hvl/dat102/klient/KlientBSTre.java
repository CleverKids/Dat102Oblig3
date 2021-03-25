package no.hvl.dat102.klient;

import no.hvl.dat102.KjedetBSTre;
import java.util.*;

public class KlientBSTre {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		KjedetBSTre bstre = new KjedetBSTre();
		
		bstre.leggTil(7);
		bstre.leggTil(5);
		bstre.leggTil(6);
		bstre.leggTil(4);
		bstre.leggTil(9);
		bstre.leggTil(10);
		bstre.leggTil(8);
		bstre.leggTil(3);
		
		System.out.println("Finner høyden på treet");
		System.out.println(bstre.hoyde());
		System.out.println();
		
		// Tester på sortert utskrift
		System.out.println("Skriver ut elementene sortert i bs-treet");
		bstre.visInorden();

		// Tester på om et bestemt element fins
		int element = 8;
		System.out.println("\nTester paa om elementet " + element + " fins");

		if (bstre.finn(element) != null) {
			System.out.println("Elementet " + element + " fins i bs-treet");
		} else {
			System.out.println("Elementet " + element + " fins ikke i bs-treet");
		}

		element = 1;
		System.out.println("\nTester paa om elementet " + element + " fins");

		if (bstre.finn(element) != null) {
			System.out.println("Elementet " + element + " fins i bs-treet");
		} else {
			System.out.println("Elementet " + element + " fins ikke i bs-treet");
		}
		int antallNoder = 1023;
		System.out.println();
		System.out.println("Testing på storre BStre");
		KjedetBSTre[] bstreArray = new KjedetBSTre[100];
		Random random = new Random();
		for(int i = 0; i < bstreArray.length; i++) {
			bstreArray[i] = new KjedetBSTre();
			for(int j = 0; j < antallNoder; j++) {
				bstreArray[i].leggTil(random.nextInt());
			}
		}
		int antall = 0;
		for(int i = 0; i < bstreArray.length; i++) {
			antall += bstreArray[i].antall();
		}
		System.out.println("Sum av alle noder: " + antall);
		System.out.println("Minimale teorietiske hoyde: " + 
		(int)Math.floor((Math.log(bstreArray[0].antall())/Math.log(2))));
		System.out.println("Maksimale teoretiske hoyde: " + (bstreArray[0].antall() - 1));
		
		int minsteHoyde = 100000;
		int storsteHoyde = 0;
		int totalHoyde = 0;
		for(int i = 0; i < bstreArray.length; i++) {
			int hoyde = bstreArray[i].hoyde();
			if(hoyde < minsteHoyde) {
				minsteHoyde = hoyde;
			}
			if(hoyde > storsteHoyde) {
				storsteHoyde = hoyde;
			}
			totalHoyde += hoyde;
		}
		int gjennomsnitt = totalHoyde/bstreArray.length;
		System.out.println("Minste hoyde blant BStreene: " + minsteHoyde);
		System.out.println("Storste hoyde blant BStreene: " + storsteHoyde);
		System.out.println("Gjennomsnittlig hoyde: " + gjennomsnitt);
	}

}
