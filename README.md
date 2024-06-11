# ValorantApp
Valorant app where is possible to get some info about Valorant in general

## Tech Stack

- Multi Module project
- Kotlin
- Clean Architecture
- Compose
- Coroutines / Flow
- MVVM
- Konsist
- Retrofit
- Gson
- Lottie Animations
- Junit
- Bitrise (CI)

## Architecture Overview:
This project is using the architecture as follows:
<p>
<img src="imgs/app_arch.png"/>  
</p>
<b>Note: Until this current moment it wasn't required to create the domain layer, once it wasn't identified some use case that could be reusable in the app, so If the domain layer had been created, it would only increase the complexity and the boilerplate of the project.</b>

### UI Layer
The UI layer is responsible for giving feedback to the user interactions, it is also the presentation layer for the user. 
</br> The UI elements are been created using the Jetpack Compose Library.
</br> The State holders are been controlled under the ViewModel, and the ViewModel is responsible for updating the state of the UI (using coroutines/flow/state, etc..)
<p>
<img src="imgs/ui_layer.png"/>  
</p>

### Data Layer
The Data layer is responsible for create, storing and also providing the data to be shown to the user.
</br> The Repository classes are responsible for managing the correct data sources to get the data from different sources like Apis or Local Queries in the local database.
</br> Currently, in the project, we're doing some REST requests to the Valo API (https://valorant-api.com/) to get the information that will be shown to the user. This request is being made using some third-party libraries such as OKHTTP and Retrofit, also the conversion of the JSON to the entities in the project is been made by Gson.
</br> The DataSources classes represent how to get the data (from web/local data sources)
</br> <b> Note: the idea is to have two data sources in the feature one for the local database and another for the remote database </b>
<p>
<img src="imgs/data_layer.png"/>  
</p>

## Gitflow
This project have three important branches:
- Master (contains the stable code)
- Release (contains the code that pretend to be stable)
- Develop (contains the development code)
![image](https://github.com/MatheusLima1/ValorantApp/assets/20291251/6484f724-ed2f-47ed-9b8e-97e5e20862a2)

### Process to create a feature:
First, it's needed checkout the develop branch, update it, and then create a feature branch following the convention: feature/[NAME-OF-THE-FEATURE], when the work in the branch is done, a new PR needs to be opened, a trigger in the bitrise will be called so the checkings will starts, the pipeline will check the code conventions, architecture patterns (using Konsist [https://docs.konsist.lemonappdev.com/getting-started/readme] to ensure it), run the tests, build the app, and then finishes, after validating all the checkings, the PR can be merged.

  <p>
    <img src="imgs/github-pipeline.png" alt="Github pipeline started" widht = 1024px/>
  </p>
  <p>
    <img src="imgs/bitrise-app-name.png" alt="Bitrise app name" widht = 1024px/>
  </p>
  <p>
    <img src="imgs/pipeline.png" alt="Pipeline name" widht = 1024px/>
  </p>

### Process to create a fix:
It's similar to the process to create a feature, instead of using a feature use a fix.

### Process to create a hotfix:
To fix a bug present the master, first, you need to check the master branch, then create a branch with the pattern: hotfix/[BUG-TO-FIX], when finished with the fix, open a PR directly for the master, and after the checkings success status, you can merge on master, after it, open a PR from master to develop and release branch.

## Continuous Integration
<p>For Continuous Integration, this app is using Bitrise (https://bitrise.io/)</p>

## Overview of the app:

<table>
  <tr>
    <td><img src="imgs/main.jpg" alt="Main Screen" height = 640px/></td>
    <td><img src="imgs/agentListFull.jpg" alt="Agent List" height = 640px/></td>
  </tr> 
</table>
