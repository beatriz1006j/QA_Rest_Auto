import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;
import org.hamcrest.Matchers;
import org.junit.Test;
import io.restassured.RestAssured.*; // não precisa digitar   RestAssured.given() import statuico

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.containsString;  //mesmo processo retira o Matchers e usa apenas o contens
import static org.hamcrest.Matchers.equalTo;


public class TestePrimeiraApi {

    String url = "http://localhost:8080/api";


    RequestSpecification requestSpecification = new RequestSpecBuilder().setBaseUri(url).build();

    @Test
    public void Exe_TesteComSucessoPrimeiraApi() {
        String path = "/primeiraApi";

        given()
                    .spec(requestSpecification)
                    .log().all()
                .when()
                    .get(path)
                .then()
                    .log().all()
                    .assertThat() // pegar o que é esperado e retornar
                    .statusCode(200)
                    .body(equalTo("Retorno da api com sucesso!!!"));
    }

    @Test
    public void Exe_PrimeiraApiQueryParam() {
        String path = "/primeiraApiV1";
        String textoQueryParam = "Teste1";

        given()
                        .spec(requestSpecification)
                        .queryParam("palavra", textoQueryParam)
                        .log().all()
                    .when()
                        .get(path)
                    .then()
                        .log().all()
                        .assertThat() // pegar o que é esperado e retornar
                        .statusCode(200)
                        .body(equalTo(textoQueryParam));
        }

    @Test
    public void Exe_PrimeiraApiParam1() {
        String textPathParam = "teste";
        String path = "/primeiraApiV2/{variavelDigitada}" + textPathParam;


        given()
                        .spec(requestSpecification)
                        .pathParam("variavelDigitada", textPathParam)
                        .log().all()
                    .when()
                        .get(path)
                    .then()
                        .log().all()
                        .assertThat() // pegar o que é esperado e retornar
                        .statusCode(200)
                        .body(containsString(textPathParam));
        }


    @Test
    public void Exe_PrimeiraApiParam() {
        String textPathParam = "teste";

        given()
                        .spec(requestSpecification)
                        .pathParam("variavelDigitada", textPathParam)
                        .log().all()
                    .when()
                        .get("/primeiraApiV2/{variavelDigitada}")
                    .then()
                        .log().all()
                        .assertThat()
                        .statusCode(200)
                        .body(containsString(textPathParam));

    }
}