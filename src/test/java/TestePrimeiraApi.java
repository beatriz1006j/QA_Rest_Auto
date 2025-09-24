import io.restassured.RestAssured;
import org.hamcrest.Matchers;
import org.junit.Test;

public class TestePrimeiraApi {

    @Test
    public void Exe_TesteComSucessoPrimeiraApi() {
        String url = "http://localhost:8080/api/primeiraApi";

        RestAssured.given()
                    .log().all()
                .when()
                .   get(url)
                .then()
                    .log().all()
                    .assertThat() // pegar o que é esperado e retornar
                    .statusCode(200)
                    .body(Matchers.equalTo("Retorno da api com sucesso!!!"));
    }

    @Test
    public void Exe_PrimeiraApiQueryParam() {
        String url = "http://localhost:8080/api/primeiraApiV1";
        String textoQueryParam = "Teste2";

        RestAssured.given()

                        //.queryParam("palavra","Teste1")
                        .queryParam("palavra",textoQueryParam)
                        .log().all()
                    .when()
                        .get(url)
                    .then()
                        .log().all()
                        .assertThat() // pegar o que é esperado e retornar
                        .statusCode(200)
                        .body(Matchers.equalTo(textoQueryParam));
    }

}