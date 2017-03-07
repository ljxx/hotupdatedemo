package com.ylx.hotupdatedemo;

import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.tencent.tinker.lib.tinker.TinkerInstaller;

public class MainActivity extends AppCompatActivity {

    private TextView mText01;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mText01 = (TextView) findViewById(R.id.mText01);
        mText01.setText("更改后：不要着急，有Tinker热修复，这都不是事！"); //更改前：不好了，发现线上的App有Bug!!!；更改后：不要着急，有Tinker热修复，这都不是事！
    }

    public void onUpdate(View view){
        TinkerInstaller.onReceiveUpgradePatch(getApplicationContext(),
                Environment.getExternalStorageDirectory().getAbsolutePath() + "/patch_signed_update.apk");
    }
}
