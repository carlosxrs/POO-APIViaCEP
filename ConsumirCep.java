package ProQQ;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

/**
 * Aluno: Carlos Eduardo Rodrigues de Sousa
 * RA: 0024303
 * Atividade: POO / API ViaCEP
 */
public class ConsumirCep {
    public static void main(String[] args) {
        // Seu CEP personalizado conforme solicitado na atividade
        String cep = "72450070";
        String url = "https://viacep.com.br/ws/" + cep + "/json";
        
        try {
            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(url)) // informa end para consulta
                    .GET() // pede os dados do site
                    .build(); // finalizar pedido
                    
            HttpResponse<String> response = client.send(
                    request,
                    HttpResponse.BodyHandlers.ofString()
            );
            
            System.out.println("Consulta realizada com sucesso para o CEP: " + cep);
            System.out.println(response.body());
            
        } catch (Exception e) {
            System.out.println("Erro ao consultar o CEP: " + e.getMessage());
        }
    }
}
