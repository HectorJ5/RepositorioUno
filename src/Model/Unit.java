package Model;

public class Unit {
	private String name;
	private String descripton;
	private int housingSpace;

	public Unit(String name, String descripton, int housingSpace) {
		this.name = name;
		this.descripton = descripton;
		this.housingSpace = housingSpace;
	}

	public Unit(String name, String descripton) {
		this.name = name;
		this.descripton = descripton;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescripton() {
		return descripton;
	}

	public void setDescripton(String descripton) {
		this.descripton = descripton;
	}

	public int getHousingSpace() {
		return housingSpace;
	}

	public void setHousingSpace(int housingSpace) {
		this.housingSpace = housingSpace;
	}

	@Override
	public String toString() {
		return "\u001B[30mUnidad\u001B[0m" + " [" + "Nombre: " + name + ", " + "\u001B[32mDescripcion: " + descripton
				+ "\u001B[0m, " + "\u001B[33mEspacio en vivienda: " + housingSpace + "\u001B[0m" + "]";
	}

}