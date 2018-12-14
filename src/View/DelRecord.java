package View;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.MessageBox;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.Text;

import Controller.SportController;
import Model.SportInfo;
import Model.SportIntoList;
public class DelRecord {

	private Shell shell;
	private Shell shells;
	private Table table;
	private SportController controller;
	private Display display;
	private Dialog dialog;

	public DelRecord(Display display, SportController controller, Shell shells, SportTable sportTable) {
		this.controller = controller;
		this.display = display;
		this.shells = shells;
		shell = new Shell(display);
		
		
		dialog = new Dialog(shell, "Удаление записи", "Удалить", controller,sportTable, new Listener() {
			
			@Override
			public void handleEvent(Event event) {
				deleteRecord();
				shell.close();
			}
		});
		
	}
	
	private void deleteRecord() {
		
		int sizeList = dialog.delRecord();
		int style = SWT.APPLICATION_MODAL | SWT.OK;
		MessageBox messageBox = new MessageBox(shells, style);
		messageBox.setText("Удалено");
		messageBox.setMessage("Было удалено " + sizeList + " запись(ей)");
		int rc = messageBox.open();
	}

}
