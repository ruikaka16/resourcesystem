package com.buaa.project.client.data;

import com.google.gwt.user.client.rpc.IsSerializable;


public class BeanDTO implements IsSerializable{

	public String N_ID;
	public String N_TITLE;
    public String  N_AUTHOR;
    public String  N_TIME;
    
    public String getN_ID() {
        return this.N_ID;
      }
    
    public String getN_TITLE() {
        return this.N_TITLE;
      }
   

   
    public String getN_TIME() {
        return this.N_TIME;
      }
   
    public String getN_AUTHOR() {
        return this.N_AUTHOR;
      }
   
    public void setN_ID(String N_ID) {
        this.N_ID = N_ID;
      }
    
    public void setN_TITLE(String N_TITLE) {
        this.N_TITLE=N_TITLE;
      }
   
 
    public void setN_AUTHOR(String N_AUTHOR) {
        this.N_AUTHOR=N_AUTHOR;
      }
   
    public void setN_TIME(String N_TIME) {
        this.N_TIME=N_TIME;
      }
  
    public Object[] toObjectArray() {
            return new Object[] {
            		N_ID,
                    N_TITLE,
                    N_AUTHOR,
                    N_TIME
            };
   } 
}

