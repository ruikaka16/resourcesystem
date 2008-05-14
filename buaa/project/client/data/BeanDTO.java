package com.buaa.project.client.data;

import com.google.gwt.user.client.rpc.IsSerializable;


public class BeanDTO implements IsSerializable{

	private String id;
    private String  psw;

    // Setters and Getters

   public Object[] toObjectArray() {
            return new Object[] {
                     id,
                     psw,                
            };
   }
   
  

}

