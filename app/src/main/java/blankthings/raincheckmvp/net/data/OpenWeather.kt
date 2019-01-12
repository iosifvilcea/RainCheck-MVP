package blankthings.raincheckmvp.net.data

import com.google.gson.annotations.SerializedName

class OpenWeather {

    @SerializedName("cod")
    var cod: String? = null

    @SerializedName("message")
    var message: Double = 0.0

    @SerializedName("cnt")
    var numberOfLinesReturnedByApi: Int = 0

    @SerializedName("list")
    var list: List<ResultList>? = null
        private set

    @SerializedName("city")
    var city: City? = null

}