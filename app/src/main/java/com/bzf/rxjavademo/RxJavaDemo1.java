package com.bzf.rxjavademo;

import android.util.Log;

import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.subjects.PublishSubject;

public class RxJavaDemo1 {

    public void rxJavaTest1(){

        //创建观察者
        Observer<String> observer = new Observer<String>() {
            @Override
            public void onSubscribe(Disposable d) {
                LogUtils.printJava("onSubscribe-----");
            }

            @Override
            public void onNext(String s) {
                LogUtils.printJava(s);
            }

            @Override
            public void onError(Throwable e) {
                LogUtils.printJava(e.getMessage());
            }

            @Override
            public void onComplete() {
                LogUtils.printJava("onComplete------");
            }
        };

        //创建被观察者
        Observable<String> observable = Observable.create(new ObservableOnSubscribe<String>() {
            @Override
            public void subscribe(ObservableEmitter<String> emitter) throws Exception {
                emitter.onNext("Android");
                emitter.onNext("IOS");
                emitter.onComplete();

                emitter.onNext("C++");
            }
        });

        //订阅
        observable.subscribe(observer);

    }

    public void rxJavaTest2(){
        Observer<String> observer = new Observer<String>() {
            @Override
            public void onSubscribe(Disposable d) {
                LogUtils.printJava("onSubscribe-----");
            }

            @Override
            public void onNext(String s) {
                LogUtils.printJava(s);
            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onComplete() {
                LogUtils.printJava("onComplete------");
            }
        };

        Observable<String> observable = Observable.just("Android", "IOS");

        observable.subscribe(observer);
    }


    public void rxJavaTest3(){

        Consumer<String> onNext = new Consumer<String>() {
            @Override
            public void accept(String s) throws Exception {
                LogUtils.printJava(s);
            }
        };

        Consumer<Throwable> onError = new Consumer<Throwable>() {
            @Override
            public void accept(Throwable throwable) throws Exception {
                LogUtils.printJava(throwable.getMessage());
            }
        };

        Observable<String> observable = Observable.just("Android", "IOS");

        observable.subscribe(onNext,onError);

    }
}
