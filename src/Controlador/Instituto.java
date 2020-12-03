/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.Constantes;
import Modelo.InstitutoDAO;

public class Instituto {

    private int cedJuridica;
    private int codSede;
    private String nombreInstituto;
    private String ubicacionInstituto;

    public Instituto() {
        cedJuridica = 0;
        codSede = 0;
        nombreInstituto = "";
        ubicacionInstituto = "";
    }
    
     public int insertar(int cedJuridica, String nombreInstituto, String ubicacionInstituto) {
        InstitutoDAO data = new InstitutoDAO();

        if (data.buscarPorNombreInstituto(nombreInstituto) != null) {
            return Constantes.ERROR_GUARDAR_COD_EXISTENTE;
        } else {
            return data.insertar(cedJuridica, nombreInstituto, ubicacionInstituto);
        }
    }

    public int actualizar(int cedJuridica, int codSede, String nombreInstituto, String ubicacionInstituto) {
        InstitutoDAO data = new InstitutoDAO();

        if (data.buscarPorNombreInstituto(nombreInstituto) == null) {
            return Constantes.ERROR_CONSULTA_NO_EXISTE;
        } else {
            return data.actualizar(cedJuridica, codSede, nombreInstituto, ubicacionInstituto);
        }
    }

    public int eliminar(int cod) {
        InstitutoDAO data = new InstitutoDAO();

        if (data.buscarPorCodSede(cod) == null) {
            return Constantes.ERROR_CONSULTA_NO_EXISTE;
        } else {
            return data.eliminar(cod);
        }
    }

    

    /**
     * @return the cedJuridica
     */
    public int getCedJuridica() {
        return cedJuridica;
    }

    /**
     * @param cedJuridica the cedJuridica to set
     */
    public void setCedJuridica(int cedJuridica) {
        this.cedJuridica = cedJuridica;
    }

    /**
     * @return the codSede
     */
    public int getCodSede() {
        return codSede;
    }

    /**
     * @param codSede the codSede to set
     */
    public void setCodSede(int codSede) {
        this.codSede = codSede;
    }

    /**
     * @return the nombreInstituto
     */
    public String getNombreInstituto() {
        return nombreInstituto;
    }

    /**
     * @param nombreInstituto the nombreInstituto to set
     */
    public void setNombreInstituto(String nombreInstituto) {
        this.nombreInstituto = nombreInstituto;
    }

    /**
     * @return the ubicacionInstituto
     */
    public String getUbicacionInstituto() {
        return ubicacionInstituto;
    }

    /**
     * @param ubicacionInstituto the ubicacionInstituto to set
     */
    public void setUbicacionInstituto(String ubicacionInstituto) {
        this.ubicacionInstituto = ubicacionInstituto;
    }

}
