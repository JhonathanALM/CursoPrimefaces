package ec.edu.espe.ad.controller;


import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import org.primefaces.model.DualListModel;

/*
 * @author jhona
 */
@ManagedBean
public class AdministradorController {

    private DualListModel<String> cities;
    @PostConstruct
    public void init() {
        //Cities
        List<String> citiesSource = new ArrayList<String>();
        List<String> citiesTarget = new ArrayList<String>();
         
        citiesSource.add("San Francisco");
        citiesSource.add("London");
         
        cities = new DualListModel<String>(citiesSource, citiesTarget);
    
    }
    
    
    public DualListModel<String> getCities() {
        return cities;
    }
 
    public void setCities(DualListModel<String> cities) {
        this.cities = cities;
    }

}
