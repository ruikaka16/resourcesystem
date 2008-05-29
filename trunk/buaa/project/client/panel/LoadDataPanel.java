package com.buaa.project.client.panel;

import java.util.Iterator;
import java.util.List;

import com.buaa.project.client.DatabaseService;
import com.buaa.project.client.DatabaseServiceAsync;
import com.buaa.project.client.data.BeanDTO;
import com.google.gwt.user.client.Timer;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;

import com.gwtext.client.core.EventObject;
import com.gwtext.client.core.Ext;
import com.gwtext.client.core.ExtElement;
import com.gwtext.client.core.Template;
import com.gwtext.client.data.ArrayReader;
import com.gwtext.client.data.FieldDef;

import com.gwtext.client.data.Record;
import com.gwtext.client.data.RecordDef;
import com.gwtext.client.data.Store;
import com.gwtext.client.data.StringFieldDef;
import com.gwtext.client.widgets.Button;
import com.gwtext.client.widgets.HTMLPanel;
import com.gwtext.client.widgets.MessageBox;
import com.gwtext.client.widgets.MessageBoxConfig;
import com.gwtext.client.widgets.PagingToolbar;
import com.gwtext.client.widgets.Panel;
import com.gwtext.client.widgets.ToolTip;
import com.gwtext.client.widgets.Toolbar;
import com.gwtext.client.widgets.ToolbarButton;
import com.gwtext.client.widgets.WaitConfig;
import com.gwtext.client.widgets.event.ButtonListenerAdapter;
import com.gwtext.client.widgets.event.PanelListenerAdapter;
import com.gwtext.client.widgets.form.Field;
import com.gwtext.client.widgets.form.NumberField;
import com.gwtext.client.widgets.form.event.FieldListenerAdapter;
import com.gwtext.client.widgets.grid.ColumnConfig;
import com.gwtext.client.widgets.grid.ColumnModel;
import com.gwtext.client.widgets.grid.GridPanel;
import com.gwtext.client.widgets.grid.GridView;
import com.gwtext.client.widgets.grid.event.GridCellListenerAdapter;
import com.gwtext.client.widgets.grid.event.GridMouseListener;
import com.gwtext.client.widgets.grid.event.GridMouseListenerAdapter;
import com.gwtext.client.widgets.grid.event.GridRowListener;
import com.gwtext.client.widgets.grid.event.GridRowListenerAdapter;
import com.gwtextux.client.data.PagingMemoryProxy;

public class LoadDataPanel extends Panel {

	String news_title;

	PagingMemoryProxy proxy;

	private Object[][] getObj(Object response) {
		List data = (List) response;

		Iterator it = data.iterator();
		int i = data.size();
		int j = 0;
		Object[][] b = new Object[i][];
		while (it.hasNext()) {
			final BeanDTO bean = (BeanDTO) it.next();
			Object[] a = bean.toObjectArray();
			b[j++] = a;

		}

		return b;
	}

	public LoadDataPanel() {

		this.setBorder(false);
		this.setPaddings(0);
		// this.setAutoHeight(true);
		this.setAutoShow(true);
		
		//this.setWidth(558);
		this.setIconCls("grid-icon");

		final GridPanel grid = new GridPanel();
		

		final Panel panel = new Panel();
		panel.setBorder(false);
		//panel.setWidth(563);

		final Toolbar refreshTb = new Toolbar();
		refreshTb.addFill();
		final ToolbarButton refreshBt = new ToolbarButton("刷新");

		final String bodyStyle = "text-align:center;padding:5px 0;"
				+ "border:1px dotted #99bbe8;background:#dfe8f6;"
				+ "color:#15428b;cursor:default;margin:10px;"
				+ "font:bold 11px tahoma,arial,sans-serif;";

		final RecordDef recordDef = new RecordDef(new FieldDef[] {
				new StringFieldDef("N_TITLE"), new StringFieldDef("N_AUTHOR"),
				new StringFieldDef("N_TIME")

		});

			
		ColumnConfig N_TITLE = new ColumnConfig("新闻标题", "N_TITLE", 220, true);
		ColumnConfig N_AUTHOR = new ColumnConfig("发布单位", "N_AUTHOR", 80, true);
		ColumnConfig N_TIME = new ColumnConfig("发布时间", "N_TIME", 56, true);
		
		
		final ColumnModel columnModel  = new ColumnModel(new ColumnConfig[]{
				 N_TITLE,
				 N_AUTHOR,
				 N_TIME
			
		});
		 
		
		
		final DatabaseServiceAsync loadService = DatabaseService.Util
				.getInstance();
		final AsyncCallback cb_load = new AsyncCallback() {

			public void onFailure(Throwable caught) {
				// TODO Auto-generated method stub
				Window.alert("Fail to getting data" + caught.toString());
			}

			public void onSuccess(Object response) {

			
				proxy = new PagingMemoryProxy(getObj(response));

				ArrayReader reader = new ArrayReader(recordDef);

				Store store = new Store(proxy, reader, true);
				
				grid.setStore(store);
				
				
				grid.setColumnModel(columnModel);
				
			    grid.setHeight(473);
				grid.setFrame(true);
				grid.stripeRows(true);
				grid.setAutoExpandMax(50);
				grid.setEnableColumnHide(true);
				grid.setWidth(563);
				grid.setLoadMask(true);
				
			
					
				 ToolTip tip = new ToolTip();
			        tip.setHtml("点击浏览该新闻");
			        tip.setWidth(120);
			        tip.setBodyStyle(bodyStyle);
			        tip.setTrackMouse(true);


				final PagingToolbar pagingToolbar = new PagingToolbar(store);

				pagingToolbar.setPageSize(19);
				pagingToolbar.setDisplayInfo(true);
				pagingToolbar.setDisplayMsg("显示新闻条数 {0} - {1} of {2}");
				pagingToolbar.setEmptyMsg("没有数据显示");

				NumberField pageSizeField = new NumberField();
				pageSizeField.setWidth(40);
				pageSizeField.setSelectOnFocus(true);
				pageSizeField.addListener(new FieldListenerAdapter() {
					public void onSpecialKey(Field field, EventObject e) {
						if (e.getKey() == EventObject.ENTER) {
							int pageSize = Integer.parseInt(field
									.getValueAsString());
							pagingToolbar.setPageSize(pageSize);
						}
					}
				});

				ToolTip toolTip = new ToolTip("请输每页要显示的新闻条数");
				toolTip.applyTo(pageSizeField);

				pagingToolbar.addField(pageSizeField);
				pagingToolbar.addButton(refreshBt);
				grid.setBottomToolbar(pagingToolbar);
				store.load(0,19);

				GridView view = new GridView();
				view.setForceFit(true);
				grid.setView(view);

				panel.add(grid);
				
			    panel.doLayout();
			    
				final ExtElement element = Ext.get("main-panel");
				element.unmask();

				if (store == null) {
					return;
				}

				List data = (List) response;

				Iterator it = data.iterator();

				while (it.hasNext()) {

					final BeanDTO bean = (BeanDTO) it.next();
					Object[] a = bean.toObjectArray();
					Object[][] b = new Object[][] { a };
					// store.add(recordDef.createRecord(bean.toObjectArray()));

				}

				store.commitChanges();

			}

		};
		loadService.getdata(cb_load);

	


		grid.addGridCellListener(new GridCellListenerAdapter() {
			
			
			public void onCellClick(GridPanel grid, int rowIndex, int title,
					EventObject e) {

		
				
				Record[] records = grid.getSelectionModel().getSelections();
				news_title = "";
				for (int i = 0; i < records.length; ++i) {
					Record record = records[i];

					news_title += record.getAsString("N_TITLE");

				}

				DatabaseServiceAsync getNewsContentService = DatabaseService.Util
						.getInstance();
				AsyncCallback cb_getNewsContent = new AsyncCallback() {

					public void onFailure(Throwable arg0) {
						// TODO Auto-generated method stub

					}

					public void onSuccess(Object result) {
						// TODO Auto-generated method stub

						// System.out.println(result);

						Panel newsPanel = new HTMLPanel();
						newsPanel.setHeight(400);
						newsPanel.setAutoScroll(true);
						newsPanel.setHtml(result.toString());
						NewsWindow newWindow = new NewsWindow();
						newWindow.setTitle(news_title);

						Template template = new Template(result.toString());
						newWindow.add(newsPanel);
						newWindow.show();
						final ExtElement element = Ext.get("main-panel");

						element.mask();

						newWindow.addListener(new PanelListenerAdapter() {

							public void onClose(Panel panel) {

								element.unmask();

							}
						});
					}

				};

				getNewsContentService.getNewsContent(news_title,
						cb_getNewsContent);

			}
		});

		refreshBt.addListener(new ButtonListenerAdapter() {

			public void onClick(Button button, EventObject e) {

				DatabaseServiceAsync loadService = DatabaseService.Util
						.getInstance();

				AsyncCallback cb_load = new AsyncCallback() {

					public void onFailure(Throwable arg0) {
						// TODO Auto-generated method stub

					}

					public void onSuccess(Object response) {

						Store store = grid.getStore();
						store.removeAll();
						store.commitChanges();

						store.reload();

						
						final GridPanel grid1 = new GridPanel();

						grid1.setStore(store);
						grid1.setColumnModel(columnModel);
						grid1.setWidth(575);
						grid1.setHeight(500);
						grid1.setFrame(true);
						grid1.stripeRows(true);

						GridView view = new GridView();
						view.setForceFit(true);
						grid1.setView(view);
						

						panel.add(grid1);
						panel.doLayout();

						if (store == null) {
							return;
						}

						List data = (List) response;
						Iterator it = data.iterator();
						while (it.hasNext()) {

							final BeanDTO bean = (BeanDTO) it.next();
				
							Object[] a = bean.toObjectArray();
							Object[][] b = new Object[][] { a };

						}

					}

				};
				loadService.getdata(cb_load);

			}
		});
		
		// refreshTb.addButton(refreshBt);
		this.add(panel);
	}

}
