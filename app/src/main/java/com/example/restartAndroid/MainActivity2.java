package com.example.restartAndroid;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity2 extends AppCompatActivity {
    private Button back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
//        这个方法在活动第一次被创建的时候调用，你应该在这个方法总完成活动的初始化操作比如加载布局绑定事件等
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        back = findViewById(R.id.back);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.putExtra("backdata","111");
                setResult(RESULT_OK,intent);
                finish();
            }
        });
    }

    @Override
    protected void onStart() {
//        这个方法在活动由不可见变为可见的时候调用
        super.onStart();
    }

    @Override
    protected void onResume() {
//        这个方法在活动在活动准备好和用户进行交互调用此时活动一定位于返回栈的栈顶，并且处于运行状态
        super.onResume();
    }

    @Override
    protected void onPause() {
//        这个方法在系统准备去启动或者恢复另一个活动的时候调用，我们通常会在这个方中将一些消耗cpu的资源释放掉，以及保存一些相关数据，但这个方法的执行速度一定要快不然会影响到新的栈顶活动使用
        super.onPause();
    }

    @Override
    protected void onStop() {
//  这个方法在活动完全不可见的时候调用，她和onpause方法的主要区别在于如果启动的新活动是一个对话框那么onpause方法会的到执行而onstop不会
        super.onStop();
    }

    @Override
    protected void onDestroy() {
//        这个方法在活动被销毁之前调用，之后活动的状态将变为销毁状态
        super.onDestroy();
    }

    @Override
    protected void onRestart() {
//        这个方法在活动由停止状态变为运行状态之前调用也就是活动重新启动了。
        super.onRestart();
    }
}