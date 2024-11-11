package com.hodor.jdbc.implementationwithhibernateorm.repository;

import com.hodor.jdbc.implementationwithhibernateorm.HibernateUtil;
import com.hodor.jdbc.implementationwithhibernateorm.entity.Epreuve;
import org.hibernate.Session;

public class EpreuveRepositoryImpl {


    public Epreuve getById(Long id) {

        Epreuve epreuve = null;
        Session session = null;

        session = HibernateUtil.getSessionFactory().getCurrentSession();
        epreuve = session.get(Epreuve.class, id);
        System.out.println("Epreuve récupéré: " + epreuve);

        return epreuve;
    }
}
