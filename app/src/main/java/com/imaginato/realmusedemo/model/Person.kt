package com.imaginato.realmusedemo.model

import io.realm.RealmObject
import io.realm.annotations.PrimaryKey

/**
 * Created by Administrator on 2017/9/4.
 */
open class Person  :RealmObject(){
     @PrimaryKey
     var id=""
     var name:String?=null
}