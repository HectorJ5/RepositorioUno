package Model;

public class LightningSpell extends Spell {

	public LightningSpell() {
		super("Hcehizo Rayo", "¡Electrocuta a tus enemigos con un rayo!", 1, 1.0, 0.4);
	}

	@Override
	public void effect() {
		System.out.println(
				"Usa este hechizo contra la aldea enemiga para dañar y aturdir edificios y unidades en un área pequeña.");
	}
}
