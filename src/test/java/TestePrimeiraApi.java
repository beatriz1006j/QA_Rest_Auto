import io.restassured.RestAssured;
import org.hamcrest.Matchers;
import org.junit.Test;

public class TestePrimeiraApi {

    @Test
    public void TesteComSucessoPrimeiraApi() {
        String url = "http://localhost:8080/api/primeiraApi";

        RestAssured.given()
                    .log().all()
                .when()
                .   get(url)
                .then()
                    .log().all()
                    .assertThat() // pegar o que é esperado e retornar
                    .statusCode(200)
                    .body(Matchers.equalTo("Retorno da api com sucesso!!!")); // Corrigido aqui
    }
}