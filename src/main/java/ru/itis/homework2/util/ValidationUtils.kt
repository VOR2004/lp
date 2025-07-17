package ru.itis.homework2.util
object ValidationUtils {
    fun isEmail(text: CharSequence?) = text != null && android.util.Patterns.EMAIL_ADDRESS.matcher(text).matches()
}
