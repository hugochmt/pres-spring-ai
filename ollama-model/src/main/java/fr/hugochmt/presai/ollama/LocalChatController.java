package fr.hugochmt.presai.ollama;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LocalChatController {

  private final ChatClient chatClient;

  public LocalChatController(ChatClient.Builder builder) {
    this.chatClient = builder.build();
  }

  @GetMapping("/ai")
  public String askAi1(String userInput) {
    return this.chatClient.prompt(userInput).call().content();
  }

  @GetMapping("/classify")
  public String askAi2(String userInput) {
    return this.chatClient
        .prompt()
        .system(
            """
        Classify the text into neutral, negative or positive.
        """)
        .user(
            """
        Text : %s
        Sentiment :
        """
                .formatted(userInput))
        .call()
        .content();
  }
}
