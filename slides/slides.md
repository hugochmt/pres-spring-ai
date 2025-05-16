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

# 📖 Quelques définitions

- LLM
- Modèle
-

---

# Disclaimer

---
layout: image-right
image: resources/img/img.png
backgroundSize: contain
---

# 🌱 Spring AI

- Module pour l'IA Générative
- Support multi-providers : OpenAI, Google, Mistral, Ollama ...
- Features
    - ChatAPI
    - Tools calling
    - MCP
    - ...
- ⚠ v1.0.0-RC1

---

# 💬 Chat API

- API fluent pour la communication avec un modèle

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
- ⚠ tente de peupler l'objet quoi qu'il arrive (pas d'exception lancée) prévoir des fallback

---

# 🔌 Modèle local ?

---

# 🛡 Sécurité

---

# Cas d'usage réels ?

- Chat bot, aide utilisateur
- Classification de données





---

# Alternatives

- aussi [langchain4j](https://github.com/langchain4j/langchain4j)