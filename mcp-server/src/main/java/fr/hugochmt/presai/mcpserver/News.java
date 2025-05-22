package fr.hugochmt.presai.mcpserver;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.ai.tool.annotation.Tool;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class News {

  private static final Logger log = LoggerFactory.getLogger(News.class);

  @Tool(description = "Get current trending news articles")
  public List<Article> getAllNews() {
    log.info("Tool called : Get current trending news articles");

    return List.of(
        new Article(
            "Recette : La Soupe aux Orties de Perceval",
            "Découvrez comment Perceval improvise une soupe avec des orties, trois cailloux et une botte de poireaux oubliée. Attention : résultat non garanti."),
        new Article(
            "Les 7 Raisons Pour Lesquelles Merlin Est Toujours Nul En Magie",
            "Spoiler : ce n’est pas la faute des astres. Analyse approfondie des plus grandes catastrophes magiques de Merlin."),
        new Article(
            "Interview Exclusive : Le Roi Loth et la Diplomatie Par le Mépris",
            "Le roi d'Orcanie nous livre sa vision unique de la politique et des banquets royaux. 'Moi j’suis venu pour la bouffe, pas pour discuter avec des pignoufs.'"),
        new Article(
            "10 Utilisations Inattendues de l’Épée de Bohort",
            "De la brochette de lapin au cure-dent pour dragon, Bohort nous montre que son épée ne sert jamais à se battre. Jamais."),
        new Article(
            "Arthur : Roi, Stratège, et Victime de Réunions Qui Ne Servent À Rien",
            "Retour sur les pires conseils de guerre de la Table Ronde. Témoignages anonymes (surtout de Léodagan et Karadoc)."));
  }
}
