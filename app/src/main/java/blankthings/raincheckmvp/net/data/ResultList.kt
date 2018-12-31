package blankthings.raincheckmvp.net.data

import com.google.gson.annotations.SerializedName

class ResultList {

    @SerializedName("dt")
    var timeOfDataForecasted: Int = 0

    @SerializedName("main")
    var main: Main? = null

    @SerializedName("weather")
    var weather: List<Weather>? = null

    @SerializedName("clouds")
    var clouds: Clouds? = null

    @SerializedName("wind")
    var wind: Wind? = null

    @SerializedName("dt_txt")
    var date: String? = null

    @SerializedName("rain")
    var rain: Rain? = null

    @SerializedName("snow")
    var snow: Snow? = null

}
