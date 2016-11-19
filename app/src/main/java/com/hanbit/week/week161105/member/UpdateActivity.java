package com.hanbit.week.week161105.member;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.hanbit.week.week161105.R;

public class UpdateActivity extends AppCompatActivity  implements View.OnClickListener{
    TextView tv_name,tv_id;
    EditText et_password,et_email,et_phone,et_addr;
    Button bt_confirm,bt_cencel;
    String id;
    MemberService service;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update);
        service = new MemberServiceImpl(this.getApplicationContext());

        tv_name = (TextView) findViewById(R.id.tv_name);
        tv_id = (TextView) findViewById(R.id.tv_id);

        et_password = (EditText) findViewById(R.id.et_password);
        et_email = (EditText) findViewById(R.id.et_email);
        et_phone = (EditText) findViewById(R.id.et_phone);
        et_addr = (EditText) findViewById(R.id.et_addr);

        id = this.getIntent().getExtras().getString("id");

        MemberDTO member = service.detail(id);
        if(member != null){
            tv_name.setText(member.getName());
            tv_id.setText(member.getId());
            et_email.setText(member.getEmail());
            et_phone.setText(member.getPhone());
            et_addr.setText(member.getAddr());
            // iv_photo.set
        }else{
            Log.d("아이디가 존재하지 않을경우","아이디 없음");
        }


        bt_confirm = (Button) findViewById(R.id.bt_confirm);
        bt_cencel = (Button) findViewById(R.id.bt_cencel);

        bt_confirm.setOnClickListener(this);
        bt_cencel.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch(v.getId()){
            case R.id.bt_confirm:
                MemberDTO member = new MemberDTO();
                member.setId(tv_id.getText().toString());
                member.setPw(et_password.getText().toString());
                member.setPhone(et_phone.getText().toString());
                member.setEmail(et_email.getText().toString());
                member.setAddr(et_addr.getText().toString());

                service.update(member);
                Intent intent1 = new Intent(UpdateActivity.this, ListActivity.class);
                intent1.putExtra("id",id);
                this.startActivity(intent1);
                break;
            case R.id.bt_cencel:
                Intent intent2 = new Intent(UpdateActivity.this, ListActivity.class);
                intent2.putExtra("id",id);
                this.startActivity(intent2);
                break;
        }

    }
}
