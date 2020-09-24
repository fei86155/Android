package com.example.android.base;

import com.trello.rxlifecycle2.LifecycleProvider;

import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;

/**
 * Author:      xxbi
 * Create Date: Created in 2020/9/24 9:50
 * Update Date:
 * Modified By:
 * Description:
 */
public abstract class BasePresenter<V extends IView, M extends IModel> {
    private V mView;
    private M mModel;

    private CompositeDisposable compositeDisposable;

    public void attachView(V mView) {
        this.mView = mView;
    }

    public V getView() {
        return mView;
    }

    public void detachView() {
        mView = null;
    }

    protected  <T> LifecycleProvider<T> getLifecycleProvider() { //可以自定义T然后使用，否则只能使用泛型类初始化时的V和M
        LifecycleProvider<T> lifecycleProvider = null;
        if (mView != null && mView instanceof LifecycleProvider) {
            lifecycleProvider = (LifecycleProvider<T>)mView;
        }
        return lifecycleProvider;
    }

    protected void addDisposable(Disposable disposable) {
        if (compositeDisposable == null) {
            compositeDisposable = new CompositeDisposable();
        }
        compositeDisposable.add(disposable);
    }

    protected void clearDisposable() {
        if (compositeDisposable != null) {
            compositeDisposable.clear();
        }

    }
}
