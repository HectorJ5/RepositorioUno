package TestController;

import static org.junit.Assert.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.List;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import Controller.Army;
import Model.Barbarian;
import Model.Giant;
import Model.Healing;
import Model.LightningSpell;
import Model.Spell;
import Model.Troop;
import Model.Valkyrie;
import Model.Wizard;

public class TestArmy {

	private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
	private final PrintStream originalOut = System.out;

	@Before
	public void setUp() {
		Army.troops.clear();
		Army.spells.clear();
		outContent.reset();
		System.setOut(new PrintStream(outContent));
	}

	@After
	public void tearDown() {
		Army.troops.clear();
		Army.spells.clear();
		System.setOut(originalOut);
	}

	@Test
	public void testSelectTroop_Barbarian() {
		Army.selectTroop(1);
		List<Troop> troops = Army.troops;
		assertEquals(1, troops.size());
		assertTrue(troops.get(0) instanceof Barbarian);
	}

	@Test
	public void testSelectTroop_Wizard() {
		Army.selectTroop(2);
		assertEquals(1, Army.troops.size());
		assertTrue(Army.troops.get(0) instanceof Wizard);
	}

	@Test
	public void testSelectTroop_Valkyrie() {
		Army.selectTroop(3);
		assertEquals(1, Army.troops.size());
		assertTrue(Army.troops.get(0) instanceof Valkyrie);
	}

	@Test
	public void testSelectTroop_Giant() {
		Army.selectTroop(4);
		assertEquals(1, Army.troops.size());
		assertTrue(Army.troops.get(0) instanceof Giant);
	}

	@Test
	public void testSelectTroop_InvalidOption() {
		ByteArrayOutputStream outErrContent = new ByteArrayOutputStream();
		PrintStream combinedStream = new PrintStream(outErrContent);
		System.setOut(combinedStream);
		System.setErr(combinedStream);

		try {
			Army.selectTroop(100);
			assertTrue("La lista de tropas debe estar vacia", Army.troops.isEmpty());

			String output = outErrContent.toString();
			assertTrue("Debe contener mensaje de error", output.contains("Selecciona una opcion valida"));
		} catch (Exception e) {
			fail(e.getMessage());
		} finally {
			System.setOut(originalOut);
			System.setErr(System.err);
		}
	}

	@Test
	public void testSelectSpell_Healing() {
		Army.selectSpell(1);
		List<Spell> spells = Army.spells;
		assertEquals(1, spells.size());
		assertTrue(spells.get(0) instanceof Healing);
	}

	@Test
	public void testSelectSpell_Lightning() {
		Army.selectSpell(2);
		assertEquals(1, Army.spells.size());
		assertTrue(Army.spells.get(0) instanceof LightningSpell);
	}

	@Test
	public void testSelectSpell_InvalidOption() {
		ByteArrayOutputStream combinedStream = new ByteArrayOutputStream();
		PrintStream combinedPrint = new PrintStream(combinedStream);
		System.setOut(combinedPrint);
		System.setErr(combinedPrint);

		try {
			Army.spells.clear();
			Army.selectSpell(-5);
			assertTrue("La lista de hechizos debe estar vacia", Army.spells.isEmpty());

			String output = combinedStream.toString();
			assertTrue("Debe contener el mensaje de error", output.contains("Selecciona una opcion valida"));
		} catch (Exception e) {
			fail(e.getMessage());
		} finally {
			System.setOut(originalOut);
			System.setErr(System.err);
		}
	}

	@Test
	public void testViewArmy_Empty() {
		Army.viewArmy();
		String output = outContent.toString();
		assertTrue(output.contains("No hay tropas"));
		assertTrue(output.contains("No hay hechizos"));
	}

	@Test
	public void testViewArmy_WithTroopsAndSpells() {
		Army.selectTroop(1);
		Army.selectSpell(1);
		outContent.reset();

		Army.viewArmy();

		String output = outContent.toString();

		output = output.replaceAll("\u001B\\[[;\\d]*m", "").toLowerCase();

		assertTrue("Debe mostrar 'barbaro'", output.contains("barbaro"));
		assertTrue("Debe mostrar 'curacion'", output.contains("curacion"));
		assertTrue("Debe mostrar 'resumen de heroes'", output.contains("resumen de heroes"));
	}

	@Test
	public void testBarbarianKing_DefaultAvailability() {
		assertTrue("El Rey Barbaro deberia estar disponibe por defecto", Army.barbarianKing.isAvailability());
	}

	@Test
	public void testBarbarianKing_ToggleAvailabilityManually() {
		Army.barbarianKing.setAvailability(true);
		assertTrue(Army.barbarianKing.isAvailability());
		Army.barbarianKing.setAvailability(false);
		assertFalse(Army.barbarianKing.isAvailability());
	}
}
