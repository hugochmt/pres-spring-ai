package fr.hugochmt.presai;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.ai.tool.annotation.Tool;
import org.springframework.stereotype.Service;

@Service
public class Chateau {
  private static final Logger log = LoggerFactory.getLogger(Chateau.class);
  private final TresorRepository tresorRepository;

  public Chateau(TresorRepository tresorRepository) {
    this.tresorRepository = tresorRepository;
  }

  @Tool(description = "Get the current gold stock present in the castle of Kaamelott")
  public Long getCurrentStockOr() {
    log.info("called tool getCurrentStockOr");
    return this.tresorRepository.getCurrentTresor();
  }

  @Tool(description = "Ajoute au trésor actuel, le nombre de pièces d'or passées en paramètre")
  public void addOr(Long value) {
    log.info("called tool addOr");
    this.tresorRepository.addOr(value);
  }
}
