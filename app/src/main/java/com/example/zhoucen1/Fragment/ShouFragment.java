package com.example.zhoucen1.Fragment;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.Toast;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.zhoucen1.Base.BaseData;
import com.example.zhoucen1.Base.BaseShouFragment;
import com.example.zhoucen1.Base.DatasBean;
import com.example.zhoucen1.BaseApp;
import com.example.zhoucen1.Presenter.MainPresenter;
import com.example.zhoucen1.R;
import com.example.zhoucen1.RecyAdapter;
import com.example.zhoucen1.View.MainView;
import com.example.zhoucen1.db.DatasBeanDao;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

/**
 * A simple {@link Fragment} subclass.
 */
public class ShouFragment extends BaseShouFragment<MainPresenter>implements MainView {

    @BindView(R.id.Recy)
    RecyclerView recy;
    private ArrayList<DatasBean> list;
    private RecyAdapter adapter;


    @Override
    protected void initListener() {

    }

    @Override
    protected void initView() {
        DatasBeanDao beanDao = BaseApp.getInstance().getDaoSession().getDatasBeanDao();
        recy.setLayoutManager(new LinearLayoutManager(getContext()));
     recy.addItemDecoration(new DividerItemDecoration(getContext(), LinearLayout.VERTICAL));
        list = new ArrayList<>();
        adapter = new RecyAdapter(list, getContext());
        recy.setAdapter(adapter);
        adapter.setA(new RecyAdapter.Send() {
            @Override
            public void OnCreate(int m) {
                DatasBean bean = list.get(m);
                list.remove(bean);
                 adapter.notifyDataSetChanged();
            }
        });
    }

    @Override
    protected void initData() {
     mPresenter.setdata();
    }

    @Override
    protected void initPresenter() {
      mPresenter=new MainPresenter();
    }

    @Override
    protected int initLayout() {
        return R.layout.fragment_shou;
    }

    @Override
    public void ShouToast(String str) {
        Toast.makeText(getActivity(), str, Toast.LENGTH_SHORT).show();
    }


    @Override
    public void bean(List<DatasBean> Listbeans) {
        list.addAll(Listbeans);
        adapter.notifyDataSetChanged();
    }
}
