package Controller;

import java.io.File;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.FileDialog;
import org.eclipse.swt.widgets.Shell;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

import Model.SportInfo;
import Model.SportIntoList;

public class FileSave {
	private SportController controller;

	public FileSave(SportController controller, String file) {
		this.controller = controller;
		try {
			DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();

			// Корневой элемент
			Document document = documentBuilder.newDocument();
			Element rootElement = document.createElement("sport");
			document.appendChild(rootElement);
			for (SportInfo sportInfo : controller.getSportInfo()) {

				// Child's корневого элемента
				Element sport_info = document.createElement("sport_info");
				rootElement.appendChild(sport_info);

				Element first_name_student = document.createElement("name");
				first_name_student.appendChild(document.createTextNode(sportInfo.NameReturn()));
				sport_info.appendChild(first_name_student);

				Element last_name_student = document.createElement("surname");
				last_name_student.appendChild(document.createTextNode(sportInfo.SurnameReturn()));
				sport_info.appendChild(last_name_student);

				Element patronymic_student = document.createElement("patronymic");
				patronymic_student.appendChild(document.createTextNode(sportInfo.PatronymicReturn()));
				sport_info.appendChild(patronymic_student);

				Element birthday = document.createElement("title");
				birthday.appendChild(document.createTextNode(Integer.toString(sportInfo.TitleReturn())));
				sport_info.appendChild(birthday);

				Element composition = document.createElement("composition");
				composition.appendChild(document.createTextNode(sportInfo.CompositionReturn()));
				sport_info.appendChild(composition);

				Element faculty = document.createElement("typeOfSport");
				faculty.appendChild(document.createTextNode(sportInfo.TypeOfSportReturn()));
				sport_info.appendChild(faculty);

				Element position = document.createElement("rasryad");
				position.appendChild(document.createTextNode(sportInfo.RasryadReturn()));
				sport_info.appendChild(position);

				Element team = document.createElement("position");
				team.appendChild(document.createTextNode(sportInfo.PositionReturn()));
				sport_info.appendChild(team);
			}
			// Теперь запишем контент в XML файл
			TransformerFactory transformerFactory = TransformerFactory.newInstance();
			Transformer transformer = transformerFactory.newTransformer();
			DOMSource domSource = new DOMSource(document);
			StreamResult streamResult = new StreamResult(new File(file + ".xml"));

			transformer.transform(domSource, streamResult);
			System.out.println("Файл сохранен!");
		} catch (ParserConfigurationException pce) {
			System.out.println(pce.getLocalizedMessage());
			pce.printStackTrace();
		} catch (TransformerException te) {
			System.out.println(te.getLocalizedMessage());
			te.printStackTrace();
		}

	}
}