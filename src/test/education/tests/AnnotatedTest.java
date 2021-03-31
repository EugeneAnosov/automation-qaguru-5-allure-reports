package tests;

import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("Test Suite with annotations")
public class AnnotatedTest {

    @Test
    @Owner("eugeneanosov")
    @Feature("Working with marking")
    @Story("Marking of annotations")
    @Severity(SeverityLevel.BLOCKER)
    @Link(name = "BaseURL", url = "https://github.com")
    @DisplayName("Example test with annotations")
    public void testSomething() {

     }
}
