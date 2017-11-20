package com.fanwe.www.develop.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.fanwe.www.develop.R;
import com.fanwe.www.develop.business.MainBusiness;

public class MainActivity extends BaseActivity implements MainBusiness.Callback
{
    private MainBusiness mBusiness = new MainBusiness();

    private Button btn_request;
    private TextView tv_result;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mBusiness.setCallback(this);

        btn_request = (Button) findViewById(R.id.btn_request);
        tv_result = (TextView) findViewById(R.id.tv_result);

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

    @Override
    protected void onDestroy()
    {
        super.onDestroy();
        mBusiness.onDestroy();
    }
}
