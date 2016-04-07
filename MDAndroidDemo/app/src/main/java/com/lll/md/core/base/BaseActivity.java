package com.lll.md.core.base;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MotionEvent;
import android.view.View;

import com.lll.md.core.R;

public class BaseActivity extends AppCompatActivity {

    /**
     * 是否左滑关闭activity
     */
    public boolean isLeftClose;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }


    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        if(isLeftClose) {
            int action=ev.getAction();
            int dX=0;
            int upX=0;
            switch (action){
                case MotionEvent.ACTION_DOWN:
                    dX= (int) ev.getX();
                    break;
                case MotionEvent.ACTION_UP:
                    upX = (int)ev.getX();
                    if((upX-dX)>50){
                        finish();
                        return true;
                    }
                    break;
            }
        }
        return super.dispatchTouchEvent(ev);
    }


    @Override
    public void startActivity(Intent intent) {
        super.startActivity(intent);
    }


    public void showLoadingDialog(String msg){

    }
}
