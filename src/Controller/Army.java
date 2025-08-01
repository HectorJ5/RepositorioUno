package Controller;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;
import Model.Barbarian;
import Model.BarbarianKing;
import Model.Giant;
import Model.Healing;
import Model.LightningSpell;
import Model.Spell;
import Model.Troop;
import Model.Valkyrie;
import Model.Wizard;

public class Army {
	public static BarbarianKing barbarianKing = new BarbarianKing();

	public static List<Troop> troops = new ArrayList<>();
	public static List<Spell> spells = new ArrayList<>();
	Scanner sc = new Scanner(System.in);

	public void createArmyMenu() throws Exception {
		int option = -1;
		while (option != 0) {
			try {
				System.out.println("¿Que deseas hacer?");
				System.out.println("1. Crear tropa");
				System.out.println("2. Crear hechizo");
				System.out.println("3. Habilitar Heroes");
				System.out.println("4. Ver ejercito actual");
				System.out.println("0. Salir");
				System.out.print("Opcion: ");

				option = sc.nextInt();
				sc.nextLine();

				switch (option) {
				case 1:
					createTroop();
					break;
				case 2:
					createSpell();
					break;
				case 3:
					enableHeros();
					break;
				case 4:
					viewArmy();
					break;
				case 0:
					System.out.println("¡Gracias por usar el creador de ejercito de Clash Of Clans!");
					System.out.println("Saliendo... Hasta pronto.");
					break;
				default:
					System.out.println("Opcion no valida.");
				}

			} catch (InputMismatchException e) {
				System.err.println("¡OPCION NO VALIDA!");
				System.err.println("SOLO SE PERMITEN NUMEROS ENTEROS");
				System.err.println("Intenta de nuevo.");
				sc.nextLine();
			}
		}
	}

	private void createTroop() {
		System.out.println("¿Que tropa deseas crear?");
		System.out.println("1. Barbaro");
		System.out.println("2. Mago");
		System.out.println("3. Valquiria");
		System.out.println("4. Gigante");
		System.out.print("Opcion: ");
		int choice = sc.nextInt();
		selectTroop(choice);
	}

	private void createSpell() {
		System.out.println("\n¿Qué hechizo quieres crear?");
		System.out.println("1. Curacion");
		System.out.println("2. Rayo");
		System.out.print("Opción: ");
		int choice = sc.nextInt();
		selectSpell(choice);

	}

	public static void selectTroop(int troopSelection) {
		switch (troopSelection) {
		case 1:
			Barbarian barbarian = new Barbarian();
			troops.add(barbarian);
			System.out.println("¡Tropa creada!");
			break;
		case 2:
			Wizard wizard = new Wizard();
			troops.add(wizard);
			System.out.println("¡Tropa creada!");
			break;
		case 3:
			Valkyrie valkyrie = new Valkyrie();
			troops.add(valkyrie);
			System.out.println("¡Tropa creada!");
			break;
		case 4:
			Giant giant = new Giant();
			troops.add(giant);
			System.out.println("¡Tropa creada!");
			break;
		default:
			System.err.println("¡Selecciona una opcion valida!");
			break;
		}
	}

	public static void selectSpell(int spellSelection) {

		switch (spellSelection) {
		case 1:
			Healing healing = new Healing();
			spells.add(healing);
			System.out.println("¡Hechizo creado!");
			break;
		case 2:
			LightningSpell lightningSpell = new LightningSpell();
			spells.add(lightningSpell);
			System.out.println("¡Hechizo creado!");
			break;
		default:
			System.err.println("¡Selecciona una opcion valida!");
			break;
		}

	}
	public static void selectHero(int heroSelection) {
		switch (heroSelection) {
		case 1:
			System.out.println(barbarianKing);
			System.out.println("¿Quieres cambiar la disponibilidad del Rey Barbaro? (s/n): ");
			Scanner sc = new Scanner(System.in);
			String yOn = sc.next();
			if (yOn.equalsIgnoreCase("s")) {
				barbarianKing.setAvailability(!barbarianKing.isAvailability());
				System.out.println("La disponibilidad ha sido cambiada");
			}
			System.out.println(barbarianKing);
		default:
			System.err.println("¡Selecciona una opcion valida!");
			break;
		}
	}

	public void enableHeros() {
		System.out.println("Heroes disponibles: ");
		System.out.println("1. Rey Barbaro");
		int heroSelection = sc.nextInt();
		switch (heroSelection) {
		case 1:
			selectHero(heroSelection);
			break;
		default:
			System.err.println("Opcion no valida!");
			break;
		}

	}

	public static void viewArmy() {
		System.out.println("EJERCITO: ");
		System.out.println("-");
		if (troops.isEmpty()) {
			System.out.println("No hay tropas en el ejercito todavia.");
		} else {
			System.out.println("\u001B[36m Resumen de tropas:\u001B[0m");
			for (Troop t : troops) {
				System.out.println(t);
			}
			System.out.println();
		}
		if (spells.isEmpty()) {
			System.out.println("No hay hechizos todavia.");
		} else {
			System.out.println("\u001B[35m Resumen de hechizos:\u001B[0m");
			for (Spell s : spells) {
				System.out.println(s);
			}
			System.out.println();
		}
		System.out.println("\u001B[33m Resumen de Heroes:\u001B[0m");
		System.out.println(barbarianKing);
		System.out.println("-");

	}
}