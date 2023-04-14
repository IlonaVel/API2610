package HW18API;

import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

    public class ApiTest {

        private static final String API_URL = "https://rickandmortyapi.com/api/character";
        private static final HttpClient client = HttpClient.newHttpClient();
        private static final JsonFactory jsonFactory = new JsonFactory();

        public static void main(String[] args) throws URISyntaxException, IOException, InterruptedException {
            List<String> names = new ArrayList<>();
            String url = API_URL;
            while (url != null) {
                HttpRequest request = HttpRequest.newBuilder()
                        .uri(new URI(url))
                        .GET()
                        .build();
                HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
                String responseBody = response.body();
                Optional<JsonToken> token = Optional.empty();
                JsonParser parser = jsonFactory.createParser(responseBody);
                while (parser.nextToken() != null) {
                    if (token.isPresent() && token.get() == JsonToken.FIELD_NAME && parser.getCurrentName().equals("name")) {
                        parser.nextToken();
                        names.add(parser.getValueAsString());
                    } else if (parser.getCurrentToken() == JsonToken.FIELD_NAME && parser.getCurrentName().equals("next")) {
                        parser.nextToken();
                        if (parser.getCurrentToken() == JsonToken.VALUE_NULL) {
                            url = null;
                        } else {
                            url = parser.getValueAsString();
                        }
                        break;
                    }
                    token = Optional.ofNullable(parser.getCurrentToken());
                }
            }
            names.forEach(System.out::println);
        }

    }


