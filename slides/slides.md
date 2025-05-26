---
hideInToc: true
theme: default
layout: image-right
backgroundSize: 90%
fonts:
  sans: 'Montserrat'
  mono: 'JetBrains Mono'
image: resources/img/bg.png
---

# **Spring AI**

### Faire discuter son application avec un LLM

---
hideInToc: true
layout: intro
---

# Sommaire

<Toc columns="2"/>


---

# Contexte

- Essor de l'utilisation des IAs génératives depuis 2023 (ChatGPT, Claude, Midjourney ...)
- Révolution du prompt : on peut définir sa demande en langage naturel
- Lancement de frameworks et librairies pour faciliter l'utilisation des LLMs, autour des APIs OpenAI, Google...
- Ex: [langchain4j](https://github.com/langchain4j/langchain4j)

---

# Quelques définitions

### **🧠 Modèle**

- Un modèle est un programme d’intelligence artificielle qui a appris à accomplir une tâche à partir de données
- Exemple : comprendre du texte, générer des images, traduire...

### **🗣️ LLM (Large Language Model)**

- Modèle de langage de très grande taille, entraîné sur d’immenses volumes de textes pour comprendre et générer du
  langage naturel.
- Exemple : GPT-3, GPT-4, Mistral_7B (ChatGPT ≠ GPT-3)

---
hideInToc: true
---

# Quelques définitions

### **📝 Prompt**

- Texte que l’on envoie au modèle pour qu’il fasse quelque chose.
- Exemple :

```
Prompt : "Écris une courte histoire sur un chat qui vole."
Réponse du modèle : "Il était une fois un chat qui avait des ailes argentées..."
```

### **📁 Context / Contexte**

- Ensemble d’informations fournies au modèle au moment où il doit générer une réponse.
- Le contexte est stateless : chaque requête doit inclure les infos utiles.
- Exemple : historique de conversation, documents, rôle utilisateur, etc.

---
hideInToc: true
---

# Quelques définitions

### **🧩 Token**

- Un token est une unité de texte comprise par un modèle. Ce n’est pas forcément un mot entier : cela peut être un
  morceau de mot, une ponctuation, etc.

### **🌡️ Température**

- La température est un paramètre qui contrôle le degré de créativité ou "d'aléatoire" dans la génération de texte par
  un modèle de langage.

---
layout: image-right
image: resources/img/spring-ai.png
backgroundSize: contain
---

# Spring AI

- Module Spring pour l'IA Générative
- Support multi-providers : OpenAI, Google, Mistral, Ollama ...
- Support multi-modèles
- Features
    - ChatAPI
    - Tools calling
    - MCP
    - ...
- v1.0.0 (mai 2025)

---

# Chat Client API

- API fluent pour la communication avec un modèle
- Envoi de prompts

```java {all}{class:'!children:text-lg'}
String askQuestion() {
  return chatClient.prompt()
          .user("Hello bot !")
          .call()
          .content();
}
```

---
hideInToc: true
layout: center
---

<style>
h1 {
  font-weight: bold;
}
</style>

# Let's code !

---
layout: image-right
image: resources/img/structured_output.png
backgroundSize: contain
---

# Structured output

- Pas besoin de fournir le modèle en entrée (spring le fait pour nous)
- Permet de mapper le résultat vers un objet typé
- Possibilité d'implémenter des converter custom
- ⚠ Tente de peupler l'objet quoi qu'il arrive (pas d'exception lancée) prévoir des fallback

---
layout: image-right
image: resources/img/tool-call.png
backgroundSize: contain
---

# Tool Calling

- Récupération d'information
- Action

```java
class DateTimeTools {
  
  @Tool(description = """
      Get the current date and time
      in the user's timezone
      """)
  String getCurrentDateTime() {
    return LocalDateTime.now()
            .atZone(LocaleContextHolder
                    .getTimeZone()
                    .toZoneId())
            .toString();
  }
}
```

---

# Mémoire

- Advisors : intercepteurs
- InMemory, Jdbc, Base vectorielle...

---

# Ollama

> Docker for LLMs

- Modèles sur Hugging Face
- Intégration avec Spring AI
- Possibilité de auto-pull model
- ⚠ Certains modèles peuvent mal supporter les structured output
- Docker Model Runner

---
layout: image-right
image: resources/img/mcp.png
backgroundSize: contain
---

# MCP - Model Context Protocol

> Like an USB port for AI applications

- Protocole pour fournir du contexte au modèle
- Lancé par Anthropic
- Exemples : fetch page web, API, file system, bases de données...
- SDK multi-langage (Java, TypeScript, Python ...)
- SSE, Stdio

---

# Et aussi...

- Observabilité
- Recherche sémantique
- RAG (Retrieval Augmented Generation) : récupération d'information

---

# Cas d'usage réels ?

- Chat bot, aide utilisateur
- Classification de données
- Recherche sémantique
- ...

---
hideInToc: true
layout: center
---

<style>
h1 {
  font-weight: bold;
}
</style>

# Merci !