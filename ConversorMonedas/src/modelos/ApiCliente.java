package modelos;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.stream.Collectors;
import org.json.JSONObject;

public class ApiCliente {
    private static final String API_CLAVE = "40b24fb89108dae27382a3c1";

    public static JSONObject obtenerTasas(String monedaBase) throws IOException {
        String urlString = String.format("https://v6.exchangerate-api.com/v6/%s/latest/%s", API_CLAVE, monedaBase);
        URL url = new URL(urlString);
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("GET");

        BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
        String response = in.lines().collect(Collectors.joining());
        in.close();

        return new JSONObject(response);
    }
}
