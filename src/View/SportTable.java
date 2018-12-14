package View;

import java.util.List;

import javax.swing.plaf.BorderUIResource;

import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.layout.RowData;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.swt.widgets.MenuItem;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;

import Controller.SportController;
import Model.SportInfo;
import Model.SportIntoList;


public class SportTable {
	private SportController sportController;
	private Table table;
	private Combo combo;
	private int curPage = 1;
	private int maxPage;
	private Label labelPageMax;
	private Label labelRecord;
	private boolean isInit = false;
	private List<SportInfo> list;
	
	public SportTable(Shell shell) {
		
		sportController = new SportController();
		list = sportController.getSportInfo();
		 combo = new Combo(shell, SWT.DROP_DOWN | SWT.READ_ONLY);
		 combo.add("5");
		 combo.add("10");
		 combo.add("50");
		 combo.select(0);
		 combo.addListener(SWT.Selection, new Listener() {
			
			@Override
			public void handleEvent(Event event) {
				table.setItemCount(Integer.parseInt(combo.getItem(combo.getSelectionIndex())));
				addRecortToTable(list);
			}
		});
		table = new Table(shell, SWT.SINGLE | SWT.FULL_SELECTION);
		table.setHeaderVisible(true);
		table.setLinesVisible(true);
		isInit = table.isVisible();
		String[] titles = { "№", "ФИО", "Вид спорта", "Состав", "Позиция", "Титулы", "Разряд" };
		for (int loopIndex = 0; loopIndex < titles.length; loopIndex++) {
			TableColumn column = new TableColumn(table, SWT.NONE);
			column.setText(titles[loopIndex]);
			column.setWidth(140);
		}
		
		FillLayout fillLayout = new FillLayout();
		fillLayout.type = SWT.HORIZONTAL;
		table.setLayout(fillLayout);
		table.setItemCount(Integer.parseInt(combo.getItem(combo.getSelectionIndex())));
		table.setLayoutData(new RowData(950, 450));

		Button buttonOnePage = new Button(shell, SWT.NONE);
		buttonOnePage.setText("Первая страница");
		buttonOnePage.addListener(SWT.Selection, new Listener() {
			public void handleEvent(Event e) {
				switch (e.type) {
				case SWT.Selection:
					curPage = 1;
					addRecortToTable(list);
					break;
				}
			}
		});

		Button buttonPrevPage = new Button(shell, SWT.NONE);
		buttonPrevPage.setText("Предыдущая страница");
		buttonPrevPage.addListener(SWT.Selection, new Listener() {
			public void handleEvent(Event e) {
				switch (e.type) {
				case SWT.Selection:
					curPage--;
					addRecortToTable(list);
					break;
				}
			}
		});

		Button buttonNextPage = new Button(shell, SWT.NONE);
		buttonNextPage.setText("Следующая страница");
		buttonNextPage.addListener(SWT.Selection, new Listener() {
			public void handleEvent(Event e) {
				switch (e.type) {
				case SWT.Selection:
						curPage++;
						addRecortToTable(list);
					break;
				}
			}
		});

		Button buttonEndPage = new Button(shell, SWT.NONE);
		buttonEndPage.setText("Последняя страница");
		buttonEndPage.addListener(SWT.Selection, new Listener() {
			public void handleEvent(Event e) {
				switch (e.type) {
				case SWT.Selection:
					curPage = maxPage;
					System.out.print(curPage);
					addRecortToTable(list);
					break;
				}
			}
		});
		
		
		labelRecord = new Label(shell,SWT.NONE);
		
		
		labelPageMax = new Label(shell,SWT.NONE);
		labelPageMax.setLayoutData(new RowData(500, 20));
		

    }
	public boolean isInit() {
		return isInit;
	}
	
	private void getCountCstr(List<SportInfo> list) {
		int colzap = list.size();
		int comboSel = Integer.parseInt(combo.getItem(combo.getSelectionIndex()));
		if (colzap % comboSel > 0) {
			maxPage = (int) (colzap / comboSel) + 1;
		}
		else {
			maxPage = (int) (colzap / comboSel);
		}
		
	}
	
	public void addRecortToTable(List<SportInfo> list) {
		
		getCountCstr(list);
		int comboSel = Integer.parseInt(combo.getItem(combo.getSelectionIndex()));
		
		if (curPage > maxPage) {
			curPage = maxPage;
		}
		if(curPage < 1 ) {
			curPage = 1;
		}
		
		labelRecord.setText("Число записей: " + list.size());
		labelPageMax.setText("Текущая страница/Max число стр.: " + curPage + "/" + maxPage);
		String fio;
		int id = 1;
		int stId = (curPage- 1) * comboSel + 1;
		int lastId = curPage * comboSel+1;
		table.clearAll();

	while (stId != lastId && stId != list.size()+1 ) {
		SportInfo sportInfo = list.get(stId-1);
			fio = sportInfo.NameReturn() + " " + sportInfo.PatronymicReturn() + " " + sportInfo.SurnameReturn();
			table.getItem(id - 1).setText(0, Integer.toString(stId));
			table.getItem(id - 1).setText(1, fio);
			table.getItem(id - 1).setText(2, sportInfo.TypeOfSportReturn());
			table.getItem(id - 1).setText(3, sportInfo.CompositionReturn());
			table.getItem(id - 1).setText(4, sportInfo.PositionReturn());
			table.getItem(id - 1).setText(5, Integer.toString(sportInfo.TitleReturn()));
			table.getItem(id - 1).setText(6, sportInfo.RasryadReturn());
			id++;
			stId++;
	}
	
	}
	public SportController getSportController() {
        return sportController;
    }
	
	public void setList(List<SportInfo> lists) {
		list = lists;
	}
	
}