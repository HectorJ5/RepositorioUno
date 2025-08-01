package Model;

public abstract class Spell extends Unit {
	private double effectRadius;
	private double timeDurationInSeconds;

	public Spell(String name, String descripton, int housingSpace, double effectRadius, double timeDurationInSeconds) {
		super(name, descripton, housingSpace);
		this.effectRadius = effectRadius;
		this.timeDurationInSeconds = timeDurationInSeconds;
	}

	public abstract void effect();

	public double getEffectRadius() {
		return effectRadius;
	}

	public void setEffectRadius(double effectRadius) {
		this.effectRadius = effectRadius;
	}

	public double getTimeDurationInSeconds() {
		return timeDurationInSeconds;
	}

	public void setTimeDurationInSeconds(double timeDurationInSeconds) {
		this.timeDurationInSeconds = timeDurationInSeconds;
	}

	@Override
	public String toString() {
		return super.toString() + " \u001B[37mTipo: Hechizo\u001B[0m [" + "\u001B[36mRadio de efecto: " + effectRadius
				+ "\u001B[0m, " + "\u001B[31mtiempo de duracion en segundos: " + timeDurationInSeconds + "\u001B[0m"
				+ "]";
	}

}
