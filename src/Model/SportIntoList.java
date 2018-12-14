package Model;

import java.util.ArrayList;
import java.util.List;

public class SportIntoList {
	List<SportInfo> sportInfoList;
	private int thisPage;
	private int recordOnPage;

	public SportIntoList() {
		sportInfoList = new ArrayList<SportInfo>();
		thisPage = 1;
		recordOnPage = 5;
	}

	public SportInfo getRec(int ind) {
		return sportInfoList.get(ind);
	}

	public void addRec(SportInfo sportInfo) {
		sportInfoList.add(sportInfo);
	}

	public List<SportInfo> getSportInfo() {
		return sportInfoList;
	}
	
	public void delRecord (SportInfo sportInfo) {
		sportInfoList.remove(sportInfo);
	}
	 
	public int getSize() {
		return getSportInfo().size();
	}

	public int getRecordOnPage() {
		return recordOnPage;
	}

	public int getThisPage() {
		return thisPage;
	}

	public void nextPage() {
		boolean hasNextPage = sportInfoList.size() > recordOnPage * (thisPage - 1) + recordOnPage;
		if (hasNextPage)
			thisPage++;
	}

	public void prevPage() {
		if (thisPage > 1)
			thisPage--;

	}

	public void firstPage() {
		if (thisPage > 1)
			thisPage = 1;

	}

	public void lastPage() {
		if (thisPage != getNumberMaxPage())
			thisPage = getNumberMaxPage();

	}

	public int getNumberMaxPage() {
		return ((sportInfoList.size() - 1) / recordOnPage) + 1;
	}

	public void setRecordOnPage(int recordOnPage) {
		this.recordOnPage = recordOnPage;
	}

}
