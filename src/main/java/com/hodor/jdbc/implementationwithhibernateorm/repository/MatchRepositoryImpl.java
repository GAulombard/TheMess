package com.hodor.jdbc.implementationwithhibernateorm.repository;

import com.hodor.jdbc.implementationwithhibernateorm.DataSourceProvider;
import com.hodor.jdbc.implementationwithhibernateorm.HibernateUtil;
import com.hodor.jdbc.implementationwithhibernateorm.dto.EpreuveEagerDTO;
import com.hodor.jdbc.implementationwithhibernateorm.dto.JoueurDTO;
import com.hodor.jdbc.implementationwithhibernateorm.dto.MatchDTO;
import com.hodor.jdbc.implementationwithhibernateorm.dto.TournoiDTO;
import com.hodor.jdbc.implementationwithhibernateorm.entity.Match;
import com.hodor.jdbc.implementationwithhibernateorm.entity.Tournoi;
import org.hibernate.Session;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class MatchRepositoryImpl {

    public Match create(Match match) {
        Connection con = null;
        try {
            con = DataSourceProvider.getInstance().getConnection();

            PreparedStatement ps = con.prepareStatement("""
                                        INSERT INTO MATCH_TENNIS (ID_EPREUVE,ID_VAINQUEUR,ID_FINALISTE)
                                        VALUES (?,?,?)
                    """, PreparedStatement.RETURN_GENERATED_KEYS);

            ps.setLong(1, match.getEpreuve().getId());
            ps.setLong(2, match.getVainqueur().getId());
            ps.setLong(3, match.getFinaliste().getId());
            ps.executeUpdate();
            ResultSet rs = ps.getGeneratedKeys();

            if (rs.next()) {
                match.setId(rs.getLong(1));
            }

            ps.close();

            System.out.println("Match créé: " + match);

        } catch (SQLException e) {
            e.printStackTrace();
            try {
                con.rollback();
            } catch (SQLException ex) {
                throw new RuntimeException(ex);
            }
        } finally {
            if (con != null) {
                try {
                    con.close();
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
            }
        }
        return match;
    }

    public Match getById(Long id) {
        Match match = null;
        Session session = null;

        session = HibernateUtil.getSessionFactory().getCurrentSession();
        match = session.get(Match.class, id);

        return match;
    }
}
