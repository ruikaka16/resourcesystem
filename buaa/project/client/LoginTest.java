package com.buaa.project.client;

import java.util.Date;

import java.util.HashMap;
import java.util.Map;


import com.buaa.project.client.panel.DataLoad;
import com.buaa.project.client.panel.EditorPanel;
import com.buaa.project.client.panel.FarenPanel;
import com.buaa.project.client.panel.Fileupload;
import com.buaa.project.client.panel.LargeDevice;

import com.buaa.project.client.panel.Login;
import com.buaa.project.client.panel.Test;


import com.buaa.project.client.panel.PiechartPanel;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.i18n.client.DateTimeFormat;

import com.google.gwt.user.client.Timer;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Hyperlink;
import com.google.gwt.user.client.ui.Image;
import com.google.gwt.user.client.ui.Widget;
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
import com.gwtext.client.util.Format;
import com.gwtext.client.util.JavaScriptObjectHelper;
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
import com.gwtext.client.widgets.ToolbarButton;
import com.gwtext.client.widgets.ToolbarTextItem;
import com.gwtext.client.widgets.Viewport;
import com.gwtext.client.widgets.WaitConfig;
import com.gwtext.client.widgets.Window;
import com.gwtext.client.widgets.WindowMgr;

import com.gwtext.client.widgets.event.ButtonListener;
import com.gwtext.client.widgets.event.ButtonListenerAdapter;
import com.gwtext.client.widgets.event.PanelListener;
import com.gwtext.client.widgets.event.PanelListenerAdapter;
import com.gwtext.client.widgets.event.TabPanelListenerAdapter;
import com.gwtext.client.widgets.form.ComboBox;
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
import com.gwtext.client.widgets.layout.VerticalLayout;

import com.gwtext.client.widgets.layout.FitLayout;

import com.gwtext.client.widgets.layout.HorizontalLayout;

import com.gwtext.client.widgets.tree.TreeNode;
import com.gwtext.client.widgets.tree.TreePanel;
import com.gwtext.client.widgets.tree.event.TreeNodeListener;
import com.gwtext.client.widgets.tree.event.TreeNodeListenerAdapter;

/**
 * Entry point classes define <code>onModuleLoad()</code>.
 */
public class LoginTest implements EntryPoint,AsyncCallback {

	public Panel panel;
	public Panel westPanel;
	
	public void onModuleLoad() {

		
		// Button btAdd = new Button();
		panel = new Panel();
		panel.setBorder(false);
		panel.setPaddings(15);
		panel.setLayout(new FitLayout());
		panel.setShadow(true);
		panel.setId("main-panel");

		Panel borderPanel = new Panel();
		borderPanel.setLayout(new BorderLayout());
		
		Panel northPanel = new Panel();
		northPanel.setHeight(56);
		northPanel.setLayout(new HorizontalLayout(0));
		borderPanel.add(northPanel, new BorderLayoutData(RegionPosition.NORTH));

	    final Toolbar toolbar = new Toolbar();
		toolbar.setWidth(224);
		toolbar.setHeight(56);
		toolbar.setStyleName("ext-el-mask-msg");
		
		Image image = new Image();
		image.setUrl("image/title.jpg");
		image.setWidth("800px");
		northPanel.add(image);	
		Date date = new Date();
	    String date1 = date.toString();

		ToolbarButton bt1 = new ToolbarButton("登    陆");
		toolbar.addButton(bt1);
        northPanel.add(toolbar);
	
	Panel northPanel1 = new HTMLPanel();
	northPanel1.setBorder(false);
	northPanel1.setHeight(25);
	
	
	
	 Toolbar toolbar1 = new Toolbar();
	 toolbar1.setWidth(1024);
	 toolbar1.setHeight(32);
	 
	 //toolbar1.addText(a);
	 
	 northPanel.add(toolbar1);
	 Panel northPanel2 = new Panel();
	//northPanel2.setBorder(false);	
	// northPanel2.add(toolbar);	
		
		
		Hyperlink hy = new Hyperlink();
		hy.setHTML("jessiena");
		
		//toolbar.addField(txtLoginname);
		//toolbar.addSeparator();
		//northPanel.add(northPanel1);
		//northPanel.add(northPanel2);
		
		
	//	LoginPanel loginPanel = new LoginPanel();
		
	//	northPanel.add(loginPanel);
		

		//ToolbarTextItem title = new ToolbarTextItem("欢迎访问资源填报系统");
		//toolbar.addItem(title);
		//title.setText("jessiena");
		//title.setSize("1024px", "56px");
		//title.setStyleName("ext-el-mask-msg");
		
	
		

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
		
		final TreeNode treeNode1_1 = new TreeNode("文件发布");
		treeNode1_1.setText("文件发布");
		treeNode1_1.setIconCls("treeNode1_2-icon");
		tr1.appendChild(treeNode1_1);
		
	
		
		final TreeNode treeNode1_2 = new TreeNode("文件浏览");
		treeNode1_2.setText("文件浏览");
		treeNode1_2.setIconCls("treeNode1_1-icon");
		tr1.appendChild(treeNode1_2);

		final TreeNode treeNode1_3 = new TreeNode("文件下载");
		treeNode1_3.setText("文件下载");
		treeNode1_3.setIconCls("treeNode1_2-icon");
		tr1.appendChild(treeNode1_3);

		treeNode1_2.addListener(new TreeNodeListenerAdapter() {

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
		tr4.setExpanded(true);
		treePanel4.setRootNode(tr4);
		
		tr4.setIconCls("treeNode1-icon");

		final TreeNode treeNode4_1 = new TreeNode("查询审核意见 ");
		treeNode4_1.setText("查询审核意见 ");
		treeNode4_1.setIconCls("treeNode4_1-icon");
		tr4.setExpanded(true);
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
		tr5.setExpanded(true);
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
		
//********************************************************************		
		treeNode5_2_2_1.addListener(new TreeNodeListenerAdapter() {

			public void onClick(Node Node, EventObject e) {

				FarenPanel faRen = new FarenPanel();
				faRen.setVisible(true);
				faRen.show();

				
				final ExtElement  element = Ext.get("main-panel");
				
				element.mask();


				
		faRen.addListener(new PanelListenerAdapter(){
			
		 	public void onClose(Panel panel){
				
				element.unmask();
				
			}
		});	

			}
		});
//*****************************************************
		treeNode5_2_2_3.addListener(new TreeNodeListenerAdapter(){
			
			public void onClick(Node node,EventObject e){
				
				LargeDevice largeDevice = new  LargeDevice();
				largeDevice.setVisible(true);
				largeDevice.show();	
				
				final ExtElement  element = Ext.get("main-panel");
				
				element.mask();

		
				
				largeDevice.addListener(new PanelListenerAdapter(){
			
					public void onClose(Panel panel){
				
						element.unmask();
				
			}
		});	

			}
			
		});
//********************************************************
		treeNode5_1.addListener(new TreeNodeListenerAdapter(){
			
			public void onClick(Node node,EventObject e){
				
				Fileupload fileUpload = new Fileupload();
				fileUpload.setVisible(true);
				fileUpload.show();
				
				
	final ExtElement  element = Ext.get("main-panel");
				
				element.mask();

				fileUpload.addListener(new PanelListenerAdapter(){
			
					public void onClose(Panel panel){
				
						element.unmask();
				
			}
		});	

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
		tr6.setIconCls("treeNode1-icon");
		treePanel6.setRootNode(tr6);
	    

		final TreeNode treeNode6_1 = new TreeNode("进度浏览");
		treeNode6_1.setText("进度浏览");
		treeNode6_1.setIconCls("treeNode6_1-icon");
		tr6.appendChild(treeNode6_1);

		// *************************************************************
		final AccordionLayout accordion = new AccordionLayout(true);
    
		
		
		westPanel = new Panel();
		westPanel.setTitle("导航栏");
		westPanel.setId("fdsfa");
		westPanel.setIconCls("westPanel-icon");
		westPanel.setCollapsible(true);
		westPanel.setWidth(200);
		westPanel.setLayout(accordion);
		
		System.out.println(westPanel.getId());
		
		Panel navPanel1 = new Panel();
		
		navPanel1.setTitle("文件管理");
		navPanel1.setBorder(false);
		navPanel1.setIconCls("navPanel1-icon");
		navPanel1.setId("navPanel1");
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

		//westPanel.getEl().mask("fdfs");
		
		borderPanel.add(westPanel, westData);
//****************************************************************
		Panel eastPanel = new Panel();
		//eastPanel.setTitle("导航栏");
		eastPanel.setIconCls("eastPanel-icon");
		eastPanel.setCollapsible(true);
		eastPanel.setBorder(false);
		eastPanel.setWidth(200);
		eastPanel.setLayout(new VerticalLayout());
		
		BorderLayoutData eastData = new BorderLayoutData(RegionPosition.EAST);
		eastData.setSplit(true);
		eastData.setMinSize(175);
		eastData.setMaxSize(400);
		eastData.setMargins(new Margins(0, 1, 0, 0));
		
		borderPanel.add(eastPanel, eastData);
		
		final Panel eastPanel_1 = new Panel();
		//eastPanel_1.setPaddings(15);
		eastPanel_1.setBodyBorder(true);
		eastPanel_1.setTitle("用户登陆");
		eastPanel_1.setCollapsible(true);
		eastPanel_1.setIconCls("eastPanel_1-icon");
		//eastPanel_1.setHeight(160);
		eastPanel_1.setWidth(200);
		
		final FormPanel login = new FormPanel();
		
		login.setFrame(true);
		login.setWidth(200);
		login.setLabelWidth(75);
		login.setIconCls("loginPanel-icon");
		
		final ComboBox cb = new ComboBox();
		
		cb.setForceSelection(true);
		cb.setMinChars(1);
		cb.setFieldLabel("用户类型");
		//cb.setStore(store);
		cb.setDisplayField("state");
		cb.setMode(ComboBox.LOCAL);
		cb.setTriggerAction(ComboBox.ALL);
		cb.setEmptyText("选择类型");
		cb.setLoadingText("Searching...");
		cb.setTypeAhead(true);
		cb.setSelectOnFocus(true);
		cb.setWidth(100);
		cb.setHideTrigger(false);
		
		login.add(cb);

		final TextField txtLoginname = new TextField("用户名", "txtLoginname", 100);
		txtLoginname.setAllowBlank(false);
		login.add(txtLoginname);

		final TextField txtLoginpsw = new TextField("密码", "txtLoginpsw", 100);
		txtLoginpsw.setPassword(true);
		login.add(txtLoginpsw);
		

	
		final Button btLogin = new Button("登陆");
		btLogin.setIconCls("btLogin-icon");
		btLogin.addListener(new ButtonListenerAdapter(){
			public void onClick(final Button button, EventObject e) {
			String username = txtLoginname.getText();
			String password = txtLoginpsw.getText();
			DatabaseServiceAsync loginService = DatabaseService.Util
					.getInstance();
	

			MessageBox.show(new MessageBoxConfig() {
				{
					setMsg("正在登陆......");
					setProgressText("登陆中...");
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
							
							
						}
					};
					timer.schedule(100000);
				}
			});

			AsyncCallback cb_login = new AsyncCallback() {

				public void onFailure(Throwable arg0) {

				}

				public void onSuccess(Object result) {
				
					Boolean ok = (Boolean) result;

					if (ok.booleanValue()) {
						
						MessageBox.alert("登陆成功!");
						
						westPanel.getEl().unmask();
						
						txtLoginname.setValue("");
				
						eastPanel_1.hide();
						
						
					} else {
						MessageBox.alert("用户名或密码不正确!");
					}

				}

			};
			
		
			loginService.login(username, password, cb_login);
			
		}
		
		

	});
	
		Button cancel = new Button("取消");
    
		login.addButton(btLogin);
		login.addButton(cancel);

		
//******************************************************		
		Panel eastPanel_2 = new HTMLPanel();
		eastPanel_2.setPaddings(15);
		eastPanel_2.setBorder(true);
		eastPanel_2.setTitle("相关链接");
		eastPanel_2.setCollapsible(true);
		eastPanel_2.setHeight(185);
		eastPanel_2.setWidth(200);
		
		
		
		Panel eastPanel_3 = new Panel();
		//eastPanel_3.setBodyBorder(true);
		eastPanel_3.setTitle("广告");
		eastPanel_3.setCollapsible(true);
		//eastPanel_3.setHeight(185);
		eastPanel_3.setWidth(200);


		eastPanel.add(eastPanel_1);
		eastPanel.add(eastPanel_2);
		eastPanel.add(eastPanel_3);
		

	  
		
		eastPanel_1.add(login);
	//	eastPanel_1.add(formPanel_1);
		
		// ************************tip********************************
		ToolTip tip1 = new ToolTip();
		tip1.setHtml("可以预览并且下载已经提交的文件");
		tip1.applyTo(navPanel1);

		// ******************************** center
		// panel********************************************

		final TabPanel centerPanel = new TabPanel();
	
		centerPanel.setActiveTab(0);
		centerPanel.setEnableTabScroll(true);
		centerPanel.setDeferredRender(false);
		centerPanel.setAutoShow(true);
      
//*********************************************************		

		Panel centerPanelTwo = new Panel();
		
		centerPanelTwo.setTitle("Center Panel 2");
		centerPanelTwo.setAutoScroll(true);
		centerPanelTwo.setAutoShow(true);
		
		
		DataLoad dataLoad = new DataLoad();
		centerPanelTwo.add(dataLoad);

//**********************************************************
	Panel centerPanelThree = new Panel();
		
		centerPanelThree.setTitle("Center Panel 3");
		centerPanelThree.setAutoScroll(true);
		centerPanelThree.setAutoShow(true);
		
		Test t = new Test();
	//	LoadDataPanel ldp = new LoadDataPanel();
		//centerPanelThree.add(ldp);
		centerPanelThree.add(t);
		
//**************************************************************************
		final CheckboxSelectionModel cbSelectionModel = new CheckboxSelectionModel();   
		
		
		RecordDef recordDef = new RecordDef(new FieldDef[] {
				new StringFieldDef("title"),
				new StringFieldDef("company"),
				new DateFieldDef("time","n/j h:ia")

		});

		Object[][] data = getCompanyData();
		MemoryProxy proxy = new  MemoryProxy(data);

		ArrayReader reader = new ArrayReader(recordDef);
		Store store = new Store(proxy, reader);
		store.load();

		BaseColumnConfig[] columns = new BaseColumnConfig[]{   
                new CheckboxColumnConfig(cbSelectionModel),   
				// column ID is company which is later used in
				// setAutoExpandColumn
				new ColumnConfig("文件标题", "title", 160, true, null, "title"),
				new ColumnConfig("发布单位", "company", 35,true,null,"company"),
				new ColumnConfig("发布时间", "time", 65,true,null),
				new ColumnConfig("选项", "select", 30),
	
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

		
/*		grid.addGridCellListener(new GridCellListenerAdapter (){
			
			public void onCellClick(GridPanel grid, int rowIndex, int title, EventObject e){
				
				
				Record[] records = cbSelectionModel.getSelections();   
				
				String id_title = "";
				for(int i=0;i<records.length;++i)
				{
					Record record = records[i];   
				
				  id_title  += record.getAsString("title");
				
				}
				final ExtElement element = Ext.get("main-panel");
				element.mask();
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
				
				window_grid.addListener(new PanelListenerAdapter(){
					
					public void onClose(Panel panel){
						element.unmask();
						
					}
				});
				
				//System.out.println(columnModel.getColumnHeader(title));
				//System.out.println(columnModel.getColumnTooltip(title));
				System.out.println(id_title);
				
				
				//MessageBox.alert("jessiens");
			}
		});
	*/	
		borderPanel.add(centerPanel,new BorderLayoutData(RegionPosition.CENTER));

		Button bt = new Button("bt",new ButtonListenerAdapter(){
			
			public void onClick(Button button,EventObject e){
				MessageBox.alert("fsfsfdsff");
			}
		});
		
		centerPanel.add(grid);
		centerPanel.add(centerPanelTwo);
		centerPanel.add(centerPanelThree);
		
//****************************************************************
		treeNode6_1.addListener(new TreeNodeListenerAdapter() {

			public void onClick(Node node, EventObject e) {
				
				PiechartPanel piePanel = new PiechartPanel();
			
				piePanel.setVisible(true);
				piePanel.setClosable(true);
			    centerPanel.activate(0);
				centerPanel.add(piePanel);
				centerPanel.doLayout();
				
			}
		});
//***********************************************************
		treeNode1_1.addListener(new TreeNodeListenerAdapter() {
			public void onClick(Node Node, EventObject e) {
				
				EditorPanel editPanel = new EditorPanel();
			
				editPanel.setVisible(true);
			    centerPanel.activate(0);
				centerPanel.add(editPanel);
				centerPanel.doLayout(); 
			}
		});
//*************************************************************
		treeNode3_1_2_1.addListener(new TreeNodeListenerAdapter(){
			
			public void onClick(Node node,EventObject e){
				 FarenPanel win_treeNode_3121 = new FarenPanel();
				 win_treeNode_3121.setClosable(true);
				 win_treeNode_3121.setTitle("法人单位概况");
				 win_treeNode_3121.setVisible(true);
				 centerPanel.activate(0);
				 centerPanel.add(win_treeNode_3121);
				 centerPanel.doLayout();
				
			}
		});
       
//****************************************************************		
		treeNode1_3.addListener(new TreeNodeListenerAdapter(){
			public void onClick(Node node,EventObject e){
				
			
				
				
				
				centerPanel.doLayout();
				
			
				
						}
		});
//******************************************************

	bt1.addListener(new ButtonListenerAdapter(){
			
			public void onClick(Button button,EventObject e){
				
				//westPanel.getEl().unmask();
				
			//panel.getEl().mask();
				
			//	name.setVisible(false);
			//	psw.setVisible(false);
			//	toolbar.addText("欢迎"+name.getText()+"访问");
		
				
				Login loginWin = new Login();
				
				loginWin.show();	
				
				

		//	loginService.login(username, password, callback)
			}
		});
//*******************************************************	
		HorizontalPanel horizontalPanel2 = new HorizontalPanel();
		horizontalPanel2.setSpacing(15);
		Panel windowPanel = new Panel();
		// windowPanel.setHtml(getShortBogusMarkup());
		

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
				window.show();

                     element.mask();
				

			
			
			window.addListener(new PanelListenerAdapter(){
				
				public void onClose(Panel panel){
					
					element.unmask();
				}
			});
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
		
		westPanel.getEl().mask("请您先登陆！");

	}
	public void unMask()
	{
		this.westPanel.getEl().unmask();
	}
	public Map getFormDataAsMap(Form form) {
		// 用户名=rui&密码=rui
		String formvalues = form.getValues();
        
		MessageBox.alert(form.getValues()); 
		//System.out.println(form.getValues());
		System.out.println("\n");
		
		Map formData = new HashMap();

		String[] nameValuePairs = formvalues.split("&");
		for (int i = 0; i < nameValuePairs.length; ++i) {
			String[] oneItem = nameValuePairs[i].split("=");

			formData.put(oneItem[0], oneItem[1]);
			//System.out.println(formData.get(oneItem[1]));
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
