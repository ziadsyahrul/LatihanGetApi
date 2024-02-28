import android.content.Context
import com.chuckerteam.chucker.api.ChuckerInterceptor
import com.ndp.latihangetapi.GameApiService
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import com.squareup.okhttp.logging.HttpLoggingInterceptor

object RetrofitClient {
    private const val BASE_URL = "https://api.rawg.io/api/"

    fun create(context: Context): GameApiService {
        val loggingInterceptor = HttpLoggingInterceptor()
        loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY)

        val httpClient = OkHttpClient.Builder()
            .addInterceptor(ChuckerInterceptor(context))
            .build()

        val retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .client(httpClient)
            .build()

        return retrofit.create(GameApiService::class.java)
    }
}
