package com.buaa.project.client.panel;

import com.gwtext.client.widgets.Window;
import com.gwtext.client.widgets.form.FormPanel;
import com.gwtext.client.widgets.form.TextField;

public class Fileupload extends Window{
	
	public Fileupload(){
		
		this.setTitle("数据导入");
		   this.setResizable(true);
		   this.setDraggable(true);
		   this.setWidth(400);
		   this.setHeight(30);
		
		
		FormPanel file = new FormPanel();
		file.setFrame(true);
		file.setFileUpload(true);
		
		TextField txtFile = new TextField("文件导入");
		txtFile.setInputType("file");
		
		
		file.add(txtFile);
		this.add(file);
		
	}

}
