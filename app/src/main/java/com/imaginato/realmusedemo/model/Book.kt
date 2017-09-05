package com.imaginato.realmusedemo.model

import io.realm.RealmModel
import io.realm.RealmObject
import io.realm.annotations.PrimaryKey

/**
 * Created by Administrator on 2017/9/4.
 */
open class Book : RealmObject {
    @PrimaryKey
    var bookName=""
    var bookDesc=""
    constructor(bookName: String, bookDesc: String) {
        this.bookName = bookName
        this.bookDesc = bookDesc
    }
     constructor() : super()
}