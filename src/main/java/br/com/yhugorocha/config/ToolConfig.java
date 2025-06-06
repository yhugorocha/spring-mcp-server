package br.com.yhugorocha.config;

import br.com.yhugorocha.tools.SolicitationService;
import org.springframework.ai.support.ToolCallbacks;
import org.springframework.ai.tool.ToolCallback;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class ToolConfig {

    @Bean
    public List<ToolCallback> solicitationTools(SolicitationService solicitationService) {
        return List.of(
                ToolCallbacks.from(solicitationService)
        );
    }
}
