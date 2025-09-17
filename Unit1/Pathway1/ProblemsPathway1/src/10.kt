fun main() {
    val timeSpentToday = 500
    val timeSpentYesterday = 400

    if (isTimeSpentMoreToday(timeSpentToday, timeSpentYesterday)){
        print("Today you spent more time")
    }
}
fun isTimeSpentMoreToday(timeSpentToday: Int,timeSpentYesterday: Int ): Boolean{
    return (timeSpentToday > timeSpentYesterday)
}