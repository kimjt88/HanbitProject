package com.hanbit.week.week161105.member;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.hanbit.week.week161105.R;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {
    MemberService service;

    EditText et_id,et_pass;
    Button bt_submit2,bt_cencel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        service = new MemberServiceImpl(this.getApplicationContext());
        et_id = (EditText) findViewById(R.id.et_id);
        et_pass = (EditText) findViewById(R.id.et_pass);

        bt_submit2 = (Button) findViewById(R.id.bt_submit2);
        bt_cencel = (Button) findViewById(R.id.bt_cencel);

        bt_submit2.setOnClickListener(this);
        bt_cencel.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {


        switch(v.getId()){
            case R.id.bt_submit2 :

                MemberDTO param = new MemberDTO();

                param.setId(et_id.getText().toString());
                param.setPw(et_pass.getText().toString());

                if(service.login(param)){
                    Toast.makeText(LoginActivity.this, "로그인성공",Toast.LENGTH_LONG).show();
                }else{
                    Toast.makeText(LoginActivity.this, "로그인실패",Toast.LENGTH_LONG).show();
                }
                break;
            case R.id.bt_cencel :

                break;
        }

    }
}
