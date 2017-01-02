package org.wildfly.jiras.issue7841;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.inject.Produces;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@ApplicationScoped
public class EntityManagerProducer {
    @PersistenceContext(unitName = "pu")
    private EntityManager em;

    @Produces
    @EM
    @RequestScoped
    public EntityManager createEntityManager() {
        return em;
    }
}
