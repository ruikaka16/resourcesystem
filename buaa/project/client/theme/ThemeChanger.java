package com.buaa.project.client.theme;

import com.gwtext.client.data.SimpleStore;
import com.gwtext.client.data.Store;
import com.gwtext.client.data.Record;
import com.gwtext.client.util.CSS;
import com.gwtext.client.widgets.form.ComboBox;
import com.gwtext.client.widgets.form.event.ComboBoxListenerAdapter;


public class ThemeChanger extends ComboBox{
	
	public ThemeChanger() {

	      final Store store = new SimpleStore(new String[]{"theme", "label"}, new Object[][]{
	                new Object[]{"themes/green/css/xtheme-green.css", "Green"},
	                new Object[]{"themes/slate/css/xtheme-slate.css", "Slate"},
	            new Object[]{"js/ext/resources/css/xtheme-gray.css", "Gray"},
	            new Object[]{"xtheme-default.css", "Aero Glass"},
	            new Object[]{"themes/indigo/css/xtheme-indigo.css", "Indigo"},
	            new Object[]{"themes/silverCherry/css/xtheme-silverCherry.css", "Silver Cherry"}
	      });

	      store.load();

	      setFieldLabel("Select Theme");
	      setEditable(false);
	      setStore(store);
	      setDisplayField("label");
	      setForceSelection(true);
	      setTriggerAction(ComboBox.ALL);
	      setValue("Green");
	      setFieldLabel("Switch theme");
	      addListener(new ComboBoxListenerAdapter() {
	         public void onSelect(ComboBox comboBox, Record record, int index) {
	            String theme = record.getAsString("theme");
	            CSS.swapStyleSheet("theme", theme);
	         }
	      });
	      setWidth(100);
	   }


}
