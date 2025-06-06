package br.com.yhugorocha.tools;

import br.com.yhugorocha.dto.Solicitation;
import org.springframework.ai.tool.annotation.Tool;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.List;

@Service
public class SolicitationService {

    private final WebClient solicitationWebClient;

    public SolicitationService(@Qualifier("solicitationWebClient") WebClient solicitationWebClient) {
        this.solicitationWebClient = solicitationWebClient;
    }

    @Tool(
            name = "getSolicitations",
            description = "Busca todas as solicitações da API externa."
    )
    public List<Solicitation> getSolicitations() {
        return solicitationWebClient.get()
                .uri("")
                .retrieve()
                .bodyToFlux(Solicitation.class)
                .collectList()
                .block();
    }

    @Tool(
            name = "getSolicitationsByCpf",
            description = "Busca todas as solicitações da API externa por CPF."
    )
    public List<Solicitation> getSolicitationsByCpf(String cpf) {
        return solicitationWebClient.get()
                .uri("/cpf/{cpf}", cpf)
                .retrieve()
                .bodyToFlux(Solicitation.class)
                .collectList()
                .block();
    }
}
