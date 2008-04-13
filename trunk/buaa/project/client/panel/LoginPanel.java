package com.buaa.project.client.panel;


import com.gwtext.client.core.Position;
import com.gwtext.client.widgets.Panel;
import com.gwtext.client.widgets.form.FormPanel;
import com.gwtext.client.widgets.form.TextField;
import com.gwtext.client.widgets.layout.AnchorLayoutData;
import com.gwtext.client.widgets.layout.ColumnLayout;
import com.gwtext.client.widgets.layout.ColumnLayoutData;
import com.gwtext.client.widgets.layout.FormLayout;


public class LoginPanel extends FormPanel{
	
	public LoginPanel(){
		
		//this.setBorder(true);
		this.setWidth(200);
		this.setHeight(160);
		//this.setTitle("身份验证");
		this.setFrame(true);
		//this.setLayout(new ColumnLayout());
		//this.setCollapsible(true);
		//this.setPaddings(15);
		//this.setLabelAlign(Position.LEFT);
		this.setBodyStyle("ext-el-mask-msg");
		this.setVisible(true);
		//this.setBorder(false);
		
	/*	Panel firstColumn_first = new Panel();
		firstColumn_first.setLayout(new FormLayout());
		firstColumn_first.setBorder(false);
		
		Panel firstColumn_sec = new Panel();
		firstColumn_sec.setLayout(new FormLayout());
		firstColumn_sec.setBorder(false);
		
		TextField txtLoginname = new TextField("用户名","txtLoginnaem");
		TextField txtLoginpsw = new TextField("密码","txtLoginpsw");
		
		firstColumn_first.add(txtLoginname,new AnchorLayoutData("80%"));
	    this.add(firstColumn_first, new ColumnLayoutData(0.5));
		
		
		firstColumn_sec.add(txtLoginpsw,new AnchorLayoutData("80%"));
		this.add(firstColumn_sec, new ColumnLayoutData(0.5));*/
		
		TextField txtLoginname = new TextField("用户名","txtLoginnaem",60);
		txtLoginname.setAllowBlank(false);
		this.add(txtLoginname);
		
		TextField txtLoginpsw = new TextField("密码","txtLoginpsw",60);
		txtLoginpsw.setAllowBlank(false);
		this.add(txtLoginpsw);
		
		
	
		
		
	}

}
