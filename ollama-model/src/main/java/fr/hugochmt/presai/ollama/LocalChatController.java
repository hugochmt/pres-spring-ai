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
            "Classify the provided character. If the character is a bad guy return 'BAD_GUY', if it is the good guy in many stories return 'GOOD_GUY'")
        .user(userInput)
        .call()
        .content();
  }
}
