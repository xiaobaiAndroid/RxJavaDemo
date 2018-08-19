package com.bzf.rxjavademo;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.subjects.PublishSubject;

/*Subject是连接Observer和Observable*/
public class Subject {

    public void test1(){

        Observer<String> observer = new Observer<String>() {
            @Override
            public void onSubscribe(Disposable d) {
                LogUtils.printJava("onSubscribe----");
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
                LogUtils.printJava("onComplete--------");
            }
        };

        Observable<String> observable = PublishSubject.just("android", "IOS");

        observable.subscribe(observer);

    }

}
