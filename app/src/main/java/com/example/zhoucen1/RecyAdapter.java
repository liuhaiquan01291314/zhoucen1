package com.example.zhoucen1;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.zhoucen1.Base.BaseData;
import com.example.zhoucen1.Base.DatasBean;

import java.util.ArrayList;

public class RecyAdapter extends RecyclerView.Adapter {
    private ArrayList<DatasBean> beans;
    private Context context;

    public RecyAdapter(ArrayList<DatasBean> beans, Context context) {
        this.beans = beans;
        this.context = context;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.layout, null);
        return new ViewHandles(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
     ViewHandles viewHandles= (ViewHandles) holder;
     viewHandles.tv_niceData.setText(beans.get(position).getNiceDate());
     viewHandles.tv_shareDate.setText(beans.get(position).getShareDate()+"");
     viewHandles.tv_superChapterName.setText(beans.get(position).getSuperChapterName());
     viewHandles.tv_title.setText(beans.get(position).getTitle());
      viewHandles.iv_envelopePic.setImageResource(R.drawable.xing);
      viewHandles.itemView.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View v) {
              A.OnCreate(position);
          }
      });
    }

    @Override
    public int getItemCount() {
        return beans.size();
    }
    class ViewHandles extends RecyclerView.ViewHolder{
        private TextView tv_shareDate;
        private TextView tv_niceData;
        private TextView tv_title;
        private TextView tv_superChapterName;
        private ImageView iv_envelopePic;
        public ViewHandles(@NonNull View itemView) {
            super(itemView);
            tv_niceData=itemView.findViewById(R.id.tv_niceData);
            tv_shareDate=itemView.findViewById(R.id.tv_shareDate);
            tv_title=itemView.findViewById(R.id.tv_title);
            tv_superChapterName=itemView.findViewById(R.id.tv_superChapterName);
            iv_envelopePic=itemView.findViewById(R.id.iv_envelopePic);
        }
    }
    private Send A;

    public void setA(Send a) {
        A = a;
    }

    public interface Send{
        void OnCreate(int m);
    }
}
