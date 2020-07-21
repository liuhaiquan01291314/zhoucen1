package com.example.zhoucen1.Presenter;

import com.example.zhoucen1.Base.BaseData;
import com.example.zhoucen1.Base.BasePresenter;
import com.example.zhoucen1.Base.DatasBean;
import com.example.zhoucen1.CallBack;
import com.example.zhoucen1.Molde.MainMolde;
import com.example.zhoucen1.View.MainView;

import java.util.List;

public class MainPresenter extends BasePresenter<MainView> implements CallBack {
    private MainMolde mMainModel;
    @Override
    protected void initMolde() {
       mMainModel=new MainMolde();
       addMolde(mMainModel);
    }


    @Override
    public void onSend(List<DatasBean> beans) {
          mView.bean(beans);
    }

    @Override
    public void OnFile(String str) {
   mView.ShouToast(str);
    }

    public void setdata() {
     mMainModel.getData(this);
    }
}
