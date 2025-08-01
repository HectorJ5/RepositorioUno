package Model;

public abstract class Hero extends Troop {

	private boolean availability;

	public Hero(String name, String descripton, int hitPoints, int damage, double movementSpeed, int level,
			double attackSpeed, boolean availability) {
		super(name, descripton, hitPoints, damage, movementSpeed, level, attackSpeed);
		this.availability = availability;
	}

	public abstract void abilities();

	public boolean isAvailability() {
		return availability;
	}

	public void setAvailability(boolean availability) {
		this.availability = availability;
	}

	@Override
	public String toString() {
		return "\u001B[37mUnidad\u001B[0m [" + "nombre: " + getName() + ", " + "\u001B[32mDescripción: "
				+ getDescripton() + "\u001B[0m, " + "\u001B[33mEspacio en vivienda: " + getHousingSpace() + "\u001B[0m"
				+ "]\n" + " \u001B[37mTipo: Heroe\u001B[0m [" + "\u001B[32mPuntos de vida: " + getHitPoints()
				+ "\u001B[0m, " + "\u001B[31mDaño: " + getDamage() + "\u001B[0m, "
				+ "\u001B[36mVelocidad de movimiento: " + getMovementSpeed() + "\u001B[0m, " + "\u001B[37mNivel: "
				+ getLevel() + "\u001B[0m, " + "\u001B[33mVelocidad de ataque: " + getAttackSpeedInSeconds()
				+ "\u001B[0m, " + "\u001B[35mDisponibilidad:\u001B[0m "
				+ (availability ? "\u001B[32mDisponible" : "\u001B[31mNo disponible") + "\u001B[0m]";
	}

}
