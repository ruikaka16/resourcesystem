package com.buaa.project.client;

import java.util.HashMap;
import java.util.Map;

import com.buaa.project.client.panel.FarenPanel;
import com.buaa.project.client.panel.LoginPanel;
import com.buaa.project.client.panel.PiechartPanel;
import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.user.client.Timer;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Hyperlink;
import com.google.gwt.user.client.ui.Image;
import com.gwtext.client.core.EventObject;
import com.gwtext.client.core.Ext;
import com.gwtext.client.core.ExtElement;
import com.gwtext.client.core.Margins;

import com.gwtext.client.core.RegionPosition;
import com.gwtext.client.data.ArrayReader;
import com.gwtext.client.data.DateFieldDef;
import com.gwtext.client.data.FieldDef;
import com.gwtext.client.data.Record;

import com.gwtext.client.data.MemoryProxy;
import com.gwtext.client.data.Node;

import com.gwtext.client.data.RecordDef;
import com.gwtext.client.data.Store;
import com.gwtext.client.data.StringFieldDef;
import com.gwtext.client.widgets.Button;
import com.gwtext.client.widgets.Component;
import com.gwtext.client.widgets.DatePicker;
import com.gwtext.client.widgets.HTMLPanel;
import com.gwtext.client.widgets.MessageBox;
import com.gwtext.client.widgets.MessageBoxConfig;
import com.gwtext.client.widgets.Panel;
import com.gwtext.client.widgets.TabPanel;
import com.gwtext.client.widgets.ToolTip;
import com.gwtext.client.widgets.Toolbar;
import com.gwtext.client.widgets.ToolbarTextItem;
import com.gwtext.client.widgets.Viewport;
import com.gwtext.client.widgets.WaitConfig;
import com.gwtext.client.widgets.Window;
import com.gwtext.client.widgets.WindowMgr;

import com.gwtext.client.widgets.event.ButtonListener;
import com.gwtext.client.widgets.event.ButtonListenerAdapter;
import com.gwtext.client.widgets.event.TabPanelListenerAdapter;
import com.gwtext.client.widgets.form.DateField;
import com.gwtext.client.widgets.form.Field;
import com.gwtext.client.widgets.form.Form;
import com.gwtext.client.widgets.form.FormPanel;

import com.gwtext.client.widgets.form.TextField;
import com.gwtext.client.widgets.form.TimeField;
import com.gwtext.client.widgets.form.VType;
import com.gwtext.client.widgets.form.event.TextFieldListenerAdapter;
import com.gwtext.client.widgets.grid.BaseColumnConfig;

import com.gwtext.client.widgets.grid.CheckboxColumnConfig;
import com.gwtext.client.widgets.grid.CheckboxSelectionModel;
import com.gwtext.client.widgets.grid.ColumnConfig;
import com.gwtext.client.widgets.grid.ColumnModel;

import com.gwtext.client.widgets.grid.GridPanel;
import com.gwtext.client.widgets.grid.GridView;

import com.gwtext.client.widgets.grid.RowNumberingColumnConfig;
import com.gwtext.client.widgets.grid.event.ColumnModelListener;
import com.gwtext.client.widgets.grid.event.ColumnModelListenerAdapter;
import com.gwtext.client.widgets.grid.event.GridCellListenerAdapter;

import com.gwtext.client.widgets.layout.AccordionLayout;

import com.gwtext.client.widgets.layout.BorderLayout;
import com.gwtext.client.widgets.layout.BorderLayoutData;
import com.gwtext.client.widgets.layout.ColumnLayout;
import com.gwtext.client.widgets.layout.RowLayout;
import com.gwtext.client.widgets.layout.RowLayoutData;

import com.gwtext.client.widgets.layout.FitLayout;

import com.gwtext.client.widgets.layout.HorizontalLayout;

import com.gwtext.client.widgets.tree.TreeNode;
import com.gwtext.client.widgets.tree.TreePanel;
import com.gwtext.client.widgets.tree.event.TreeNodeListenerAdapter;

/**
 * Entry point classes define <code>onModuleLoad()</code>.
 */
public class LoginTest   implements EntryPoint,AsyncCallback {

	public void onModuleLoad() {


		// Button btAdd = new Button();
		Panel panel = new Panel();
		panel.setBorder(false);
		panel.setPaddings(15);
		panel.setLayout(new FitLayout());
		panel.setShadow(true);
		panel.setId("main-panel");

		Panel borderPanel = new Panel();
		borderPanel.setLayout(new BorderLayout());
		
		Panel northPanel = new Panel();
		northPanel.setHeight(60);
		northPanel.setLayout(new RowLayout());	
		northPanel.setLayout(new HorizontalLayout(1));
		borderPanel.add(northPanel, new BorderLayoutData(RegionPosition.NORTH));

	    Toolbar toolbar = new Toolbar();
		toolbar.setSize(600, 58);
		Image image = new Image();
		image.setUrl("image/logo.jpg");
		image.setWidth("600px");
		//northPanel.add(image);
	
		
		
		Hyperlink hy = new Hyperlink();
		hy.setHTML("jessiena");
		
		//toolbar.addField(txtLoginname);
		//toolbar.addSeparator();
		northPanel.add(toolbar);
		
		
		LoginPanel loginPanel = new LoginPanel();
		
		northPanel.add(loginPanel);
		

		ToolbarTextItem title = new ToolbarTextItem("欢迎访问资源填报系统");
		toolbar.addItem(title);
		title.setText("jessiena");
		title.setSize("1024px", "58px");
		title.setStyleName("ext-el-mask-msg");
		
	
		
		
//****************************************************************
		final FormPanel formPanel_1 = new FormPanel();
		formPanel_1.setFrame(true);
		formPanel_1.setTitle("gfdgfgd");

		formPanel_1.setWidth(350);
		formPanel_1.setLabelWidth(75);
		formPanel_1.setVisible(true);
		//formPanel_1.setAnimCollapse(true);
		
		formPanel_1.add(hy);

		TextField firstName = new TextField("Name", "id", 230);
		firstName.setAllowBlank(false);
		formPanel_1.add(firstName);

	//	TextField lastName = new TextField("Last Name", "last", 230);
	//	formPanel.add(lastName);

		TextField company = new TextField("Company", "password", 230);
		formPanel_1.add(company);

		TextField email = new TextField("Email", "email", 230);
		email.setVtype(VType.EMAIL);
		formPanel_1.add(email);

	//	TimeField time = new TimeField("Time", "time", 230);
	//	time.setMinValue("8:00am");
	//	time.setMaxValue("6:00pm");
	//	formPanel.add(time);

		Button save = new Button("Save",new ButtonListenerAdapter(){
			
			public void onClick(Button button,EventObject e){
				
				MessageBox.alert("ghjgjjkhkj");
				
			}
		});
	

		Button cancel = new Button("Cancel");
		formPanel_1.addButton(save);
		formPanel_1.addButton(cancel);

// **********************tree1*********************************************

		final TreePanel treePanel1 = new TreePanel();
		treePanel1.setWidth(200);
		treePanel1.setHeight(600);
		treePanel1.setCollapsible(true);
		treePanel1.setAnimate(true);
		treePanel1.setEnableDD(true);
		treePanel1.setContainerScroll(true);
		treePanel1.setRootVisible(true);
		treePanel1.setIconCls("treePanel1-icon");
		// treePanel1.add(bt);

		TreeNode tr1 = new TreeNode("文件管理");
		tr1.setIconCls("treeNode1-icon");
		tr1.setExpanded(true);
		treePanel1.setRootNode(tr1);
		final TreeNode treeNode1_1 = new TreeNode("文件浏览");
		treeNode1_1.setText("文件浏览");
		treeNode1_1.setIconCls("treeNode1_1-icon");
		tr1.appendChild(treeNode1_1);

		final TreeNode treeNode1_2 = new TreeNode("文件下载");
		treeNode1_2.setText("文件下载");
		treeNode1_2.setIconCls("treeNode1_2-icon");
		tr1.appendChild(treeNode1_2);

		treeNode1_1.addListener(new TreeNodeListenerAdapter() {

			public void onClick(Node Node, EventObject e) {
				final DatePicker datePicker = new DatePicker();
				Window window_tn_11 = new Window();

				window_tn_11.setDraggable(true);
				window_tn_11.setTitle("文件下载");
				window_tn_11.setMaximizable(true);
				window_tn_11.setResizable(true);
				window_tn_11.setDraggable(true);
				window_tn_11.setWidth(400);
				window_tn_11.setHeight(300);

				FormPanel formPanel_tn_11 = new FormPanel();
				// formPanel_tn_11.setLayout(new FitLayout());
				formPanel_tn_11.setPaddings(15);
				formPanel_tn_11.setFrame(true);

				TextField txtName_tn_11 = new TextField("地址", "address", 200);
				DateField txtData_tn_11 = new DateField("出生年月", "birthday", 200);

				txtData_tn_11.addListener(new TextFieldListenerAdapter() {
					public void onEnable(Component component) {

						datePicker.show();
					}
				});
				
				

				formPanel_tn_11.add(txtName_tn_11);
				formPanel_tn_11.add(txtData_tn_11);

				Button bt1 = new Button("bt1",new ButtonListenerAdapter(){
					public void onClick(Button button ,EventObject e){
						
						MessageBox.alert("ghjghjhj");
						
					}
				});
				
				formPanel_tn_11.add(bt1);
				window_tn_11.add(formPanel_tn_11);
				window_tn_11.show();

				// MessageBox.alert("jessiena");
			}
		});

		// *******************************tree2*************************************
		final TreePanel treePanel2 = new TreePanel();
		treePanel2.setWidth(200);
		treePanel2.setHeight(600);
		treePanel2.setAnimate(true);
		treePanel2.setEnableDD(true);
		treePanel2.setContainerScroll(true);
		treePanel2.setRootVisible(true);
		treePanel2.setContainerScroll(true);
		treePanel2.setCollapsible(true);

		TreeNode tr2 = new TreeNode("用户管理");
		tr2.setExpanded(true); // 默认节点展开
		treePanel2.setRootNode(tr2);
		tr2.setIconCls("treeNode1-icon");

		final TreeNode treeNode2_1 = new TreeNode("单位基本信息");
		treeNode2_1.setText("单位基本信息");
		treeNode2_1.setIconCls("treeNode2_1-icon");
		tr2.appendChild(treeNode2_1);

		treeNode2_1.addListener(new TreeNodeListenerAdapter() {

			public void onClick(Node node, EventObject e) {

			}
		});

		final TreeNode treeNode2_2 = new TreeNode("研究实验基地");
		treeNode2_2.setText("研究实验基地");
		treeNode2_2.setIconCls("treeNode2_2-icon");
		tr2.appendChild(treeNode2_2);

		final TreeNode treeNode2_3 = new TreeNode("资源保存机构");
		treeNode2_3.setText("资源保存机构 ");
		treeNode2_3.setIconCls("treeNode2_3-icon");
		tr2.appendChild(treeNode2_3);

		final TreeNode treeNode2_4 = new TreeNode("其他填报部门");
		treeNode2_4.setText("其他填报部门");
		treeNode2_4.setIconCls("treeNode2_4-icon");
		tr2.appendChild(treeNode2_4);

		// ****************************tree3**************************

		final TreePanel treePanel3 = new TreePanel();
		treePanel3.setWidth(200);
		treePanel3.setHeight(600);
		treePanel3.setAnimate(true);
		treePanel3.setEnableDD(true);
		treePanel3.setContainerScroll(true);
		treePanel3.setRootVisible(true);

		TreeNode tr3 = new TreeNode("数据管理");
		tr3.setExpanded(true); 
		treePanel3.setRootNode(tr3);
		tr3.setIconCls("treeNode3-icon");

		final TreeNode treeNode3_1 = new TreeNode("数据浏览 ");
		treeNode3_1.setText("数据浏览 ");
		treeNode3_1.setExpanded(true);
		treeNode3_1.setIconCls("treeNode3_1-icon");
		tr3.appendChild(treeNode3_1);
		
		treeNode3_1.setExpanded(true);

		final TreeNode treeNode3_1_1 = new TreeNode("专项资源");
		treeNode3_1_1.setIconCls("treeNode3_1_1-icon");
		treeNode3_1_1.setText("专项资源");
		treeNode3_1.appendChild(treeNode3_1_1);

		final TreeNode treeNode3_1_1_1 = new TreeNode("生物种质资源");
		treeNode3_1_1_1.setText("生物种质资源");
		treeNode3_1_1_1.setIconCls("treeNode3_1_1_1-icon");
		treeNode3_1_1.appendChild(treeNode3_1_1_1);

		final TreeNode treeNode3_1_2 = new TreeNode("重点资源");
		treeNode3_1_2.setText("重点资源");
		treeNode3_1_2.setIconCls("treeNode3_1_2-icon");
		treeNode3_1.appendChild(treeNode3_1_2);

		final TreeNode treeNode3_1_2_1 = new TreeNode("法人单位概况 ");
		treeNode3_1_2_1.setText("法人单位概况 ");
		treeNode3_1_2.appendChild(treeNode3_1_2_1);
		treeNode3_1_2_1.setIconCls("treeNode3_1_2_1-icon");

		

		final TreeNode treeNode3_1_2_2 = new TreeNode("科研仪器设备概况  ");
		treeNode3_1_2_2.setText("科研仪器设备概况 ");
		treeNode3_1_2.appendChild(treeNode3_1_2_2);
		treeNode3_1_2_2.setIconCls("treeNode3_1_2_2-icon");

		final TreeNode treeNode3_1_2_3 = new TreeNode("大型科学仪器设备（设施） ");
		treeNode3_1_2_3.setText("大型科学仪器设备（设施）");
		treeNode3_1_2.appendChild(treeNode3_1_2_3);
		treeNode3_1_2_3.setIconCls("treeNode3_1_2_3-icon");

		final TreeNode treeNode3_1_2_4 = new TreeNode("人员概况");
		treeNode3_1_2_4.setText("人员概况");
		treeNode3_1_2.appendChild(treeNode3_1_2_4);
		treeNode3_1_2_4.setIconCls("treeNode3_1_2_4-icon");

		final TreeNode treeNode3_1_2_5 = new TreeNode("高层次科技人员基本信息");
		treeNode3_1_2_5.setText("高层次科技人员基本信息");
		treeNode3_1_2.appendChild(treeNode3_1_2_5);
		treeNode3_1_2_5.setIconCls("treeNode3_1_2_5-icon");

		final TreeNode treeNode3_1_2_6 = new TreeNode("财务概况");
		treeNode3_1_2_6.setText("财务概况");
		treeNode3_1_2.appendChild(treeNode3_1_2_6);
		treeNode3_1_2_6.setIconCls("treeNode3_1_2_6-icon");

		final TreeNode treeNode3_1_2_7 = new TreeNode("研究实验基地");
		treeNode3_1_2_7.setText("研究实验基地");
		treeNode3_1_2.appendChild(treeNode3_1_2_7);
		treeNode3_1_2_7.setIconCls("treeNode3_1_2_7-icon");

		final TreeNode treeNode3_2 = new TreeNode("数据查询");
		treeNode3_2.setText("数据查询");
		treeNode3_2.setIconCls("treeNode3_2-icon");
		tr3.appendChild(treeNode3_2);

		final TreeNode treeNode3_3 = new TreeNode("数据统计 ");
		treeNode3_3.setText("数据统计");
		treeNode3_3.setIconCls("treeNode3_3-icon");
		tr3.appendChild(treeNode3_3);

		final TreeNode treeNode3_4 = new TreeNode("数据导出 ");
		treeNode3_4.setText("数据导出");
		treeNode3_4.setIconCls("treeNode3_4-icon");
		tr3.appendChild(treeNode3_4);

		// ********************************tree4********************
		final TreePanel treePanel4 = new TreePanel();
		treePanel4.setWidth(200);
		treePanel4.setHeight(600);
		treePanel4.setAnimate(true);
		treePanel4.setEnableDD(true);
		treePanel4.setContainerScroll(true);
		treePanel4.setRootVisible(true);

		TreeNode tr4 = new TreeNode("审核意见");
		treePanel4.setRootNode(tr4);
		tr4.setIconCls("treeNode1-icon");

		final TreeNode treeNode4_1 = new TreeNode("查询审核意见 ");
		treeNode4_1.setText("查询审核意见 ");
		treeNode4_1.setIconCls("treeNode4_1-icon");
		tr4.appendChild(treeNode4_1);

		// ****************************tree5**************************
		final TreePanel treePanel5 = new TreePanel();
		treePanel5.setWidth(200);
		treePanel5.setHeight(600);
		treePanel5.setAnimate(true);
		treePanel5.setEnableDD(true);
		treePanel5.setContainerScroll(true);
		treePanel5.setRootVisible(true);

		TreeNode tr5 = new TreeNode("数据采集");
		treePanel5.setRootNode(tr5);
		tr5.setIconCls("treeNode1-icon");

		final TreeNode treeNode5_1 = new TreeNode("数据导入");
		treeNode5_1.setText("数据导入");
		treeNode5_1.setIconCls("treeNode5_1-icon");
		tr5.appendChild(treeNode5_1);

		final TreeNode treeNode5_2 = new TreeNode("数据填报");
		treeNode5_2.setText("数据填报");
		treeNode5_2.setIconCls("treeNode5_2-icon");
		tr5.appendChild(treeNode5_2);

		final TreeNode treeNode5_2_1 = new TreeNode("专项资源");
		treeNode5_2_1.setText("专项资源");
		treeNode5_2_1.setIconCls("treeNode5_2_1-icon");
		treeNode5_2.appendChild(treeNode5_2_1);

		final TreeNode treeNode5_2_1_1 = new TreeNode("生物种质资源");
		treeNode5_2_1_1.setText("生物种质资源");
		treeNode5_2_1_1.setIconCls("treeNode5_2_1_1-icon");
		treeNode5_2_1.appendChild(treeNode5_2_1_1);

		final TreeNode treeNode5_2_2 = new TreeNode("重点资源");
		treeNode5_2_2.setText("重点资源");
		treeNode5_2_2.setIconCls("treeNode5_2_2-icon");
		treeNode5_2.appendChild(treeNode5_2_2);

		final TreeNode treeNode5_2_2_1 = new TreeNode("法人单位概况 ");
		treeNode5_2_2_1.setText("法人单位概况 ");
		treeNode5_2_2_1.setIconCls("treeNode5_2_2_1-icon");
		treeNode5_2_2.appendChild(treeNode5_2_2_1);

		final TreeNode treeNode5_2_2_2 = new TreeNode("科研仪器设备概况  ");
		treeNode5_2_2_2.setText("科研仪器设备概况 ");
		treeNode5_2_2_2.setIconCls("treeNode5_2_2_2-icon");
		treeNode5_2_2.appendChild(treeNode5_2_2_2);

		final TreeNode treeNode5_2_2_3 = new TreeNode("大型科学仪器设备（设施） ");
		treeNode5_2_2_3.setText("大型科学仪器设备（设施）");
		treeNode5_2_2_3.setIconCls("treeNode5_2_2_3-icon");
		treeNode5_2_2.appendChild(treeNode5_2_2_3);

		final TreeNode treeNode5_2_2_4 = new TreeNode("人员概况");
		treeNode5_2_2_4.setText("人员概况");
		treeNode5_2_2_4.setIconCls("treeNode5_2_2_4-icon");
		treeNode5_2_2.appendChild(treeNode5_2_2_4);

		final TreeNode treeNode5_2_2_5 = new TreeNode("高层次科技人员基本信息");
		treeNode5_2_2_5.setText("高层次科技人员基本信息");
		treeNode5_2_2_5.setIconCls("treeNode5_2_2_5-icon");
		treeNode5_2_2.appendChild(treeNode5_2_2_5);

		final TreeNode treeNode5_2_2_6 = new TreeNode("财务概况");
		treeNode5_2_2_6.setText("财务概况");
		treeNode5_2_2_6.setIconCls("treeNode5_2_2_6-icon");
		treeNode5_2_2.appendChild(treeNode5_2_2_6);

		final TreeNode treeNode5_2_2_7 = new TreeNode("研究实验基地");
		treeNode5_2_2_7.setText("研究实验基地");
		treeNode5_2_2_7.setIconCls("treeNode5_2_2_7-icon");
		treeNode5_2_2.appendChild(treeNode5_2_2_7);

		final TreeNode treeNode5_3 = new TreeNode("申请退回");
		treeNode5_3.setText("申请退回");
		treeNode5_3.setIconCls("treeNode5_3-icon");
		tr5.appendChild(treeNode5_3);
		
		
		treeNode5_2_2_1.addListener(new TreeNodeListenerAdapter() {

			public void onClick(Node Node, EventObject e) {

				Window window_tn_3121 = new Window();

				window_tn_3121.setDraggable(true);
				window_tn_3121.setTitle("法人单位概况");
				window_tn_3121.setMaximizable(true);
				window_tn_3121.setResizable(true);
				window_tn_3121.setDraggable(true);
				window_tn_3121.setWidth(800);
				window_tn_3121.setHeight(600);
				

		        FarenPanel panel_tn_3121 = new FarenPanel();
                
				window_tn_3121.add(panel_tn_3121);
				window_tn_3121.show();

				// MessageBox.alert("jessiena");
			}
		});

		// ********************************tree6*******************************
		final TreePanel treePanel6 = new TreePanel();
		treePanel6.setWidth(200);
		treePanel6.setHeight(600);
		treePanel6.setAnimate(true);
		treePanel6.setEnableDD(true);
		treePanel6.setContainerScroll(true);
		treePanel6.setRootVisible(true);

		TreeNode tr6 = new TreeNode("进度管理");
		treePanel6.setRootNode(tr6);
		tr6.setIconCls("treeNode1-icon");

		final TreeNode treeNode6_1 = new TreeNode("进度浏览");
		treeNode6_1.setText("进度浏览");
		treeNode6_1.setIconCls("treeNode6_1-icon");
		tr6.appendChild(treeNode6_1);

		// *************************************************************
		final AccordionLayout accordion = new AccordionLayout(true);
    
		
		
		
		Panel westPanel = new Panel();
		westPanel.setTitle("导航栏");
		westPanel.setIconCls("westPanel-icon");
		westPanel.setCollapsible(true);
		westPanel.setWidth(200);
		westPanel.setLayout(accordion);
		
		Panel navPanel1 = new Panel();

		navPanel1.setTitle("文件管理");
		navPanel1.setBorder(false);
		navPanel1.setIconCls("navPanel1-icon");
		navPanel1.add(treePanel1);
		westPanel.add(navPanel1);

		Panel navPanel2 = new Panel();

		navPanel2.setTitle("用户管理");
		navPanel2.setBorder(false);
		navPanel2.setIconCls("navPanel2-icon");
		navPanel2.add(treePanel2);
		westPanel.add(navPanel2);

		Panel navPanel3 = new Panel();

		navPanel3.setTitle("数据管理");
		navPanel3.setBorder(false);
		navPanel3.setIconCls("navPanel3-icon");
		navPanel3.add(treePanel3);
		westPanel.add(navPanel3);

		Panel navPanel4 = new Panel();

		navPanel4.setTitle("审核意见");
		navPanel4.setBorder(false);
		navPanel4.setIconCls("navPanel4-icon");
		navPanel4.add(treePanel4);
		westPanel.add(navPanel4);

		Panel navPanel5 = new Panel();

		navPanel5.setTitle("数据采集");
		navPanel5.setBorder(false);
		navPanel5.setIconCls("navPanel5-icon");
		navPanel5.add(treePanel5);
		westPanel.add(navPanel5);

		Panel navPanel6 = new Panel();

		navPanel6.setTitle("进度管理");
		navPanel6.setBorder(false);
		navPanel6.setIconCls("navPanel6-icon");
		navPanel6.add(treePanel6);
		westPanel.add(navPanel6);

		BorderLayoutData westData = new BorderLayoutData(RegionPosition.WEST);
		westData.setSplit(true);
		westData.setMinSize(175);
		westData.setMaxSize(400);
		westData.setMargins(new Margins(0, 2, 0, 0));

		borderPanel.add(westPanel, westData);
		// ************************tip********************************
		ToolTip tip1 = new ToolTip();
		tip1.setHtml("可以预览并且下载已经提交的文件");
		tip1.applyTo(navPanel1);

		// ******************************** center
		// panel********************************************

		final TabPanel centerPanel = new TabPanel();
		panel.setBorder(false);
		panel.setPaddings(15);
		centerPanel.setActiveTab(0);
		centerPanel.setEnableTabScroll(true);
		centerPanel.setDeferredRender(false);
		centerPanel.setAutoShow(true);

		

		Panel centerPanelTwo = new Panel();
		centerPanelTwo.setVisible(true);
		
		centerPanelTwo.setTitle("Center Panel");
		centerPanelTwo.setAutoScroll(true);
		
		centerPanelTwo.add(formPanel_1);
//**************************************************************************
		final CheckboxSelectionModel cbSelectionModel = new CheckboxSelectionModel();   
		
		RecordDef recordDef = new RecordDef(new FieldDef[] {
				new StringFieldDef("title"), new StringFieldDef("company"),
				new DateFieldDef("time", "n/j h:ia"),

		});

		Object[][] data = getCompanyData();
		MemoryProxy proxy = new MemoryProxy(data);

		ArrayReader reader = new ArrayReader(recordDef);
		Store store = new Store(proxy, reader);
		store.load();

		BaseColumnConfig[] columns = new BaseColumnConfig[]{   
                new CheckboxColumnConfig(cbSelectionModel),   
				// column ID is company which is later used in
				// setAutoExpandColumn
				new ColumnConfig("文件标题", "title", 160, true, null, "title"),
				new ColumnConfig("发布单位", "company", 35),
				new ColumnConfig("发布时间", "time", 65),
				new ColumnConfig("选项", "select", 30),
		// new ColumnConfig("% Change", "pctChange", 65),
		// new ColumnConfig("Last Updated", "lastChanged", 65),
		// new ColumnConfig("Industry", "industry", 60, true)
		};

		final ColumnModel columnModel = new ColumnModel(columns);

		
		
		GridPanel grid = new GridPanel();
		grid.setStore(store);
		grid.setColumnModel(columnModel);

		grid.setTitle("文件浏览");
		grid.setHeight(300);
		grid.setWidth(600);
		grid.setIconCls("grid-icon");
	 	grid.setAutoExpandColumn("title");
	 	grid.setSelectionModel(cbSelectionModel);

		GridView view = new GridView();
		view.setForceFit(true);
		grid.setView(view);

		
		grid.addGridCellListener(new GridCellListenerAdapter (){
			
			public void onCellClick(GridPanel grid, int rowIndex, int title, EventObject e){
				
				
				Record[] records = cbSelectionModel.getSelections();   
				
				String id_title = "";
				for(int i=0;i<records.length;++i)
				{
					Record record = records[i];   
				
				  id_title  += record.getAsString("title");
				
				}
				Window window_grid = new Window();
				window_grid.setHeight(400);
				window_grid.setWidth(600);
				window_grid.setTitle(id_title);
				
				Panel news = new HTMLPanel();
				news.setBorder(false);
				news.setHeight(400);
				news.setHtml("<p>十一届全国人大第一次会议《政府工作报告》提出，要建设“面向企业的创新支撑平台”，“加强科技基础能力建设”。为深入贯彻落实大会精神和有关要求，按照科技部党组和部领导的指示，2008年3月19日-22日，平台中心徐建国主任、计划司相关负责同志等，赴浙江开展了面向企业的创新支撑平台调研," +
						"调研组在杭州召开了工作座谈会，并在杭州、绍兴、舟山分别考察了浙江省新药创制科技服务平台、浙江省现代纺织技术及装备创新服务平台、浙江省海洋科技创新服务平台。座谈会上，浙江省科技厅介绍了浙江科技平台建设的总体情况，重点介绍了“六个一批”创新载体建设以及三类重大创新平台建设。实地调研中，" +
						"三个平台建设单位分别就组织机构、管理制度、专业培训、交流研讨、创新服务、科研攻关、人才队伍等各方面情况进行了详细介绍。总体来说，三个创新平台各具特色、非常典型，在优化科技资源配置、提高科技资源利用效率，推进新型产学研结合、服务企业和行业技术创新等方面发挥了重要作用。浙江省创新平台" +
						"建设一些好的经验和做法，为国家和其它地方面向企业的创新支撑平台建设提供了重要启示。一是必须坚持需求导向，立足区域和地方的产业集群优势，这是基本前提；二是必须坚持整合共享和必要投入，有效盘活存量和调控增量，这是必要手段；三是必须坚持机制创新，结合实际建立适应企业自主创新的服务机制，" +
						"<hr>"+
						"这是核心关键；四是必须坚持开放服务，大力提高创新支撑和服务能力，这是最终目标。调研过程中也了解到当前平台建设的一些问题需要研究解决，如平台共享服务和技术创新服务中的知识产权问题、平台建设中的人才培养和稳定问题以及平台持续运行与长远发展问题等。 此次调研对于地方在面向企业的创新支撑平台建设方面所做的工作有了进一步的了解，对于地方科技管理部门和有关平台建设单位的想法和认识有了深入的体会，这些将为国家层面开展面向企业的创新支撑平台顶层设计和布局建设提供有益的支持和帮助。 ");
				window_grid.add(news);
				window_grid.show();
				
				//System.out.println(columnModel.getColumnHeader(title));
				//System.out.println(columnModel.getColumnTooltip(title));
				System.out.println(id_title);
				
				
				//MessageBox.alert("jessiens");
			}
		});
		
		borderPanel.add(centerPanel,new BorderLayoutData(RegionPosition.CENTER));

		Button bt = new Button("bt",new ButtonListenerAdapter(){
			
			public void onClick(Button button,EventObject e){
				MessageBox.alert("fsfsfdsff");
			}
		});
		
		//formPanel_1.add(bt);
		centerPanelTwo.add(bt);
		centerPanelTwo.add(formPanel_1);

		centerPanel.add(grid);
		centerPanel.add(centerPanelTwo);
//****************************************************************
		treeNode6_1.addListener(new TreeNodeListenerAdapter() {

			public void onClick(Node node, EventObject e) {

				PiechartPanel piePanel = new PiechartPanel();
				piePanel.setVisible(true);
			    centerPanel.activate(0);
				centerPanel.add(piePanel);
				centerPanel.doLayout();
				
			}
		});
//***********************************************************
		HorizontalPanel horizontalPanel2 = new HorizontalPanel();
		horizontalPanel2.setSpacing(15);
		Panel windowPanel = new Panel();
		// windowPanel.setHtml(getShortBogusMarkup());
		windowPanel.setShadow(true);

		final Window window = new Window();
		window.setTitle("用户信息");
		window.setIconCls("paste-icon");
		window.setMaximizable(true);
		window.setResizable(true);
		window.setLayout(new FitLayout());
		window.setWidth(400);
		window.setHeight(300);
		window.setModal(false);
		window.setAutoHeight(false);
		window.setIconCls("window-icon");
		// window.setCloseAction(CloseAction closeAction());

		final FormPanel frm = new FormPanel();

		frm.setPaddings(20);
		//frm.setTitle("用户信息");
		frm.setWidth(300);
		frm.setFrame(true);

		final TextField  txtUsername = new TextField("用户名", "username");
		txtUsername.setId("name");
		TextField txtPassword = new TextField("密码", "password");
		TextField txtEmail = new TextField("Email", "email");

		txtUsername.setRegex("^[a-zA-Z]*$");
		txtUsername.setRegexText("只允许输入字母");
		txtUsername.setAllowBlank(false);

		txtPassword.setPassword(true);
		txtPassword.setRegex("^[a-zA-Z]*$");
		txtPassword.setRegexText("只允许输入字母");
		txtPassword.setAllowBlank(false);

		txtEmail.setVtype(VType.EMAIL);

		txtEmail.setAllowBlank(false);

		frm.add(txtUsername);
		frm.add(txtPassword);
		frm.add(txtEmail);

		Panel buttonPanel = new Panel();
		buttonPanel.setLayout(new HorizontalLayout(10));

		final AsyncCallback callback = this;

		Button btSave = new Button("保存");
		btSave.setId("save");
		btSave.addListener(new ButtonListenerAdapter() {
			public void onClick(final Button button, EventObject e) {
				
				
				TextField txtUsername1 = (TextField)frm.getComponent(0);
				System.out.println(txtUsername1.getText());
				
			//	String item = frm.getId(name);
				
				//item.
				
			//	 txtUsername2 = (TextField)frmf.getId();
				
				/*TextField txtUsername2 = (TextField)frm.getComponent(3);
				System.out.println(txtUsername2.getText());
				
				TextField txtUsername3 = (TextField)frm.getComponent(5);
				System.out.println(txtUsername3.getText());*/
				
				
				if (frm.getForm().isValid()) {

					DatabaseServiceAsync service = DatabaseService.Util
							.getInstance();
					Map formData = getFormDataAsMap(frm.getForm());

					service.saveData(formData, callback);

					MessageBox.show(new MessageBoxConfig() {
						{
							setMsg("正在保存, 请等待...");
							setProgressText("保存中...");
							setWidth(300);
							setWait(true);
							setWaitConfig(new WaitConfig() {
								{
									setInterval(200);
								}
							});
							setAnimEl(button.getId());

							Timer timer = new Timer() {
								public void run() {
									MessageBox.hide();
									// System.out.println("Done, Your fake data
									// was saved!");
								}
							};
							timer.schedule(8000);
						}
					});
				} else {

					MessageBox.alert("输入有误", "请重新输入!");
				}

			}

		});

		Button btCancel = new Button("取消");
		btCancel.addListener(new ButtonListenerAdapter() {
			public void onClick(final Button button, EventObject e) {
				MessageBox.alert("取消", "重新输入");
			}

		});

		Button btAdd = new Button("添加", new ButtonListenerAdapter() {
			public void onClick(Button button, EventObject e) {

				final ExtElement element = Ext.get("main-panel");
				window.setVisible(true);

				// window.addListener(listener);
                     element.mask();
				// window.close();

			}

		});

		window.setAnimateTarget(btAdd.getId());
		buttonPanel.add(btSave);
		buttonPanel.add(btCancel);
		frm.add(buttonPanel);
		window.add(frm);

		treePanel2.add(btAdd);

		

		panel.add(borderPanel);

		Viewport viewPort = new Viewport(panel);

	}

	public Map getFormDataAsMap(Form form) {
		// 用户名=rui&密码=rui
		String formvalues = form.getValues();
         
		Map formData = new HashMap();

		String[] nameValuePairs = formvalues.split("&");
		for (int i = 0; i < nameValuePairs.length; ++i) {
			String[] oneItem = nameValuePairs[i].split("=");

			formData.put(oneItem[0], oneItem[1]);
		}

		return formData;
	}

	public void onFailure(Throwable arg0) {
		MessageBox.hide();
		System.out.println(" data save failer!");
		MessageBox.alert("保存失败");

	}

	public void onSuccess(Object arg0) {
		MessageBox.hide();
		System.out.println(" data  saved!");
		MessageBox.alert("保存成功");

	}

	private Object[][] getCompanyData() {
		return new Object[][] {
				new Object[] { "计划司、平台中心赴浙江开展面向企业创新支撑平台调研", "教育部", "9/1 12:00am" },
				new Object[] { "平台中心召开平台门户建设工作会议", "科技部", "9/1 12:00am" },
				new Object[] { "国家科技基础条件平台中心网站正式开通", "财政部", "9/1 12:00am" },
				new Object[] { "国家科技基础条件平台建设专家顾问组2008年工作座", "体育部", "9/1 12:00am" },
				new Object[] { "关于开展国家科技基础条件平台门户建设的通知", "司法",
						"9/1 12:00am" },
				new Object[] { "召开国家科技基础条件平台门户建设标准规范培训会议", "国防科工委", "9/1 12:00am" },
				new Object[] { "国家自然科技资源共享平台项目年度总结交流会昆明召开", "新闻办", "9/1 12:00am" },
				new Object[] { "平台中心召开平台门户建设联络员会议", "外交部", "9/1 12:00am" },
				new Object[] { "召开科技基础条件资源调查动员暨工作部署会议的通知", "公安部", "9/1 12:00am" },
				new Object[] { "科技部、财政部召开国家重点实验室工作会议 ", "铁道部",
						"9/1 12:00am" },
				new Object[] { "召开国家科技基础条件平台门户建设标准规范培训会议", "国防科工委", "9/1 12:00am" },
				new Object[] { "国家自然科技资源共享平台项目年度总结交流会昆明召开", "新闻办", "9/1 12:00am" },
				new Object[] { "平台中心召开平台门户建设联络员会议", "外交部", "9/1 12:00am" },
				new Object[] { "召开科技基础条件资源调查动员暨工作部署会议的通知", "公安部", "9/1 12:00am" },
				new Object[] { "科技部、财政部召开国家重点实验室工作会议 ", "铁道部",
								"9/1 12:00am" },
				new Object[] { "计划司、平台中心赴浙江开展面向企业创新支撑平台调研", "教育部", "9/1 12:00am" },
				new Object[] { "平台中心召开平台门户建设工作会议", "科技部", "9/1 12:00am" },
				new Object[] { "国家科技基础条件平台中心网站正式开通", "财政部", "9/1 12:00am" },
				new Object[] { "国家科技基础条件平台建设专家顾问组2008年工作座", "体育部", "9/1 12:00am" },
				new Object[] { "关于开展国家科技基础条件平台门户建设的通知", "司法",
										"9/1 12:00am" } };
	}

}
