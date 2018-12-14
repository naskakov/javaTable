package Model;

public class SportInfo {
	String name;
	String surname;
	String patronymic;
	String typeOfSport;
	String composition;
	String position;
	int title;
	String rasryad;

	public SportInfo(String name, String surname, String patronymic, String typeOfSport, String composition,
			String position, int title, String rasryad) {
		this.name = name;
		this.surname = surname;
		this.patronymic = patronymic;
		this.typeOfSport = typeOfSport;
		this.composition = composition;
		this.position = position;
		this.title = title;
		this.rasryad = rasryad;
	}

	public String NameReturn() {
		return name;
	}

	public String SurnameReturn() {
		return surname;
	}

	public String PatronymicReturn() {
		return patronymic;
	}

	public String TypeOfSportReturn() {
		return typeOfSport;
	}

	public String CompositionReturn() {
		return composition;
	}

	public String PositionReturn() {
		return position;
	}

	public int TitleReturn() {
		return title;
	}

	public String RasryadReturn() {
		return rasryad;
	}
}
