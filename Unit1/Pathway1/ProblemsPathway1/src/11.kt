fun main() {
    val cityName = "Ha Noi"
    val lowTemperature = 25
    val highTemperature = 30
    val chanceOfRain = 10
    printNotification(cityName,lowTemperature,highTemperature,chanceOfRain)
}

fun printNotification(cityName: String,lowTemperature: Int,highTemperature: Int,chanceOfRain: Int){
    print(
        "City: $cityName\n" +
                "Low temperature: $lowTemperature, High temperature: $highTemperature\n" +
                "Chance of rain: $chanceOfRain%"
    )
}