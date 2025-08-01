package Model;

public class BarbarianKing extends Hero {
	public BarbarianKing() {
		super("Rey Barbaro",
				"El barbaro más imponente y más valiente de todos. Esta colosal amenaza es capaz de resistir ingentes cantidades de daño y de aniquilar a base de espadazos todo lo que encuentre a su paso. Defiende su territorio a capa y espada.",
				12100, 643, 16.0, 100, 1.2, true);
	}

	@Override
	public void abilities() {
		System.out.println("Invoca serpientes que luchan junto a ti al recibir daño.");
		System.out.println("Invoca una manada de bárbaros enfurecidos.");
	}

}
