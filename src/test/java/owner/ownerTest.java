package owner;


import config.CredentialsConfig;
import org.aeonbits.owner.ConfigFactory;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import java.lang.module.Configuration;

@Tag("owner")
public class ownerTest {

    CredentialsConfig credentialsConfig = ConfigFactory.create(CredentialsConfig.class);
    @Test
    void ownerTest() {
        String login = credentialsConfig.login();
        String password = credentialsConfig.password();
        System.out.println("login " + login);
        System.out.println("password " + password);
    }
}
