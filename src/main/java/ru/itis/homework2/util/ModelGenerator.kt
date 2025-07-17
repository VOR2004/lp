package ru.itis.homework2.util
import ru.itis.homework2.data.ModelItem
import kotlin.random.Random

fun generateModels(count: Int): List<ModelItem> = List(count) { index ->
    ModelItem(index, Constants.IMAGE_LIST.random(), "Кот ${index+1}", "Описание кота ${index+1}")
}
