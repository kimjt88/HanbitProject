package com.hanbit.week.week161105.calc;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.hanbit.week.week161105.R;

public class calcActivity extends AppCompatActivity implements View.OnClickListener{

    EditText et_first, et_second;
    Button bt_plus,bt_minus, bt_multi, bt_mod, bt_equal,bt_cencel,bt_divid;
    TextView tv_result;
    int result;

    CalcService service;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_calc);

        service = new CalcServiceImpl();
        et_first = (EditText) findViewById(R.id.et_first);
        et_second = (EditText) findViewById(R.id.et_second);

        bt_plus = (Button) findViewById(R.id.bt_plus);
        bt_minus = (Button) findViewById(R.id.bt_minus);
        bt_multi = (Button) findViewById(R.id.bt_multi);
        bt_mod = (Button) findViewById(R.id.bt_mod);
        bt_divid = (Button) findViewById(R.id.bt_divid);

        bt_cencel = (Button) findViewById(R.id.bt_cencel);
        bt_equal = (Button) findViewById(R.id.bt_equal);

        tv_result = (TextView) findViewById(R.id.tv_result);


        bt_plus.setOnClickListener(this);
        bt_minus.setOnClickListener(this);
        bt_multi.setOnClickListener(this);
        bt_mod.setOnClickListener(this);
        bt_cencel.setOnClickListener(this);
        bt_equal.setOnClickListener(this);
        bt_divid.setOnClickListener(this);
        // 이벤트 리스너 등록



    }

    @Override
    public void onClick(View v) {

        int first = Integer.parseInt(et_first.getText().toString());
        int second = Integer.parseInt(et_second.getText().toString());
        CalcDTO dto = new CalcDTO();

        dto.setFirst(first);
        dto.setSecond(second);
        // local variable initialize

        switch (v.getId()){
            case R.id.bt_plus :
                result = service.plus(dto);
                break;
            case R.id.bt_minus:
                result = service.minus(dto);
                break;
            case R.id.bt_multi:
                result = service.multi(dto);
                break;
            case R.id.bt_mod:
                result = service.mod(dto);
                break;
            case R.id.bt_divid:
                result = service.divid(dto);
                break;
            case R.id.bt_equal:
                tv_result.setText("Result : "+result);
                break;
            case R.id.bt_cencel:
                result = 0;
                tv_result.setText("Result : ");
                et_first.setText("");
                et_second.setText("");
                break;
        }
    }
}
