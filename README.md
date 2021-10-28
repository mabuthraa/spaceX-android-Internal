# SpaceX
SpaceX app is sample of Android `app` which written in `Kotlin` and follow `MVVM` with DI `Koin` and `kotlin-coroutines` based on Clean Architecture.

## Table of contents
* [1. Dependencies](#1.-Dependencies)
* [2. Design and layers](#2.-Design and layers)
* [3. Minimum Android version](#3.-Minimum-Android-version)
* [4. Permissions](#4.-Permissions)
* [5. Build](#5.-Build)
* [6. License](#6.-License)

## 1. Dependencies
- MVVM (Architecture)
- Android architecture components (LiveData,LifeCycle & viewModel)
- Data-binding with ViewState 
- android navigation components
- Koin (Dependency Injection)
- Retrofit 2 (HTTP API)
- kotlin-Coroutines (for non-blocking programming)
- Moshi (lib to parse JSON into model)
- Recyclerview
- CardView
- Semantic Version


## 2. Design and layers
* App layers:
    1. Data: Datasource, DataStore & Repository
    2. Domain : Interactor
    3. Presentation : VM/V
* Mappers: 
    1. Dto -> DataMapper -> Entity
    2. Entity -> VMaMapper -> Model


## 3. Minimum Android version

Android 5.1 Lollipop (API-level 22)


## 4. Permissions

- android.permission.INTERNET (Normal)
- android.permission.ACCESS_NETWORK_STATE (Normal)


## 5. Build

- Release
```
./gradlew clean AssembleRelease
```
- Debug
```
./gradlew clean AssembleDebug
```

## 6. License
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


