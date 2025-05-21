package fr.hugochmt.presai.ollama;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LocalChatController {

  @GetMapping("/local-ai")
  public ResponseEntity<String> askAi1(String userInput) {
    return ResponseEntity.ok("hello");
  }
}
