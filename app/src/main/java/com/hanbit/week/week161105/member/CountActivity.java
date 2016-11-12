package com.hanbit.week.week161105.member;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.hanbit.week.week161105.R;

public class CountActivity extends AppCompatActivity {
    MemberService service;

    //MemberService service = new MemberServiceImpl();
    // 필드는 속성을 정의 할 뿐 동작을 실행하지 않는다.
    // OOP 는 속성과 기능의 정의를 분할한다.
    // 서비스는 모든 에어리어에서 사용해야하기때문에 필드변수로 선언


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_count);

        service = new MemberServiceImpl(this.getApplicationContext());



    }




}
