package View;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.FileDialog;
import org.eclipse.swt.widgets.Shell;

import Controller.FileSave;
import Controller.SportController;
import Model.SportIntoList;



public class FileSaveWind {
	
	private Shell shell;
	private Display display;
	private SportController controller;
	
	public FileSaveWind(SportController controller, Display display) {
		shell = new Shell(display);

		FileDialog dlg = new FileDialog(shell, SWT.OPEN);
		dlg.setFilterNames(new String[] { "xml" });
		dlg.setFilterExtensions(new String[] { "*.xml" });
		String fname = dlg.open();
		new FileSave(controller, fname);
	}

}
