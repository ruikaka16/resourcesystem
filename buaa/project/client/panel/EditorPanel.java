package com.buaa.project.client.panel;


import com.gwtext.client.widgets.Panel;
import com.gwtext.client.widgets.form.HtmlEditor;

public class EditorPanel extends Panel{

	public EditorPanel (){
		
		this.setClosable(true);
		HtmlEditor  htmlEditor = new HtmlEditor("文件发布","docSubmit");
		htmlEditor.setTitle("文件发布");
		htmlEditor.setWidth(624);
		htmlEditor.setHeight(350);
		this.setTitle("文件发布");
		this.add(htmlEditor);
	}
}
