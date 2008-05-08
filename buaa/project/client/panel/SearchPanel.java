package com.buaa.project.client.panel;

 
import com.google.gwt.user.client.Window;   
 
import com.gwtext.client.core.JsObject;
import com.gwtext.client.data.*;   
import com.gwtext.client.util.Format;   
import com.gwtext.client.widgets.Panel;   
import com.gwtext.client.widgets.form.ComboBox;   
import com.gwtext.client.widgets.form.FormPanel;   
import com.gwtext.client.widgets.form.event.ComboBoxListenerAdapter; 

public class SearchPanel extends Panel{
	
	public SearchPanel(){
		
		
		  
	       this.setBorder(false);   
	       this.setPaddings(15);   
	  
	        //Use a ScriptTagProxy because you are getting data from a different domain using   
	        //a Json web service. If getting data from your own domain, then should use HttpProxy   
	        DataProxy dataProxy = new ScriptTagProxy("http://extjs.com/forum/topics-remote.php");   
	  
	        RecordDef recordDef = new RecordDef(new FieldDef[]{   
	                new StringFieldDef("title", "topic_title"),   
	                new StringFieldDef("topicId", "topic_id"),   
	                new StringFieldDef("author", "author"),   
	                new DateFieldDef("lastPost", "post_time", "timestamp"),   
	                new StringFieldDef("excerpt", "post_text")   
	        });   
	  
	        JsonReader reader = new JsonReader(recordDef);   
	        reader.setRoot("topics");   
	        reader.setTotalProperty("totalCount");   
	        reader.setId("post_id");   
	  
	        final Store store = new Store(dataProxy, reader);   
	        store.load();   
	  
	        final String resultTpl = "<div class=\"search-item\"><h3><span>{lastPost:date(\"M j, Y\")}"  
	                                +  "<br/>by {author}</span>{title}</h3>{excerpt}</div>";   
	  
	        ComboBox cb = new ComboBox();   
	        cb.setStore(store);   
	        cb.setDisplayField("title");   
	        cb.setTypeAhead(false);   
	        cb.setLoadingText("搜索中...");   
	        cb.setWidth(440);   
	        cb.setPageSize(10);   
	        cb.setHideTrigger(true);   
	        cb.setTpl(resultTpl);   
	        cb.setMode(ComboBox.REMOTE);   
	        cb.setTitle("搜索");   
	        cb.setHideLabel(true);   
	        cb.setItemSelector("div.search-item");   
	  
	        cb.addListener(new ComboBoxListenerAdapter() {   
	            public void onSelect(ComboBox comboBox, Record record, int index) {   
	                String[] args = new String[]{record.getAsString("topicId"), record.getId()};   
	                String url = Format.format("http://localhost:8888/com.buaa.project.LoginTest/LoginTest.html",   
	                                            args);   
	                Window.open(url, "forum", "");   
	            }   
	        });   
	  
	        Panel searchPanel = new Panel();   
	        searchPanel.setWidth(490);   
	        searchPanel.setHeight(150);   
	        searchPanel.setPaddings(20);   
	        searchPanel.setTitle("搜索……");   
	        searchPanel.setFrame(true);   
	  
	        FormPanel form = new FormPanel();   
	        form.setBorder(false);   
	        form.add(cb);   
	        searchPanel.add(form);   
	  
	        Panel instructionPanel = new Panel();   
	        instructionPanel.setBorder(false);   
	        instructionPanel.setPaddings(4, 0, 0, 0);   
	        instructionPanel.setHtml("最少输入四个关键字！");   
	        searchPanel.add(instructionPanel);   
	        this.add(searchPanel);   

		
	}

}
