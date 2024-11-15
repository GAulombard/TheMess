package com.hodor.jdbc.implementationwithjpaentitymanager.service;

import com.hodor.jdbc.implementationwithjpaentitymanager.HibernateUtil;
import com.hodor.jdbc.implementationwithjpaentitymanager.dto.EpreuveEagerDTO;
import com.hodor.jdbc.implementationwithjpaentitymanager.dto.EpreuveLazyDTO;
import com.hodor.jdbc.implementationwithjpaentitymanager.dto.JoueurDTO;
import com.hodor.jdbc.implementationwithjpaentitymanager.dto.TournoiDTO;
import com.hodor.jdbc.implementationwithjpaentitymanager.entity.Epreuve;
import com.hodor.jdbc.implementationwithjpaentitymanager.entity.Joueur;
import com.hodor.jdbc.implementationwithjpaentitymanager.repository.EpreuveRepositoryImpl;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class EpreuveService {

    private EpreuveRepositoryImpl epreuveRepository;

    public EpreuveService() {
        this.epreuveRepository = new EpreuveRepositoryImpl();
    }

    public EpreuveEagerDTO getEpreuveDetaille(Long id) {
        Session session = null;
        Transaction tx = null;
        Epreuve epreuve = null;
        EpreuveEagerDTO dto = new EpreuveEagerDTO();
        try {
            session = HibernateUtil.getSessionFactory().getCurrentSession();
            tx = session.beginTransaction();
            epreuve = epreuveRepository.getById(id);
            //Hibernate.initialize(epreuve.getTournoi());

            TournoiDTO tournoiDTO = new TournoiDTO();
            tournoiDTO.setId(epreuve.getTournoi().getId());
            tournoiDTO.setCode(epreuve.getTournoi().getCode());
            tournoiDTO.setNom(epreuve.getTournoi().getNom());

            dto.setTournoi(tournoiDTO);
            dto.setAnnee(epreuve.getAnnee());
            dto.setTypeEpreuve(epreuve.getTypeEpreuve());
            dto.setId(epreuve.getId());
            dto.setParticipants(new HashSet<>());

            for (Joueur joueur : epreuve.getParticipants()) {
                final JoueurDTO joueurDto = new JoueurDTO();
                joueurDto.setId(joueur.getId());
                joueurDto.setNom(joueur.getNom());
                joueurDto.setPrenom(joueur.getPrenom());
                joueurDto.setSexe(joueur.getSexe());
                dto.getParticipants().add(joueurDto);
            }

            tx.commit();
        } catch (Exception e) {
            if (tx != null) tx.rollback();
            e.printStackTrace();
        } finally {
            if (session != null) {
                session.close();
            }
        }
        System.out.println("Epreuve récupéré: " + dto);
        return dto;
    }

    public EpreuveLazyDTO getEpreuveSansTournoi(Long id) {
        Session session = null;
        Transaction tx = null;
        Epreuve epreuve = null;
        EpreuveLazyDTO dto = new EpreuveLazyDTO();
        try {
            session = HibernateUtil.getSessionFactory().getCurrentSession();
            tx = session.beginTransaction();
            epreuve = epreuveRepository.getById(id);

            dto.setAnnee(epreuve.getAnnee());
            dto.setTypeEpreuve(epreuve.getTypeEpreuve());
            dto.setId(epreuve.getId());

            tx.commit();
        } catch (Exception e) {
            if (tx != null) tx.rollback();
            e.printStackTrace();
        } finally {
            if (session != null) {
                session.close();
            }
        }
        System.out.println("Epreuve récupéré: " + dto);
        return dto;
    }

    public List<EpreuveEagerDTO> getListEpreuve(String code) {
        Session session = null;
        Transaction tx = null;
        List<EpreuveEagerDTO> epreuveEagerDTOS = new ArrayList<>();
        try {
            session = HibernateUtil.getSessionFactory().getCurrentSession();
            tx = session.beginTransaction();

            epreuveRepository.list(code).forEach(e -> {
                EpreuveEagerDTO epreuveEagerDTO = new EpreuveEagerDTO();
                epreuveEagerDTO.setId(e.getId());
                epreuveEagerDTO.setAnnee(e.getAnnee());
                epreuveEagerDTO.setTypeEpreuve(e.getTypeEpreuve());

                TournoiDTO tournoiDTO = new TournoiDTO();
                tournoiDTO.setId(e.getTournoi().getId());
                tournoiDTO.setCode(e.getTournoi().getCode());
                tournoiDTO.setNom(e.getTournoi().getNom());

                epreuveEagerDTO.setTournoi(tournoiDTO);

                System.out.println(epreuveEagerDTO);
                epreuveEagerDTOS.add(epreuveEagerDTO);
            });

            tx.commit();
        } catch (Exception e) {
            if (tx != null) tx.rollback();
            e.printStackTrace();
        } finally {
            if (session != null) {
                session.close();
            }
        }
        return epreuveEagerDTOS;
    }
}
