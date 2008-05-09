package com.buaa.project.client.panel;


import com.gwtext.client.core.EventObject;
import com.gwtext.client.util.Format;
import com.gwtext.client.widgets.Button;
import com.gwtext.client.widgets.MessageBox;
import com.gwtext.client.widgets.Panel;
import com.gwtext.client.widgets.event.ButtonListenerAdapter;
import com.gwtext.client.widgets.form.HtmlEditor;

public class EditorPanel extends Panel{

	public EditorPanel (){
		
		this.setClosable(true);
		final HtmlEditor  htmlEditor = new HtmlEditor("文件发布","docSubmit");
		htmlEditor.setTitle("文件发布");
		htmlEditor.setWidth(624);
		htmlEditor.setHeight(350);
		htmlEditor.getFieldLabel();
		
		

		
		Button bt = new Button("提交");
		bt.addListener(new ButtonListenerAdapter(){
			
			public void onClick(Button button,EventObject e){
				final String rawData = Format.stripTags(htmlEditor.getRawValue());
			//MessageBox.alert(rawData);
			//	System.out.println(rawData);
			}
		});
		
		
		this.setTitle("文件发布");
		this.add(htmlEditor);
		this.add(bt);
	}
}
