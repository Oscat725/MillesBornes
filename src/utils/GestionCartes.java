package utils;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Random;

import cartes.Carte;

public class GestionCartes {

	private static <E> E extraire(List<E> carteList) {
		Random random = new Random();
		int randomInt = random.nextInt(carteList.size());
		E carte = carteList.get(randomInt);
		carteList.remove(randomInt);
		return carte;
	}

	public static <E> E extraireIterator(List<E> carteList) {
		Random random = new Random();
		int randomInt = random.nextInt(carteList.size());
		ListIterator<E> it = carteList.listIterator(randomInt);
		if (it.hasNext()) {
			E carte = it.next();
			it.remove();
			return carte;
		}
		if (it.hasPrevious()) {
			E carte = it.previous();
			it.remove();
			return carte;
		}
		return null;
	}

	public static <E> List<E> melanger(List<E> carteList) {
		List<E> newCarteList = new ArrayList<>();

		for (int i = 0; i < carteList.size(); i++) {
			E carte = extraire(carteList);
			newCarteList.add(carte);

		}
		return newCarteList;
	}

	public static <E> boolean verifierMelange(List<E> list1, List<E> list2) {
		for (Iterator<E> iterator = list2.iterator(); iterator.hasNext();) {
			E e = (E) iterator.next();
			if (Collections.frequency(list2, e) != Collections.frequency(list1, e)) {
				return false;
			}
		}
		return true;
	}

	public static <E> List<E> rassembler(List<E> list) {
		List<E> newList = new ArrayList<>();
		ListIterator<E> it = newList.listIterator();
		for (Iterator<E> iterator = list.iterator(); iterator.hasNext();) {
			E e = (E) iterator.next();
			if (Collections.frequency(newList, e) == 0) {
				for (int i = 0; i < Collections.frequency(list, e); i++) {
					it.add(e);
				}
			}
		}
		return newList;
	}

	public static <E> boolean verifierRassemblement(List<E> list) {
		for (ListIterator<E> iterator = list.listIterator(); iterator.hasNext();) {
			E e = (E) iterator.next();
			if (iterator.hasPrevious()) {
				E e2 = iterator.previous();
				if (!e.equals(e2)) {
					for (ListIterator<E> iterator2 = list.listIterator(iterator.nextIndex()); iterator2.hasNext();) {
						E e3 = (E) iterator2.next();
						if (e.equals(e3)) {
							return false;
						}
					}
				}
				iterator.next();
			}
		}
		return true;
	}
}
