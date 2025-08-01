package Model;

public class Healing extends Spell {

	public Healing() {
		super("Curacion", "¡Cura a tus tropas y mantenlas luchando!", 2, 10.0, 12.0);
	}

	@Override
	public void effect() {
		System.out.println(
				"Usa este hechizo para crear un círculo de sanación y curar a tus unidades mientras se encuentren en su interior.");
	}

}
