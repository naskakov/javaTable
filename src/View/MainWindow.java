package View;

import java.io.File;
import java.lang.ModuleLayer.Controller;
import java.util.List;

import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.RowLayout;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.swt.widgets.MenuItem;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Table;

import Controller.FileSave;
import Controller.OpenFile;
import Controller.SportController;
import Model.Model;
import Model.SportIntoList;

public class MainWindow {
	private Display display;
	private Shell shell;
	private Table table;
	private SportController sportController;

	public MainWindow() {
		display = new Display();
		shell = new Shell(display);
		shell.setText("Window");

		RowLayout rowLayout = new RowLayout();
		rowLayout.spacing = 0;
		shell.setLayout(rowLayout);
		shell.setLocation(300, 100);
		
		SportTable sportTable = new SportTable(shell);
		sportController = sportTable.getSportController();
		
		sportController.addList(new OpenFile().read());
		sportTable.addRecortToTable(sportController.getSportInfo());
		

		Menu menuBar = new Menu(shell, SWT.BAR);
		shell.setMenuBar(menuBar);

		MenuItem fileItem = new MenuItem(menuBar, SWT.CASCADE);
		fileItem.setText("Таблица");

		MenuItem editItem = new MenuItem(menuBar, SWT.CASCADE);
		editItem.setText("Файл");

		Menu submenu = new Menu(shell, SWT.DROP_DOWN);
		fileItem.setMenu(submenu);

		Menu submenu1 = new Menu(shell, SWT.DROP_DOWN);
		editItem.setMenu(submenu1);

		MenuItem item = new MenuItem(submenu, SWT.PUSH);
		item.setText("Добавить запись");
		item.addListener(SWT.Selection, new Listener() {
			@Override
			public void handleEvent(Event e) {
				new CreateAddDialog(display, sportController, shell,sportTable);
			}
		});
		MenuItem item2 = new MenuItem(submenu, SWT.PUSH);
		item2.setText("Удалить запись");
		item2.addListener(SWT.Selection, new Listener() {
			@Override
			public void handleEvent(Event e) {
				new DelRecord(display, sportController, shell, sportTable);
			}
		});
		MenuItem item3 = new MenuItem(submenu, SWT.PUSH);
		item3.setText("Поиск записи");
		item3.addListener(SWT.Selection, new Listener() {
			@Override
			public void handleEvent(Event e) {
				new FindCriteria(display, sportController, sportTable);
			}
		});
		MenuItem item4 = new MenuItem(submenu1, SWT.PUSH);
		item4.setText("Сохранить файл");
		item4.addListener(SWT.Selection, new Listener() {
			@Override
			public void handleEvent(Event e) {
				new FileSaveWind(sportController, display);
			}
		});

		shell.setSize(1000, 650);
		shell.open();
		while (!shell.isDisposed()) {
			if (!display.readAndDispatch())
				display.sleep();
		}
		display.dispose();
	}
	
	
	public static void main(String[] args) {
		new MainWindow();

	}

}
