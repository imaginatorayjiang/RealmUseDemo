package com.imaginato.realmusedemo

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.imaginato.realmusedemo.model.Book
import com.imaginato.realmusedemo.model.Person
import com.imaginato.realmusedemo.model.Student
import io.realm.*
import rx.Observable
import rx.Scheduler
import rx.android.schedulers.AndroidSchedulers
import rx.schedulers.Schedulers
import java.util.concurrent.Callable

class MainActivity : AppCompatActivity() {
    lateinit var  realm:Realm;
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val lisiStudent=getLiSi();
        val  zhangsanStudent=getZhangsan()
        val wangwuStudent1=getWangwu2()
//        realm= Realm.getDefaultInstancesyncConfig
//        realm.executeTransaction({
//            realm ->
//            realm.copyToRealmOrUpdate(lisiStudent)
//            realm.copyToRealmOrUpdate(zhangsanStudent)
//            realm.copyToRealmOrUpdate(wangwuStudent1)
//        })
//        realm.executeTransactionAsync({
//            realm ->
//            Log.i("ray","AsyncThread:"+Thread.currentThread())
//        },{
//            Log.i("ray","AnyncSuccess:"+Thread.currentThread())
//        },{
//            error ->
//        })
//       var studentResult: RealmResults<Student>? =realm.where(Student::class.java)
//               .findAllAsync()
//            studentResult?.load()
//            studentResult = if (studentResult != null) studentResult.sort("name", Sort.DESCENDING) else null
//            studentResult?.forEach { student: Student? ->
//                Log.i("ray", "student:" + student?.name)
//            }
//            studentResult?.addChangeListener { t: RealmResults<Student>? ->
//                Log.i("ray", "resultCount:" + t?.size)
//            }
//            realm.executeTransaction({ realm ->
//                studentResult?.get(1)?.deleteFromRealm()
//            })
//            realm.executeTransaction({ realm ->
//                realm.copyToRealmOrUpdate(getWangwu())
//            })
//        val  person =Person()
//        person.id="1";
////        person.name="2"
//        realm.executeTransaction({
//            realm ->
//            realm.copyToRealmOrUpdate(person)
//        })
        Observable.fromCallable(Callable<SyncConfiguration>{
            val myCredentials: SyncCredentials = SyncCredentials.usernamePassword("ray.jiang@imaginato.com",
                    "rayjiang888", false)
            val user = SyncUser.login(
                    myCredentials,
                    "http://192.168.11.51:9080/auth");
            val syncConfig = SyncConfiguration.Builder(user, "realm://192.168.11.51:9080/first/default")
                    .build();
            syncConfig.shouldDeleteRealmIfMigrationNeeded()
            return@Callable syncConfig

        }).observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe ({
                  t ->
                    realm=Realm.getInstance(t);
                    realm?.executeTransaction({
                        realm ->
                        val wangwu=getLiSi()
                        realm.copyToRealmOrUpdate(wangwu)
                    })
                },{
                    t ->
                    Log.i("ray","error:${t.message}")
                })
    }
    fun  getLiSi() :Student{
        val book=Book("english","englist");
        val yuwen=Book("yuwen","yuwen")
        val realmList=RealmList<Book>();
        realmList.add(book)
        realmList.add(yuwen)
        val student=Student("lisi",13,realmList);
        return student
    }
    fun  getZhangsan(): Student{
        val book=Book("shuxue","shuxue");
        val yuwen=Book("wuli","wuli")
        val realmList=RealmList<Book>();
        realmList.add(book)
        realmList.add(yuwen)
        val student=Student("2","zhangsan",13,175,realmList);
        return student
    }
    fun  getWangwu(): Student{
        val book=Book("meixu","meishu")
        val yuwen=Book("yinyue","yinyue")
        val realmList=RealmList<Book>();
        realmList.add(book)
        realmList.add(yuwen)
        val student=Student("3","wangwu",13,realmList);
        return student
    }
    fun  getWangwu2(): Student{
        val book=Book("meixu","meishu")
        val yuwen=Book("yinyue","yinyue")
        val realmList=RealmList<Book>();
        realmList.add(book)
        realmList.add(yuwen)
        val student=Student("4","wangwu2",13,realmList);
        return student
    }
}
