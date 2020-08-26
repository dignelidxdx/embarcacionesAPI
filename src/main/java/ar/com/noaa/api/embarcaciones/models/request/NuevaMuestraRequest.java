package ar.com.noaa.api.embarcaciones.models.request;

import ar.com.noaa.api.embarcaciones.entities.Faro.FaroEnum;

public class NuevaMuestraRequest {
    
    public Double longitudInstalacion;
    public Double latitudInstalacion;
    public FaroEnum estadoLuz;

}