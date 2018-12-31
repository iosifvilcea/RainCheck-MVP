package blankthings.raincheckmvp.net.api

import blankthings.raincheckmvp.BuildConfig
import blankthings.raincheckmvp.net.data.OpenWeather
import blankthings.raincheckmvp.net.data.Photo
import io.reactivex.Observable
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {

    companion object {

        private const val BASE_URL = "https://api.openweathermap.org"

        fun create() : ApiService {
            val retrofit = Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()

            return retrofit.create(ApiService::class.java)
        }
    }

    @GET("/photos")
    fun getPhotos() : Observable<List<Photo>>

    @GET("/data/2.5/forecast")
    fun get5DayForecast(
            @Query("zip") zip : String,
            @Query("appid") appId : String = BuildConfig.OWM_API): Observable<OpenWeather>


}