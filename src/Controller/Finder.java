package Controller;

import Model.SportInfo;
import Model.SportIntoList;

public class Finder {
	SportIntoList listLoc = new SportIntoList();
	SportIntoList sportInfoList;
	String textname;
	String textsurname;
	String textpatronymic;
	String textTypeOfSport;
	String textrasryad;
	String texttitle1;
	String texttitle2;

	public Finder(SportIntoList sportInfoList, String textname, String textsurname, String textpatronymic, String textTypeOfSport , 
			String textrasryad, String texttitle1, String texttitle2) {
		this.sportInfoList = sportInfoList;
		this.textname = textname;
		this.textsurname = textsurname;
		this.textpatronymic = textpatronymic;
		this.textTypeOfSport = textTypeOfSport;
		this.textrasryad = textrasryad;
		this.texttitle1 = texttitle1;
		this.texttitle2 = texttitle2;
	}
	
	public SportIntoList listFinder() {
		
		
		if (textname.length() != 0 && textsurname.length() != 0
				&& textpatronymic.length() != 0 && textTypeOfSport.length() != 0) {
			return finder1(textname, textsurname, textpatronymic, textTypeOfSport);
		}
		
		if (textname.length() != 0 && textsurname.length() != 0
				&& textpatronymic.length() != 0 && textrasryad.length() != 0) {
			return finder2(textname, textsurname, textpatronymic, textrasryad);
		}
		
		return finder3(texttitle1, texttitle2);
	}
	
	private SportIntoList finder1 (String textname, String textsurname, String textpatronymic, String textTypeOfSport ) { 
			for (SportInfo sportInfo : sportInfoList.getSportInfo()) {
				if (textname.equals(sportInfo.NameReturn())
						&& textsurname.equals(sportInfo.SurnameReturn())
						&& textpatronymic.equals(sportInfo.PatronymicReturn())
						&& textTypeOfSport.equals(sportInfo.TypeOfSportReturn())) {
					listLoc.addRec(sportInfo);
				}
			}
			return listLoc;
		}
	private SportIntoList finder2 (String textname, String textsurname, String textpatronymic, String textrasryad ) { 
			for (SportInfo sportInfo : sportInfoList.getSportInfo()) {
				if (textname.equals(sportInfo.NameReturn())
						&& textsurname.equals(sportInfo.SurnameReturn())
						&& textpatronymic.equals(sportInfo.PatronymicReturn())
						&& textrasryad.equals(sportInfo.RasryadReturn())) {
					listLoc.addRec(sportInfo);
				}
			}
			return listLoc;
		}
	
	private SportIntoList finder3 (String texttitle1, String texttitle2 ) { 
			for (SportInfo sportInfo : sportInfoList.getSportInfo()) {
				if (Integer.parseInt(texttitle1) <= sportInfo.TitleReturn()
						&& Integer.parseInt(texttitle2) >= sportInfo.TitleReturn()) {
					listLoc.addRec(sportInfo);
				}
			}
			return listLoc;
		}
		
	

}
