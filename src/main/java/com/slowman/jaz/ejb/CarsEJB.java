
package com.slowman.jaz.ejb;

import com.slowman.jaz.domain.Car;
import java.util.List;
import javax.ejb.Stateful;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateful
@Named
public class CarsEJB {
    
    @PersistenceContext(unitName = "com.slowman.jaz_Slowman_war_1.0.0-SNAPSHOTPU")
    private EntityManager em;
    
    public void delete(Car car) {
        car = em.merge(car);
        em.remove(car);
    }
 
    public void update(Car car) {
        em.merge(car);
    }
    
     public List<Car> getAll() {
        return em.createQuery("select car from Car car").getResultList();
    }
}
