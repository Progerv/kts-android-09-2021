package com.khaymoev.myapplication.models

import java.util.*

//      Заголовок, кнопка лайка, кол-во лайков, автор
data class ArticleItem(
    val title: String,
    val amountLike: Int,
    val author: String,
    val uuid: UUID,
    val email: String = ""
)