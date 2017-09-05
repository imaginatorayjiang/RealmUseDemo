package com.imaginato.realmusedemo

import android.util.Log
import io.realm.DynamicRealm
import io.realm.FieldAttribute
import io.realm.RealmMigration
import io.realm.RealmSchema
/**
 * Created by Administrator on 2017/9/4.
 */
class FirstMigration : RealmMigration{
    override fun migrate(realm: DynamicRealm?, oldVersion: Long, newVersion: Long) {
        val realmSchma:RealmSchema ? =realm?.schema;
        var copyOrder=oldVersion;
        Log.i("ray","newVersion:"+newVersion)
        Log.i("ray","oldVersion:"+oldVersion)
//        if(copyOrder==1L){
//            realmSchma?.get("Student")?.addField("height",Int::class.java)
//            copyOrder++
//        }
        if(copyOrder==1L){
            realmSchma?.create("Person")?.addField("id",String::class.java,
                    FieldAttribute.PRIMARY_KEY,FieldAttribute.REQUIRED)
                    ?.addField("name",String::class.java)
        }
    }
}