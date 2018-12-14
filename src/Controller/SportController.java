package Controller;

import java.util.List;

import org.eclipse.swt.widgets.Shell;

import Model.SportInfo;
import Model.SportIntoList;
import View.SportTable;

public class SportController {
private SportIntoList sportIntoList;
private boolean isInit = false;
private SportTable sportTables;
	public SportController() {
	sportIntoList = new SportIntoList();
	
	}
	public SportInfo get(int ind) {
		return sportIntoList.getRec(ind);
	}

	public void add(SportInfo sportInfo) {
		sportIntoList.addRec(sportInfo);
	}

	public List<SportInfo> getSportInfo() {
		return sportIntoList.getSportInfo();
	}
	
	public void delRecord (SportInfo sportInfo) {
		sportIntoList.getSportInfo().remove(sportInfo);
	}
	
	public int getSize() {
		return sportIntoList.getSize();
	}
	
	public void addList (List<SportInfo> list) {
		for (int i=0; i<list.size(); i++) {
			add(list.get(i));
		}
	}
	public void setInit(Boolean isInits) {
		isInit = isInits;
	}
	
public void findRecord(Shell shell ,String textname, String textsurname, String textpatronymic, String textTypeOfSport, String textrasryad, String texttitle1, String texttitle2) {
		
		SportIntoList findList = new Finder(sportIntoList, textname, textsurname, textpatronymic, 
				textTypeOfSport, textrasryad, texttitle1, texttitle2).listFinder();
		
		System.out.println(texttitle1);
		System.out.println(texttitle2);
		System.out.println(findList.getSize());
		if (isInit) {
			sportTables.setList(findList.getSportInfo());
			sportTables.addRecortToTable(findList.getSportInfo());
			
			
		}else {
			sportTables = new SportTable(shell);
			sportTables.setList(findList.getSportInfo());
			sportTables.addRecortToTable(findList.getSportInfo());
			isInit = true;
		}
	}

	public int delRecord(String textname, String textsurname, String textpatronymic, String textTypeOfSport, String textrasryad, String texttitle1, String texttitle2, SportTable sportTable) {
		SportIntoList listDel = new Finder(sportIntoList, textname, textsurname, textpatronymic, 
				textTypeOfSport, textrasryad, texttitle1, texttitle2).listFinder();
	new Deliter().deliteRecord(listDel, sportTable, sportIntoList);
		return listDel.getSportInfo().size();
	}
	
	public void createNewRecord(String textName, String textSurname, String textPatronymic, String textTypeOfSport, String textRasryad,
			String textTitle, String textComposition, String textPosition, SportTable sportTable) {
		SportInfo sportInfo = new SportInfo(textName, textSurname, textPatronymic,
				textTypeOfSport, textComposition, textPosition,
				Integer.parseInt(textTitle), textRasryad);
		
		add(sportInfo);
		sportTable.addRecortToTable(getSportInfo());
	}
	
}
