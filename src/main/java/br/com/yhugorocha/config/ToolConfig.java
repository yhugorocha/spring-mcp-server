package br.com.yhugorocha.config;

import br.com.yhugorocha.tools.SolicitationService;
import org.springframework.ai.tool.ToolCallbackProvider;
import org.springframework.ai.tool.method.MethodToolCallbackProvider;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class ToolConfig {

    /*
    @Bean
    public List<ToolCallback> solicitationTools(SolicitationService solicitationService) {
        return List.of(
                ToolCallbacks.from(solicitationService)
        );
    }
    */
    @Bean
    public ToolCallbackProvider solicitationTools(SolicitationService solicitationService) {
        return MethodToolCallbackProvider.builder().toolObjects(solicitationService).build();
    }
}
