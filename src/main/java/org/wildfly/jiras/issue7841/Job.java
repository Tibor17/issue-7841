package org.wildfly.jiras.issue7841;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import java.util.List;

@ApplicationScoped
public class Job implements Runnable {
    private static final Logger LOG = LoggerFactory.getLogger(Job.class.getName());

    @Inject @EM
    private EntityManager em;


    @Override
    public void run() {
        try {
            List results = em.createQuery("select e from MyEntity e")
                    .getResultList();

            LOG.info("Found {} results.", results.size());
        } catch (Exception e) {
            LOG.error(e.getLocalizedMessage(), e);
        }
    }

    @Transactional
    public void persist() {
        try {
            em.persist(new MyEntity());
        } catch (Exception e) {
            LOG.error(e.getLocalizedMessage(), e);
        }
    }
}
