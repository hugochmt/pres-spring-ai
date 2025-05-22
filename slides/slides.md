---
hideInToc: true
theme: default
layout: image-right
backgroundSize: 90%
fonts:
  sans: 'Montserrat'
image: resources/img/bg.png
---

# **Spring AI**

### Faire discuter son application avec un LLM

---
hideInToc: true
layout: intro
---

# Sommaire

<Toc/>


---

# Contexte

- Essor de l'utilisation des IAs génératives depuis quelques années (ChatGPT, Claude, Midjourney ...)
- Révolution du prompt ➡ on peut définir sa demande en langage naturel
- Lancement de frameworks et librairies pour faciliter l'utilisation des LLMs, autour des APIs OpenAI, Google, etc.

---

# Quelques définitions

### **🧠 Modèle**

- Un modèle est un programme d’intelligence artificielle qui a appris à accomplir une tâche à partir de données
- Exemple : comprendre du texte, générer des réponses, traduire ...

### **🗣️ LLM (Large Language Model)**

- Modèle de langage de très grande taille, entraîné sur d’immenses volumes de textes pour comprendre et générer du
  langage naturel.
- Exemple : GPT-3, GPT-4, Mistral_7B (ChatGPT ≠ GPT-3)

---

### **📝 Prompt**

- Texte que l’on envoie au modèle pour qu’il fasse quelque chose.
- Exemple :

```bash
  Prompt : "Écris une courte histoire sur un chat qui vole."
  Réponse du modèle : "Il était une fois un chat qui avait des ailes argentées..."
```

### **📁 Context / Contexte**

Ensemble d’informations fournies au modèle au moment où il doit générer une réponse.
- Le contexte est stateless → chaque requête doit inclure les infos utiles.
- Peut inclure : historique de conversation, documents, rôle utilisateur, etc.

---

# Mais aussi

### **🧩 Token**

- Un token est une unité de texte comprise par un modèle. Ce n’est pas forcément un mot entier : cela peut être un
  morceau de mot, une ponctuation, etc.

### **🌡️ Température**

- La température est un paramètre qui contrôle le degré de créativité ou de randomness dans la génération de texte par
  un modèle de langage.

---

# Disclaimer

- Ceci n'est pas une presentation sur le fonctionnement de l'IA
- Domaine qui évolue vite (obsolescence, nouvelles technologies, ...)

---
layout: image-right
image: resources/img/img.png
backgroundSize: contain
---

# 🌱 Spring AI

- Module pour l'IA Générative
- Support multi-providers : OpenAI, Google, Mistral, Ollama ...
- Support multi-modèles
- Features
    - ChatAPI
    - Tools calling
    - MCP
    - ...
- v1.0.0 mai 2025

---

# 💬 Chat API

- API fluent pour la communication avec un modèle
- system
- user

---
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

# 🗂️ Structured output

- Pas besoin de fournir le modèle en entrée (spring le fait pour nous)
- Permet de mapper le résultat vers un objet typé
- Possibilité d'implémenter des converter custom
- ⚠ Tente de peupler l'objet quoi qu'il arrive (pas d'exception lancée) prévoir des fallback

---

# Tool Calling

- Lecture/écriture
- Evidemment, attention

---

# Mémoire

---

# Monitoring

- SimpleLoggerAdvisor

---

# 🦙 Ollama
> Docker for LLMs

- Modèles sur Hugging Face
- Intégration avec Spring AI
- Possibilité de auto-pull model
- ⚠ Certains modèles peuvent mal supporter les structured output
- Docker Model Runner


---

# ᯤ MCP
- > Like an USB port for AI applications
- Protocole pour fournir du contexte
- SDK multi-langage (Java, TypeScript, Python ...)
- Fetch page web, API, file system, bases de données...



---

# 🛡 Sécurité

- protection de prompt
-

---

# Cas d'usage réels ?

- Chat bot, aide utilisateur
- Classification de données
- Recherche sémantique
- ...

---

# Et aussi...

- observabilité
- RAG
- MCP Model Context Protocol
- 🦜 [langchain4j](https://github.com/langchain4j/langchain4j)