package com.hanbit.week.week161105.member;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.hanbit.week.week161105.R;

import java.util.ArrayList;

/**
 * Created by 1027 on 2016-11-19.
 */
// BaseAdapter 익스텐즈 한다.
// 업뎁터가 필요한 인스턴스 두개
public class MemberAdapter extends BaseAdapter{
    ArrayList<MemberDTO> list;
    LayoutInflater inflater;
    private int[] photos = {
            R.drawable.cupcake,
            R.drawable.donut,
            R.drawable.eclair,
            R.drawable.froyo,
            R.drawable.gingerbread,
            R.drawable.honeycomb,
            R.drawable.icecream,
            R.drawable.jellybean,
            R.drawable.kitkat,
            R.drawable.lollipop
    };

    // 어뎁터의 클래스를 엑티비티로 불러야한다.
    public MemberAdapter(Context context, ArrayList<MemberDTO> list) {

        this.list = list;
        this.inflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {

        return list.size();
    }

    @Override
    public Object getItem(int i) {

        return list.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View v, ViewGroup g) {
        ViewHolder holder;
        if(v==null){
            v = inflater.inflate(R.layout.member_list,null);
            holder = new ViewHolder();
            holder.ivPhoto = (ImageView) v.findViewById(R.id.iv_photo);
            holder.tvName = (TextView) v.findViewById(R.id.tv_name);
            holder.tvPhone = (TextView) v.findViewById(R.id.tv_phone);
            v.setTag(holder);;
        }else{
            holder = (ViewHolder) v.getTag();
        }
        Log.d("Adapter Checked Name : ",list.get(i).getName());
        holder.ivPhoto.setImageResource(photos[i]);
        holder.tvName.setText(list.get(i).getName());
        holder.tvPhone.setText(list.get(i).getPhone());
        return v;
    }

    //이너 클래스
    static class ViewHolder{
        ImageView ivPhoto;
        TextView tvName;
        TextView tvPhone;
    }
}
