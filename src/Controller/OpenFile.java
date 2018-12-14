package Controller;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.FileDialog;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Table;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import Model.SportInfo;
import Model.SportIntoList;

public class OpenFile {
	private List<SportInfo> list;
	

	public OpenFile() {
		 list = new ArrayList<SportInfo>();
	      try {
	         File file = new File("C:\\Users\\naska\\eclipse-workspace\\secondLB\\iblog.xml");
	         SAXParserFactory factory = SAXParserFactory.newInstance();
	         SAXParser saxParser = factory.newSAXParser();
	         UserHandler userhandler = new UserHandler(list);
	         saxParser.parse(file, userhandler);     
	      } catch (Exception e) {
	         e.printStackTrace();
	      }
	   }   

	public List<SportInfo> read() {
		return list;
	}
}

class UserHandler extends DefaultHandler {

	private String nameStr;
	private String surnameStr;
	private String patronymicStr;
	private String typeOfSportStr;
	private String compositionStr;
	private String positionStr;
	private int titleStr;
	private String rasryadStr;
	private List<SportInfo> list;

	boolean name = false;
	boolean surname = false;
	boolean patronymic = false;
	boolean title = false;
	boolean composition = false;
	boolean typeOfSport = false;
	boolean rasryad = false;
	boolean position = false;

	public UserHandler(List<SportInfo> list) {
		this.list = list;
	}

	@Override
	public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {

		if (qName.equalsIgnoreCase("sport")) {
		} else if (qName.equalsIgnoreCase("name")) {
			name = true;
		} else if (qName.equalsIgnoreCase("surname")) {
			surname = true;
		} else if (qName.equalsIgnoreCase("patronymic")) {
			patronymic = true;
		} else if (qName.equalsIgnoreCase("title")) {
			title = true;
		} else if (qName.equalsIgnoreCase("composition")) {
			composition = true;
		} else if (qName.equalsIgnoreCase("typeOfSport")) {
			typeOfSport = true;
		} else if (qName.equalsIgnoreCase("rasryad")) {
			rasryad = true;
		} else if (qName.equalsIgnoreCase("position")) {
			position = true;
		}
	}

	@Override
	public void endElement(String uri, String localName, String qName) throws SAXException {

		if (qName.equalsIgnoreCase("sport_info")) {
			SportInfo sportInfo = new SportInfo(nameStr, surnameStr, patronymicStr, typeOfSportStr, compositionStr,
					positionStr, titleStr, rasryadStr);
			list.add(sportInfo);

		}
	}

	@Override
	public void characters(char ch[], int start, int length) throws SAXException {

		if (name) {
			nameStr = new String(ch, start, length);
			name = false;
		} else if (surname) {
			surnameStr = new String(ch, start, length);
			surname = false;
		} else if (patronymic) {
			patronymicStr = new String(ch, start, length);
			patronymic = false;
		} else if (title) {
			String title1 = new String(ch, start, length);
			int title2 = Integer.parseInt(title1);
			titleStr = title2;
			title = false;
		} else if (composition) {
			compositionStr = new String(ch, start, length);
			composition = false;
		} else if (typeOfSport) {
			typeOfSportStr = new String(ch, start, length);
			typeOfSport = false;
		} else if (rasryad) {
			rasryadStr = new String(ch, start, length);
			rasryad = false;
		} else if (position) {
			positionStr = new String(ch, start, length);
			position = false;
		}
	}
}
