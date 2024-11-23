package racingcar

data class Car(
    val name: String,
    var distance: Int = 0,
) {
    fun move() {
        distance += 1
    }
}