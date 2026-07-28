package dao;

import model.Transaction;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class TransactionDAO {

    public boolean addTransaction(String senderEmail, String receiverEmail, double amount, String type) {
        String sql = "INSERT INTO transactions (sender_email, receiver_email, amount, type) VALUES (?, ?, ?, ?)";
        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, senderEmail);
            ps.setString(2, receiverEmail);
            ps.setDouble(3, amount);
            ps.setString(4, type);
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public List<Transaction> getTransactionsByUser(String email) {
        List<Transaction> list = new ArrayList<>();
        String sql = "SELECT * FROM transactions WHERE sender_email = ? OR receiver_email = ? ORDER BY date DESC";
        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, email);
            ps.setString(2, email);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Transaction t = new Transaction();
                t.setId(rs.getInt("id"));
                t.setSenderEmail(rs.getString("sender_email"));
                t.setReceiverEmail(rs.getString("receiver_email"));
                t.setAmount(rs.getDouble("amount"));
                t.setType(rs.getString("type"));
                t.setDate(rs.getTimestamp("date"));
                list.add(t);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }
}
