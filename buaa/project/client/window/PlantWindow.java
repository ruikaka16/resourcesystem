package com.buaa.project.client.window;

import com.gwtext.client.core.Template;
import com.gwtext.client.data.Reader;
import com.gwtext.client.data.SimpleStore;
import com.gwtext.client.data.Store;
import com.gwtext.client.widgets.Button;
import com.gwtext.client.widgets.Panel;
import com.gwtext.client.widgets.ToolTip;
import com.gwtext.client.widgets.Window;
import com.gwtext.client.widgets.form.ComboBox;
import com.gwtext.client.widgets.form.FieldSet;
import com.gwtext.client.widgets.form.TextField;
import com.gwtext.client.widgets.form.event.ComboBoxListenerAdapter;
import com.gwtext.client.widgets.layout.AnchorLayoutData;
import com.gwtext.client.widgets.layout.ColumnLayout;
import com.gwtext.client.widgets.layout.ColumnLayoutData;
import com.gwtext.client.widgets.layout.FormLayout;
import com.gwtext.client.data.Record;  

public class PlantWindow extends Window{
	
   public PlantWindow() {
	   

	   this.setBorder(true);
	   this.setPaddings(10);
	   this.setHeight(600);
	   this.setWidth(800);
	   this.setMaximizable(true);
	   this.setResizable(true);
	   this.setDraggable(true);
	   this.setTitle("植物种质资源");
	   this.setFrame(true);
	   
	   String bodyStyle = "text-align:center;padding:5px 0;" +   
       "border:1px dotted #99bbe8;background:#dfe8f6;" +   
       "color:#15428b;cursor:default;margin:10px;" +   
       "font:bold 11px tahoma,arial,sans-serif;";   

	   
	   FieldSet plantPanel = new FieldSet("植物种质基本信息");
	   plantPanel.setCollapsible(true);
	   plantPanel.setFrame(true);
	   
	   	Panel firstPanel = new Panel();
		firstPanel.setLayout(new ColumnLayout());
		firstPanel.setBorder(false);
		firstPanel.setFrame(true);
		
		Panel firstColumn = new Panel();
		firstColumn.setLayout(new FormLayout());
		firstColumn.setBorder(false);
		
		Panel secondColumn = new Panel();
		secondColumn.setLayout(new FormLayout());
		secondColumn.setBorder(false);
		
		ComboBox cb_1 = new ComboBox("主要特征特性");
		final Store store = new SimpleStore(new String[]{"type", "feature"}, getFeature());
		store.load();  
		cb_1.setAllowBlank(false);
		cb_1.setStore(store);
		cb_1.setSelectOnFocus(true);
		cb_1.setMinChars(1);
		cb_1.setDisplayField("feature"); 
		cb_1.setMode(ComboBox.LOCAL);
		cb_1.setTriggerAction(ComboBox.ALL);
		cb_1.setEmptyText("选择特征类型");
		cb_1.setTypeAhead(true);
		cb_1.setSelectOnFocus(true);
		cb_1.setWidth(100);
		cb_1.setHideTrigger(false);
		
		ComboBox cb_2 = new ComboBox("资源类型");
		final Store store2 = new SimpleStore(new String[]{"id", "type", "nick"}, getType());
		store2.load();  
		cb_2.setAllowBlank(false);
		cb_2.setStore(store2);
		cb_2.setSelectOnFocus(true);
		cb_2.setMinChars(1);
		cb_2.setDisplayField("type"); 
		cb_2.setMode(ComboBox.LOCAL);
		cb_2.setTriggerAction(ComboBox.ALL);
		cb_2.setEmptyText("选择资源类型");
		cb_2.setTypeAhead(true);
		cb_2.setSelectOnFocus(true);
		cb_2.setWidth(100);
		cb_2.setHideTrigger(false);
		
		ComboBox cb_3 = new ComboBox("保存资源类型");
		final Store store3 = new SimpleStore(new String[]{"type", "saveType"}, getSaveType());
		store3.load();  
		cb_3.setAllowBlank(false);
		cb_3.setStore(store3);
		cb_3.setSelectOnFocus(true);
		cb_3.setMinChars(1);
		cb_3.setDisplayField("saveType"); 
		cb_3.setMode(ComboBox.LOCAL);
		cb_3.setTriggerAction(ComboBox.ALL);
		cb_3.setEmptyText("选择资源类型");
		cb_3.setTypeAhead(true);
		cb_3.setSelectOnFocus(true);
		cb_3.setWidth(100);
		cb_3.setHideTrigger(false);
		
		ComboBox cb_4 = new ComboBox("实物状态");
		final Store store4 = new SimpleStore(new String[]{"id", "type"}, getStatus());
		store4.load();  
		cb_4.setAllowBlank(false);
		cb_4.setStore(store4);
		cb_4.setSelectOnFocus(true);
		cb_4.setMinChars(1);
		cb_4.setDisplayField("type"); 
		cb_4.setMode(ComboBox.LOCAL);
		cb_4.setTriggerAction(ComboBox.ALL);
		cb_4.setEmptyText("选择实物状态");
		cb_4.setTypeAhead(true);
		cb_4.setSelectOnFocus(true);
		cb_4.setWidth(100);
		cb_4.setHideTrigger(false);
		
		ComboBox cb_5 = new ComboBox("共享方式");
		final Store store5 = new SimpleStore(new String[]{"type", "share"}, getShareType());
		store5.load();  
		cb_5.setAllowBlank(false);
		cb_5.setStore(store5);
		cb_5.setSelectOnFocus(true);
		cb_5.setMinChars(1);
		cb_5.setDisplayField("share"); 
		cb_5.setMode(ComboBox.LOCAL);
		cb_5.setTriggerAction(ComboBox.ALL);
		cb_5.setEmptyText("选择共享方式");
		cb_5.setTypeAhead(true);
		cb_5.setSelectOnFocus(true);
		cb_5.setWidth(100);
		cb_5.setHideTrigger(false);
		
		
		final Template template = new Template("<div class=\"x-combo-list-item\">" +   
                "<img src=\"image/flags/{cid}.gif\"> " +   
                "{country}<div class=\"x-clear\"></div></div>");   
	
//************************************************************		
		 Object[][] countries = new Object[][]{ 
				 new Object[]{"AU", "澳大利亚"},
				 new Object[]{"BR", "巴西"},
				 new Object[]{"CA", "加拿大"},
				 new Object[]{"CH", "瑞士"},
				 new Object[]{"CN","中国"},
				 new Object[]{"DE", "德国"},
				 new Object[]{"FI", "芬兰"},
				 new Object[]{"FR", "法国"}, 
				 new Object[]{"GH", "加纳"},
				 new Object[]{"IN", "印度"},
				 new Object[]{"IE", "爱尔兰"},
				 new Object[]{"IE", "意大利"},
				 new Object[]{"JP", "日本"},
				 new Object[]{"USA", "美国"}, 
				
		 
	        };   
	  
	        final Store countriesStore = new SimpleStore(new String[]{"cid", "country"}, countries);   
	        countriesStore.load();   
	  
	        //cities store   
	        Object[][] cities = new Object[][]{   
	        		new Object[]{new Integer(1), "CN", "北京市"},  
	        		new Object[]{new Integer(2), "CN", "天津市"},  
	        		new Object[]{new Integer(3), "CN", "重庆市"},  
	        		new Object[]{new Integer(4), "CN", "上海市"},  
	        		new Object[]{new Integer(5), "CN", "河北省"},  
	        		new Object[]{new Integer(6), "CN", "山西省"},
	        		new Object[]{new Integer(7), "CN", "辽宁省"},  
	        		new Object[]{new Integer(8), "CN", "吉林省"},  
	        		new Object[]{new Integer(9), "CN", "黑龙江省"},  
	        		new Object[]{new Integer(10), "CN", "江苏省"},  
	        		new Object[]{new Integer(11), "CN", "浙江省"},  
	        		new Object[]{new Integer(12), "CN", "安徽省"},  
	        		new Object[]{new Integer(13), "CN", "福建省"},  
	        		new Object[]{new Integer(14), "CN", "江西省"},  
	        		new Object[]{new Integer(15), "CN", "山东省"},  
	        		new Object[]{new Integer(16), "CN", "河南省"},  
	        		new Object[]{new Integer(17), "CN", "湖北省"},  
	        		new Object[]{new Integer(18), "CN", "湖南省"},  
	        		new Object[]{new Integer(19), "CN", "广东省"},
	        		new Object[]{new Integer(20), "CN", "海南省"},  
	        		new Object[]{new Integer(21), "CN", "四川省"},  
	        		new Object[]{new Integer(22), "CN", "贵州省"},  
	        		new Object[]{new Integer(23), "CN", "云南省"},  
	        		new Object[]{new Integer(24), "CN", "陕西省"},  
	        		new Object[]{new Integer(25), "CN", "甘肃省"},  
	        		new Object[]{new Integer(26), "CN", "青海省"},  
	        		new Object[]{new Integer(27), "CN", "台湾省"},  
	        		new Object[]{new Integer(28), "CN", "内蒙古自治区"},
	        		new Object[]{new Integer(29), "CN", "广西壮族自治区"},  
	        		new Object[]{new Integer(30), "CN", "宁夏回族自治区"},  
	        		new Object[]{new Integer(31), "CN", "新疆维吾尔自治区"},  
	        		new Object[]{new Integer(32), "CN", "西藏自治区"},  
	        		new Object[]{new Integer(33), "CN", "香港特别行政区"},
	        		new Object[]{new Integer(34), "CN", "澳门特别行政区"},
	        		new Object[]{new Integer(35), "USA", "纽约"},   
	                new Object[]{new Integer(36), "USA", "克利夫兰"},   
	                new Object[]{new Integer(37), "USA", "奥斯丁"},   
	                new Object[]{new Integer(38), "USA", "洛杉矶"},   
	                new Object[]{new Integer(39), "DE", "法兰克福"},   
	                new Object[]{new Integer(40), "FR", "巴黎"},   
	                new Object[]{new Integer(41), "FR", "里昂"},   
	                new Object[]{new Integer(42), "GB", "伦敦"},   
	                new Object[]{new Integer(43), "GB", "曼彻斯特"},   
	                new Object[]{new Integer(44), "GB", "利物浦"}   
	        };   
	  
	        final Store citiesStore = new SimpleStore(new String[]{"id", "cid", "city"}, cities);   
	        citiesStore.load();  
		
		final ComboBox countryCB = new ComboBox();   
        countryCB.setFieldLabel("产国");   
        countryCB.setAllowBlank(false);
        countryCB.setStore(countriesStore);   
        countryCB.setDisplayField("country");   
        countryCB.setMode(ComboBox.LOCAL);   
        countryCB.setTriggerAction(ComboBox.ALL);   
        countryCB.setForceSelection(true);   
        countryCB.setValueField("cid");   
        countryCB.setReadOnly(true);  
        countryCB.setResizable(true);
        countryCB.setTpl(template);
        
        

  
        final ComboBox cityCB = new ComboBox();   
        cityCB.setFieldLabel("原产省"); 
        cityCB.setAllowBlank(false);
        cityCB.setStore(citiesStore);   
        cityCB.setDisplayField("city");   
        cityCB.setValueField("id");   
        cityCB.setMode(ComboBox.LOCAL);   
        cityCB.setTriggerAction(ComboBox.ALL);   
        cityCB.setLinked(true);   
        cityCB.setForceSelection(true);   
        cityCB.setReadOnly(true);   

        countryCB.addListener(new ComboBoxListenerAdapter() {   
      	  
            public void onSelect(ComboBox comboBox, Record record, int index) {   
                cityCB.setValue("");   
                citiesStore.filter("cid", comboBox.getValue());   
            }   
        });  
		
		TextField id = new TextField("国家统一编号","id");
		TextField name_chn = new TextField("中文名称","name_chn");
		TextField ke_name = new TextField("科名","ke_name");
		TextField zhong_name = new TextField("种名","zhong_name");
		TextField location = new TextField("产地","location");

		ke_name.setAllowBlank(false);
	    ToolTip tip_ke_name = new ToolTip();   
	    tip_ke_name.setHtml("该项为必添项！该项为必添项该项为必添项该项为必添项该项为必添项该项为必添项该项为必添项该项为必添项该项为必添项该项为必添项");   
	    tip_ke_name.setDismissDelay(15000);   
	    tip_ke_name.setWidth(200); 
	    tip_ke_name.setHeight(200);
	    tip_ke_name.setTrackMouse(true);   
	    tip_ke_name.applyTo(ke_name);
	    tip_ke_name.setBodyStyle(bodyStyle);
		
		firstColumn.add(id,new AnchorLayoutData("80%"));
		firstColumn.add(name_chn,new AnchorLayoutData("80%"));
		firstColumn.add(ke_name,new AnchorLayoutData("80%"));
		firstColumn.add(zhong_name,new AnchorLayoutData("80%"));
		firstColumn.add(countryCB,new AnchorLayoutData("80%"));
		firstColumn.add(location,new AnchorLayoutData("80%"));	
		firstColumn.add(cb_1,new AnchorLayoutData("80%"));
		firstColumn.add(cb_3,new AnchorLayoutData("80%"));
		firstColumn.add(cb_5,new AnchorLayoutData("80%"));
		//firstColumn.add(countryCB,new AnchorLayoutData("80%"));
		
		
		TextField save_id = new TextField("保存单位编号","save_id");
		TextField name_forn=new TextField("外文名称","name_forn");
		TextField name_belong = new TextField("属名","name_belong");
		TextField id_location =new TextField("归属编码","id_location");
		TextField original = new TextField("来源地","original");
		
		save_id.setAllowBlank(false);
		name_belong.setAllowBlank(false);
		id_location.setAllowBlank(false);
		name_forn.setRegex("^[a-zA-Z]*$");
		name_forn.setRegexText("只允许输入字母");
		
		secondColumn.add(save_id,new AnchorLayoutData("80%"));
		secondColumn.add(name_forn,new AnchorLayoutData("80%"));
		secondColumn.add(name_belong,new AnchorLayoutData("80%"));
		secondColumn.add(id_location,new AnchorLayoutData("80%"));
		secondColumn.add(cityCB,new AnchorLayoutData("80%"));
		secondColumn.add(original,new AnchorLayoutData("80%"));
		secondColumn.add(cb_2,new AnchorLayoutData("80%"));
		secondColumn.add(cb_4,new AnchorLayoutData("80%"));
		//secondColumn.add(cityCB,new AnchorLayoutData("80%"));
		
		firstPanel.add(firstColumn, new ColumnLayoutData(0.5));
		firstPanel.add(secondColumn, new ColumnLayoutData(0.5));
		plantPanel.add(firstPanel);
		
		
		this.add(plantPanel);
		Button submit = new Button("提交");
		Button cancel = new Button("关闭");
		
		this.addButton(submit);
		this.addButton(cancel);
		
   }

private  static String[][] getSaveType() {
	// TODO Auto-generated method stub
	return new  String[][]{
			
			new String[]{"A","植株"},
			new String[]{"B","种子"},
			new String[]{"C","种茎"},
			new String[]{"D","块根"},
			new String[]{"E","花粉"},
			new String[]{"F","培养物"},
			new String[]{"G"," DNA"},
			new String[]{"H"," 其他"}
			
	};
	
}

private static String[][]  getType() {
return new  String[][]{
			
			new String[]{"A","野生"},
			new String[]{"B","地方品种"},
			new String[]{"C","选育品种"},
			new String[]{"D","品系"},
			new String[]{"E","遗传材料"},
			new String[]{"F","其他"}
	};
}

private static String[][] getFeature() {
	return new  String[][]{
			
			new String[]{"A","高产"},
			new String[]{"B","优质"},
			new String[]{"C","抗病"},
			new String[]{"D","抗虫"},
			new String[]{"E","抗逆"},
			new String[]{"F","高效"},
			new String[]{"G"," DNA"}
			
	};
	
}

private static String[][] getStatus() {
	return new  String[][]{
			
			new String[]{"A","良好"},
			new String[]{"B","中等"},
			new String[]{"C","较差"},
			new String[]{"D","无实物"}
			
	};
	
}
private static String[][] getShareType() {
	return new  String[][]{
			
			new String[]{"A","公益性共享"},
			new String[]{"B","公益性借用共享"},
			new String[]{"C","合作研究共享"},
			new String[]{"D","知识产权交易性共享"},
			new String[]{"E","资源纯交易性共享"},
			new String[]{"F","资源交换性共享"},
			new String[]{"G"," 收藏地共享"},
			new String[]{"H"," 行政许可性共享"},
			new String[]{"L"," 不共享"}
			
	};
	
}




}
