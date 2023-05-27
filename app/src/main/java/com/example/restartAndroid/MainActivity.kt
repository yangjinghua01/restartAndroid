package com.example.restartAndroid

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.PersistableBundle
import android.util.Log
import android.view.View
import android.widget.TextView

class MainActivity : AppCompatActivity(){
    val resultCode = 0x0001
    var cli:TextView? = null
    val TAG:String = "RESTART"
    val saveKey = "savekey"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
//        取得保存数据
        if (savedInstanceState!=null){
            val template = savedInstanceState.getString(saveKey)
            Log.e(TAG, "onCreate: ${template}", )
        }
        cli = findViewById(R.id.cli)
        cli?.setOnClickListener(View.OnClickListener {
            gotoNextActivitygetResult()
        })
    }

    /**
     * 离开页面保存数据
     */
    override fun onSaveInstanceState(outState: Bundle, outPersistentState: PersistableBundle) {
        super.onSaveInstanceState(outState, outPersistentState)
        val template = "保存的数据"
        outState.putString(saveKey,template)
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
    }



// intent 携带返回值，这个问题忘记了重温
    fun gotoNextActivitygetResult(){
        val intent = Intent(this,MainActivity2::class.java);
        startActivityForResult(intent,resultCode)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        when(requestCode){
            1->if (resultCode == RESULT_OK){
                val res = data?.getStringExtra("backdata");
                Log.e(TAG, "onActivityResult:结果${res}" )
            }
        }
    }
}