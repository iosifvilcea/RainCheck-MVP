package blankthings.raincheckmvp.net.data

import com.google.gson.annotations.SerializedName

class OpenWeather {

    @SerializedName("cod")
    var cod: String? = null

    @SerializedName("message")
    var message: Double = 0.toDouble()

    @SerializedName("cnt")
    var cnt: Int = 0

    @SerializedName("list")
    var list: List<ResultList>? = null
        private set

    @SerializedName("city")
    var city: City? = null

    fun setResultList(resultList: List<ResultList>) {
        this.list = resultList
    }

}