package com.example.zhoucen1.Base;

import com.example.zhoucen1.Molde.MainMolde;

import java.util.ArrayList;

public abstract class BasePresenter<V extends BaseView>{
    public V mView;
        public ArrayList<MainMolde> moldes=new ArrayList<MainMolde>();
        public BasePresenter(){
            initMolde();
    }
    public void addMolde(MainMolde molde){
          moldes.add(molde);
    }
    public void BindView(V view){
      this.mView=view;
    }
    protected abstract void initMolde();
}
