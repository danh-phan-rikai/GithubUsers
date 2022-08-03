package danhpd.github.users.data.api

import danhpd.github.users.data.models.User
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiInterface {
    @GET("users")
    fun getUsers(@Query("per_page") size: Int) : Call<List<User>>

    companion object {

        private var BASE_URL = "https://api.github.com/"

        fun create() : ApiInterface {
            val retrofit = Retrofit.Builder()
                    .addConverterFactory(GsonConverterFactory.create())
                    .baseUrl(BASE_URL)
                    .build()
            return retrofit.create(ApiInterface::class.java)
        }
    }

}