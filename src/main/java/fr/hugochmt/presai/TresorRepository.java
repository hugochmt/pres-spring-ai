package fr.hugochmt.presai;

import org.springframework.stereotype.Service;

@Service
public class TresorRepository {

  private Long stockOr = 1500L;

  public Long getCurrentTresor() {
    return this.stockOr;
  }

  public void addOr(Long value) {
    this.stockOr = this.stockOr + value;
  }
}
