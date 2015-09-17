/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package he1.uci.sessions;


import he1.uci.entities.UEscalaValoracion;
import he1.uci.entities.UOpcionPaciente;
import he1.uci.entities.UUciMenu;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author luis_guanoluiza
 */
@Stateless
public class UEscalaValoracionFacade extends AbstractFacade<UEscalaValoracion> {
    @PersistenceContext(unitName = "EJB_HE1PU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public UEscalaValoracionFacade() {
        super(UEscalaValoracion.class);
    }
    public List<UEscalaValoracion> listEscalaValoracion(UOpcionPaciente opcPaciente, UUciMenu uciMenu) {
        StringBuilder sb = new StringBuilder("select object(o) from UEscalaValoracion o");
        sb.append(" where o.uOpcionPaciente = :opcPaciente AND O.uOpciones.uUciMenu = :uciMenu ORDER BY o.uOpciones.opcOrdinal");
        Query q = em.createQuery(sb.toString());
        q.setParameter("opcPaciente", opcPaciente);
        q.setParameter("uciMenu", uciMenu);
        q.setHint("eclipselink.refresh", true);
        return q.getResultList();
    }
}
