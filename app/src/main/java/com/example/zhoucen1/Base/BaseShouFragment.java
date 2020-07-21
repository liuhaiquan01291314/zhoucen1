package com.example.zhoucen1.Base;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.zhoucen1.R;

import butterknife.ButterKnife;
import butterknife.Unbinder;

public abstract class BaseShouFragment<P extends BasePresenter> extends Fragment implements BaseView {
    public P mPresenter;
    private Unbinder unbinder;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(initLayout(), container, false);
        unbinder = ButterKnife.bind(this, view);
        initPresenter();
        if(mPresenter!=null){
            mPresenter.BindView(this);
        }
        initData();
        initView();
        initListener();
        return view;

    }

    protected abstract void initListener();

    protected abstract void initView();

    protected abstract void initData();

    protected abstract void initPresenter();

    protected abstract int initLayout();
}
