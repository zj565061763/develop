package com.sd.www.develop.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.sd.www.develop.R;
import com.sd.www.develop.business.MainBusiness;

public class MainActivity extends BaseActivity implements MainBusiness.Callback
{
    private final MainBusiness mBusiness = new MainBusiness(toString());

    private Button btn_request;
    private TextView tv_result;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn_request = findViewById(R.id.btn_request);
        tv_result = findViewById(R.id.tv_result);

        btn_request.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                mBusiness.requestInitAndShow();
            }
        });
    }

    @Override
    public void onBsShowInitResult(String result)
    {
        tv_result.setText(result);
    }
}
