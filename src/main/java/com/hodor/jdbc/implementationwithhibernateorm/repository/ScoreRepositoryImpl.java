package com.hodor.jdbc.implementationwithhibernateorm.repository;

import com.hodor.jdbc.implementationwithhibernateorm.DataSourceProvider;
import com.hodor.jdbc.implementationwithhibernateorm.entity.Score;

import java.sql.*;

public class ScoreRepositoryImpl {

    public Score create(Score score) {
        Connection con = null;
        try {
            con = DataSourceProvider.getInstance().getConnection();

            PreparedStatement ps = con.prepareStatement("""
                                        INSERT INTO SCORE_VAINQUEUR (ID_MATCH,SET_1,SET_2,SET_3,SET_4,SET_5)
                                        VALUES (?,?,?,?,?,?)
                    """, PreparedStatement.RETURN_GENERATED_KEYS);

            ps.setLong(1, score.getMatch().getId());
            ps.setByte(2, score.getSet1());
            ps.setByte(3, score.getSet2());
            ps.setByte(4, score.getSet3());

            if (score.getSet4() == null) {
                ps.setNull(5, Types.TINYINT);
            } else {
                ps.setByte(5, score.getSet4());
            }

            if (score.getSet5() == null) {
                ps.setNull(6, Types.TINYINT);
            } else {
                ps.setByte(6, score.getSet5());
            }
            ps.executeUpdate();
            ResultSet rs = ps.getGeneratedKeys();

            if (rs.next()) {
                score.setId(rs.getLong(1));
            }

            ps.close();

            System.out.println("Score créé: " + score);

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
        return score;
    }

}
