# 📝 To-Do Compose App

A simple, modern, and powerful To-Do app built with **Kotlin**, **Jetpack Compose**, and the **MVVM pattern**. Manage your tasks efficiently with a sleek UI and a robust architecture.

## ✨ Features

- ✅ Add, update, and delete tasks
- 🎨 Modern UI built with Jetpack Compose
- 🔄 Real-time task updates with **StateFlow**
- 📦 Local storage using **Room Database**
- 🛠️ Clean and maintainable **MVVM architecture**
- 🚀 Dependency injection powered by **Hilt**

## 📸 Screenshots

| Add Tasks | Manage Tasks | Delete Tasks |
|-----------|--------------|--------------|
| ![Add Tasks](https://via.placeholder.com/150) | ![Manage Tasks](https://via.placeholder.com/150) | ![Delete Tasks](https://via.placeholder.com/150) |

## 🛠️ Tech Stack

- **UI**: Jetpack Compose, Material 3
- **State Management**: StateFlow, ViewModel
- **Database**: Room Database
- **Dependency Injection**: Hilt
- **Language**: Kotlin (Coroutines, Flows)

## 📂 Project Structure

```
com.example.todocomposeapp
│
├── data                    # Data layer
│   ├── model              # Room entities
│   ├── dao                # Data Access Objects
│   ├── database           # Database configuration
│   └── repository         # Data source logic
│
├── ui                     # Presentation layer
│   ├── viewmodel          # ViewModel for managing state
│   └── screen             # Compose screens
│
├── TodoApplication.kt     # Application class (Hilt setup)
└── MainActivity.kt        # Entry point
```

## 🚀 Getting Started

### 1. Prerequisites

* **Android Studio**: Arctic Fox or later
* **JDK**: Version 17 or above
* **Kotlin**: Latest stable version

### 2. Clone the Repository

```bash
git clone https://github.com/your-username/todo-compose-app.git
```

### 3. Open in Android Studio
* Open the project in Android Studio
* Sync Gradle to download all dependencies

### 4. Run the App
* Connect an emulator or physical device
* Press the ▶️ Run button in Android Studio

## 🖥️ Screens in the App

### Main Screen
* Displays a list of tasks
* Add new tasks using the input field and button
* Mark tasks as done using checkboxes

### Task Item
* Represents an individual task
* Includes options to delete or toggle task completion

## 🔗 Contributing

We love contributions! To contribute:

1. Fork the repository
2. Create a feature branch:
```bash
git checkout -b feature-name
```
3. Commit your changes:
```bash
git commit -m 'Add some feature'
```
4. Push to the branch:
```bash
git push origin feature-name
```
5. Open a pull request

## 🛡️ License

This project is licensed under the MIT License.

## 🙌 Acknowledgments

Special thanks to the open-source community and Android developers for their incredible resources and tools. 💙

Enjoy building with **Jetpack Compose** and feel free to share your feedback! 🚀 **Happy Coding!**
