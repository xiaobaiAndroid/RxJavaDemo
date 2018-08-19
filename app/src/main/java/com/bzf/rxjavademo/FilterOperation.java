package com.bzf.rxjavademo;

import io.reactivex.Observable;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Predicate;

/*过滤操作符测试*/
public class FilterOperation {

    public void testFilter(){
        Observable.just(1,2,3,4).filter(new Predicate<Integer>() {
            @Override
            public boolean test(Integer integer) throws Exception {
                return integer>2;
            }
        }).subscribe(new Consumer<Integer>() {
            @Override
            public void accept(Integer integer) throws Exception {
                LogUtils.printJava(integer.toString());
            }
        });
    }

}
