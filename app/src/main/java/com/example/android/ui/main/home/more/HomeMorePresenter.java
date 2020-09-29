package com.example.android.ui.main.home.more;

import com.example.android.base.BasePresenter;
import com.example.android.base.IModel;

import java.util.concurrent.TimeUnit;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

/**
 * Author:      xxbi
 * Create Date: Created in 2020/9/25 16:42
 * Update Date:
 * Modified By:
 * Description:
 */
public class HomeMorePresenter extends BasePresenter<IHomeMoreView, IModel> {
    public void getData() {
        Disposable disposable = Observable.interval(1, TimeUnit.SECONDS)
                .take(1)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<Long>() {
                    @Override
                    public void accept(Long aLong) throws Exception {
                        getView().requestDataSuccess();
                    }
                });
        addDisposable(disposable);
    }
}
