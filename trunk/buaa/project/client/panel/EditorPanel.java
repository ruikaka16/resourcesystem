package com.buaa.project.client.panel;




import com.buaa.project.client.DatabaseService;
import com.buaa.project.client.DatabaseServiceAsync;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.gwtext.client.core.EventObject;
import com.gwtext.client.util.Format;
import com.gwtext.client.widgets.Button;
import com.gwtext.client.widgets.Component;
import com.gwtext.client.widgets.DatePicker;
import com.gwtext.client.widgets.MessageBox;
import com.gwtext.client.widgets.Panel;
import com.gwtext.client.widgets.event.ButtonListenerAdapter;
import com.gwtext.client.widgets.form.DateField;
import com.gwtext.client.widgets.form.Field;
import com.gwtext.client.widgets.form.FieldSet;
import com.gwtext.client.widgets.form.FormPanel;
import com.gwtext.client.widgets.form.HtmlEditor;
import com.gwtext.client.widgets.form.TextField;
import com.gwtext.client.widgets.form.event.TextFieldListenerAdapter;

public class EditorPanel extends Panel{

	public EditorPanel (){
		
		this.setClosable(true);
		this.setTitle("文件发布");
		this.setFrame(true);
		
		FieldSet fieldSet1 = new FieldSet("新闻信息");
		fieldSet1.setCollapsible(true);
		final TextField N_TITLE = new TextField("新闻标题","N_TITLE",200);
		N_TITLE.setAllowBlank(false);
		final TextField N_AUTHOR = new TextField("发布单位","N_AUTHOR",200);
		N_AUTHOR.setAllowBlank(false);
		
		final DateField N_TIME = new DateField("发布时间","N_TIME",200);
		N_TIME.setFormat("y.m.d");
		final DatePicker datePicker = new DatePicker();
		N_TIME.addListener(new TextFieldListenerAdapter() {
					public void onEnable(Component component) {
						datePicker.show();
					}
				});
		fieldSet1.add(N_TITLE);
		fieldSet1.add(N_AUTHOR);
		fieldSet1.add(N_TIME);
		
		
		
		final HtmlEditor htmlEditor = new HtmlEditor();
		htmlEditor.setTitle("文件发布");
		htmlEditor.setWidth(552);
		htmlEditor.setHeight(350);
		htmlEditor.getFieldLabel();
		


		
		Button bt = new Button("提交");
		bt.addListener(new ButtonListenerAdapter(){
			
			public void onClick(Button button,EventObject e){
				final String N_CONTENT =htmlEditor.getRawValue();
				//MessageBox.alert(N_CONTENT);
				System.out.println(N_CONTENT);
				 
				DatabaseServiceAsync service = DatabaseService.Util
					.getInstance();
				 
				 AsyncCallback cb_addNews = new AsyncCallback() {

					public void onFailure(Throwable arg0) {
						// TODO Auto-generated method stub
						
					}

					public void onSuccess(Object result) {
						Boolean ok = (Boolean) result;
						if (ok.booleanValue()) {
							
							MessageBox.alert("保存成功!");
							N_TITLE.setValue("");
							N_AUTHOR.setValue("");
							htmlEditor.setValue("");
							N_TIME.setRawValue("");
						}
						else
							MessageBox.alert("失败!");
						
					}
										
				 };
			//	System.out.println(rawData);
				 service.addNews(N_TITLE.getText(), N_AUTHOR.getText(),N_CONTENT, N_TIME.getRawValue(),cb_addNews);
			}
		});
		
		
		this.add(fieldSet1);
		this.add(htmlEditor);
		this.addButton(bt);
	}
}
