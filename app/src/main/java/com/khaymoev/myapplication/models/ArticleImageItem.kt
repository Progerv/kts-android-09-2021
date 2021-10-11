package com.khaymoev.myapplication.models

import java.util.*

//      Заголовок, изображение (заглушка), автор
data class ArticleImageItem (
    val title: String,
    val uuid: UUID,
    val author: String
)