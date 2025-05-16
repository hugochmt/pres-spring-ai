package fr.hugochmt.presai;

import java.util.List;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ChatController {

  private final ChatClient chatClient;
  private final Chateau chateau;

  public ChatController(ChatClient.Builder chatClientBuilder, Chateau chateau) {
    this.chatClient = chatClientBuilder.build();
    this.chateau = chateau;
  }

  @GetMapping("/ask-ai")
  public String askAi(String userInput) {
    return this.chatClient.prompt(userInput).call().content();
  }

  @GetMapping("/ask-perceval")
  public String askAi2(String userInput) {
    return this.chatClient
        .prompt()
        .system(
            """
          Tu es le personnage Perceval de la série Kaamelott.
          Parle de la même manière que lui.
          """)
        .user(userInput)
        .call()
        .content();
  }

  /**
   * Problèmes : - On doit fournir le format au modèle - pas sûr qu'il nous renvoie exactement
   * l'objet
   */
  @GetMapping("/ask-perceval-potions")
  public String askAi3(String userInput) {
    return this.chatClient
        .prompt()
        .system(
            """
            Tu es le personnage Perceval de la série Kaamelott.
            Parle de la même manière que lui.

            La recette de la potion doit avoir un nom, un pouvoir, et un effet.
            Le résultat doit être au format json avec une clé pour chaque élément.
            Retourne juste le contenu du json

            Je vais te donner un pouvoir. Invente une potion magique de Merlin pour avoir ce pouvoir
            """)
        .user(userInput)
        .call()
        .content();
  }

  @GetMapping("/ask-perceval-potions-structured")
  public Potion askAi3StructuredOutput(String userInput) {
    return this.chatClient
        .prompt()
        .system(
            """
            Tu es le personnage Perceval de la série Kaamelott.
            Parle de la même manière que lui.

            Je vais te donner un pouvoir. Invente une potion magique de Merlin pour avoir ce pouvoir
            """)
        .user(userInput)
        .call()
        .entity(Potion.class);
  }

  @GetMapping("/ask-perceval-potions-structured-list")
  public List<Potion> askAi3StructuredOutputList(String userInput) {
    return this.chatClient
        .prompt()
        .system(
            """
            Tu es le personnage Perceval de la série Kaamelott.
            Parle de la même manière que lui.

            Je vais te donner un pouvoir. Invente une liste de 3 potions magiques de Merlin pour avoir ce pouvoir
            """)
        .user(userInput)
        .call()
        .entity(new ParameterizedTypeReference<>() {});
  }

  @GetMapping("/ask-perceval-tool")
  public String askAi4(String userInput) {
    return this.chatClient
        .prompt()
        .system(
            """
            Tu es le personnage Perceval de la série Kaamelott.
            Parle de la même manière que lui.
            N'oublie pas d'utiliser les outils que je te donne
            """)
        .tools(this.chateau)
        .user(userInput)
        .call()
        .content();
  }
}
