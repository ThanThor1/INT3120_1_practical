package com.example.lunchtray.datasource


enum class Screen(
    val title: String,
    val canGoBack: Boolean = true
) {
    START(
        title = "Lunch Tray",
        canGoBack = false
    ),
    ENTREE(
        title = "Choose Entree"
    ),
    SIDE_DISH(
        title = "Choose Side Dish"
    ),
    ACCOMPANIMENT(
        title = "Choose Accompaniment"
    ),
    CHECKOUT(
        title = "Order Checkout"
    );

    companion object {
        fun getNextScreen(currentScreen: Screen): Screen? {
            return when (currentScreen) {
                START -> ENTREE
                ENTREE -> SIDE_DISH
                SIDE_DISH -> ACCOMPANIMENT
                ACCOMPANIMENT -> CHECKOUT
                CHECKOUT -> null // Kết thúc flow
            }
        }
        fun getPreviousScreen(currentScreen: Screen): Screen? {
            return when (currentScreen) {
                START -> null
                ENTREE -> START
                SIDE_DISH -> ENTREE
                ACCOMPANIMENT -> SIDE_DISH
                CHECKOUT -> ACCOMPANIMENT
            }
        }
    }
}