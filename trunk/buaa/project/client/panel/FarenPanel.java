package com.buaa.project.client.panel;

import com.gwtext.client.core.Position;
import com.gwtext.client.widgets.Panel;
import com.gwtext.client.widgets.form.FormPanel;
import com.gwtext.client.widgets.form.TextField;
import com.gwtext.client.widgets.layout.AnchorLayoutData;
import com.gwtext.client.widgets.layout.ColumnLayout;
import com.gwtext.client.widgets.layout.ColumnLayoutData;
import com.gwtext.client.widgets.layout.FitLayout;
import com.gwtext.client.widgets.layout.FormLayout;
import com.gwtext.client.widgets.layout.RowLayout;
import com.gwtext.client.widgets.layout.RowLayoutData;

public class FarenPanel extends Panel{
	
	public FarenPanel(){
		
	
		this.setBorder(false);
		this.setPaddings(15);
		this.setHeight(400);
		this.setLayout(new FitLayout());
		//this.setTitle("法人单位概况");

		final Panel wrapperPanel = new Panel();
		wrapperPanel.setLayout(new RowLayout());
		wrapperPanel.setBorder(true);
		// wrapperPanel.setBodyStyle("border-style:dotted;border-color:blue;");

		FormPanel formPanel_tn_3121_1 = new FormPanel();
		formPanel_tn_3121_1.setPaddings(5);
		formPanel_tn_3121_1.setFrame(true);
		formPanel_tn_3121_1.setLabelAlign(Position.LEFT);
		formPanel_tn_3121_1.setHeight(300);
		// formPanel_tn_3121.setLayout(new RowLayout());
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

		firstColumn_first.add(new TextField("单位全称", "first"),
				new AnchorLayoutData("80%"));
		firstColumn_first.add(new TextField("上一级主管单位", "company"),
				new AnchorLayoutData("80%"));
		firstColumn_first.add(new TextField("单位通讯地址", "company"),
				new AnchorLayoutData("80%"));
		firstColumn_first.add(new TextField("所在单位地址", "company"),
				new AnchorLayoutData("80%"));
		firstColumn_first.add(new TextField("法人性质", "company"),
				new AnchorLayoutData("80%"));
		firstPanel.add(firstColumn_first, new ColumnLayoutData(0.5));

		firstColumn_sec.add(new TextField("序号", "first"),
				new AnchorLayoutData("80%"));
		secPanel.add(firstColumn_sec, new ColumnLayoutData(0.5));

		firstColumn_third.add(new TextField("序号", "first"),
				new AnchorLayoutData("80%"));
		thirdPanel.add(firstColumn_third, new ColumnLayoutData(0.5));

		Panel secondColumn_first = new Panel();
		secondColumn_first.setLayout(new FormLayout());
		secondColumn_first.setBorder(false);

		Panel secondColumn_sec = new Panel();
		secondColumn_sec.setLayout(new FormLayout());
		secondColumn_sec.setBorder(false);

		Panel secondColumn_third = new Panel();
		secondColumn_third.setLayout(new FormLayout());
		secondColumn_third.setBorder(false);

		secondColumn_first.add(new TextField("组织机构代码", "last"),
				new AnchorLayoutData("80%"));
		secondColumn_first.add(new TextField("行政主管部门", "email"),
				new AnchorLayoutData("80%"));
		secondColumn_first.add(new TextField("邮政编码", "email"),
				new AnchorLayoutData("80%"));
		secondColumn_first.add(new TextField("单位网址", "email"),
				new AnchorLayoutData("80%"));
		secondColumn_first.add(new TextField("单位属性", "email"),
				new AnchorLayoutData("80%"));
		firstPanel.add(secondColumn_first, new ColumnLayoutData(0.5));

		secondColumn_sec.add(new TextField("行业名称", "last"),
				new AnchorLayoutData("80%"));
		secPanel.add(secondColumn_sec, new ColumnLayoutData(0.5));

		secondColumn_third.add(new TextField("学科名称", "last"),
				new AnchorLayoutData("80%"));
		thirdPanel.add(secondColumn_third, new ColumnLayoutData(0.5));

		// add first panel as first column with 50% of the width

		formPanel_tn_3121_1.add(firstPanel);
		formPanel_tn_3121_2.add(secPanel);
		formPanel_tn_3121_3.add(thirdPanel);
		wrapperPanel.add(formPanel_tn_3121_1, new RowLayoutData(160));
		wrapperPanel.add(formPanel_tn_3121_2, new RowLayoutData(60));
		wrapperPanel.add(formPanel_tn_3121_3, new RowLayoutData(60));
		
		this.add(wrapperPanel);
	}

}
