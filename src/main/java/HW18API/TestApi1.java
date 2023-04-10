package HW18API;

import org.junit.Test;
import rest.RestGet;

public class TestApi1 {
    String response;
    @Test
    public void test1(){
        response= RestGet.Get("https://bank.gov.ua/NBUStatService/v1/statdirectory/exchange?valcode=USD&json");
        System.out.println(response);
    }

}
