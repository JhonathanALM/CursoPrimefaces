package ec.edu.espe.ad.controller;

import ec.edu.espe.ad.ejb.CategoriaFacadeLocal;
import ec.edu.espe.ad.model.Categoria;
import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.view.ViewScoped;
import javax.inject.Named;


/**
 * @author jhona
 */
@Named
@ViewScoped
public class CategoriaController implements Serializable {
    @EJB
    private CategoriaFacadeLocal categoriaEJB;
    private Categoria categoria;
    
    @PostConstruct
    public void init(){
        categoria = new Categoria();
    }
    
    public void registrar(){
        try{
            categoriaEJB.create(categoria);
        }catch(Exception e){
            
        }
        
    }
    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

}
