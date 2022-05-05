import javax.swing.plaf.nimbus.State;
import javax.xml.crypto.Data;
import javax.xml.transform.Result;
import java.sql.*;

public class ContinentDAO {
    public void create(String name) throws SQLException {
        Connection con = Database.getConnection();
        try (PreparedStatement pstmt = con.prepareStatement(
                "insert into continents (name) values (?)")) {
            pstmt.setString(1, name);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Couldn't create");
        }
    }

    public Integer findByName(String name) throws SQLException {
        Connection con = Database.getConnection();

        StringBuilder nameAppended = new StringBuilder();
        nameAppended.append("'").append(name).append("'");

        ResultSet rs = null;
        try {
            Statement stmt = con.createStatement();
            rs = stmt.executeQuery(
                    "select id from continents where name='" + name + "'");
        } catch (SQLException e) {
            System.out.println("Couldn't find continent by name");
        }
        assert rs != null;
        return rs.next() ? rs.getInt(1) : null;

    }

    public String findById(int id) throws SQLException {
        Connection con = Database.getConnection();

        StringBuilder nameAppended = new StringBuilder();
        nameAppended.append("'").append(id).append("'");

        ResultSet rs = null;

        try {
            Statement stmt = con.createStatement();
            rs = stmt.executeQuery(
                    "select name from continents where id ='" + id + "'");
        } catch (SQLException e) {
            System.out.println("Couldn't find continent by id");
        }
        assert rs != null;
        return rs.next() ? rs.getString(1) : null;
    }
}