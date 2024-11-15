package com.hodor.jdbc.implementationwithjpaentitymanager.dao;

import com.hodor.jdbc.implementationwithjpaentitymanager.DataSourceProvider;
import com.hodor.jdbc.implementationwithjpaentitymanager.entity.Match;

import java.sql.*;

public class MatchDAO {

    public Match createMatchWithScore(Match match) {
        Connection con = null;
        try {
            con.setAutoCommit(false);
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

            PreparedStatement ps2 = con.prepareStatement("""
                                        INSERT INTO SCORE_VAINQUEUR (ID_MATCH,SET_1,SET_2,SET_3,SET_4,SET_5)
                                        VALUES (?,?,?,?,?,?)
                    """, PreparedStatement.RETURN_GENERATED_KEYS);

            ps.setLong(1, match.getScore().getMatch().getId());
            ps.setByte(2, match.getScore().getSet1());
            ps.setByte(3, match.getScore().getSet2());
            ps.setByte(4, match.getScore().getSet3());

            if (match.getScore().getSet4() == null) {
                ps2.setNull(5, Types.TINYINT);
            } else {
                ps2.setByte(5, match.getScore().getSet4());
            }

            if (match.getScore().getSet5() == null) {
                ps2.setNull(6, Types.TINYINT);
            } else {
                ps2.setByte(6, match.getScore().getSet5());
            }
            ps.executeUpdate();
            ResultSet rs2 = ps.getGeneratedKeys();

            if (rs2.next()) {
                match.getScore().setId(rs2.getLong(1));
            }

            ps2.close();

            System.out.println("Score créé: " + match.getScore());
            con.commit();
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
}
