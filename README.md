Bu proje, **JSONPlaceholder Users API** üzerinden kullanıcı verilerini çekerek modern Android geliştirme yaklaşımlarıyla ekranda gösteren bir uygulamadır.
Projede şu teknolojiler ve mimari yapı kullanılmıştır:

- MVVM (Model - View - ViewModel)
- Retrofit (API iletişimi)
- Kotlin Coroutines (asenkron işlemler)
- StateFlow (reaktif state yönetimi)
- Jetpack Compose (modern UI)

##  [Data Katmanı](app/src/main/java/eu/tutorials/mvvm/data/model/User.kt)
###  Görevi:
API’den gelen kullanıcı verisini temsil eden data class.

##  [Api Service](app/src/main/java/eu/tutorials/mvvm/data/remote/ApiService.kt)
###  Görevi:
API endpoint’lerini tanımlar. Retrofit HTTP isteğini buradan yapar

##  [Retrofit Instance](app/src/main/java/eu/tutorials/mvvm/data/remote/RetrofitInstance.kt)
###  Görevi:
Retrofit nesnesini oluşturur.
- Base URL burada tanımlanır
- Gson converter eklenir
- Singleton yapı kullanılır

##  [User Repository](app/src/main/java/eu/tutorials/mvvm/data/repository/UserRepository.kt)
###  Görevi:
API ile ViewModel arasında köprü kurar.
- ViewModel doğrudan API ile konuşmaz
- Temiz mimari sağlanır

##  [User View Model](app/src/main/java/eu/tutorials/mvvm/viewmodel/UserViewModel.kt)
###  Görevi:
- API’den veri çekmek
- UI state yönetmek

##  [User UI State](app/src/main/java/eu/tutorials/mvvm/viewmodel/UserUiState.kt)
###  Görevi:
UI'ın alabileceği durumları tanımlar

##  [User Item](app/src/main/java/eu/tutorials/mvvm/ui/theme/components/UserItem.kt)
###  Görevi:
Her kullanıcı için UI kartı oluşturur.

##  [User List Screen](app/src/main/java/eu/tutorials/mvvm/ui/theme/screen/UserListScreen.kt)
###  Görevi:
Ana ekranı oluşturur ve UI state’e göre ekranı yönetir.

## Bağımlılıklar

AndroidManifest.xml dosyasına internet izninin eklenmesi gerekmektedir:
```xml
<uses-permission android:name="android.permission.INTERNET"/>

---

```kotlin
dependencies {
// ViewModel ve Lifecycle
implementation("androidx.lifecycle:lifecycle-viewmodel-compose:2.8.0")
implementation("androidx.lifecycle:lifecycle-runtime-compose:2.8.0")
// Retrofit ve Gson
implementation("com.squareup.retrofit2:retrofit:2.11.0")
implementation("com.squareup.retrofit2:converter-gson:2.11.0")
// Coroutines
implementation("org.jetbrains.kotlinx:kotlinx-coroutines-android:1.8.1")
// Material Icons (opsiyonel)
implementation("androidx.compose.material:material-icons-extended:1.6.8")
}

