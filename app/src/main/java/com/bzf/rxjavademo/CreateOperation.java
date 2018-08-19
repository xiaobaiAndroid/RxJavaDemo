package com.bzf.rxjavademo;

import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;

import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

/*创建操作符的使用*/
public class CreateOperation {

    /*按照给定的时间间隔发送连续的整数*/
    public void testInterval(){

        Disposable disposable = Observable.interval(3, TimeUnit.SECONDS
                , Schedulers.trampoline())//当其它排队的任务完成后，在当前线程排队开始执行
                .subscribe(new Consumer<Long>() {
                    @Override
                    public void accept(Long aLong) throws Exception {
                        LogUtils.printJava("interval：" + aLong.intValue());
                    }
                });

      //  disposable.dispose();//取消订阅
    }

    public void testRange() {

        Disposable disposable = Observable.range(0, 5)
                .subscribe(new Consumer<Integer>() {
                    @Override
                    public void accept(Integer integer) throws Exception {
                        LogUtils.printJava("range：" + integer.intValue());
                    }
                });
    }

    /*延迟两秒后，发送0值*/
    public void testTimer(){
        Disposable disposable = Observable.timer(2, TimeUnit.SECONDS,Schedulers.trampoline())
                .subscribe(new Consumer<Long>() {
                    @Override
                    public void accept(Long aLong) throws Exception {
                        LogUtils.printJava("timer：" + aLong.intValue());
                    }
                });
    }


}
