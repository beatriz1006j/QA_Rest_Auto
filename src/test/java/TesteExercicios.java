

import io.restassured.RestAssured;
import org.hamcrest.Matchers;
import org.junit.Test;


public class TesteExercicios {

    @Test
    public void Exe_PrimeiraApiParImpar() {
        String url = "http://localhost:8080/exercicios/parOuImpar";
        //String msg = "O numero 3 é impar";

        RestAssured.given()
                        .queryParam("numero",2)
                        .log().all()
                    .when()
                        .get(url)
                    .then()
                        .log().all()
                        .statusCode(200)
                         .body(Matchers.equalToIgnoringCase("o numero 2 é par"));
                        //.body(Matchers.equalTo("O numero 2 é par"));
    }
}
