package br.edu.uniritter.searchPhone;

import io.restassured.RestAssured;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@TestPropertySource("classpath:application-test.properties")
public class SearchPhoneApplicationTests {

    @Value("${local.server.port}")
    protected int porta;

    @Before
    public void setUp() throws Exception {
        RestAssured.port = porta;
    }

    @Test
    public void contextLoads() throws Exception {}
}
