package com.imaginato.realmusedemo

import android.app.Application
import com.imaginato.realmusedemo.model.RealmUserModel
import io.realm.Realm
import io.realm.RealmConfiguration
import io.realm.RealmObject
import io.realm.annotations.RealmModule

/**
 * Created by Administrator on 2017/9/4.
 */
class MyApplication :Application() {
    override fun onCreate() {
        super.onCreate()
        Realm.init(this)

//        var realmConfig=RealmConfiguration.Builder()
//                .schemaVersion(2)
//                .migration(FirstMigration())
////                .deleteRealmIfMigrationNeeded()
//                .modules(RealmUserModel())
//                .build()
//        Realm.setDefaultConfiguration(realmConfig);
    }
}