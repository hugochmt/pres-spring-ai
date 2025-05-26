package com.example.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TresorController {

  private final TresorRepository tresorRepository;

  public TresorController(TresorRepository tresorRepository) {
    this.tresorRepository = tresorRepository;
  }

  @GetMapping("/tresor")
  public Long getTresor() {
    return this.tresorRepository.getCurrentTresor();
  }
}
