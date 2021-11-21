package org;

import io.restassured.RestAssured;
import org.testng.annotations.Test;

/**
 * @author Vishal Tailor
 */

/***
 * Debugging Methode
 * .peek()   peek methode print header and body to the standard  output
 * .prettyPeek() pretty peek methode print header and body to the standard output more readable .
 * .print()   print methode can print only body of response and a return string as a standard output.
 * .prettyPrint()  print methode can print only body of response and a return string  as a standard
 *  output but more readable .
 */
public class Peek_And_Print {
    public static String baseUrl = "https://api.github.com";

    // TestNg Annotation
    @Test
    // peek
    public void peek() {
        RestAssured.get(baseUrl)
                // peek methode print header and body to the standard  output
                .peek();
    }

    @Test
    // pretty peek methode print header and body to the standard output more readable .
    public void prettypeek() {
        RestAssured.get(baseUrl)
                .prettyPeek();
    }

    @Test
    // print methode can print only body of response and a return string as a standard output.
    public void print() {
        RestAssured.get(baseUrl)
                .print();

    }

    @Test
    // print methode can print only body of response and a return string  as a standard
    // output but more readable .
    public void prettyprint() {
        RestAssured.get(baseUrl)
                .prettyPrint();

    }

}
