package no.hvl.dat102;

import java.util.Iterator;

import no.hvl.dat102.adt.BSTreADT;

//********************************************************************
// KjedetBinærSøkeTre.java        
//
//********************************************************************

public class KjedetBSTre<T extends Comparable<T>> implements BSTreADT<T>,Iterable<T> {

	private int antall;
	/**
	 * @return the rot
	 */
	public BinaerTreNode<T> getRot() {
		return rot;
	}

	/**
	 * @param rot the rot to set
	 */
	public void setRot(BinaerTreNode<T> rot) {
		this.rot = rot;
	}

	private BinaerTreNode<T> rot;

	/******************************************************************
	 * Oppretter et tomt binært søketre.
	 ******************************************************************/
	public KjedetBSTre() {
		antall = 0;
		rot = null;
	}

	/******************************************************************
	 * Oppretter et binært søketre med en node..
	 ******************************************************************/
	public KjedetBSTre(T element) {
		rot = new BinaerTreNode<T>(element);
		antall = 1;
	}

	/*****************************************************************
	 * Returnerer sann hvis dette binære trett er tomt og usann ellers.
	 *****************************************************************/
	@Override
	public int antall() {
		return antall;
	}

	/*****************************************************************
	 * Returnerer sann hvis dette binære treet er tom og usann ellers.
	 *****************************************************************/
	@Override
	public boolean erTom() {
		return (antall == 0);
	}
	
	
	/**********************************************************************
	 * Legger det spesifiserte elementet på passende plass i BS-treet. Like
	 * elementer blir lagt til høyre. Bruk av rekursiv hjelpemetode.
	 ********************************************************************/
	@Override
	public void leggTil(T element) {
		rot = leggTilRek(rot, element);
		antall++;
	}

	private BinaerTreNode<T> leggTilRek(BinaerTreNode<T> p, T element) {
		if(p == null) {
			return new BinaerTreNode<T>(element);
		} else {
			if(element.compareTo(p.getElement()) < 0) {
				p.setVenstre(leggTilRek(p.getVenstre(), element));
			} else {
				p.setHoyre(leggTilRek(p.getHoyre(), element));
			}
			return p;
		}
	}
	
	public int hoyde() {
		return hoydeRek(rot, -1);
	}
	
	private int hoydeRek(BinaerTreNode<T> p, int hoyde) {
		if(p == null) {
			return hoyde;
		} else {
			int vHoyde = hoydeRek(p.getVenstre(), hoyde) + 1;
			int hHoyde = hoydeRek(p.getHoyre(), hoyde) + 1;
			return vHoyde > hHoyde ? vHoyde : hHoyde;
		}
	}

	/******************************************************************
	 * Legger det spesifiserte elementet på passende plass i dette binære søketreet.
	 * Like elementer blir lagt til høyre.
	 ******************************************************************/

	public void leggTil2(T element) {
		// 
	}

	/******************************************************************
	 * Fjerner noden med minste verdi fra dette binære søketreet.
	 *********************************************************************/
	@Override
	public T fjernMin() {
		T element = fjernMinRek(rot);
		antall--;
		return element;
	}//

	private T fjernMinRek(BinaerTreNode<T> p) {
		if(p != null) {
			T element;
			if(p.getVenstre() == null) {
				if(p.getHoyre() != null) {
					element = p.getElement();
					p.setElement(p.getHoyre().getElement());
					p.setVenstre(p.getHoyre().getVenstre());
					p.setHoyre(p.getHoyre().getHoyre());
					return element;
				} else {
					element = p.getElement();
					p = null;
					return element;
				}
			} else {
				return fjernMinRek(p.getVenstre());
			}
		}
		return null;
	}
	
	/******************************************************************
	 * Fjerner noden med største verdi fra dette binære søketreet.
	 ******************************************************************/
	@Override
	public T fjernMaks() {
		 T element = fjernMaksRek(rot);
		 antall--;
		return element;
	}//
	
	private T fjernMaksRek(BinaerTreNode<T> p) {
		if(p != null) {
			if(p.getHoyre() == null) {
				if(p.getVenstre() != null) {
					T element = p.getElement();
					p.setElement(p.getVenstre().getElement());
					p.setVenstre(null);
					return element;
				} else {
					return p.getElement();
				}
			} else {
				return fjernMaksRek(p.getHoyre());
			}
		}
		return null;
	}

	/******************************************************************
	 * Returnerer det minste elementet i dette binære søketreet.
	 ******************************************************************/
	@Override
	public T finnMin() {
		return finnMinRek(rot);
	}//
	
	private T finnMinRek(BinaerTreNode<T> p) {
		if(p.getVenstre() == null) {
			return p.getElement();
		} else {
			return finnMinRek(p.getVenstre());
		}
	}

	/******************************************************************
	 * Returnerer det største elementet i dette binære søketreet.
	 ******************************************************************/
	@Override
	public T finnMaks() {
		return finnMaksRek(rot);
	}//
	
	private T finnMaksRek(BinaerTreNode<T> p) {
		if(p.getHoyre() == null) {
			return p.getElement();
		} else {
			return finnMaksRek(p.getHoyre());
		}
	}

	/*******************************************************************************
	 * Returnerer en referanse til det spesifiserte elementet hvis det finst i dette
	 * BS-treet, null ellers. Bruk av rekursjon /
	 ******************************************************************************/
	@Override
	public T finn(T element) {
		return finnRek(rot, element);
	}

	private T finnRek(BinaerTreNode<T> p, T element) {
		T resultat = null;
		if(p != null) {
			int sml = element.compareTo(p.getElement());
			if(sml == 0) {
				resultat = p.getElement();
			} else if(sml < 0) {
				resultat = finnRek(p.getVenstre(), element);
			} else {
				resultat = finnRek(p.getHoyre(), element);
			}
		}
		return resultat;
	}

	/************************************************************************
	 * Returnerer en referanse til det spesifiserte elementet hvis det fins i dette
	 * BS-treet, null ellers. Uten bruk av rekursjon. /
	 ************************************************************************/
	public T finn2(T element) {
		BinaerTreNode<T> aktuell = rot;
		T resultat = null;
		boolean funnet = false;
		for(int i = 0; i < antall && !funnet; i++) {
			if(element == aktuell.getElement()) {
				funnet = true;
				resultat = aktuell.getElement();
			}
			if(aktuell.getElement() == null) {
				funnet = true;
			} else {
				int sml = element.compareTo(aktuell.getElement());
				if(sml < 0) {
					aktuell = aktuell.getVenstre();
				} else {
					aktuell = aktuell.getHoyre();
				}
			}
		}
		return resultat;
	}

	public void visInorden() {
		visInorden(rot);
		System.out.println();
	}

	private void visInorden(BinaerTreNode<T> p) {
		if (p != null) {
			visInorden(p.getVenstre());
			System.out.print(" " + p.getElement());
			visInorden(p.getHoyre());
		}  
	}

	@Override
	public Iterator<T> iterator() {
		return new InordenIterator<T>(rot);
		
	}
}// class
