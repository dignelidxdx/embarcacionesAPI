package ar.com.noaa.api.embarcaciones.models.response;

import java.io.Serializable;

public class GenericResponse  implements Serializable {

    public boolean isOk;
    public String message;
    public Integer id;  
    
    private static final long serialVersionUID = -3642310382243888892L;
	  
    public GenericResponse(boolean isOk, String message, Integer id){
        
        this.isOk = true;
        this.message = message;
        this.id = id;
    }



    
}