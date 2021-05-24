
package com.integrador2.serviciosgenerales.entidad;

public class EspeXAct {
    private String idEspecialista;
    private String idActividad;
    private double precioConsulta;
    private String descripcionConsulta;

    public EspeXAct() {
    }
    
    

    /**
     * @return the idEspecialista
     */
    public String getIdEspecialista() {
        return idEspecialista;
    }

    /**
     * @param idEspecialista the idEspecialista to set
     */
    public void setIdEspecialista(String idEspecialista) {
        this.idEspecialista = idEspecialista;
    }

    /**
     * @return the idActividad
     */
    public String getIdActividad() {
        return idActividad;
    }

    /**
     * @param idActividad the idActividad to set
     */
    public void setIdActividad(String idActividad) {
        this.idActividad = idActividad;
    }

    /**
     * @return the precioConsulta
     */
    public double getPrecioConsulta() {
        return precioConsulta;
    }

    /**
     * @param precioConsulta the precioConsulta to set
     */
    public void setPrecioConsulta(double precioConsulta) {
        this.precioConsulta = precioConsulta;
    }

    /**
     * @return the descripcionConsulta
     */
    public String getDescripcionConsulta() {
        return descripcionConsulta;
    }

    /**
     * @param descripcionConsulta the descripcionConsulta to set
     */
    public void setDescripcionConsulta(String descripcionConsulta) {
        this.descripcionConsulta = descripcionConsulta;
    }
    
    
    
}
