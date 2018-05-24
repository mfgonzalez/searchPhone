package br.edu.uniritter.searchPhone.resource;

import br.edu.uniritter.searchPhone.SearchPhoneApplicationTests;
import br.edu.uniritter.searchPhone.model.Cliente;
import br.edu.uniritter.searchPhone.model.Telefone;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.hamcrest.Matchers;
import org.junit.Test;
import org.springframework.http.HttpStatus;

import java.util.Arrays;
import java.util.Collections;

public class ClienteResourceTest extends SearchPhoneApplicationTests {

    @Test
    public void deve_salvar_cliente() throws Exception {
        final Cliente cliente = new Cliente("Renato Henry da Silva", "06577059268");

        final Telefone telefone = new Telefone("41", "25515713");

        cliente.setTelefones(Arrays.asList(telefone));

        RestAssured.given()
                .request()
                .header("Accept", ContentType.ANY)
                .header("Content-type", ContentType.JSON)
                .body(cliente)
                .when()
                .post("/clientes")
                .then()
                .log().headers()
                .log().body()
                .and()
                .statusCode(HttpStatus.CREATED.value())
                .header("Location", Matchers.equalTo("http://localhost:" + porta + "/clientes/41/25515713"))
                .body("nome", Matchers.equalTo("Renato Henry da Silva"),
                        "cpf", Matchers.equalTo("06577059268"));
    }

    @Test
    public void deve_buscar_cliente_pelo_ddd_e_numero() throws Exception {
        RestAssured.given()
                .pathParam("ddd", "86")
                .pathParam("numero", "35006330")
                .get("clientes/{ddd}/{numero}")
                .then()
                .log().body()
                .statusCode(HttpStatus.OK.value())
                .and()
                .body(
                        "id", Matchers.equalTo(3),
                        "nome", Matchers.equalTo("Cauê"),
                        "cpf", Matchers.equalTo("38767897100")
                );
    }

    @Test
    public void deve_buscar_todos_cliente_cadastrados() throws Exception {
        RestAssured.given()
                .request()
                .header("Accept", ContentType.ANY)
                .header("Content-type", ContentType.JSON)
                .when()
                .get("/clientes")
                .then()
                .log().body()
                .and()
                .statusCode(HttpStatus.OK.value())
                .body("id", Matchers.hasItems(1, 3, 5),
                        "nome", Matchers.hasItems("Thiago", "Iago", "Cauê"));
    }

    @Test
    public void deve_retornar_erro_nao_encontrando_quando_buscar_cliente_com_telefone_invalido() throws Exception {
        RestAssured.given()
                .pathParam("ddd", "99")
                .pathParam("numero", "12345678")
                .get("clientes/{ddd}/{numero}")
                .then()
                .log().body()
                .statusCode(HttpStatus.NOT_FOUND.value())
                .and()
                .body(
                        "erro", Matchers.equalTo("Não existe cliente com o telefone (99) 12345678")
                );
    }

    @Test
    public void nao_deve_salvar_cliente_com_cpf_repetido() throws Exception {
        final Cliente cliente = new Cliente("Renato Henry da Silva", "38767897100");

        final Telefone telefone = new Telefone("41", "25515713");

        cliente.setTelefones(Arrays.asList(telefone));

        RestAssured.given()
                .request()
                .header("Accept", ContentType.ANY)
                .header("Content-type", ContentType.JSON)
                .body(cliente)
                .when()
                .post("/clientes")
                .then()
                .log().body()
                .and()
                .statusCode(HttpStatus.BAD_REQUEST.value())
                .body(
                        "erro", Matchers.equalTo("Já existe cliente cadastrado com o CPF '38767897100'")
                );
    }

    @Test
    public void nao_deve_salvar_cliente_com_telefone_repetido() throws Exception {
        final Cliente cliente = new Cliente("Renato Henry da Silva", "06577059268");

        final Telefone telefone = new Telefone("41", "999570146");

        cliente.setTelefones(Collections.singletonList(telefone));

        RestAssured.given()
                .request()
                .header("Accept", ContentType.ANY)
                .header("Content-type", ContentType.JSON)
                .body(cliente)
                .when()
                .post("/clientes")
                .then()
                .log().body()
                .and()
                .statusCode(HttpStatus.BAD_REQUEST.value())
                .body(
                        "erro", Matchers.equalTo("Já existe cliente cadastrado com o telefone (41) 999570146")
                );
    }
}
