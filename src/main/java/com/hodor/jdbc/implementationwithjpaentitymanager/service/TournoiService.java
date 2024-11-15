package com.hodor.jdbc.implementationwithjpaentitymanager.service;

import com.hodor.jdbc.implementationwithjpaentitymanager.EntityManagerHolder;
import com.hodor.jdbc.implementationwithjpaentitymanager.HibernateUtil;
import com.hodor.jdbc.implementationwithjpaentitymanager.dto.TournoiDTO;
import com.hodor.jdbc.implementationwithjpaentitymanager.entity.Tournoi;
import com.hodor.jdbc.implementationwithjpaentitymanager.repository.TournoiRepositoryImpl;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class TournoiService {

    private TournoiRepositoryImpl tournoiRepository;

    public TournoiService() {
        this.tournoiRepository = new TournoiRepositoryImpl();
    }

    public TournoiDTO createTournoi(TournoiDTO dto) {

        EntityManager em = null;
        EntityTransaction tx = null;
        Tournoi tournoi = null;

        try {
            em = EntityManagerHolder.getCurrentEntityManager();
            tx = em.getTransaction();
            tx.begin();
            tournoi = new Tournoi();
            tournoi.setCode(dto.getCode());
            tournoi.setNom(dto.getNom());
            tournoiRepository.create(tournoi);
            tx.commit();
        } catch (Exception e) {
            if (tx != null) {
                tx.rollback();
            }
            e.printStackTrace();
        } finally {
            if (em != null) {
                em.close();
            }
        }
        return dto;
    }

    public TournoiDTO getTournoi(Long id) {
        EntityManager em = null;
        EntityTransaction tx = null;
        Tournoi tournoi = null;
        TournoiDTO dto = null;
        try {
            em = EntityManagerHolder.getCurrentEntityManager();
            tx = em.getTransaction();
            tx.begin();
            tournoi = tournoiRepository.getByID(id);
            dto = new TournoiDTO();
            dto.setNom(tournoi.getNom());
            dto.setId(tournoi.getId());
            dto.setCode(tournoi.getCode());
            System.out.println("Tournoi récupéré: " + dto);
            tx.commit();
        } catch (Exception e) {
            if (tx != null) tx.rollback();
            e.printStackTrace();
        } finally {
            if (em != null) {
                em.close();
            }
        }
        return dto;
    }

    public void deleteTournoi(long id) {
        EntityManager em = null;
        EntityTransaction tx = null;
        try {
            em = EntityManagerHolder.getCurrentEntityManager();
            tx = em.getTransaction();
            tx.begin();
            tournoiRepository.delete(id);
            tx.commit();
        } catch (Exception e) {
            if (tx != null) tx.rollback();
            e.printStackTrace();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }
}
