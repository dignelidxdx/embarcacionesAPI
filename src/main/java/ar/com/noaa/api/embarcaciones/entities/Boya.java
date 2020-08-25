package ar.com.noaa.api.embarcaciones.entities;

import javax.persistence.Column;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

import ar.com.noaa.api.embarcaciones.entities.Faro.FaroEnum;

@Entity
@Table(name = "boya")
public class Boya {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "boya_id")
    private Integer boyaId;
    @Column(name = "longitud_instalacion")
    private Double longitudInstalacion;
    @Column(name = "latitud_instalacion")
    private Double latitudInstalacion;
    @Column(name = "id_luz")
    private FaroEnum estadoLuz;

    @OneToMany(mappedBy = "boya", cascade = CascadeType.ALL)
    @LazyCollection(LazyCollectionOption.FALSE)
    private List<Muestra> muestras = new ArrayList<>();

	public Integer getBoyaId() {
		return this.boyaId;
	}

	public void setBoyaId(Integer boyaId) {
		this.boyaId = boyaId;
	}

	public Double getLongitudInstalacion() {
		return this.longitudInstalacion;
	}

	public void setLongitudInstalacion(Double longitudInstalacion) {
		this.longitudInstalacion = longitudInstalacion;
	}

	public Double getLatitudInstalacion() {
		return this.latitudInstalacion;
	}

	public void setLatitudInstalacion(Double latitudInstalacion) {
		this.latitudInstalacion = latitudInstalacion;
	}

	public FaroEnum getEstadoLuz() {
		return this.estadoLuz;
	}

	public void setEstadoLuz(FaroEnum estadoLuz) {
		this.estadoLuz = estadoLuz;
	}

	public List<Muestra> getMuestras() {
		return this.muestras;
	}

	public void setMuestras(List<Muestra> muestras) {
		this.muestras = muestras;
	}
}