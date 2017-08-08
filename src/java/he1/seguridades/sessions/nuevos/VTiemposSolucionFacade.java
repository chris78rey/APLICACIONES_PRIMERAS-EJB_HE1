/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package he1.seguridades.sessions.nuevos;

import he1.seguridades.entities.nuevos.VTiemposSolucion;
import he1.seguridades.entities.nuevos.VTiemposSolucion_;
import he1.sis.entities.Personal;
import he1.sis.entities.Personal_;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

/**
 *
 * @author christian_ruiz
 */
@Stateless
public class VTiemposSolucionFacade extends AbstractFacade<VTiemposSolucion> {

    @PersistenceContext(unitName = "EJB_HE1PU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public VTiemposSolucionFacade() {
        super(VTiemposSolucion.class);
    }

    public List<VTiemposSolucion> findTiemposSolucion(String par) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<VTiemposSolucion> cq = cb.createQuery(VTiemposSolucion.class);
        Root<VTiemposSolucion> root = cq.from(VTiemposSolucion.class);
        List<Predicate> predicatesOR = new ArrayList<>();
          predicatesOR.add(cb.like(root.get(VTiemposSolucion_.area), "%" + par.toUpperCase() + "%"));        
        cq.where(cb.or(predicatesOR.toArray(new Predicate[predicatesOR.size()])));
        List resultList = em.createQuery(cq).setMaxResults(20).setHint("eclipselink.refresh", "true").getResultList();
        return resultList;
    }

}
