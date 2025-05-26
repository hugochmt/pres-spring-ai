package com.example.demo;

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

  public Long getCurrentStockOr() {
    return this.tresorRepository.getCurrentTresor();
  }

  public void addOr(Long value) {
    this.tresorRepository.addOr(value);
  }
}
