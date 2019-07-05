package ec.edu.espe.ad.controller;

import ec.edu.espe.ad.model.Usuario;
import java.io.Serializable;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

/**
 * @author jhona
 */
@Named
@ViewScoped
public class PlantillaController implements Serializable{

    public void verificarSesion (){
        try {
            FacesContext context = FacesContext.getCurrentInstance();
            Usuario us = (Usuario) context.getExternalContext().getSessionMap().get("usuario");
            if (us == null) {
                context.getExternalContext().redirect("./../permisos.xhtml");

            }
        } catch (Exception e) {
            //implementaciones para guardar regitrso de un error
        }

    }

}
