package com.bzf.rxjavademo;

import com.bzf.rxjavademo.entity.Swordsman;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import io.reactivex.observables.GroupedObservable;

/*变换操作符示例*/
public class ConversionOperation {

    final String Host = "http://blog.csdn.net/";

    public void testMap(){


        Disposable disposable = Observable.just("itachi85").map(new Function<String, String>() {
            @Override
            public String apply(String s) throws Exception {
                return Host+s;
            }
        }).subscribe(new Consumer<String>() {
            @Override
            public void accept(String url) throws Exception {
                LogUtils.printJava(url);
            }
        });
    }

    /*flatmap发送事件的顺序可能会交错*/
    public void testFlatMap(){
        List<String> list =new ArrayList<>();
        list.add("itachi85");
        list.add("itachi86");
        list.add("itachi87");
        list.add("itachi88");
        list.add("itachi89");
        list.add("itachi90");
        list.add("itachi91");
        list.add("itachi92");
        list.add("itachi93");

        Disposable disposable = Observable.fromIterable(list).flatMap(new Function<String, ObservableSource<String>>() {
            @Override
            public ObservableSource<String> apply(String s) throws Exception {
                return Observable.just(s);
            }
        }).cast(String.class).subscribe(new Consumer<String>() {
            @Override
            public void accept(String s) throws Exception {
                LogUtils.printJava(s);
            }
        });

    }

    /*concatMap解决了flatMap发送顺序问题，也就是事件一定会按顺序发送*/
    public void testConcatMap(){
        List<String> list =new ArrayList<>();
        list.add("itachi85");
        list.add("itachi86");
        list.add("itachi87");
        list.add("itachi88");
        list.add("itachi89");
        list.add("itachi90");
        list.add("itachi91");
        list.add("itachi92");
        list.add("itachi93");

        Disposable disposable = Observable.fromIterable(list).concatMap(new Function<String, ObservableSource<String>>() {
            @Override
            public ObservableSource<String> apply(String s) throws Exception {
                return Observable.just(s);
            }
        }).subscribe(new Consumer<String>() {
            @Override
            public void accept(String s) throws Exception {
                LogUtils.printJava(s);
            }
        });

      //  disposable.dispose();
    }


    /*根据给定的条件进行分组*/
    public void testGroupBy(){
        Swordsman swordsman1 = new Swordsman("韦一笑", "A");
        Swordsman swordsman2 = new Swordsman("张三丰", "ss");
        Swordsman swordsman3 = new Swordsman("周芷若", "s");
        Swordsman swordsman4 = new Swordsman("宋远桥", "s");
        Swordsman swordsman5 = new Swordsman("殷梨亭", "A");
        Swordsman swordsman6 = new Swordsman("张无忌", "ss");
        Swordsman swordsman7 = new Swordsman("鹤笔翁", "s");
        Swordsman swordsman8 = new Swordsman("宋青书", "A");

        Observable<GroupedObservable<String, Swordsman>> observable = Observable.just(swordsman1, swordsman2, swordsman3, swordsman4, swordsman5, swordsman6, swordsman7, swordsman8)
                .groupBy(new Function<Swordsman, String>() {
                    @Override
                    public String apply(Swordsman swordsman) throws Exception {
                        return swordsman.getLevel();//根据等级进行分组
                    }
                });

        Disposable disposable = Observable.concat(observable).subscribe(new Consumer<Swordsman>() {
            @Override
            public void accept(Swordsman swordsman) throws Exception {
                LogUtils.printJava(swordsman.getName()+"--"+swordsman.getLevel());
            }
        });

//        disposable.dispose();
    }

}
