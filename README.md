# SpaceX

SpaceX app is sample of Android `app` which written in `Kotlin` and follow `MVVM` with DI `Koin`
and `kotlin-coroutines` based on Clean Architecture.

## Table of contents

* [1. Dependencies](#1.-Dependencies)
* [2. Design and layers](#2.-Design and layers)
* [3. Technical Features](#3.-Technical Features)
* [4. Minimum Android version](#4.-Minimum-Android-version)
* [5. Permissions](#5.-Permissions)
* [6. Build](#6.-Build)

## 1. Dependencies

- MVVM (Architecture)
- Android architecture components (LiveData, LifeCycle, Data binding, Navigation & viewModel)
- Data-binding with ViewState
- Koin (Dependency Injection)
- Retrofit 2 (HTTP API)
- kotlin-Coroutines (for non-blocking programming)
- Moshi (lib to parse JSON into model)
- Glide (Async image-loader)
- Check (HTTP inspector via notifications)
- Androidx components : RecyclerView, ConstraintLayout, SwipeRefreshLayout & CardView

## 2. Design and layers

* App layers:
    1. Data: Datasource, DataStore & Repository
    2. Domain : Interactor
    3. Presentation : ViewModel, View & ViewState
* Mappers:
    1. Dto -> DataMapper -> Entity
    2. Entity -> VMMapper -> Model
    3. Model -> InteractorMapper -> Entity
    4. Entity -> RequestMapper -> Dto

## 3. Technical Features

* Clean MVVM architecture
* Koin as DI
* Use latest version of
* Material design
* Support dark-mode
* Kotlin DSL
* Paging
* Data mappers between layers
* SplashScreen with timer
* Parcelize
* BottomSheet Dialog
* ViewState (OnSuccess|onError|onLoading)
* Impl two-way binding
* SimpleRecyclerAdapter
* Shared ViewModel via Koin
* SingleLiveEvent for messaging UI -> ViewModel
* Integrate Chuck for monitoring API and enable monitoring via Charles under debug BuildType
* Log for logging with stackTrace implicitly
* NonNullMutableLiveData
* Semantic Version

## 4. Minimum Android version

Android 5.0 Lollipop (API-level 21)

## 5. Permissions

- android.permission.INTERNET (Normal)
- android.permission.ACCESS_NETWORK_STATE (Normal)

## 6. Build

- Release

```
./gradlew clean AssembleRelease
```

- Debug

```
./gradlew clean AssembleDebug
```
- <span style='color:red'>❗❗❗ To build project via Gradle wrapper by command, check if java-jdk-11 is
installed with updated path JAVA_HOME. Any version above 11 is not supported yet</span>.
- If JDK-11 issue shows up with Android Studio, go to -> preferences(Settings) -> Build, Execution.. -> Build Tool -> Gradle and update Gradle JDK to 11
