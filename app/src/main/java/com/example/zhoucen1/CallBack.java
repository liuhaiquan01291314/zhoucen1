package com.example.zhoucen1;

import com.example.zhoucen1.Base.BaseData;
import com.example.zhoucen1.Base.DatasBean;

import java.util.List;

public interface CallBack {
    void onSend(List<DatasBean> beans);
    void OnFile(String str);
}
