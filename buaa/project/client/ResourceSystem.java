package com.buaa.project.client;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import com.buaa.project.client.data.BeanNewsDTO;
import com.buaa.project.client.panel.ColumnPanel;
import com.buaa.project.client.panel.DepartmentPanel;
import com.buaa.project.client.panel.EditorPanel;
import com.buaa.project.client.panel.FarenPanel;
import com.buaa.project.client.panel.Fileupload;
import com.buaa.project.client.panel.FormGridSample;
import com.buaa.project.client.panel.LinkListPanel;
import com.buaa.project.client.panel.LoadNewsPanel;
import com.buaa.project.client.panel.Login;
import com.buaa.project.client.panel.NewsWindow;
import com.buaa.project.client.panel.PiechartPanel;
import com.buaa.project.client.panel.SampleGrid;
import com.buaa.project.client.theme.ThemeChanger;
import com.buaa.project.client.window.FarenWindow;
import com.buaa.project.client.window.LargeDeviceWindow;
import com.buaa.project.client.window.PlantWindow;
import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.user.client.DOM;
import com.google.gwt.user.client.Timer;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Frame;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Hyperlink;
import com.gwtext.client.core.EventCallback;
import com.gwtext.client.core.EventObject;
import com.gwtext.client.core.Ext;
import com.gwtext.client.core.ExtElement;
import com.gwtext.client.core.Function;
import com.gwtext.client.core.Margins;
import com.gwtext.client.core.Position;
import com.gwtext.client.core.RegionPosition;
import com.gwtext.client.core.Template;
import com.gwtext.client.data.ArrayReader;
import com.gwtext.client.data.FieldDef;
import com.gwtext.client.data.MemoryProxy;
import com.gwtext.client.data.Node;
import com.gwtext.client.data.Record;
import com.gwtext.client.data.RecordDef;
import com.gwtext.client.data.Store;
import com.gwtext.client.data.StringFieldDef;
import com.gwtext.client.util.DelayedTask;
import com.gwtext.client.widgets.Button;
import com.gwtext.client.widgets.Component;
import com.gwtext.client.widgets.DatePicker;
import com.gwtext.client.widgets.HTMLPanel;
import com.gwtext.client.widgets.MessageBox;
import com.gwtext.client.widgets.MessageBoxConfig;
import com.gwtext.client.widgets.PagingToolbar;
import com.gwtext.client.widgets.Panel;
import com.gwtext.client.widgets.TabPanel;
import com.gwtext.client.widgets.ToolTip;
import com.gwtext.client.widgets.Toolbar;
import com.gwtext.client.widgets.ToolbarButton;
import com.gwtext.client.widgets.Viewport;
import com.gwtext.client.widgets.WaitConfig;
import com.gwtext.client.widgets.Window;
import com.gwtext.client.widgets.event.ButtonListenerAdapter;
import com.gwtext.client.widgets.event.PanelListenerAdapter;
import com.gwtext.client.widgets.form.DateField;
import com.gwtext.client.widgets.form.Field;
import com.gwtext.client.widgets.form.Form;
import com.gwtext.client.widgets.form.FormPanel;
import com.gwtext.client.widgets.form.NumberField;
import com.gwtext.client.widgets.form.TextField;
import com.gwtext.client.widgets.form.VType;
import com.gwtext.client.widgets.form.event.FieldListenerAdapter;
import com.gwtext.client.widgets.form.event.TextFieldListenerAdapter;
import com.gwtext.client.widgets.grid.ColumnConfig;
import com.gwtext.client.widgets.grid.ColumnModel;
import com.gwtext.client.widgets.grid.GridPanel;
import com.gwtext.client.widgets.grid.GridView;
import com.gwtext.client.widgets.grid.event.GridCellListener;
import com.gwtext.client.widgets.grid.event.GridCellListenerAdapter;
import com.gwtext.client.widgets.layout.AccordionLayout;
import com.gwtext.client.widgets.layout.BorderLayout;
import com.gwtext.client.widgets.layout.BorderLayoutData;
import com.gwtext.client.widgets.layout.FitLayout;
import com.gwtext.client.widgets.layout.HorizontalLayout;
import com.gwtext.client.widgets.tree.TreeNode;
import com.gwtext.client.widgets.tree.TreePanel;
import com.gwtext.client.widgets.tree.event.TreeNodeListenerAdapter;
import com.gwtextux.client.data.PagingMemoryProxy;
import com.gwtextux.client.widgets.image.Image;
import com.gwtextux.client.widgets.image.ImageListenerAdapter;

/**
 * Entry point classes define <code>onModuleLoad()</code>.
 */
public class ResourceSystem implements EntryPoint {

	private TabPanel centerPanel;

	public Panel panel;

	public Panel westPanel;

	public ToolbarButton bt1;

	public ToolbarButton bt2;

	public Toolbar toolbar;

	public String bodyStyle = "text-align:center;padding:5px 0;"
			+ "border:1px dotted #99bbe8;background:#dfe8f6;"
			+ "color:#15428b;cursor:default;margin:10px;"
			+ "font:bold 11px tahoma,arial,sans-serif;";

	ToolTip tip;

	String news_title;

	PagingMemoryProxy proxy;

	private Object[][] getObj(Object response) {
		List data = (List) response;

		Iterator it = data.iterator();
		int i = data.size();
		int j = 0;
		Object[][] b = new Object[i][];
		while (it.hasNext()) {
			final BeanNewsDTO bean = (BeanNewsDTO) it.next();
			Object[] a = bean.toObjectArray();
			b[j++] = a;

		}

		return b;
	}

	private Store getStore(int i) {
		Object[][][] data = new Object[][][] {

				new Object[][] { new Object[] { "硬件及作业信息", "Manufacturing" },
						new Object[] { "网络质量监控信息", "Manufacturing" },
						new Object[] { "GOS监控信息", "Manufacturing" },
						new Object[] { "作业信息", "Manufacturing" },

				},
				new Object[][] { new Object[] { "全局配置信息", "Manufacturing" },
						new Object[] { "节点配置信息", "Manufacturing" },

				},
				new Object[][] { new Object[] { "作业报表", "Manufacturing" },
						new Object[] { "网络质量报表", "Manufacturing" },
						new Object[] { "硬件日报表", "Manufacturing" },
						new Object[] { "硬件月报表", "Manufacturing" },
						new Object[] { "硬件年报表", "Manufacturing" },

						new Object[] { "GOS日报表", "Manufacturing" },
						new Object[] { "GOS月报表", "Manufacturing" },
						new Object[] { "GOS年报表", "Manufacturing" },

				},
				new Object[][] { new Object[] { "3m Co", "Manufacturing" },
						new Object[] { "Alcoa Inc", "Manufacturing" },
						new Object[] { "Altria Group Inc", "Manufacturing" } }

		};

		MemoryProxy proxy = new MemoryProxy(data[i]);
		RecordDef recordDef = new RecordDef(
				new FieldDef[] { new StringFieldDef("name") });
		ArrayReader reader = new ArrayReader(recordDef);
		Store store = new Store(proxy, reader);
		store.load();
		return store;
	}

	private GridPanel getNewLeftGrid(int i) {
		GridPanel grid = new GridPanel();
		ColumnConfig[] columns = new ColumnConfig[] { new ColumnConfig("start",
				"name", 200, true, null, "name"), };
		ColumnModel columnModel = new ColumnModel(columns);
		grid.setColumnModel(columnModel);
		grid.setBorder(false);
		grid.setAutoExpandColumn("name");

		grid.setAutoHeight(true);
		grid.setAutoExpandMin(200);
		grid.setStore(this.getStore(i));
		grid.setHideColumnHeader(true);
		return grid;

	}

	public void onModuleLoad() {

		panel = new Panel();
		panel.setBorder(false);
		panel.setPaddings(10);
		panel.setLayout(new FitLayout());
		panel.setShadow(true);
		panel.setId("main-panel");
		// panel.setStyle("color:black;background-color:red");
		// panel.addClass("ext-el-mask-msg");
		panel.doLayout();

		Panel borderPanel = new Panel();
		borderPanel.setLayout(new BorderLayout());

		Panel northPanel = new Panel();
		northPanel.setHeight(53);
		northPanel.setId("northPanel");
		northPanel.setStyleName("");
		northPanel.setLayout(new HorizontalLayout(0));
		borderPanel.add(northPanel, new BorderLayoutData(RegionPosition.NORTH));

		Panel southPanel = new Panel();
		southPanel.setHeight(42);
		southPanel.setBorder(false);
		southPanel.setFrame(true);
		southPanel
				.setHtml("<P align=center>版权所有：国家科技基础条件平台中心</p>\n"
						+ "<p align=center>地址：北京市复兴路乙15号 | 邮编：100862 | 地理位置图 | 咨询电话：010-58881463 | 联系我们</P>");
		borderPanel.add(southPanel, new BorderLayoutData(RegionPosition.SOUTH));
		// ThemeChanger themeChanger = new ThemeChanger();
		// southPanel.add(themeChanger);

		toolbar = new Toolbar();
		toolbar.setId("login-tooblar");
		toolbar.setWidth(64);
		toolbar.setHeight(54);
		toolbar.setStyleName("ext-el-mask-msg");

		Image image = new Image("title", "image/12.jpg");
		image.setWidth("960px");

		image.addListener(new ImageListenerAdapter() {

			public void onMouseOver(Image image, EventObject e) {

				ToolTip imageToolTip = new ToolTip();
				imageToolTip.setBodyStyle(bodyStyle);
				imageToolTip
						.setHtml("<p>资源填报系统全称为“国家科技基础条件平台资源调查信息管理系统”，是“国家科技基础条件平台”的子系统。平台中心实施资源调查的目的是为了解和掌握我国科技资源分布状况及利用情况，建成相应科技资源数据库，建立科技资源数据动态更新机制。初步形成国家科技基础条件资源管理信息和决策支持系统，为国家科技基础条件平台建设、国家科技计划和重大科技专项的实施，乃至科技条件建设投入提供决策参考。</p>");
				imageToolTip.setWidth(330);
				imageToolTip.setTrackMouse(true);
				imageToolTip.setDismissDelay(150000);
				imageToolTip.applyTo(image);

			}
		});

		northPanel.add(image);

		bt1 = new ToolbarButton("登陆");
		bt1.setId("login");
		toolbar.addButton(bt1);
		northPanel.add(toolbar);

		Hyperlink hy = new Hyperlink();
		hy.setHTML("jessiena");

		// **********************tree1*********************************************

		final TreePanel treePanel1 = new TreePanel();
		treePanel1.setWidth(200);
		treePanel1.setHeight(340);
		treePanel1.setBodyBorder(false);
		treePanel1.setCollapsible(true);
		treePanel1.setAnimate(true);
		treePanel1.setEnableDD(true);
		treePanel1.setContainerScroll(true);
		treePanel1.setRootVisible(true);
		treePanel1.setId("treePanel1");
		treePanel1.setIconCls("treePanel1-icon");

		// treePanel1.add(bt);

		TreeNode tr1 = new TreeNode("文件管理");
		tr1.setIconCls("treeNode1-icon");
		tr1.setExpanded(true);
		treePanel1.setRootNode(tr1);
		// treePanel1.setRootNode(tr8);

		final TreeNode treeNode1_1 = new TreeNode("新闻发布");
		treeNode1_1.setText("新闻发布");
		treeNode1_1.setId("treeNode1_1");
		treeNode1_1.setIconCls("treeNode1_2-icon");
		tr1.appendChild(treeNode1_1);
		tip = new ToolTip();
		tip.setHtml("进行新闻发布！");
		tip.setBodyStyle(bodyStyle);

		final TreeNode treeNode1_2 = new TreeNode("文件浏览");
		treeNode1_2.setText("文件浏览");
		treeNode1_1.setId("treeNode1_1");
		treeNode1_2.setIconCls("treeNode1_1-icon");
		tr1.appendChild(treeNode1_2);

		final TreeNode treeNode1_3 = new TreeNode("文件下载");
		treeNode1_3.setText("文件下载");
		treeNode1_1.setId("treeNode1_3");
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

				Button bt1 = new Button("bt1", new ButtonListenerAdapter() {
					public void onClick(Button button, EventObject e) {

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
		treePanel2.setHeight(340);
		treePanel2.setAnimate(true);
		treePanel2.setEnableDD(true);
		treePanel2.setContainerScroll(true);
		treePanel2.setRootVisible(true);
		treePanel2.setId("treePanel2");
		treePanel2.setContainerScroll(true);
		treePanel2.setCollapsible(true);

		TreeNode tr2 = new TreeNode("用户管理");
		tr2.setExpanded(true); // 默认节点展开
		treePanel2.setRootNode(tr2);
		tr2.setIconCls("treeNode1-icon");

		final TreeNode treeNode2_1 = new TreeNode("法人单位基本信息");
		treeNode2_1.setText("法人单位基本信息");
		treeNode2_1.setId("treeNode2_1");
		treeNode2_1.setIconCls("treeNode2_1-icon");
		tr2.appendChild(treeNode2_1);

		final TreeNode treeNode2_2 = new TreeNode("研究实验基地");
		treeNode2_2.setText("研究实验基地");
		treeNode2_2.setId("treeNode2_2");
		treeNode2_2.setIconCls("treeNode2_2-icon");
		tr2.appendChild(treeNode2_2);

		final TreeNode treeNode2_3 = new TreeNode("资源保存机构");
		treeNode2_3.setText("资源保存机构 ");
		treeNode2_3.setId("treeNode2_3");
		treeNode2_3.setIconCls("treeNode2_3-icon");
		tr2.appendChild(treeNode2_3);

		final TreeNode treeNode2_4 = new TreeNode("其他填报部门");
		treeNode2_4.setText("其他填报部门");
		treeNode2_4.setId("treeNode2_4");
		treeNode2_4.setIconCls("treeNode2_4-icon");
		tr2.appendChild(treeNode2_4);

		// ****************************tree3**************************

		final TreePanel treePanel3 = new TreePanel();
		treePanel3.setWidth(200);
		treePanel3.setHeight(340);
		treePanel3.setAnimate(true);
		treePanel3.setEnableDD(true);
		treePanel3.setContainerScroll(true);
		treePanel3.setRootVisible(true);
		treePanel3.setId("treePanel3");

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
		treePanel4.setHeight(340);
		treePanel4.setAnimate(true);
		treePanel4.setEnableDD(true);
		treePanel4.setContainerScroll(true);
		treePanel4.setRootVisible(true);
		treePanel4.setId("treePanel4");

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
		treePanel5.setHeight(340);
		treePanel5.setId("treePanel5");
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
		treeNode5_2_1_1.setIconCls("treeNode5_2_2-icon");
		treeNode5_2_1.appendChild(treeNode5_2_1_1);

		final TreeNode treeNode5_2_1_1_1 = new TreeNode("植物种质资源");
		treeNode5_2_1_1_1.setText("植物种质资源");
		treeNode5_2_1_1_1.setIconCls("treeNode5_2_1_1-icon");
		treeNode5_2_1_1.appendChild(treeNode5_2_1_1_1);

		final TreeNode treeNode5_2_1_1_2 = new TreeNode("动物种质资源");
		treeNode5_2_1_1_2.setText("动物种质资源");
		treeNode5_2_1_1_2.setIconCls("treeNode5_2_1_1-icon");
		treeNode5_2_1_1.appendChild(treeNode5_2_1_1_2);

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

		// ********************************************************************
		treeNode5_2_2_1.addListener(new TreeNodeListenerAdapter() {

			public void onClick(Node Node, EventObject e) {

				FarenWindow faRen = new FarenWindow();
				faRen.setVisible(true);
				faRen.show();

				final ExtElement element = Ext.get("main-panel");

				element.mask();

				faRen.addListener(new PanelListenerAdapter() {

					public void onClose(Panel panel) {

						element.unmask();

					}
				});

			}
		});
		// *****************************************************
		treeNode5_2_2_3.addListener(new TreeNodeListenerAdapter() {

			public void onClick(Node node, EventObject e) {

				LargeDeviceWindow largeDevice = new LargeDeviceWindow();
				largeDevice.setVisible(true);
				largeDevice.show();

				final ExtElement element = Ext.get("main-panel");

				element.mask();

				largeDevice.addListener(new PanelListenerAdapter() {

					public void onClose(Panel panel) {

						element.unmask();

					}
				});

			}

		});
		// ********************************************************
		treeNode5_1.addListener(new TreeNodeListenerAdapter() {

			public void onClick(Node node, EventObject e) {

				Fileupload fileUpload = new Fileupload();
				fileUpload.setVisible(true);
				fileUpload.show();

				final ExtElement element = Ext.get("main-panel");

				element.mask();

				fileUpload.addListener(new PanelListenerAdapter() {

					public void onClose(Panel panel) {

						element.unmask();

					}
				});

			}
		});
		// ***********************************************************
		treeNode5_2_1_1_1.addListener(new TreeNodeListenerAdapter() {

			public void onClick(Node node, EventObject e) {

				PlantWindow plantWindow = new PlantWindow();
				plantWindow.setVisible(true);
				plantWindow.show();

				final ExtElement element = Ext.get("main-panel");

				element.mask();

				plantWindow.addListener(new PanelListenerAdapter() {

					public void onClose(Panel panel) {

						element.unmask();

					}
				});

			}
		});
		// ********************************tree6*******************************
		final TreePanel treePanel6 = new TreePanel();
		treePanel6.setWidth(200);
		treePanel6.setHeight(340);
		treePanel6.setAnimate(true);
		treePanel6.setEnableDD(true);
		treePanel6.setContainerScroll(true);
		treePanel6.setRootVisible(true);
		treePanel6.setId("treePanel6");
		treePanel6.setUseArrows(true);

		TreeNode tr6 = new TreeNode("进度管理");
		tr6.setIconCls("treeNode1-icon");
		treePanel6.setRootNode(tr6);

		final TreeNode treeNode6_1 = new TreeNode("进度浏览");
		treeNode6_1.setText("进度浏览");
		treeNode6_1.setIconCls("treeNode6_1-icon");
		tr6.appendChild(treeNode6_1);

		final TreeNode treeNode6_2 = new TreeNode("柱状浏览");
		treeNode6_2.setText("柱状浏览");
		treeNode6_2.setIconCls("columnChart-icon");
		tr6.appendChild(treeNode6_2);
		// *************************************************************
		final AccordionLayout accordion = new AccordionLayout(true);
		final AccordionLayout accordion1 = new AccordionLayout(true);

		westPanel = new Panel();
		westPanel.setTitle("导航栏");
		westPanel.setId("west");
		westPanel.setIconCls("westPanel-icon");
		westPanel.setCollapsible(true);
		westPanel.setWidth(200);
		westPanel.setLayout(accordion);
		// System.out.println(westPanel.getId()+"********");

		Panel navPanel1 = new Panel();

		navPanel1.setTitle("文件管理");
		navPanel1.setBorder(false);
		navPanel1.setIconCls("navPanel1-icon");
		navPanel1.setId("navPanel1");
		navPanel1.add(treePanel1);
		navPanel1.setMaskDisabled(true);
		navPanel1.isMaskDisabled();
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

		// westPanel.getEl().mask("fdfs");

		borderPanel.add(westPanel, westData);
		// ****************************************************************

		Panel eastPanel = new HTMLPanel();
		eastPanel.setTitle("其他");
		// eastPanel.setBodyStyle("background-color:#15428b");
		eastPanel.setCollapsible(true);
		eastPanel.setBorder(true);
		eastPanel.setWidth(200);
		eastPanel.setIconCls("plugin-icon");
		eastPanel.setLayout(accordion1);
		// eastPanel.setHtml("<p><a href=\"MainModule.html\">相关连接</a></p>");
		// <a href = "sina.com"></a>

		BorderLayoutData eastData = new BorderLayoutData(RegionPosition.EAST);
		eastData.setSplit(true);
		eastData.setMinSize(175);
		eastData.setMaxSize(400);
		eastData.setMargins(new Margins(0, 0, 5, 0));

		borderPanel.add(eastPanel, eastData);

		// ******************************************************

		Panel navPanel_east1 = new Panel();
		navPanel_east1.setTitle("部级联席会成员单位");
		navPanel_east1.setBorder(false);
		navPanel_east1.setIconCls("html-icon");
		eastPanel.add(navPanel_east1);

		DepartmentPanel d = new DepartmentPanel();
		navPanel_east1.add(d);

		Panel navPanel_east2 = new Panel();
		navPanel_east2.setTitle("相关连接");
		navPanel_east2.setBorder(false);
		navPanel_east2.setIconCls("list-icon");
		eastPanel.add(navPanel_east2);
		LinkListPanel linkList = new LinkListPanel();
		navPanel_east2.add(linkList);

		Panel navPanel_east3 = new Panel();
		navPanel_east3.setTitle("Google搜索页面");
		navPanel_east3.setBorder(false);
		navPanel_east3.setIconCls("google-icon");
		// navPanel_east3.setHtml("<p align=center><FONT size=1><a
		// href=\"http://www.sina.com.cn\">863计划</a></FONT></p>");
		eastPanel.add(navPanel_east3);

		Frame google = new Frame("http://www.google.com");

		Panel googlePanel = new Panel();
		googlePanel.setLayout(new FitLayout());
		googlePanel.setIconCls("tab-icon");
		googlePanel.add(google);
		googlePanel.setHeight(408);
		googlePanel.setAutoWidth(true);

		navPanel_east3.add(googlePanel);

		// ************************tip********************************
		ToolTip tip1 = new ToolTip();
		tip1.setHtml("可以预览并且下载已经提交的文件");
		tip1.applyTo(navPanel1);

		// ******************************** center

		// panel********************************************

		centerPanel = new TabPanel();

		centerPanel.setActiveTab(0);
		centerPanel.setEnableTabScroll(true);
		centerPanel.setDeferredRender(false);
		centerPanel.setAutoShow(true);
		centerPanel.setLayoutOnTabChange(true);

		final Panel centerPanel1 = new Panel();
		centerPanel1.setLayout(new FitLayout());
		centerPanel1.setTitle("新闻浏览");
		centerPanel1.setIconCls("grid-icon");

		centerPanel.add(centerPanel1);

		final GridPanel grid_news = new GridPanel();

		ToolTip tip = new ToolTip();
		tip.setHtml("点击浏览该新闻");
		tip.setWidth(120);
		tip.setBodyStyle(bodyStyle);
		tip.setTrackMouse(true);
		tip.applyTo(grid_news);

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

		final ColumnModel columnModel = new ColumnModel(new ColumnConfig[] {
				N_TITLE, N_AUTHOR, N_TIME

		});

		final DatabaseServiceAsync loadService = DatabaseService.Util
				.getInstance();
		final AsyncCallback cb_load = new AsyncCallback() {

			public void onFailure(Throwable caught) {
				// TODO Auto-generated method stub
				// Window.alert("Fail to getting data" + caught.toString());
			}

			public void onSuccess(Object response) {

				proxy = new PagingMemoryProxy(getObj(response));

				ArrayReader reader = new ArrayReader(recordDef);

				Store store = new Store(proxy, reader, true);

				grid_news.setStore(store);

				grid_news.setColumnModel(columnModel);

				// grid_news.setHeight(473);
				grid_news.setFrame(true);
				// grid_news.setAutoExpandColumn("N_TITLE");
				grid_news.stripeRows(true);
				// grid_news.setWidth(563);
				// grid_news.setLoadMask(true);

				grid_news.setVisible(true);

				final PagingToolbar pagingToolbar = new PagingToolbar(store);

				pagingToolbar.setPageSize(19);
				pagingToolbar.setDisplayInfo(true);
				pagingToolbar.setDisplayMsg("显示新闻条数 {0} - {1} of {2}");
				pagingToolbar.setEmptyMsg("没有数据显示");
				pagingToolbar.setVisible(true);

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

				// pagingToolbar.setVisible(true);
				// pagingToolbar.addButton(refreshBt);

				pagingToolbar.addField(pageSizeField);
				grid_news.setBottomToolbar(pagingToolbar);
				grid_news.doLayout();
				GridView view = new GridView();
				view.setForceFit(true);
				grid_news.setView(view);

				store.load(0, 19);
				centerPanel1.add(grid_news);
				centerPanel1.doLayout();

				final ExtElement element = Ext.get("main-panel");
				element.unmask();

				if (store == null) {
					return;
				}

				List data = (List) response;

				Iterator it = data.iterator();

				while (it.hasNext()) {

					final BeanNewsDTO bean = (BeanNewsDTO) it.next();
					Object[] a = bean.toObjectArray();
					Object[][] b = new Object[][] { a };
					// store.add(recordDef.createRecord(bean.toObjectArray()));

				}

				store.commitChanges();

			}

		};
		loadService.getdata(cb_load);

		grid_news.addGridCellListener(new GridCellListenerAdapter() {

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

		// LoadDataPanel ldp = new LoadDataPanel();
		// ldp.setTitle("新闻预览");
		// ldp.setVisible(true);
		// centerPanel.setAutoShow(true);
		// centerPanel.add(ldp);
		// centerPanel.doLayout();

		// *********************************************************

		Panel centerPanelTwo = new Panel();

		centerPanelTwo.setTitle("Center Panel 2");
		centerPanelTwo.setAutoScroll(true);
		centerPanelTwo.setAutoShow(true);

		// DataLoad dataLoad = new DataLoad();
		// centerPanelTwo.add(dataLoad);

		// **********************************************************

		Panel centerPanelThree = new Panel();
		centerPanelThree.setPaddings(0);
		centerPanelThree.setTitle("Search Test");
		centerPanelThree.setAutoScroll(true);
		SampleGrid f = new SampleGrid();
		centerPanelThree.add(f);
		// centerPanel.add(centerPanelThree);

		// **************************************************************************

		borderPanel.add(centerPanel,
				new BorderLayoutData(RegionPosition.CENTER));

		Button bt = new Button("bt", new ButtonListenerAdapter() {

			public void onClick(Button button, EventObject e) {
				MessageBox.alert("fsfsfdsff");
			}
		});

		// centerPanel.add(centerPanelTwo);
		// centerPanel.add(centerPanelThree);

		// ****************************************************************
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
		// ***********************************************************
		treeNode6_2.addListener(new TreeNodeListenerAdapter() {

			public void onClick(Node node, EventObject e) {

				ColumnPanel columnPanel = new ColumnPanel();
				columnPanel.setVisible(true);
				columnPanel.setClosable(true);
				centerPanel.activate(0);
				centerPanel.add(columnPanel);
				centerPanel.doLayout();

			}
		});
		// ×××××××××××××××××××××××××××××××××××××××××××××××××××××××××××
		treeNode1_1.addListener(new TreeNodeListenerAdapter() {
			public void onClick(Node Node, EventObject e) {

				EditorPanel editPanel = new EditorPanel();

				editPanel.setIconCls("navPanel3-icon");
				editPanel.setVisible(true);
				centerPanel.activate(0);
				centerPanel.add(editPanel);
				centerPanel.doLayout();
			}
		});
		// *************************************************************
		treeNode3_1_2_1.addListener(new TreeNodeListenerAdapter() {

			public void onClick(Node node, EventObject e) {
				FarenPanel farenPanel = new FarenPanel();
				farenPanel.setTitle("法人单位概况");
				farenPanel.setVisible(true);
				centerPanel.activate(0);
				centerPanel.add(farenPanel);
				centerPanel.doLayout();

			}
		});

		// ****************************************************************
		treeNode1_3.addListener(new TreeNodeListenerAdapter() {
			public void onClick(Node node, EventObject e) {

				centerPanel.doLayout();

			}
		});
		// ******************************************************
		treeNode2_1.addListener(new TreeNodeListenerAdapter() {

			public void onClick(Node node, EventObject e) {

				SampleGrid sampGrid = new SampleGrid();
				sampGrid.setVisible(true);
				centerPanel.add(sampGrid);
				centerPanel.doLayout();

			}
		});
		// *****************************************************
		bt1.addListener(new ButtonListenerAdapter() {
			//			
			public void onClick(Button button, EventObject e) {

				// westPanel.getEl().unmask();

				// panel.getEl().mask();

				// name.setVisible(false);
				// psw.setVisible(false);
				// toolbar.addText("欢迎"+name.getText()+"访问");

				Login loginWin = new Login();

				loginWin.show();

				final ExtElement element = Ext.get("main-panel");

				element.mask();

				loginWin.addListener(new PanelListenerAdapter() {

					public void onClose(Panel panel) {

						element.unmask();

					}
				});
			}
		});
		// *******************************************************
		HorizontalPanel horizontalPanel2 = new HorizontalPanel();
		horizontalPanel2.setSpacing(15);
		Panel windowPanel = new Panel();
		// windowPanel.setHtml(getShortBogusMarkup());

		/*
		 * final Window window = new Window(); window.setTitle("用户信息");
		 * window.setIconCls("paste-icon"); window.setMaximizable(true);
		 * window.setResizable(true); window.setLayout(new FitLayout());
		 * window.setWidth(400); window.setHeight(300); window.setModal(false);
		 * window.setAutoHeight(false); window.setIconCls("window-icon"); //
		 * window.setCloseAction(CloseAction closeAction());
		 *  /* final FormPanel frm = new FormPanel();
		 * 
		 * frm.setPaddings(20); //frm.setTitle("用户信息"); frm.setWidth(300);
		 * frm.setFrame(true);
		 * 
		 * final TextField txtUsername = new TextField("用户名", "username");
		 * txtUsername.setId("name"); TextField txtPassword = new
		 * TextField("密码", "password"); TextField txtEmail = new
		 * TextField("Email", "email");
		 * 
		 * txtUsername.setRegex("^[a-zA-Z]*$");
		 * txtUsername.setRegexText("只允许输入字母");
		 * txtUsername.setAllowBlank(false);
		 * 
		 * txtPassword.setPassword(true); txtPassword.setRegex("^[a-zA-Z]*$");
		 * txtPassword.setRegexText("只允许输入字母");
		 * txtPassword.setAllowBlank(false);
		 * 
		 * txtEmail.setVtype(VType.EMAIL);
		 * 
		 * txtEmail.setAllowBlank(false);
		 * 
		 * frm.add(txtUsername); frm.add(txtPassword); frm.add(txtEmail);
		 * 
		 * Panel buttonPanel = new Panel(); buttonPanel.setLayout(new
		 * HorizontalLayout(10));
		 * 
		 * final AsyncCallback callback = this;
		 * 
		 * Button btSave = new Button("保存"); btSave.setId("save");
		 * btSave.addListener(new ButtonListenerAdapter() { public void
		 * onClick(final Button button, EventObject e) {
		 * 
		 * 
		 * TextField txtUsername1 = (TextField)frm.getComponent(0);
		 * System.out.println(txtUsername1.getText());
		 *  // String item = frm.getId(name);
		 * 
		 * //item.
		 *  // txtUsername2 = (TextField)frmf.getId();
		 * 
		 * /*TextField txtUsername2 = (TextField)frm.getComponent(3);
		 * System.out.println(txtUsername2.getText());
		 * 
		 * TextField txtUsername3 = (TextField)frm.getComponent(5);
		 * System.out.println(txtUsername3.getText());
		 */

		/*
		 * if (frm.getForm().isValid()) {
		 * 
		 * DatabaseServiceAsync service = DatabaseService.Util .getInstance();
	//	// * Map formData = getFormDataAsMap(frm.getForm());
		 * 
		 * service.saveData(formData, callback);
		 * 
		 * MessageBox.show(new MessageBoxConfig() { { setMsg("正在保存, 请等待...");
		 * setProgressText("保存中..."); setWidth(300); setWait(true);
		 * setWaitConfig(new WaitConfig() { { setInterval(200); } });
		 * setAnimEl(button.getId());
		 * 
		 * Timer timer = new Timer() { public void run() { MessageBox.hide(); //
		 * System.out.println("Done, Your fake data // was saved!"); } };
		 * timer.schedule(8000); } }); } else {
		 * 
		 * MessageBox.alert("输入有误", "请重新输入!"); }
		 *  }
		 * 
		 * });
		 * 
		 * Button btCancel = new Button("取消"); btCancel.addListener(new
		 * ButtonListenerAdapter() { public void onClick(final Button button,
		 * EventObject e) { MessageBox.alert("取消", "重新输入"); }
		 * 
		 * });
		 * 
		 * Button btAdd = new Button("添加", new ButtonListenerAdapter() { public
		 * void onClick(Button button, EventObject e) {
		 * 
		 * final ExtElement element = Ext.get("main-panel"); window.show();
		 * 
		 * element.mask();
		 * 
		 * 
		 * 
		 * 
		 * window.addListener(new PanelListenerAdapter(){
		 * 
		 * public void onClose(Panel panel){
		 * 
		 * element.unmask(); } }); }
		 * 
		 * });
		 * 
		 * window.setAnimateTarget(btAdd.getId()); buttonPanel.add(btSave);
		 * buttonPanel.add(btCancel); frm.add(buttonPanel); window.add(frm);
		 */
		centerPanel.doLayout();
		panel.add(borderPanel);

		Viewport viewPort = new Viewport(panel);

		// navPanel1.getEl().mask("jessiena");
		westPanel.getEl().mask("请您先登陆！");
		panel.getEl().mask("数据加载中，请稍后……");

	}

}
