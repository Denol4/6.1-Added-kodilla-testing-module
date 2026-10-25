import com.kodilla.jdbc.DbManager;
import org.junit.jupiter.api.Test;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DbManagerTestSuite {

    @Test
    public void testSelectUsersAndPosts() throws SQLException {
        // Given
        DbManager dbManager = DbManager.getInstance();

        String sqlQuery = "SELECT U.FIRSTNAME, U.LASTNAME " +
                "FROM USERS U " +
                "JOIN POSTS P ON U.ID = P.USER_ID " +
                "GROUP BY U.ID, U.FIRSTNAME, U.LASTNAME " +
                "HAVING COUNT(P.ID) >= 2";

        Statement statement = dbManager.getConnection().createStatement();
        ResultSet resultSet = statement.executeQuery(sqlQuery);

        int counter = 0;
        while (resultSet.next()) {
            String firstName = resultSet.getString("FIRSTNAME");
            String lastName = resultSet.getString("LASTNAME");
            System.out.println(firstName + " " + lastName);
            counter++;
        }

        resultSet.close();
        statement.close();


        int expectedUserCount = 2;
        assertEquals(expectedUserCount, counter);
    }
}