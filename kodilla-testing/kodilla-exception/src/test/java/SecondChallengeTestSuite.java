import com.kodilla.exception.test.SecondChallenge;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Testy metody probablyIWillThrowException")
class SecondChallengeTestSuite {

    @Test
    @DisplayName("Testy które NIE powinny rzucić wyjątku")
    void testProbablyIWillThrowExceptionSuccess() {
        // Given
        SecondChallenge secondChallenge = new SecondChallenge();

        // When & Then
        assertAll(
                // Wartość brzegowa dla x = 1 (początek przedziału <1, 2))
                () -> assertDoesNotThrow(() -> secondChallenge.probablyIWillThrowException(1.0, 2.0)),
                // Środek przedziału x oraz y != 1.5
                () -> assertDoesNotThrow(() -> secondChallenge.probablyIWillThrowException(1.5, 2.0)),
                // Wartość tuż pod granicą x = 2
                () -> assertDoesNotThrow(() -> secondChallenge.probablyIWillThrowException(1.9999, 1.4999))
        );
    }

    @Test
    @DisplayName("Testy wartości brzegowych")
    void testProbablyIWillThrowExceptionThrowsException() {
        // Given
        SecondChallenge secondChallenge = new SecondChallenge();

        // When & Then
        assertAll(

                () -> assertThrows(Exception.class, () -> secondChallenge.probablyIWillThrowException(0.9999, 2.0)),

                () -> assertThrows(Exception.class, () -> secondChallenge.probablyIWillThrowException(2.0, 2.0)),

                () -> assertThrows(Exception.class, () -> secondChallenge.probablyIWillThrowException(3.0, 2.0)),

                () -> assertThrows(Exception.class, () -> secondChallenge.probablyIWillThrowException(1.5, 1.5)),

                () -> assertThrows(Exception.class, () -> secondChallenge.probablyIWillThrowException(0.5, 1.5))
        );
    }
}