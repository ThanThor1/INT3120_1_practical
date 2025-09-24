open class Phone(var isScreenLightOn: Boolean = false) {
    open fun switchOn() {
        isScreenLightOn = true
    }

    open fun switchOff() {
        isScreenLightOn = false
    }

    fun checkPhoneScreenLight() {
        val phoneScreenLight = if (isScreenLightOn) "on" else "off"
        println("The phone screen's light is $phoneScreenLight.")
    }
}

open class FoldablePhone(isScreenLightOn: Boolean = false, var isFolded: Boolean = false) : Phone(isScreenLightOn) {
    override fun switchOn() {
        isScreenLightOn = !isFolded
    }

    fun fold() {
        isFolded = true
    }

    fun unfold() {
        isFolded = false
    }
}