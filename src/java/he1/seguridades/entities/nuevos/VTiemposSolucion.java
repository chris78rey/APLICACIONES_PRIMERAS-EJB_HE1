/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package he1.seguridades.entities.nuevos;

import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author christian_ruiz
 */
@Entity
@Table(name = "V_TIEMPOS_SOLUCION")
public class VTiemposSolucion implements Serializable {

    private static final long serialVersionUID = 1L;

    public VTiemposSolucion() {
    }
    @Column(name = "ID")
    @Id
    @Basic(optional = false)
    private BigDecimal id;

    @Column(name = "ANIO")
    @Basic(optional = true)
    private String anio;

    @Column(name = "AREA")
    @Basic(optional = true)
    private String area;

    @Column(name = "INCIDENTES")
    @Basic(optional = true)
    private String incidentes;

    @Column(name = "TIEMPO_MEDIO_SOLUCION")
    @Basic(optional = true)
    private String tiempoMedioSolucion;

    public void setTiempoMedioSolucion(String tiempoMedioSolucion) {
        this.tiempoMedioSolucion = tiempoMedioSolucion;
    }

    public String getTiempoMedioSolucion() {
        return this.tiempoMedioSolucion;
    }

    public void setIncidentes(String incidentes) {
        this.incidentes = incidentes;
    }

    public String getIncidentes() {
        return this.incidentes;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getArea() {
        return this.area;
    }

    public void setId(BigDecimal id) {
        this.id = id;
    }

    public BigDecimal getId() {
        return this.id;
    }

    public void setAnio(String anio) {
        this.anio = anio;
    }

    public String getAnio() {
        return this.anio;
    }

}
