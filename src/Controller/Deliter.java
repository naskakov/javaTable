package Controller;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.MessageBox;

import Model.SportInfo;
import Model.SportIntoList;
import View.SportTable;

public class Deliter {
	
	SportIntoList sportInfoList;
	SportIntoList newList;
	
	private void deliter(SportIntoList sportInfoList) {
		this.sportInfoList = sportInfoList;
		SportIntoList newList = new SportIntoList();
	}
		
	public SportIntoList deliteRecord(SportIntoList listDel, SportTable sportTable, SportIntoList sportInfoList) {
		SportIntoList newList = new SportIntoList();
		for (SportInfo sportInfo : sportInfoList.getSportInfo()) {
			int adder = 0;
			for (SportInfo sportInfoDel : listDel.getSportInfo()) {
				if (sportInfoDel.equals(sportInfo)) {
					adder++;
				}
			}
			if (adder == 0) {
				newList.addRec(sportInfo);
			}
		}
		
		sportInfoList.getSportInfo().clear();
		for (int i = 0; i < newList.getSportInfo().size(); i++) {
			sportInfoList.addRec(newList.getRec(i));
		}
		sportTable.addRecortToTable(sportInfoList.getSportInfo());
		
		return newList;
	}

}
