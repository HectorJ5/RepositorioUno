package Model;

public abstract class Troop extends Unit {

	private int hitPoints;
	private int damage;
	private double movementSpeed;
	private int level;
	private double attackSpeedInSeconds;

	public Troop(String name, String descripton, int housingSpace, int hitPoints, int damage, double movementSpeed,
			int level, double attackSpeedInSeconds) {
		super(name, descripton, housingSpace);
		this.hitPoints = hitPoints;
		this.damage = damage;
		this.movementSpeed = movementSpeed;
		this.level = level;
		this.attackSpeedInSeconds = attackSpeedInSeconds;
	}

	public Troop(String name, String descripton, int hitPoints, int damage, double movementSpeed, int level,
			double attackSpeedInSeconds) {
		super(name, descripton);
		this.hitPoints = hitPoints;
		this.damage = damage;
		this.movementSpeed = movementSpeed;
		this.level = level;
		this.attackSpeedInSeconds = attackSpeedInSeconds;
	}

	public int getHitPoints() {
		return hitPoints;
	}

	public void setHitPoints(int hitPoints) {
		this.hitPoints = hitPoints;
	}

	public int getDamage() {
		return damage;
	}

	public void setDamage(int damage) {
		this.damage = damage;
	}

	public double getMovementSpeed() {
		return movementSpeed;
	}

	public void setMovementSpeed(double movementSpeed) {
		this.movementSpeed = movementSpeed;
	}

	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
	}

	public double getAttackSpeedInSeconds() {
		return attackSpeedInSeconds;
	}

	public void setAttackSpeedInSeconds(double attackSpeedInSeconds) {
		this.attackSpeedInSeconds = attackSpeedInSeconds;
	}

	@Override
	public String toString() {
		return super.toString() + " \u001B[37mTipo: Tropa\u001B[0m [" + 
				"\u001B[32mPuntos de vida: " + hitPoints + "\u001B[0m, " +
				"\u001B[31mdanio: " + damage + "\u001B[0m, " + 
				"\u001B[36mvelocidad de movimiento: " + movementSpeed + "\u001B[0m, " + 
				"\u001B[37mnivel: " + level + "\u001B[0m, " + 
				"\u001B[33mVelocidad de ataque en Segundos: " + attackSpeedInSeconds + "\u001B[0m" + 
				"]";
	}

}
