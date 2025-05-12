<h1 align="center">🎮 Social Twitch</h1>

<p align="center">
  <a href="https://opensource.org/licenses/Apache-2.0"><img alt="License" src="https://img.shields.io/badge/License-Apache%202.0-blue.svg"/></a>
  <a href="https://android-arsenal.com/api?level=21"><img alt="API" src="https://img.shields.io/badge/API-21%2B-brightgreen.svg"/></a>
  <a href="#"><img alt="Build Status" src="https://img.shields.io/github/actions/workflow/status/shubhanshu24510/SocialClone/android-ci.yml?branch=main"/></a>
</p>

<p align="center">
📱 A modern social media Android app built with Jetpack Compose, demonstrating features like chatting, posting, messaging, friend connections, image sharing, and responsive UI — powered by modern Android development tools.
</p>

---

## ✨ Features

- 🔐 Authentication (Login & Signup)
- 📝 Post creation, like, comment
- 💬 Real-time chat & messaging
- 🧑‍🤝‍🧑 Friend search & connection
- 📷 Image sharing
- 📱 Foldable-device friendly UI (Navigation Rail)
- 🔎 Comprehensive search
- 🌙 Material Design 3 theming

---

## 📸 Previews

### 🏠 Home Screen
<img src="https://github.com/shubhanshu24510/SocialClone/assets/100926922/a7be9795-0499-435d-9bf6-975089b977b8" alt="Home Preview" style="max-width: 100%; max-height: 1200px; width: auto; height: auto;"/>

### 📝 Post Detail Screen
<img src="https://github.com/shubhanshu24510/SocialClone/assets/100926922/05d6f366-b4e5-4fb2-8a32-453ddc56b001" alt="Post Detail Preview" style="max-width: 100%; max-height: 1200px; width: auto; height: auto;"/>


## 🧰 Tech Stack

### 🔹 Language & UI
- [Kotlin](https://kotlinlang.org/)
- [Jetpack Compose](https://developer.android.com/jetpack/compose)
- [Material 3](https://m3.material.io/)

### 🔹 Architecture & Patterns
- MVVM Architecture
- Repository Pattern
- Offline-First Design

### 🔹 Networking & Backend
- [Ktor](https://ktor.io/)
- [Retrofit](https://square.github.io/retrofit/)
- [Scarlet](https://github.com/Tinder/Scarlet) – WebSockets
- [KMongo](https://litote.org/kmongo/)

### 🔹 Dependency Injection & Persistence
- [Dagger-Hilt](https://developer.android.com/training/dependency-injection/hilt-android)
- [Room DB](https://developer.android.com/jetpack/androidx/releases/room)

### 🔹 Asynchronous & Serialization
- [Kotlin Coroutines](https://kotlinlang.org/docs/coroutines-overview.html)
- [Flow](https://developer.android.com/kotlin/flow)
- [Kotlinx Serialization](https://github.com/Kotlin/kotlinx.serialization)

### 🔹 Image Loading
- [Coil](https://coil-kt.github.io/coil/)

---

## 🏛️ Architecture

**Social Twitch** follows [Google's recommended architecture](https://developer.android.com/topic/architecture) with **UI Layer** and **Data Layer** separation.

### 📐 Overview

![Architecture Overview](https://github.com/user-attachments/assets/29f555f6-2339-40dc-899c-79835b0c7fb7)

- **Unidirectional Data Flow**: UI sends events, Data layer streams state.
- **Loosely coupled** and highly maintainable components.

---

### 🎨 UI Layer

![UI Layer](https://github.com/user-attachments/assets/80d123e6-e72b-4ca8-998b-a9edec78ae19)

- Built using Jetpack Compose.
- ViewModel observes app state and emits updates.
- Supports configuration changes and lifecycle-aware UI.

---

### 📦 Data Layer

![Data Layer](https://github.com/user-attachments/assets/0bdebc42-69a1-41a2-ad8f-d57d3cbf9124)

- Repositories handle business logic.
- Combines local (Room) and remote (Ktor) data sources.
- Offline-first with "single source of truth".

---

## 🧩 Modularization Strategy

- ✂ **Reusability**: Isolated feature and core modules
- ⚙ **Parallel Builds**: Faster CI/CD and dev builds
- 🔒 **Encapsulation**: Strong visibility boundaries
- 🧑‍💻 **Team Scalability**: Assignable modules per dev team

[📘 Learn about Android App Modularization](https://developer.android.com/topic/modularization)

---

## 🤝 Support

If you like this project, please consider ⭐ starring the repo and following me for more cool Android projects!

☕ You can also support my work by buying me a coffee:

<p align="left">
  <a href="https://buymeacoffee.com/shubhanshu24510" target="_blank">
    <img src="https://cdn.buymeacoffee.com/buttons/v2/default-yellow.png" alt="Buy Me A Coffee" height="60" width="217">
  </a>
</p>

---

👉 [GitHub @shubhanshu24510](https://github.com/shubhanshu24510)
