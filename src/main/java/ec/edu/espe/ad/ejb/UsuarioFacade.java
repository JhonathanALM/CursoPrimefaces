package ec.edu.espe.ad.ejb;

import ec.edu.espe.ad.model.Usuario;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 * @author jhona
 */
@Stateless
public class UsuarioFacade extends AbstractFacade<Usuario> implements UsuarioFacadeLocal {

    @PersistenceContext(unitName = "primePU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public UsuarioFacade() {
        super(Usuario.class);
    }
    
    @Override
    public Usuario iniciarSesion(Usuario us){
        Usuario usuario = null;
        String consulta;
        try{
            consulta= "FROM Usuario u WHERE u.usuario =?1 and u.clave =?2";
            Query query = em.createQuery(consulta);
            System.out.println(us.getUsuario()+" ---- "+us.getClave() );
            query.setParameter(1, us.getUsuario());
            query.setParameter(2, us.getClave());
            List<Usuario> lista = query.getResultList();
            
            if(!lista.isEmpty()){
                usuario=lista.get(0);
            }
            
        }catch(Exception e){
            throw e;
        }finally{
            //
        }
        return usuario;
    }
}
