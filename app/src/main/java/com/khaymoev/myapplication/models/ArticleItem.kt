package com.khaymoev.myapplication.models

//      Заголовок, кнопка лайка, кол-во лайков, автор
data class ArticleItem (
    val title: String,
    val amountLike: Int,
    val author: String
)