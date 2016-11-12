package com.hanbit.week.week161105.member;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.hanbit.week.week161105.R;



public class DetailActivity extends AppCompatActivity {
    MemberService service;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        service = new MemberServiceImpl(this.getApplicationContext());
        //Activity가 service를 만들때 자신의 컨텍스트를 건내줘야함
        // 인스턴스에 맥락을 주게되는 것임
    }
}
