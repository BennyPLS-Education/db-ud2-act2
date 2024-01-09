import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Main {
    private static final String FIRST_STMT = "INSERT INTO EMP VALUES (7499, 'Ximenes', 'IT', 7839, '2023-10-21', 500000, 34000, 20)";
    private static final String SECOND_STMT = "INSERT INTO EMP VALUES (1, null, 'IT', 7839, '2023-10-21', 500000, 34000, 20)";
    private static final String THIRD_STMT = "INSERT INTO EMP VALUES (1, 'Ximenes', null, 7839, '2023-10-21', 500000, 34000, 20)";
    private static final String FOURTH_STMT = "INSERT INTO EMP VALUES (1, 'Ximenes', 'IT', 10, '2023-10-21', 500000, 34000, 20)";
    private static final String FIFTH_STMT = "INSERT INTO EMP VALUES (1, 'Ximenes', 'IT', 7839, '2023-10-21', -100, 34000, 20)";
    private static final String SIXTH_STMT = "INSERT INTO EMP VALUES (1, 'Ximenes', 'IT', 7839, '2023-10-21', 500000, -10, 20)";
    private static final String SEVENTH_STMT = "INSERT INTO EMP VALUES (1, 'Ximenes', 'IT', 7839, '2023-10-21', 500000, 34000, 3)";
    private static final String EIGHTH_STMT = "INSERT INTO EMP VALUES (1, 'Ximenes', 'IT', 7839, '2023-10-21', 500000, 34000, 20)";

    public static void main(String[] args) {
        executeStatement("DELETE FROM EMP WHERE EMP_NO = 1");

        executeStatement(FIRST_STMT);
        executeStatement(SECOND_STMT);
        executeStatement(THIRD_STMT);
        executeStatement(FOURTH_STMT);
        executeStatement(FIFTH_STMT);
        executeStatement(SIXTH_STMT);
        executeStatement(SEVENTH_STMT);
        executeStatement(EIGHTH_STMT);
    }

    private static void executeStatement(String sql) {
        System.out.println(sql);

        try (var stmt = getConnection().createStatement()) {
            stmt.executeUpdate(sql);
            System.out.println("A la fi! Empleat inserit correctament");
        } catch (SQLException e) {

        }

        System.out.println();
    }

    private static String getValueBetween(String message, char ch) {
        var valStart = message.indexOf(ch);
        var valEnd = message.indexOf(ch, ++valStart);

        return message.substring(valStart, valEnd);
    }

    private static Connection getConnection() throws SQLException {
        return DriverManager.getConnection("jdbc:mysql://localhost:3306/empresa", "root", "CalaClara21.");
    }
}
