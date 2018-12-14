package Model;

import java.util.List;

public class Model {
	private SportIntoList sportInfoList;

	public Model(SportIntoList sportInfoList) {
		this.sportInfoList = sportInfoList;
	}

	public SportIntoList getTableModel() {
		return sportInfoList;
	}

	public List<SportInfo> getSportInfo() {
		return sportInfoList.getSportInfo();
	}
}
