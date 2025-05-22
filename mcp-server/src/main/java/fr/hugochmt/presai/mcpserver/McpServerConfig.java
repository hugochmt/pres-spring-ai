package fr.hugochmt.presai.mcpserver;

import org.springframework.ai.tool.ToolCallbackProvider;
import org.springframework.ai.tool.method.MethodToolCallbackProvider;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class McpServerConfig {

  private final News news;

  public McpServerConfig(News news) {
    this.news = news;
  }

  @Bean
  public ToolCallbackProvider tools() {
    return MethodToolCallbackProvider.builder().toolObjects(news).build();
  }
}
