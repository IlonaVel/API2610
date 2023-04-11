package HW18API;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import models.exchange.Exchange;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import rest.RestGet;

import java.util.Arrays;
import java.util.Collection;

@RunWith(Parameterized.class)
public class TestParams1 {
    static Exchange exchange;

    @Parameterized.Parameters
    public static Collection options() {
        return Arrays.asList(ExchangeEnaum.values());

    }

    static Exchange[] exchangesMass;

    public TestParams1(ExchangeEnaum exchangeEnaum) throws JsonProcessingException {
        String response = RestGet.Get("https://bank.gov.ua/NBUStatService/v1/statdirectory/exchange?valcode="+exchangeEnaum.getVal()+"&json");
        ObjectMapper om = new ObjectMapper();
        exchangesMass= om.readValue(response, Exchange[].class);
    }
    @Test
    public void test1(){
        System.out.println(exchangesMass[0].cc+" = "+exchangesMass[0].peremennaya);

    }
}
