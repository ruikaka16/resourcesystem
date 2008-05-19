package com.buaa.project.client.panel;

import java.util.Iterator;
import java.util.List;

import com.buaa.project.client.DatabaseService;
import com.buaa.project.client.DatabaseServiceAsync;
import com.buaa.project.client.data.BeanDTO;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;

import com.gwtext.client.core.EventObject;
import com.gwtext.client.data.ArrayReader;
import com.gwtext.client.data.FieldDef;

import com.gwtext.client.data.Record;
import com.gwtext.client.data.RecordDef;
import com.gwtext.client.data.Store;
import com.gwtext.client.data.StringFieldDef;
import com.gwtext.client.widgets.Button;
import com.gwtext.client.widgets.HTMLPanel;
import com.gwtext.client.widgets.MessageBox;
import com.gwtext.client.widgets.Panel;
import com.gwtext.client.widgets.Toolbar;
import com.gwtext.client.widgets.ToolbarButton;
import com.gwtext.client.widgets.event.ButtonListenerAdapter;
import com.gwtext.client.widgets.grid.ColumnConfig;
import com.gwtext.client.widgets.grid.ColumnModel;
import com.gwtext.client.widgets.grid.GridPanel;
import com.gwtext.client.widgets.grid.GridView;
import com.gwtext.client.widgets.grid.event.GridCellListenerAdapter;

public class LoadDataPanel extends Panel {

	String news_title;
	
	public LoadDataPanel() {

		this.setBorder(false);
		this.setPaddings(0);
		this.setWidth(577);
		this.setIconCls("grid-icon");

		final Panel panel = new Panel();
		panel.setBorder(false);
		panel.setWidth(577);

		final Toolbar refreshTb = new Toolbar();
	
		refreshTb.addFill();

		final ToolbarButton refreshBt = new ToolbarButton("刷新");

	

		final GridPanel grid = new GridPanel();

		final RecordDef recordDef = new RecordDef(new FieldDef[] {
				new StringFieldDef("N_ID"), new StringFieldDef("N_TITLE"),
				new StringFieldDef("N_AUTHOR"), new StringFieldDef("N_TIME")

		});

		final ColumnModel columnModel = new ColumnModel(new ColumnConfig[] {
				new ColumnConfig("序号", "N_ID", 50, true),
				new ColumnConfig("新闻标题", "N_TITLE", 330, true),
				new ColumnConfig("发布单位", "N_AUTHOR", 100, true),
				new ColumnConfig("发布时间", "N_TIME", 76, true)

		});

		final DatabaseServiceAsync loadService = DatabaseService.Util.getInstance();

		final AsyncCallback cb_load = new AsyncCallback() {

			public void onFailure(Throwable caught) {
				// TODO Auto-generated method stub
				Window.alert("Fail to getting data" + caught.toString());
			}

			public void onSuccess(Object response) {
				ArrayReader reader = new ArrayReader(recordDef);
				// Store store = grid.getStore();
				Store store = new Store(reader);
				store.load();
				grid.setStore(store);
				//grid.setTitle("新闻列表");
				grid.setColumnModel(columnModel);
				grid.setWidth(577);
				grid.setHeight(500);
				grid.setFrame(true);
				grid.stripeRows(true);
				   
				grid.setBottomToolbar(refreshBt);
				GridView view = new GridView();
				view.setForceFit(true);
				grid.setView(view);
				
				panel.add(grid);
				panel.doLayout();

				if (store == null) {
					return;
				}

				List data = (List) response;
				Iterator it = data.iterator();
				while (it.hasNext()) {
					
					final BeanDTO bean = (BeanDTO) it.next();
					//System.out.println(bean.getN_TITLE()+"****");
					store.add(recordDef.createRecord(bean.toObjectArray()));

				}

				store.commitChanges();

				// grid.setStore(store);

				// panel.add(grid);
			}

		};
		loadService.getdata(cb_load);
		
		grid.addGridCellListener(new GridCellListenerAdapter (){
			public void onCellClick(GridPanel grid, int rowIndex, int title, EventObject e){
				
				Record[] records = grid.getSelectionModel().getSelections();  
				news_title = "";
				for(int i=0;i<records.length;++i)
				{
					Record record = records[i];   
				
					news_title  += record.getAsString("N_ID");
				
				}
	
				DatabaseServiceAsync getNewsContentService = DatabaseService.Util.getInstance();
				AsyncCallback cb_getNewsContent = new AsyncCallback() {

					
					public void onFailure(Throwable arg0) {
						// TODO Auto-generated method stub
						
					}

					public void onSuccess(Object result) {
						// TODO Auto-generated method stub
					
						System.out.println(result.toString());
						
						Panel newsPanel = new HTMLPanel();
						
						newsPanel.setHtml(result.toString());
						NewsWindow newWindow = new NewsWindow();
						newWindow.setFrame(true);
						newWindow.setTitle(news_title);
						newWindow.add(newsPanel);
						newWindow.show();
						
					}
					
				};
				
				getNewsContentService.getNewsContent(news_title,cb_getNewsContent);

			
			}
		});

		
	refreshBt.addListener(new ButtonListenerAdapter(){
			
			public void onClick(Button button, EventObject e){
				
				DatabaseServiceAsync loadService = DatabaseService.Util.getInstance();

				AsyncCallback cb_load = new AsyncCallback() {

					public void onFailure(Throwable arg0) {
						// TODO Auto-generated method stub
						
					}

					public void onSuccess(Object response) {
					
						ArrayReader reader = new ArrayReader(recordDef);
						// Store store = grid.getStore();
						Store store = new Store(reader);
						store.load();
						grid.setStore(store);
						//grid.setTitle("新闻列表");
						grid.setColumnModel(columnModel);
						grid.setWidth(577);
						grid.setHeight(500);
						grid.setFrame(true);
						grid.stripeRows(true);
						   
						grid.setBottomToolbar(refreshBt);
						GridView view = new GridView();
						view.setForceFit(true);
						grid.setView(view);
						
						panel.add(grid);
						panel.doLayout();

						if (store == null) {
							return;
						}

						List data = (List) response;
						Iterator it = data.iterator();
						while (it.hasNext()) {
							
							final BeanDTO bean = (BeanDTO) it.next();
							//System.out.println(bean.getN_TITLE()+"****");
							store.add(recordDef.createRecord(bean.toObjectArray()));

						}

						store.commitChanges();

					}

				};
				loadService.getdata(cb_load);
				
			}
		});
		
		refreshTb.addButton(refreshBt);
		this.add(panel);
	}

}