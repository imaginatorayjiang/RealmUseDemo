package com.imaginato.realmusedemo.model

import io.realm.RealmList
import io.realm.RealmModel
import io.realm.RealmObject
import io.realm.annotations.PrimaryKey

/**
 * Created by Administrator on 2017/9/4.
 */
open class Student :RealmObject {
    @PrimaryKey
    var id="1"
    var name="";
    var age=0;
    var height=0;
    lateinit  var realmList :RealmList<Book>;



    constructor(name: String, age: Int, realmList: RealmList<Book>) {
        this.name = name
        this.age = age
        this.realmList = realmList
    }


    constructor() : super()
    constructor(id: String, name: String, age: Int, realmList: RealmList<Book>) : super() {
        this.id = id
        this.name = name
        this.age = age
        this.realmList = realmList
    }

    constructor(id: String, name: String, age: Int, height: Int, realmList: RealmList<Book>) : super() {
        this.id = id
        this.name = name
        this.age = age
        this.height = height
        this.realmList = realmList
    }

}