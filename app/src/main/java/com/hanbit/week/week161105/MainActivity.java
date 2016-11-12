package com.hanbit.week.week161105;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.hanbit.week.week161105.calc.calcActivity;
import com.hanbit.week.week161105.member.JoinActivity;
import com.hanbit.week.week161105.member.LoginActivity;

public class MainActivity extends AppCompatActivity  implements View.OnClickListener{

    Button calc;
    Button join;
    Button login;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        calc = (Button) findViewById(R.id.Calc);
        join = (Button) findViewById(R.id.Join);
        login = (Button) findViewById(R.id.login);

        calc.setOnClickListener(this);
        join.setOnClickListener(this);
        login.setOnClickListener(this);


        // 이벤트 리스너 등록
    }

    @Override
    public void onClick(View v) { // v : 로컬변수

        // local variable initialize
        Intent intent;
        switch (v.getId()){
            case R.id.Calc :
                // 시작하는 위치, 가야하는 클래스
                intent = new Intent(this.getApplicationContext(), calcActivity.class);
                this.startActivity(intent);
                break;
            case R.id.Join :
                intent = new Intent(this.getApplicationContext(), JoinActivity.class);
                this.startActivity(intent);
                break;
            case R.id.login:
                intent = new Intent(this.getApplicationContext(), LoginActivity.class);
                this.startActivity(intent);
                break;
        }



    }
}
