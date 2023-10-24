package baseball.util

fun String.toIntList(): List<Int> =
    this.map { char ->
        val current = char.toString()
        if (!current.isInt()) {
            throw IllegalArgumentException("Int 타입이 아님")
        }
        current.toInt()
    }

/**
 * @param includeSign 기호를 포함하여 검사할 건지 여부
 * */
fun String.isInt(includeSign: Boolean = true): Boolean {
    if (includeSign && containsSign()) {
        return false
    }

    return this.toIntOrNull() != null
}

fun String.removeSign(): String {
    if (containsSign()) {
        return this.substring(1)
    }
    return this
}

fun String.containsSign(): Boolean =
    listOf('+', '-').contains(this.getOrNull(0)) ?: false