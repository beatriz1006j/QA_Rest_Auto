

import io.restassured.RestAssured;
import org.hamcrest.Matchers;
import org.junit.Test;


public class TesteExercicios {

    @Test
    public void exe_PrimeiraApiParImpar() {
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

    @Test
    public void exe_PrimeiraCpfValido() {


        String url = "http://localhost:8080/exercicios/validarCpf";

        RestAssured.given()
                        .queryParam("cpf","44690514038")
                        .log().all()
                    .when()
                        .get(url)
                    .then()
                        .log().all()
                        .statusCode(200)
                        .body(Matchers.equalTo("CPF Valido"));

    }

    @Test
    public void exe_PrimeiraCpfInvalido() {


        String url = "http://localhost:8080/exercicios/validarCpf";;

        RestAssured.given()
                .queryParam("cpf","4469051403")
                .log().all()
                .when()
                .get(url)
                .then()
                .log().all()
                .statusCode(500);


    }


    @Test
    public void exe_Par_Impar() {
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
