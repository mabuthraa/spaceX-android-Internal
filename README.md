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
* [7. License](#7.-License)

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
* Kotlin DSL
* Paging
* Data mappers between layers
* SplashScreen
* Parcelize
* BottomSheet
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

## 7. License

### Apache 2.0 License

[![License](https://img.shields.io/badge/License-Apache%202.0-yellowgreen.svg)](https://opensource.org/licenses/Apache-2.0)
=======

    Copyright 202 Maher Abuthraa

    Licensed under the Apache License, Version 2.0 (the "License");
    you may not use this file except in compliance with the License.
    You may obtain a copy of the License at

       http://www.apache.org/licenses/LICENSE-2.0

    Unless required by applicable law or agreed to in writing, software
    distributed under the License is distributed on an "AS IS" BASIS,
    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
    See the License for the specific language governing permissions and
    limitations under the License. 


