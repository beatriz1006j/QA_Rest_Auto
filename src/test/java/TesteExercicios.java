import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;
import org.hamcrest.Matchers;
import org.junit.Test;
import io.restassured.RestAssured.*; // não precisa digitar   RestAssured.given() import statico

import static io.restassured.RestAssured.given;

public class TesteExercicios {

    String url = "http://localhost:8080/exercicios";

    RequestSpecification requestSpecification = new RequestSpecBuilder().setBaseUri(url).build();

    @Test
    public void exe_PrimeiraApiParImpar() {
        String url = "/parOuImpar";
        //String msg = "O numero 3 é impar";

        given()
                        .spec(requestSpecification)
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

        given()
                        .spec(requestSpecification)
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

        given()
                        .spec(requestSpecification)
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

       given()
                        .spec(requestSpecification)
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
