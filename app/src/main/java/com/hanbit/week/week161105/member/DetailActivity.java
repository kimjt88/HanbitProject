package com.hanbit.week.week161105.member;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.hanbit.week.week161105.R;
import com.hanbit.week.week161105.util.MapsActivity;
import com.hanbit.week.week161105.util.Phone;
import com.hanbit.week.week161105.util.webActivity;


public class DetailActivity extends AppCompatActivity implements View.OnClickListener{
    MemberService service;
    ImageView iv_photo;
    TextView tv_id,tv_name,tv_email,tv_phone,tv_addr;
    Button bt_call,bt_message,bt_map,bt_movie,bt_update,bt_list;
    String id;
    Phone phone;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        service = new MemberServiceImpl(this.getApplicationContext());
        //Activity가 service를 만들때 자신의 컨텍스트를 건내줘야함
        // 인스턴스에 맥락을 주게되는 것임

        iv_photo = (ImageView) findViewById(R.id.iv_photo);
        phone = new Phone(this,this);
        tv_id = (TextView) findViewById(R.id.tv_id);
        tv_name = (TextView) findViewById(R.id.tv_name);
        tv_email = (TextView) findViewById(R.id.tv_email);
        tv_phone = (TextView) findViewById(R.id.tv_phone);
        tv_addr = (TextView) findViewById(R.id.tv_addr);

        id = this.getIntent().getExtras().getString("id");

        MemberDTO member = service.detail(id);
        if(member !=null){
            tv_name.setText(member.getName());
            tv_id.setText(member.getId());
            tv_email.setText(member.getEmail());
            tv_phone.setText(member.getPhone());
            tv_addr.setText(member.getAddr());
            // iv_photo.set
        }else{
            Log.d("아이디가 존재하지 않을경우","아이디 없음");
        }


        bt_call = (Button) findViewById(R.id.bt_call);
        bt_message = (Button) findViewById(R.id.bt_message);
        bt_map = (Button) findViewById(R.id.bt_map);
        bt_movie = (Button) findViewById(R.id.bt_movie);
        bt_update = (Button) findViewById(R.id.bt_update);
        bt_list = (Button) findViewById(R.id.bt_list);

        bt_call.setOnClickListener(this);
        bt_message.setOnClickListener(this);
        bt_map.setOnClickListener(this);
        bt_movie.setOnClickListener(this);
        bt_update.setOnClickListener(this);
        bt_list.setOnClickListener(this);


    }

    @Override
    public void onClick(View v) {
        Intent intent = null;
        switch(v.getId()){
            case R.id.bt_call :

                Log.d("call click:","ok");
                phone.directCall(tv_phone.getText().toString());
                break;
            case R.id.bt_message :

                break;
            case R.id.bt_map :
                Log.d("구글맵 클릭 :","OK");
                intent = new Intent(this.getApplicationContext(), MapsActivity.class);
                //37.5665350,126.9779690 시청역
                String pos = tv_addr.getText().toString();
                //좌표 수하는 로직이 돌아감
                pos = "37.5665350,126.9779690";
                intent.putExtra("pos",pos);
                this.startActivity(intent);
                break;
            case R.id.bt_movie :
                Log.d("무비 들어옴 :","OK");
                intent = new Intent(DetailActivity.this, webActivity.class); // from , to
                this.startActivity(intent);
                break;
            case R.id.bt_update :

                intent = new Intent(DetailActivity.this, UpdateActivity.class); // from , to
                intent.putExtra("id",id);
                this.startActivity(intent);
                break;

            case R.id.bt_list :
                this.startActivity(new Intent(DetailActivity.this, ListActivity.class));
                break;
        }
    }
}
