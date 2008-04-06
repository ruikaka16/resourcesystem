package com.buaa.project.client;


import java.util.HashMap;
import java.util.Map;



import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.user.client.Timer;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.ClickListener;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Image;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.Widget;
import com.gwtext.client.core.EventObject;
import com.gwtext.client.core.Ext;
import com.gwtext.client.core.ExtElement;
import com.gwtext.client.core.Margins;
import com.gwtext.client.core.Position;
import com.gwtext.client.core.RegionPosition;
import com.gwtext.client.data.ArrayReader;
import com.gwtext.client.data.DateFieldDef;
import com.gwtext.client.data.FieldDef;
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
import com.gwtext.client.widgets.Window.CloseAction;
import com.gwtext.client.widgets.event.ButtonListenerAdapter;
import com.gwtext.client.widgets.event.WindowListener;
import com.gwtext.client.widgets.event.WindowListenerAdapter;
import com.gwtext.client.widgets.form.DateField;
import com.gwtext.client.widgets.form.Form;
import com.gwtext.client.widgets.form.FormPanel;
import com.gwtext.client.widgets.form.TextField;
import com.gwtext.client.widgets.form.TimeField;
import com.gwtext.client.widgets.form.VType;
import com.gwtext.client.widgets.form.event.TextFieldListener;
import com.gwtext.client.widgets.form.event.TextFieldListenerAdapter;
import com.gwtext.client.widgets.grid.BaseColumnConfig;
import com.gwtext.client.widgets.grid.ColumnConfig;
import com.gwtext.client.widgets.grid.ColumnModel;
import com.gwtext.client.widgets.grid.GridPanel;
import com.gwtext.client.widgets.grid.GridView;
import com.gwtext.client.widgets.grid.RowNumberingColumnConfig;
import com.gwtext.client.widgets.layout.AccordionLayout;
import com.gwtext.client.widgets.layout.AnchorLayoutData;
import com.gwtext.client.widgets.layout.BorderLayout;
import com.gwtext.client.widgets.layout.BorderLayoutData;
import com.gwtext.client.widgets.layout.ColumnLayout;
import com.gwtext.client.widgets.layout.ColumnLayoutData;
import com.gwtext.client.widgets.layout.FitLayout;
import com.gwtext.client.widgets.layout.FormLayout;
import com.gwtext.client.widgets.layout.HorizontalLayout;
import com.gwtext.client.widgets.layout.RowLayout;
import com.gwtext.client.widgets.layout.RowLayoutData;
import com.gwtext.client.widgets.layout.VerticalLayout;
import com.gwtext.client.widgets.tree.TreeNode;
import com.gwtext.client.widgets.tree.TreePanel;
import com.gwtext.client.widgets.tree.event.TreeNodeListener;
import com.gwtext.client.widgets.tree.event.TreeNodeListenerAdapter;
import com.gwtext.client.widgets.Window;


/**
 * Entry point classes define <code>onModuleLoad()</code>.
 */
public class LoginTest  implements EntryPoint, AsyncCallback {

	public void onModuleLoad() {

		createComponents();
	}

	public void createComponents() {

		//Button btAdd = new Button();
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
		borderPanel.add(northPanel, new BorderLayoutData(RegionPosition.NORTH));
        
		Toolbar toolbar = new Toolbar();
		toolbar.setSize(1024, 60);
		Image image = new Image();
		image.setUrl("image/logo.jpg");
		image.setWidth("1024px");
		northPanel.add(image);
		northPanel.add(toolbar);
		
		ToolbarTextItem title = new ToolbarTextItem("欢迎访问资源填报系统");
		toolbar.addItem(title);
		title.setText("jessiena");
		title.setSize("1024px", "58px");
		title.setStyleName("ext-el-mask-msg");
		
		final FormPanel formPanel = new FormPanel();
		formPanel.setFrame(true);
		formPanel.setTitle("Simple Form");

		formPanel.setWidth(350);
		formPanel.setLabelWidth(75);
        formPanel.setVisible(true);
		formPanel.setAnimCollapse(true);

		TextField firstName = new TextField("First Name", "first", 230);
		firstName.setAllowBlank(false);
		formPanel.add(firstName);

		TextField lastName = new TextField("Last Name", "last", 230);
		formPanel.add(lastName);

		TextField company = new TextField("Company", "company", 230);
		formPanel.add(company);

		TextField email = new TextField("Email", "email", 230);
		email.setVtype(VType.EMAIL);
		formPanel.add(email);

		TimeField time = new TimeField("Time", "time", 230);
		time.setMinValue("8:00am");
		time.setMaxValue("6:00pm");
		formPanel.add(time);

		Button save = new Button("Save");
		formPanel.addButton(save);

		Button cancel = new Button("Cancel");
		formPanel.addButton(cancel);

		
		
// **********************tree1*********************************************
         
         
          
		
		
		final TreePanel treePanel1 = new TreePanel();
		treePanel1.setWidth(200);
		treePanel1.setHeight(600);
        treePanel1.setCollapsible(true);
		treePanel1.setAnimate(true);
		treePanel1.setEnableDD(true);
		treePanel1.setContainerScroll(true);
		treePanel1.setRootVisible(true);
       // treePanel1.add(bt);
		
		TreeNode tr1 = new TreeNode("文件管理");
		tr1.setExpanded(true);
		treePanel1.setRootNode(tr1);
		final TreeNode treeNode1_1 = new TreeNode("文件浏览");
		treeNode1_1.setText("文件浏览");
		tr1.appendChild(treeNode1_1);

		final TreeNode treeNode1_2 = new TreeNode("文件下载");
		treeNode1_2.setText("文件下载");
		tr1.appendChild(treeNode1_2);
		
	
		treeNode1_1.addListener(new TreeNodeListenerAdapter(){
			
			public void onClick(Node Node, EventObject e ){
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
			//	formPanel_tn_11.setLayout(new FitLayout());
				formPanel_tn_11.setPaddings(15);
				formPanel_tn_11.setFrame(true);
				
				TextField txtName_tn_11 = new TextField("地址","address",200);
				DateField txtData_tn_11 = new DateField("出生年月","birthday",200);
				
				
				
				txtData_tn_11.addListener(new TextFieldListenerAdapter(){
					public void onEnable(Component component){
						
						datePicker.show();
					}
				});
				
				
				
				
				formPanel_tn_11.add(txtName_tn_11);
				formPanel_tn_11.add(txtData_tn_11);
				
				
				window_tn_11.add(formPanel_tn_11);
				window_tn_11.show();
				
				//MessageBox.alert("jessiena");
			}
		});
		
	
		
		
//		*******************************tree2*************************************
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
		tr2.setExpanded(true);                           //默认节点展开
		treePanel2.setRootNode(tr2);
		
		final TreeNode treeNode2_1 = new TreeNode("单位基本信息");
		treeNode2_1.setText("单位基本信息");
		tr2.appendChild(treeNode2_1);

		final TreeNode treeNode2_2 = new TreeNode("研究实验基地");
		treeNode2_2.setText("研究实验基地");
		tr2.appendChild(treeNode2_2);
		
		final TreeNode treeNode2_3 = new TreeNode("资源保存机构");
		treeNode2_3.setText("资源保存机构 ");
		tr2.appendChild(treeNode2_3);
		
		final TreeNode treeNode2_4 = new TreeNode("其他填报部门");
		treeNode2_4.setText("其他填报部门");
		tr2.appendChild(treeNode2_4);
		
//****************************tree3**************************	
		
		final TreePanel treePanel3 = new TreePanel();
		treePanel3.setWidth(200);
		treePanel3.setHeight(600);
		treePanel3.setAnimate(true);
		treePanel3.setEnableDD(true);
		treePanel3.setContainerScroll(true);
		treePanel3.setRootVisible(true);
		
		TreeNode tr3 = new TreeNode("数据管理");
		treePanel3.setRootNode(tr3);
		
		final TreeNode treeNode3_1 = new TreeNode("数据浏览 ");
		treeNode3_1.setText("数据浏览 ");
		tr3.appendChild(treeNode3_1);
		
		final TreeNode treeNode3_1_1 = new TreeNode("专项资源");
		treeNode3_1_1.setText("专项资源");
		treeNode3_1.appendChild(treeNode3_1_1);
		
		final TreeNode treeNode3_1_1_1 = new TreeNode("生物种质资源");
		treeNode3_1_1_1.setText("生物种质资源");
		treeNode3_1_1.appendChild(treeNode3_1_1_1);
		
		final TreeNode treeNode3_1_2 = new TreeNode("重点资源");
		treeNode3_1_2.setText("重点资源");
		treeNode3_1.appendChild(treeNode3_1_2); 
		
		final TreeNode treeNode3_1_2_1 = new TreeNode("法人单位概况 ");
		treeNode3_1_2_1.setText("法人单位概况 ");
		treeNode3_1_2.appendChild(treeNode3_1_2_1);
		
	treeNode3_1_2_1.addListener(new TreeNodeListenerAdapter(){
			
			public void onClick(Node Node, EventObject e ){
				 
				Window window_tn_3121 = new Window();
				
				window_tn_3121.setDraggable(true);
				window_tn_3121.setTitle("法人单位概况");
				window_tn_3121.setMaximizable(true);
				window_tn_3121.setResizable(true);
				window_tn_3121.setDraggable(true);
				window_tn_3121.setWidth(800);
				window_tn_3121.setHeight(600);
				//window_tn_3121.setLayout(new GridLayout(2,1));
				//window_tn_3121.setLayout(new HorizontalLayout(10));
				
				
				
				 Panel panel_tn_3121 = new Panel();
			     panel_tn_3121.setBorder(false);
			     panel_tn_3121.setPaddings(15);
                 panel_tn_3121.setHeight(400);
			     panel_tn_3121.setLayout(new FitLayout());

			     final Panel wrapperPanel = new Panel();
			     wrapperPanel.setLayout(new RowLayout());
			     wrapperPanel.setBorder(true);
			     //wrapperPanel.setBodyStyle("border-style:dotted;border-color:blue;");
				
				FormPanel formPanel_tn_3121_1 = new FormPanel();
			    formPanel_tn_3121_1.setPaddings(5);
				formPanel_tn_3121_1.setFrame(true);
				formPanel_tn_3121_1.setLabelAlign(Position.LEFT);
				formPanel_tn_3121_1.setHeight(300);
				//formPanel_tn_3121.setLayout(new RowLayout());
				FormPanel formPanel_tn_3121_2 = new FormPanel();
			    formPanel_tn_3121_2.setPaddings(5);
				formPanel_tn_3121_2.setFrame(true);
				formPanel_tn_3121_2.setLabelAlign(Position.LEFT);
				formPanel_tn_3121_2.setAutoHeight(true);
				formPanel_tn_3121_2.setTitle("从事和服务的国民经济行业");
				
				FormPanel formPanel_tn_3121_3 = new FormPanel();
			    formPanel_tn_3121_3.setPaddings(5);
				formPanel_tn_3121_3.setFrame(true);
				formPanel_tn_3121_3.setLabelAlign(Position.LEFT);
				formPanel_tn_3121_3.setAutoHeight(true);
				formPanel_tn_3121_3.setTitle("主要科学领域");
				
				Panel firstPanel = new Panel();
				firstPanel.setLayout(new ColumnLayout());
				firstPanel.setBorder(false);   
				
				Panel secPanel = new Panel();
				secPanel.setLayout(new ColumnLayout());
				secPanel.setBorder(false); 
				
				Panel thirdPanel = new Panel();
				thirdPanel.setLayout(new ColumnLayout());
				thirdPanel.setBorder(false); 
				
				Panel firstColumn = new Panel();   
		        firstColumn.setLayout(new FormLayout());   
		        firstColumn.setBorder(false); 
		        
		        Panel firstColumn_first = new Panel();   
		        firstColumn_first.setLayout(new FormLayout());   
		        firstColumn_first.setBorder(false); 
		        
		        Panel firstColumn_sec = new Panel();   
		        firstColumn_sec.setLayout(new FormLayout());   
		        firstColumn_sec.setBorder(false); 
		        
		        Panel firstColumn_third = new Panel();   
		        firstColumn_third.setLayout(new FormLayout());   
		        firstColumn_third.setBorder(false); 
				
				Panel columnOnePanel = new Panel();   
		        columnOnePanel.setLayout(new FormLayout()); 
		        
		        Panel columnOnePanel_sec = new Panel();   
		        columnOnePanel_sec.setLayout(new FormLayout()); 
		        
		        Panel columnOnePanel_third = new Panel();   
		        columnOnePanel_third.setLayout(new FormLayout());

		        firstColumn_first.add(new TextField("单位全称", "first"), new AnchorLayoutData("80%"));   
		        firstColumn_first.add(new TextField("上一级主管单位", "company"), new AnchorLayoutData("80%")); 
		        firstColumn_first.add(new TextField("单位通讯地址", "company"), new AnchorLayoutData("80%")); 
		        firstColumn_first.add(new TextField("所在单位地址", "company"), new AnchorLayoutData("80%"));
		        firstColumn_first.add(new TextField("法人性质", "company"), new AnchorLayoutData("80%"));
		        firstPanel.add(firstColumn_first, new ColumnLayoutData(0.5));   
		        
		        firstColumn_sec.add(new TextField("序号", "first"), new AnchorLayoutData("80%")); 
		        secPanel.add(firstColumn_sec,new ColumnLayoutData(0.5));
		        
		        firstColumn_third.add(new TextField("序号", "first"), new AnchorLayoutData("80%")); 
		        thirdPanel.add(firstColumn_third,new ColumnLayoutData(0.5));
		        
		        Panel secondColumn_first = new Panel();   
		        secondColumn_first.setLayout(new FormLayout());   
		        secondColumn_first.setBorder(false); 
		        
		        Panel secondColumn_sec = new Panel();   
		        secondColumn_sec.setLayout(new FormLayout());   
		        secondColumn_sec.setBorder(false); 
		        
		        Panel secondColumn_third = new Panel();   
		        secondColumn_third.setLayout(new FormLayout());   
		        secondColumn_third.setBorder(false); 
		        
		        
		        
		        
		        secondColumn_first.add(new TextField("组织机构代码", "last"), new AnchorLayoutData("80%"));   
		        secondColumn_first.add(new TextField("行政主管部门", "email"), new AnchorLayoutData("80%")); 
		        secondColumn_first.add(new TextField("邮政编码", "email"), new AnchorLayoutData("80%")); 
		        secondColumn_first.add(new TextField("单位网址", "email"), new AnchorLayoutData("80%"));
		        secondColumn_first.add(new TextField("单位属性", "email"), new AnchorLayoutData("80%"));
		        firstPanel.add(secondColumn_first, new ColumnLayoutData(0.5));   
		        
		        secondColumn_sec.add(new TextField("行业名称", "last"), new AnchorLayoutData("80%"));
		        secPanel.add(secondColumn_sec,new ColumnLayoutData(0.5));
		        
		        secondColumn_third.add(new TextField("学科名称", "last"), new AnchorLayoutData("80%"));
		        thirdPanel.add(secondColumn_third,new ColumnLayoutData(0.5));
		       
		        
		        
		       
		        
		        //add first panel as first column with 50% of the width   
		        
		        formPanel_tn_3121_1.add(firstPanel);
		        formPanel_tn_3121_2.add(secPanel);
		        formPanel_tn_3121_3.add(thirdPanel);
		        wrapperPanel.add(formPanel_tn_3121_1, new RowLayoutData(160));
		        wrapperPanel.add(formPanel_tn_3121_2, new RowLayoutData(60));
		        wrapperPanel.add(formPanel_tn_3121_3,new RowLayoutData(60));
		        panel_tn_3121.add(wrapperPanel);
		       
			
				
				window_tn_3121.add(panel_tn_3121);
				window_tn_3121.show();
				
				//MessageBox.alert("jessiena");
			}
		});
		
		final TreeNode treeNode3_1_2_2 = new TreeNode("科研仪器设备概况  ");
		treeNode3_1_2_2.setText("科研仪器设备概况 ");
		treeNode3_1_2.appendChild(treeNode3_1_2_2);
		
		final TreeNode treeNode3_1_2_3 = new TreeNode("大型科学仪器设备（设施） ");
		treeNode3_1_2_3.setText("大型科学仪器设备（设施）");
		treeNode3_1_2.appendChild(treeNode3_1_2_3);
		
		final TreeNode treeNode3_1_2_4 = new TreeNode("人员概况");
		treeNode3_1_2_4.setText("人员概况");
		treeNode3_1_2.appendChild(treeNode3_1_2_4);
		
		final TreeNode treeNode3_1_2_5 = new TreeNode("高层次科技人员基本信息");
		treeNode3_1_2_5.setText("高层次科技人员基本信息");
		treeNode3_1_2.appendChild(treeNode3_1_2_5);
		
		final TreeNode treeNode3_1_2_6 = new TreeNode("财务概况");
		treeNode3_1_2_6.setText("财务概况");
		treeNode3_1_2.appendChild(treeNode3_1_2_6);
		
		final TreeNode treeNode3_1_2_7 = new TreeNode("研究实验基地");
		treeNode3_1_2_7.setText("研究实验基地");
		treeNode3_1_2.appendChild(treeNode3_1_2_7);
		
		final TreeNode treeNode3_2 = new TreeNode("数据查询");
		treeNode3_2.setText("数据查询");
		tr3.appendChild(treeNode3_2);
		
		final TreeNode treeNode3_3 = new TreeNode("数据统计 ");
		treeNode3_3.setText("数据统计");
		tr3.appendChild(treeNode3_3);
		
		final TreeNode treeNode3_4 = new TreeNode("数据导出 ");
		treeNode3_4.setText("数据导出");
		tr3.appendChild(treeNode3_4);
		
//********************************tree4********************
		final TreePanel treePanel4 = new TreePanel();
		treePanel4.setWidth(200);
		treePanel4.setHeight(600);
		treePanel4.setAnimate(true);
		treePanel4.setEnableDD(true);
		treePanel4.setContainerScroll(true);
		treePanel4.setRootVisible(true);
		
		TreeNode tr4 = new TreeNode("审核意见");
		treePanel4.setRootNode(tr4);
		
		final TreeNode treeNode4_1 = new TreeNode("查询审核意见 ");
		treeNode4_1.setText("查询审核意见 ");
		tr4.appendChild(treeNode4_1);
		
//****************************tree5**************************
		final TreePanel treePanel5 = new TreePanel();
		treePanel5.setWidth(200);
		treePanel5.setHeight(600);
		treePanel5.setAnimate(true);
		treePanel5.setEnableDD(true);
		treePanel5.setContainerScroll(true);
		treePanel5.setRootVisible(true);
		
		TreeNode tr5 = new TreeNode("数据采集");
		treePanel5.setRootNode(tr5);
		
		final TreeNode treeNode5_1 = new TreeNode("数据导入");
		treeNode5_1.setText("数据导入");
		tr5.appendChild(treeNode5_1);
		
		final TreeNode treeNode5_2 = new TreeNode("数据填报");
		treeNode5_2.setText("数据填报");
		tr5.appendChild(treeNode5_2);
		
		final TreeNode treeNode5_2_1 = new TreeNode("专项资源");
		treeNode5_2_1.setText("专项资源");
		treeNode5_2.appendChild(treeNode5_2_1);
		
		final TreeNode treeNode5_2_1_1 = new TreeNode("生物种质资源");
		treeNode5_2_1_1.setText("生物种质资源");
		treeNode5_2_1.appendChild(treeNode5_2_1_1);
		
		final TreeNode treeNode5_2_2 = new TreeNode("重点资源");
		treeNode5_2_2.setText("重点资源");
		treeNode5_2.appendChild(treeNode5_2_2); 
		
		final TreeNode treeNode5_2_2_1 = new TreeNode("法人单位概况 ");
		treeNode5_2_2_1.setText("法人单位概况 ");
		treeNode5_2_2.appendChild(treeNode5_2_2_1);
		
		final TreeNode treeNode5_2_2_2 = new TreeNode("科研仪器设备概况  ");
		treeNode5_2_2_2.setText("科研仪器设备概况 ");
		treeNode5_2_2.appendChild(treeNode5_2_2_2);
		
		final TreeNode treeNode5_2_2_3 = new TreeNode("大型科学仪器设备（设施） ");
		treeNode5_2_2_3.setText("大型科学仪器设备（设施）");
		treeNode5_2_2.appendChild(treeNode5_2_2_3);
		
		final TreeNode treeNode5_2_2_4 = new TreeNode("人员概况");
		treeNode5_2_2_4.setText("人员概况");
		treeNode5_2_2.appendChild(treeNode5_2_2_4);
		
		final TreeNode treeNode5_2_2_5 = new TreeNode("高层次科技人员基本信息");
		treeNode5_2_2_5.setText("高层次科技人员基本信息");
		treeNode5_2_2.appendChild(treeNode5_2_2_5);
		
		final TreeNode treeNode5_2_2_6 = new TreeNode("财务概况");
		treeNode5_2_2_6.setText("财务概况");
		treeNode5_2_2.appendChild(treeNode5_2_2_6);
		
		final TreeNode treeNode5_2_2_7 = new TreeNode("研究实验基地");
		treeNode5_2_2_7.setText("研究实验基地");
		treeNode5_2_2.appendChild(treeNode5_2_2_7);
		
		final TreeNode treeNode5_3 = new TreeNode("申请退回");
		treeNode5_3.setText("申请退回");
		tr5.appendChild(treeNode5_3);
		
//********************************tree6*******************************
		final TreePanel treePanel6 = new TreePanel();
		treePanel6.setWidth(200);
		treePanel6.setHeight(600);
		treePanel6.setAnimate(true);
		treePanel6.setEnableDD(true);
		treePanel6.setContainerScroll(true);
		treePanel6.setRootVisible(true);
		
		TreeNode tr6 = new TreeNode("进度管理");
		treePanel6.setRootNode(tr6);
		
		final TreeNode treeNode6_1 = new TreeNode("进度浏览");
		treeNode6_1.setText("进度浏览");
		tr6.appendChild(treeNode6_1);
		
		
		final AccordionLayout accordion = new AccordionLayout(true);

		Panel westPanel = new Panel();
		westPanel.setTitle("导航栏");
		westPanel.setCollapsible(true);
		westPanel.setWidth(200);
		westPanel.setLayout(accordion);

		Panel navPanel1 = new Panel();

	
		navPanel1.setTitle("文件管理");
		navPanel1.setBorder(false);
		navPanel1.setIconCls("rss");
		navPanel1.add(treePanel1);
		westPanel.add(navPanel1);

		Panel navPanel2 = new Panel();
		
		navPanel2.setTitle("用户管理");
		navPanel2.setBorder(false);
		navPanel2.setIconCls("forlder-icon");
		navPanel2.add(treePanel2);
		westPanel.add(navPanel2);

		Panel navPanel3 = new Panel();
		
		navPanel3.setTitle("数据管理");
		navPanel3.setBorder(false);
		navPanel3.setIconCls("forlder-icon");
		navPanel3.add(treePanel3);
		westPanel.add(navPanel3);
		
		Panel navPanel4 = new Panel();
		
		navPanel4.setTitle("审核意见");
		navPanel4.setBorder(false);
		navPanel4.setIconCls("forlder-icon");
		navPanel4.add(treePanel4);
		westPanel.add(navPanel4);
		
		
		Panel navPanel5 = new Panel();
		
		navPanel5.setTitle("数据采集");
		navPanel5.setBorder(false);
		navPanel5.setIconCls("forlder-icon");
		navPanel5.add(treePanel5);
		westPanel.add(navPanel5);
		
		Panel navPanel6 = new Panel();
		
		navPanel6.setTitle("进度管理");
		navPanel6.setBorder(false);
		navPanel6.setIconCls("forlder-icon");
		navPanel6.add(treePanel6);
		westPanel.add(navPanel6);

		BorderLayoutData westData = new BorderLayoutData(RegionPosition.WEST);
		westData.setSplit(true);
		westData.setMinSize(175);
		westData.setMaxSize(400);
		westData.setMargins(new Margins(0, 2, 0, 0));

		borderPanel.add(westPanel, westData);
//************************tip********************************
		ToolTip tip1 = new ToolTip();   
        tip1.setHtml("可以预览并且下载已经提交的文件");   
        tip1.applyTo(navPanel1);  
        
        
//      ******************************** center panel********************************************

		TabPanel centerPanel = new TabPanel();
		panel.setBorder(false);
		panel.setPaddings(15);
		centerPanel.setActiveTab(0);
		centerPanel.setEnableTabScroll(true);
		centerPanel.setDeferredRender(false);

		Panel centerPanelTwo = new HTMLPanel();
		centerPanelTwo.setHtml("");

		centerPanelTwo.setTitle("Center Panel");
		centerPanelTwo.setAutoScroll(true);

		Panel centerPanelThree = new HTMLPanel();
		centerPanelThree.setHtml("");

		centerPanelThree.setTitle("Center Panel");
		centerPanelThree.setAutoScroll(true);

		RecordDef recordDef = new RecordDef(new FieldDef[] {
				new StringFieldDef("title"), new StringFieldDef("company"),
				new DateFieldDef("time", "n/j h:ia"),

		});

		Object[][] data = getCompanyData();
		MemoryProxy proxy = new MemoryProxy(data);

		ArrayReader reader = new ArrayReader(recordDef);
		Store store = new Store(proxy, reader);
		store.load();

		BaseColumnConfig[] columns = new BaseColumnConfig[] {
				new RowNumberingColumnConfig(),
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

		ColumnModel columnModel = new ColumnModel(columns);

		GridPanel grid = new GridPanel();
		grid.setStore(store);
		grid.setColumnModel(columnModel);

		grid.setTitle("文件浏览");
		grid.setHeight(300);
		grid.setWidth(600);
		grid.setIconCls("grid-icon");

		GridView view = new GridView();
		view.setForceFit(true);
		grid.setView(view);

		// centerPanel.add(centerPanelTwo);
		borderPanel.add(centerPanel,
				new BorderLayoutData(RegionPosition.CENTER));

		centerPanelTwo.add(formPanel);

		centerPanel.add(grid);
		centerPanel.add(centerPanelTwo);
		centerPanel.add(centerPanelThree);
		
	
		HorizontalPanel horizontalPanel2 = new HorizontalPanel();
		horizontalPanel2.setSpacing(15);
		Panel windowPanel = new Panel();
		// windowPanel.setHtml(getShortBogusMarkup());
		windowPanel.setShadow(true);

		final Window window = new Window();
		window.setTitle("Window Panel");
		window.setIconCls("paste-icon");
		window.setMaximizable(true);
		window.setResizable(true);
		window.setLayout(new FitLayout());
		window.setWidth(400);
		window.setHeight(300);
		window.setModal(false);
		window.setAutoHeight(false);
		//window.setCloseAction(CloseAction closeAction());

		final FormPanel frm = new FormPanel();

		frm.setPaddings(20);
		frm.setTitle("用户信息");
		frm.setWidth(300);
		frm.setFrame(true);

		TextField txtUsername = new TextField("用户名", "username");
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
				if (frm.getForm().isValid()) {

					DatabaseServiceAsync service = DatabaseService.Util
							.getInstance();
					Map formData = getFormDataAsMap(frm.getForm());

					service.saveData(formData, callback);
					
					MessageBox.show(new MessageBoxConfig(){
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
		                             //   System.out.println("Done, Your fake data was saved!");   
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
				
		
			//	window.addListener(listener);
				
					
			//	window.close();
	
				
				
				
			}

			
		});

		window.setAnimateTarget(btAdd.getId());
		buttonPanel.add(btSave);
		buttonPanel.add(btCancel);
		frm.add(buttonPanel);
		window.add(frm);
		
		treePanel2.add(btAdd);
		
		RootPanel.get().add(centerPanel);

		panel.add(borderPanel);

		new Viewport(panel);
		//panel_1.add(btAdd);
		//RootPanel.get().add(panel_1);
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
        System.out.println("Done, Your fake data was saved!");   
		MessageBox.alert("保存失败");

	}

	public void onSuccess(Object arg0) {
		MessageBox.hide();   
        System.out.println("Done, Your fake data was saved!");   
		MessageBox.alert("保存成功");

	}

private Object[][] getCompanyData() {
	return new Object[][] {
			new Object[] { "3m Co", "教育部", "9/1 12:00am" },
			new Object[] { "Alcoa Inc", "科技部", "9/1 12:00am" },
			new Object[] { "Altria Group Inc", "财政部", "9/1 12:00am" },
			new Object[] { "American Express Company", "体育部", "9/1 12:00am" },
			new Object[] { "American International Group, Inc.", "司法",
					"9/1 12:00am" },
			new Object[] { "AT&T Inc.", "国防科工委", "9/1 12:00am" },
			new Object[] { "Boeing Co.", "新闻办", "9/1 12:00am" },
			new Object[] { "Caterpillar Inc.", "外交部", "9/1 12:00am" },
			new Object[] { "Citigroup, Inc.", "公安部", "9/1 12:00am" },
			new Object[] { "E.I. du Pont de Nemours and Company", "铁道部",
					"9/1 12:00am" },
			new Object[] { "American International Group, Inc.", "司法",
					"9/1 12:00am" },
			new Object[] { "AT&T Inc.", "国防科工委", "9/1 12:00am" },
			new Object[] { "Boeing Co.", "新闻办", "9/1 12:00am" },
			new Object[] { "Caterpillar Inc.", "外交部", "9/1 12:00am" },
			new Object[] { "Citigroup, Inc.", "公安部", "9/1 12:00am" },
			new Object[] { "E.I. du Pont de Nemours and Company", "铁道部",
					"9/1 12:00am" },
			new Object[] { "Boeing Co.", "新闻办", "9/1 12:00am" },
			new Object[] { "Caterpillar Inc.", "外交部", "9/1 12:00am" },
			new Object[] { "Citigroup, Inc.", "公安部", "9/1 12:00am" },
			new Object[] { "E.I. du Pont de Nemours and Company", "铁道部",
					"9/1 12:00am" },
			new Object[] { "American International Group, Inc.", "司法",
					"9/1 12:00am" },
			new Object[] { "AT&T Inc.", "国防科工委", "9/1 12:00am" },
			new Object[] { "Boeing Co.", "新闻办", "9/1 12:00am" },
			new Object[] { "Caterpillar Inc.", "外交部", "9/1 12:00am" },
			new Object[] { "Citigroup, Inc.", "公安部", "9/1 12:00am" },
			new Object[] { "E.I. du Pont de Nemours and Company", "铁道部",
					"9/1 12:00am" } };
}
private static Object[][] getData() {   
    return new Object[][]{   
            new Object[]{"Summer", new Integer(564815), "#00b8bf"},   
            new Object[]{"Fall", new Double(664182), "#8dd5e7"},   
            new Object[]{"Spring", new Double(248124), "#c0fff6"},   
            new Object[]{"Winter", new Double(271214), "#ffa928"},   
            new Object[]{"Undecided", new Double(81845), "#edff9f"}   
    };   
}   


}

