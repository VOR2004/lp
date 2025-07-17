package ru.itis.homework2.data

import java.io.Serializable

data class ModelItem(
    val id: Int,
    var imageRes: Int,
    val title: String,
    val description: String
) : Serializable
