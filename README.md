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
