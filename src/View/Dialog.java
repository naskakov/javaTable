package View;

import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.layout.RowData;
import org.eclipse.swt.layout.RowLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.MessageBox;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.Text;

import Controller.Deliter;
import Controller.Finder;
import Controller.SportController;
import Model.SportInfo;
import Model.SportIntoList;

public class Dialog {
	
	private Shell shell;
	private SportTable sportTable;
	private FillLayout fillLayout;
	private Label labelname;
	private Label labelsurname;
	private Label labelTypeOfSport;
	private Label labelpatronymic;
	private Label labelrasryad;
	private Label labeltitle1;
	private Label labeltitle2;
	private Text textname;
	private Text textsurname;
	private Text textpatronymic;
	private Text textrasryad;
	private Text texttitle1;
	private Text texttitle2;
	private Text textTypeOfSport;
	private Button button1;
	private SportController controller;
	private Shell shells;
	private SportTable sportTables = null;
	
	public Dialog(Shell shell,String title, String nameBut, SportController controller, SportTable sportTable, Listener listener) {
		
		this.shell = shell;
		this.sportTable = sportTable;
		this.controller = controller;
		
		shell.setText(title);
		RowLayout rowLayout = new RowLayout();
		rowLayout.type = SWT.VERTICAL;
        rowLayout.marginTop    = 5;
        rowLayout.marginRight  = 15;
        rowLayout.marginBottom = 15;
        rowLayout.marginLeft   = 5;
        rowLayout.spacing      = 10;

        rowLayout.wrap = true;
        rowLayout.pack = true;
        rowLayout.justify = true;
		shell.setLayout(rowLayout);
		shell.setLocation(500, 100);

		labelname = new Label(shell, SWT.NONE);
		labelname.setText("Имя:");
		textname = new Text(shell, SWT.BORDER);
		textname.setLayoutData(new RowData(200, 20));

		labelsurname = new Label(shell, SWT.NONE);
		labelsurname.setText("Фамилия:");
		textsurname = new Text(shell, SWT.BORDER);
		textsurname.setLayoutData(new RowData(200, 20));

		labelpatronymic = new Label(shell, SWT.NONE);
		labelpatronymic.setText("Отчество:");
		textpatronymic = new Text(shell, SWT.BORDER);
		textpatronymic.setLayoutData(new RowData(200, 20));

		labelTypeOfSport = new Label(shell, SWT.NONE);
		labelTypeOfSport.setText("Вид спорта:");
		textTypeOfSport = new Text(shell, SWT.BORDER);
		textTypeOfSport.setLayoutData(new RowData(200, 20));

		labelrasryad = new Label(shell, SWT.NONE);
		labelrasryad.setText("Разряд:");
		textrasryad = new Text(shell, SWT.BORDER);
		textrasryad.setLayoutData(new RowData(200, 20));

		labeltitle1 = new Label(shell, SWT.NONE);
		labeltitle1.setText("Титул нижняя граница:");
		texttitle1 = new Text(shell, SWT.BORDER);
		texttitle1.setLayoutData(new RowData(200, 20));

		labeltitle2 = new Label(shell, SWT.NONE);
		labeltitle2.setText("Титул верхняя граница:");
		texttitle2 = new Text(shell, SWT.BORDER);
		texttitle2.setLayoutData(new RowData(200, 20));

		button1 = new Button(shell, SWT.NONE);
		button1.setText(nameBut);
		button1.setLayoutData(new RowData(200, 20));
		button1.addListener(SWT.Selection, listener);
		
		shell.setSize(350, 600);
		shell.open();	
		
	}
	
	public void findRecord() {
		controller.findRecord(shell, textname.getText(), textsurname.getText(), textpatronymic.getText(),
				textTypeOfSport.getText(), textrasryad.getText(), texttitle1.getText(), texttitle2.getText());
		shell.layout();
		
	}
	
	public int delRecord() {
		return controller.delRecord(textname.getText(), textsurname.getText(), textpatronymic.getText(),
				textTypeOfSport.getText(), textrasryad.getText(), texttitle1.getText(), texttitle2.getText(), sportTable);
	}
	

}
