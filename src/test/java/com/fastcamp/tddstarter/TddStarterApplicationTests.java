package com.fastcamp.tddstarter;

import org.junit.jupiter.api.Test;
import org.springframework.boot.jdbc.EmbeddedDatabaseConnection;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@AutoConfigureTestDatabase(replace = Replace.ANY, connection = EmbeddedDatabaseConnection.H2)
class TddStarterApplicationTests {

    @Test
    void contextLoads() {
    }

}
