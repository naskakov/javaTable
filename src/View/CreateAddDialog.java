package View;

import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.Text;

import Controller.SportController;
import Model.SportInfo;
import Model.SportIntoList;

public class CreateAddDialog {

	private Shell shell;
	FillLayout fillLayout;
	private Text textName;
	private Text textSurname;
	private Text textPatronymic;
	private Text textTypeOfSport;
	private Text textComposition;
	private Text textPosition;
	private Text textTitle;
	private Text textRasryad;
	private Button button1;
	private Label label1;
	private Label label2;
	private Label label3;
	private Label label4;
	private Label label5;
	private Label label6;
	private Label label7;
	private Label label8;
	private SportController controller;
	private SportTable sportTable;

	public CreateAddDialog(Display display, SportController controller, Shell shells, SportTable sportTable) {

		this.sportTable = sportTable;
		this.controller = controller;
		shell = new Shell(display);
		shell.setText("Добавление записи");
		fillLayout = new FillLayout();
		fillLayout.type = SWT.VERTICAL;
		shell.setLayout(fillLayout);
		shell.setLocation(500, 100);

		label1 = new Label(shell, SWT.NONE);
		label1.setText("Фамилия:");
		textSurname = new Text(shell, SWT.BORDER);

		label2 = new Label(shell, SWT.NONE);
		label2.setText("Имя:");
		textName = new Text(shell, SWT.BORDER);

		label3 = new Label(shell, SWT.NONE);
		label3.setText("Отчество :");
		textPatronymic = new Text(shell, SWT.BORDER);

		label4 = new Label(shell, SWT.NONE);
		label4.setText("Вид спорта:");
		textTypeOfSport = new Text(shell, SWT.BORDER);

		label5 = new Label(shell, SWT.NONE);
		label5.setText("Состав:");
		textComposition = new Text(shell, SWT.BORDER);

		label6 = new Label(shell, SWT.NONE);
		label6.setText("Позиция:");
		textPosition = new Text(shell, SWT.BORDER);

		label7 = new Label(shell, SWT.NONE);
		label7.setText("Титулы:");
		textTitle = new Text(shell, SWT.BORDER);

		label8 = new Label(shell, SWT.NONE);
		label8.setText("Разряд:");
		textRasryad = new Text(shell, SWT.BORDER);

		button1 = new Button(shell, SWT.NONE);
		button1.setText("Добавить");

		button1.addListener(SWT.Selection, new Listener() {
			public void handleEvent(Event e) {
				switch (e.type) {
				case SWT.Selection:
					createNewrecord(shells);
					shell.close();
					break;
				}
			}
		});

		shell.setSize(400, 600);
		shell.open();
		while (!shell.isDisposed()) {
			if (!display.readAndDispatch())
				display.sleep();
		}

	}

	private void createNewrecord(Shell shells) {

		if (isRecordCorrect()) {
			controller.createNewRecord(textName.getText(), textSurname.getText(), textPatronymic.getText(),
					textTypeOfSport.getText(), textRasryad.getText(), textTitle.getText(),
					textComposition.getText(), textPosition.getText(), sportTable);
		} else {
			//  "Ошибка"
		}

	}

	private boolean isRecordCorrect() {
		if (textName.getText().length() == 0 || textSurname.getText().length() == 0
				|| textPatronymic.getText().length() == 0 || textTypeOfSport.getText().length() == 0
				|| textComposition.getText().length() == 0 || textPosition.getText().length() == 0
				|| textTitle.getText().length() == 0 || textRasryad.getText().length() == 0) {
			return false;
		}

		return true;

	}
}
