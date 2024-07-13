package modelos;

import org.json.JSONObject;

public class ConvertidorDeMoneda {
    public static double convertir(String monedaDesde, String monedaHacia, double monto) {
        try {
            JSONObject jsonResponse = ApiCliente.obtenerTasas(monedaDesde);
            double tasaDeCambio = jsonResponse.getJSONObject("conversion_rates").getDouble(monedaHacia);
            return monto * tasaDeCambio;
        } catch (Exception e) {
            System.out.println("Error al obtener la tasa de cambio: " + e.getMessage());
            return 0;
        }
    }
}
