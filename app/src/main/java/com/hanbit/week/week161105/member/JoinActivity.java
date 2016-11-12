package com.hanbit.week.week161105.member;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.hanbit.week.week161105.R;

public class JoinActivity extends AppCompatActivity implements View.OnClickListener {
    MemberService service;
    EditText et_id,et_pass,et_name,et_email,et_phone,et_addr;
    Button bt_submit,bt_cencel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_join);
        service = new MemberServiceImpl(this.getApplicationContext());


        et_id = (EditText) findViewById(R.id.et_id);
        et_pass = (EditText) findViewById(R.id.et_pass);
        et_name = (EditText) findViewById(R.id.et_name);
        et_email = (EditText) findViewById(R.id.et_email);
        et_phone = (EditText) findViewById(R.id.et_phone);
        et_addr = (EditText) findViewById(R.id.et_addr);

        bt_submit = (Button) findViewById(R.id.bt_submit);
        bt_cencel = (Button) findViewById(R.id.bt_cencel);
        //버튼 이벤트 등록
        bt_submit.setOnClickListener(this);
        bt_cencel.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Intent intent;
        switch(v.getId()){
            case R.id.bt_submit :

                MemberDTO param = new MemberDTO();

                param.setId(et_id.getText().toString());
                param.setPw(et_pass.getText().toString());
                param.setName(et_name.getText().toString());
                param.setEmail(et_email.getText().toString());
                param.setPhone(et_phone.getText().toString());
                param.setAddr(et_addr.getText().toString());
                service.join(param);

                break;
            case R.id.bt_cencel :

                break;
        }

    }
}
