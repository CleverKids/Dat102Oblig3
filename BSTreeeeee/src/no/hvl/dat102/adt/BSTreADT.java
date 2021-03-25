package no.hvl.dat102.adt;

import java.util.*;

public interface BSTreADT<T extends Comparable<T>> {

	/**
	 * @return returnerer antall elementer i treet.
	 */
	public int antall();

	/**
	 * @return returnerer sann hvis dette binære treet er tom og usann ellers.
	 */
	public boolean erTom();
	
	/**
	 * @param Legger det spesifiserte elementet på passende plass i dette binære søketreet.
	 * Like elementer blir lagt til høyre.
	 */
	public void leggTil(T element);
	
	/**
	 * @param elementet som skal finnes.
	 * @return Returnerer en referanse til det spesifiserte elementet hvis det fins i dette
	 * binære treet ellers returneres null.
	 */
	public T finn(T element);
	
	/**
	 * @return Returnerer en referanse til minste elementet, null viss tre er tomt.
	 */
	public T finnMin();
	
	/**
	 * @return Returnerer en referanse til største elementet, null viss tre er tomt.
	 */
	public T finnMaks();

	/************************************************************************
	 * Fjerner et element fra dette treet hvis det fins, ellers returneres null
	 ************************************************************************/
	
	// public T fjern( T element);
	// Ikke impelmentert
	
	/**
	 * @return Fjerner minste elementet fra dette treet hvis det fins, ellers returneres null
	 */
	public T fjernMin();
	
	/**
	 * @return Fjerner største elementet fra dette treet hvis det fins, ellers returneres null
	 */
	public T fjernMaks();
}
