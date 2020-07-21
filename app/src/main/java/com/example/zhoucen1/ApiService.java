package com.example.zhoucen1;


import com.example.zhoucen1.Base.BaseData;
import com.example.zhoucen1.Base.DatasBean;

import io.reactivex.Observable;
import okhttp3.ResponseBody;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface ApiService {

    String url = "https://www.wanandroid.com/";
    @GET("project/list/1/json?cid=294")
    Observable<BaseData> bean();

}
