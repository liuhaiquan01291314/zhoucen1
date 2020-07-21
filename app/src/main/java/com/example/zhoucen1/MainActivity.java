package com.example.zhoucen1;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.FragmentManager;

import com.example.zhoucen1.Fragment.ChangFragment;
import com.example.zhoucen1.Fragment.GongFragment;
import com.example.zhoucen1.Fragment.ShouFragment;
import com.example.zhoucen1.Fragment.TiFragment;
import com.google.android.material.tabs.TabLayout;

public class MainActivity extends AppCompatActivity {

    /**
     * 首页
     */
    private TextView mShou;
    private Toolbar mTool;
    private TabLayout mTab;
    private FragmentManager manager;
    private ShouFragment shouFragment;
    private ChangFragment changFragment;
    private GongFragment gongFragment;
    private TiFragment tiFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    private void initView() {
        mShou = (TextView) findViewById(R.id.shou);
        mTool = (Toolbar) findViewById(R.id.Tool);
        mTool.setTitle("");
        setSupportActionBar(mTool);
        mTab = (TabLayout) findViewById(R.id.Tab);
        manager = getSupportFragmentManager();
        shouFragment = new ShouFragment();
        changFragment = new ChangFragment();
        gongFragment = new GongFragment();
        tiFragment = new TiFragment();
        mTab.addTab(mTab.newTab().setText("首页").setIcon(R.drawable.deng));
        mTab.addTab(mTab.newTab().setText("广场").setIcon(R.drawable.deng));
        mTab.addTab(mTab.newTab().setText("公众号").setIcon(R.drawable.deng));
        mTab.addTab(mTab.newTab().setText("体系").setIcon(R.drawable.deng));
        manager.beginTransaction().add(R.id.frage,shouFragment).add(R.id.frage,changFragment).add(R.id.frage,gongFragment).add(R.id.frage,tiFragment).hide(changFragment).hide(gongFragment).hide(tiFragment).commit();
        mTab.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                 switch (tab.getPosition()){
                     case 0:
                         manager.beginTransaction().show(shouFragment).hide(changFragment).hide(gongFragment).hide(tiFragment).commit();
                         break;
                     case 1:
                         manager.beginTransaction().show(changFragment).hide(shouFragment).hide(gongFragment).hide(tiFragment).commit();
                         break;
                     case 2:
                         manager.beginTransaction().show(gongFragment).hide(changFragment).hide(shouFragment).hide(tiFragment).commit();
                         break;
                     case 3:
                         manager.beginTransaction().show(tiFragment).hide(changFragment).hide(gongFragment).hide(shouFragment).commit();
                         break;
                 }
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
    }
}
