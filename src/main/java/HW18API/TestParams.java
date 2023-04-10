package HW18API;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import models.exchange.Exchange;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import rest.RestGet;

import java.util.Arrays;
import java.util.Collection;

@RunWith(Parameterized.class)
public class TestParams {
    static Exchange exchange;

    @Parameterized.Parameters
    public static Collection options() {
        return Arrays.asList(ExchangeEnaum.values());

    }

//    String response;
//
//    @Test
//    public void test1() {
//        response = RestGet.Get("https://bank.gov.ua/NBUStatService/v1/statdirectory/exchange?valcode="+ExchangeEnaum.getVal()+"@json");
//        System.out.println(response);
//

//    public TestParams(ExchangeEnaum exchangeEnaum) {
//            exchange = RestGet.Get("https://bank.gov.ua/NBUStatService/v1/statdirectory/exchange?valcode=")
//        }


    static Exchange[] exchangesMass;
    @BeforeClass
    public static void b() throws JsonProcessingException {
        String response = RestGet.Get("https://bank.gov.ua/NBUStatService/v1/statdirectory/exchange?valcode="+ExchangeEnaum.getVal()+"@json");
        ObjectMapper om = new ObjectMapper();
        exchangesMass= om.readValue(response, Exchange[].class);
    }
    @Test
    public void test1(){
        for (Exchange mass : exchangesMass) {
            System.out.println(mass.cc);
        }

    }
}
