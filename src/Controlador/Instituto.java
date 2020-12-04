/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.Constantes;
import Modelo.CursoDAO;
import Modelo.InstitutoDAO;
import java.util.ArrayList;

public class Instituto {

    private int idInstituto;
    private int cedJuridica;
    private int codSede;
    private String nombreInstituto;
    private String ubicacionInstituto;

    public Instituto() {
        idInstituto = 0;
        cedJuridica = 0;
        codSede = 0;
        nombreInstituto = "";
        ubicacionInstituto = "";
    }

    public int insertar(int cedJuridica, int codSede, String nombreInstituto, String ubicacionInstituto) {
        InstitutoDAO data = new InstitutoDAO();

        if (data.buscarPorCodSede(codSede) != null) {
            return Constantes.ERROR_GUARDAR_COD_EXISTENTE;
        } else {
            return data.insertar(cedJuridica, codSede, nombreInstituto, ubicacionInstituto);
        }
    }

    public ArrayList<Instituto> ListarTodo() {
        InstitutoDAO datos = new InstitutoDAO();
        ArrayList<Instituto> listado = datos.listarTodo();

        return listado;
    }

    public int consultarPorCodSede(int cod) {
        InstitutoDAO datos = new InstitutoDAO();
        Instituto res = datos.buscarPorCodSede(cod);

        if (res == null) {
            return Constantes.ERROR_CONSULTA_NO_EXISTE;
        } else {
            this.setIdInstituto(res.getIdInstituto());
            this.setCedJuridica(res.getCedJuridica());
            this.setCodSede(res.getCodSede());
            this.setNombreInstituto(res.getNombreInstituto());
            this.setUbicacionInstituto(res.getUbicacionInstituto());

            return Constantes.EXITO;
        }
    }

    public int actualizar(int idInstituto, int cedJuridica, int codSede, String nombreInstituto, String ubicacionInstituto) {
        InstitutoDAO data = new InstitutoDAO();

        if (data.buscarPorId(idInstituto) == null) {
            return Constantes.ERROR_CONSULTA_NO_EXISTE;
        } else {
            return data.actualizar(idInstituto, cedJuridica, codSede, nombreInstituto, ubicacionInstituto);
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
    
    @Override
    public String toString()
    {
        return  this.getNombreInstituto();
    }

    /**
     * @return the cedJuridica
     */
    public int getIdInstituto() {
        return idInstituto;
    }

    /**
     * @param IdInstituto the idInstituto to set
     */
    public void setIdInstituto(int idInstituto) {
        this.idInstituto = idInstituto;
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
