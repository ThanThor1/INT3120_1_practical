
//1 và 2
data class Event(
    val title: String,
    val description: String? = null,
    val daypart: Daypart,
    val durationInMinutes: Int,
)
enum class Daypart {
    MORNING,
    AFTERNOON,
    EVENING,
}

fun main() {
    val event1 = Event(
        title = "Wake up", description = "Time to get up",
        daypart = Daypart.MORNING, durationInMinutes = 0
    )
    val event2 = Event(
        title = "Eat breakfast", daypart = Daypart.MORNING,
        durationInMinutes = 15
    )
    val event3 = Event(
        title = "Learn about Kotlin", daypart = Daypart.AFTERNOON,
        durationInMinutes = 30
    )
    val event4 = Event(
        title = "Practice Compose", daypart = Daypart.AFTERNOON,
        durationInMinutes = 60
    )
    val event5 = Event(
        title = "Watch latest DevBytes video", daypart = Daypart.AFTERNOON,
        durationInMinutes = 10
    )
    val event6 = Event(
        title = "Check out latest Android Jetpack library", daypart = Daypart.EVENING,
        durationInMinutes = 45
    )
    //cau3
    val events = mutableListOf<Event>(event1, event2, event3, event4, event5, event6)
//cau4
    val shortEvents = mutableListOf<Event>()
    for (event in events) {
        if (event.durationInMinutes < 60) {
            shortEvents.add(event)
        }
    }
    println("You have ${shortEvents.size} short events.")
    //cau 5
    val grouped = events.groupBy { it.daypart }
    grouped.forEach { (daypart, events) ->
        println("$daypart: ${events.size} events")
    }
    //cau 6
    println("Last event of the day: ${events.last().title}")
    println("Duration of first event: ${events[0].durationOfEvent}")
    
}
//cau7
val Event.durationOfEvent: String
    get() = if (durationInMinutes < 60) "short" else "long"

fun

object : Object {
    
}