package com.example.zhoucen1.Molde;

import com.example.zhoucen1.ApiService;
import com.example.zhoucen1.Base.BaseData;
import com.example.zhoucen1.Base.DatasBean;
import com.example.zhoucen1.CallBack;
import com.example.zhoucen1.Presenter.MainPresenter;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainMolde {
    public void getData(CallBack callBack) {
        Retrofit build = new Retrofit.Builder()
                .baseUrl(ApiService.url)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();
        ApiService apiService = build.create(ApiService.class);
        Observable<BaseData> bean = apiService.bean();
        bean.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
               .subscribe(new Observer<BaseData>() {
                   @Override
                   public void onSubscribe(Disposable d) {

                   }

                   @Override
                   public void onNext(BaseData baseData) {
                        callBack.onSend(baseData.getData().getDatas());
                   }

                   @Override
                   public void onError(Throwable e) {

                   }

                   @Override
                   public void onComplete() {

                   }
               });
    }
}
