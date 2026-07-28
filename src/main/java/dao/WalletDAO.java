package dao;

import java.sql.*;

public class WalletDAO {

    public double getBalance(String email) {
        String sql = "SELECT wallet_balance FROM users WHERE email = ?";
        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, email);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return rs.getDouble("wallet_balance");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    public boolean addMoney(String email, double amount) {
        String sql = "UPDATE users SET wallet_balance = wallet_balance + ? WHERE email = ?";
        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setDouble(1, amount);
            ps.setString(2, email);
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean deductMoney(String email, double amount) {
        String sql = "UPDATE users SET wallet_balance = wallet_balance - ? WHERE email = ? AND wallet_balance >= ?";
        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setDouble(1, amount);
            ps.setString(2, email);
            ps.setDouble(3, amount);
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean transferMoney(String senderEmail, String receiverEmail, double amount) {
        Connection con = null;
        try {
            con = DBConnection.getConnection();
            con.setAutoCommit(false);

            String deductSql = "UPDATE users SET wallet_balance = wallet_balance - ? WHERE email = ? AND wallet_balance >= ?";
            PreparedStatement deductPs = con.prepareStatement(deductSql);
            deductPs.setDouble(1, amount);
            deductPs.setString(2, senderEmail);
            deductPs.setDouble(3, amount);
            int rows = deductPs.executeUpdate();

            if (rows == 0) {
                con.rollback();
                return false;
            }

            String addSql = "UPDATE users SET wallet_balance = wallet_balance + ? WHERE email = ?";
            PreparedStatement addPs = con.prepareStatement(addSql);
            addPs.setDouble(1, amount);
            addPs.setString(2, receiverEmail);
            addPs.executeUpdate();

            con.commit();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            try { if (con != null) con.rollback(); } catch (SQLException ex) { ex.printStackTrace(); }
            return false;
        } finally {
            try { if (con != null) { con.setAutoCommit(true); con.close(); } } catch (SQLException e) { e.printStackTrace(); }
        }
    }
}
