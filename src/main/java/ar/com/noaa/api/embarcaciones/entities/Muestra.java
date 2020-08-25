package ar.com.noaa.api.embarcaciones.entities;

import java.util.Date;

import javax.persistence.*;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
@Table(name = "muestra")
public class Muestra {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "muestra_id")
    private Integer muestraId;
    @Column(name = "horario_muestra")
    private Date horarioMuestra;
    @Column(name = "matricula_embarcacion")
    private String matriculaEmbarcacion;
    private Double longitud;
    private Double latitud;
    @Column(name = "altura_al_nivel_del_mar")
    private Double alturaAlNivelDelMar;

    @ManyToOne
    @JoinColumn(name = "boya_id", referencedColumnName = "boya_id")
    private Boya boya;

	public Integer getMuestraId() {
		return this.muestraId;
	}

	public void setMuestraId(Integer muestraId) {
		this.muestraId = muestraId;
	}

	public Date getHorarioMuestra() {
		return this.horarioMuestra;
	}

	public void setHorarioMuestra(Date horarioMuestra) {
		this.horarioMuestra = horarioMuestra;
	}

	public String getMatriculaEmbarcacion() {
		return this.matriculaEmbarcacion;
	}

	public void setMatriculaEmbarcacion(String matriculaEmbarcacion) {
		this.matriculaEmbarcacion = matriculaEmbarcacion;
	}

	public Double getLongitud() {
		return this.longitud;
	}

	public void setLongitud(Double longitud) {
		this.longitud = longitud;
	}

	public Double getLatitud() {
		return this.latitud;
	}

	public void setLatitud(Double latitud) {
		this.latitud = latitud;
	}

	public Double getAlturaAlNivelDelMar() {
		return this.alturaAlNivelDelMar;
	}

	public void setAlturaAlNivelDelMar(Double alturaAlNivelDelMar) {
		this.alturaAlNivelDelMar = alturaAlNivelDelMar;
	}

	public Boya getBoya() {
		return this.boya;
	}

	public void setBoya(Boya boya) {
        this.boya = boya;
        this.boya.getMuestras().add(this);
	}
   
}