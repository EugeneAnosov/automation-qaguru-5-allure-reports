package tests;

import io.qameta.allure.Allure;
import org.junit.jupiter.api.Test;

import java.util.UUID;

import static com.codeborne.selenide.Selenide.open;

public class DynamicTest {

    final String uuid = UUID.randomUUID().toString();
    @Test
    public void testDynamic() {

        //talk with developers about adding to separate log database
        open("https://github.com?session=" + uuid);

        Allure.getLifecycle().updateTestCase(tc -> {
            tc.setName("Dynamic Test");
        });
        // Can add conditions inside of tests
        if (true) {
            Allure.label("owner", "eugeneanosov");
        }
        Allure.feature("Working with marking");
        Allure.story("Dynamic marking of annotations");
        //Implement clicking by this link in tests of allure report
        Allure.link("logger", "https://logdatabase.com?session=" + uuid);
    }
}
