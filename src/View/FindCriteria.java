package View;

import org.eclipse.swt.events.DisposeEvent;
import org.eclipse.swt.events.DisposeListener;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Shell;

import Controller.SportController;
import Model.SportIntoList;

public class FindCriteria {


	private Dialog dialog;

	public FindCriteria(Display display, SportController controller, SportTable sportTable) {
		Shell shell = new Shell(display);
		dialog = new Dialog(shell, "Поиск записи", "Поиск", controller ,sportTable, new Listener() {
			
			@Override
			public void handleEvent(Event event) {
				shell.setSize(1300, 800);
				findRec();
				
			}
		});
		shell.addDisposeListener(new DisposeListener() {
			
			@Override
			public void widgetDisposed(DisposeEvent e) {
				controller.setInit(false);
			}
		});
	}
	
	private void findRec() {
		dialog.findRecord();
	}

}
