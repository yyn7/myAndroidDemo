package com.example.myandroiddemo.tuozhuai

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.MotionEvent
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.LinearLayout
import android.widget.Toast
import com.example.myandroiddemo.R


/**
 *  拖拽组件
 *  点击事件
 *  触控事件
 */
class MainActivity : AppCompatActivity() {
    var mButton: Button? = null
    var mRoot: ViewGroup? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.tuozhuai)
        var mRoot: ViewGroup = findViewById(R.id.root)
        var mButton: Button = findViewById(R.id.button)

        var myLayoutParams = LinearLayout.LayoutParams(
            ViewGroup.LayoutParams.WRAP_CONTENT,
            ViewGroup.LayoutParams.WRAP_CONTENT
        )
        myLayoutParams.marginStart = 50
        myLayoutParams.marginEnd = 50

        mButton.layoutParams = myLayoutParams
//       mButton.setOnClickListener(myClick())
        mButton.setOnTouchListener(myTouch())


    }

//    class myClick : View.OnClickListener{
//        override fun onClick(v:View){
//            Log.d("tag","123")
//        }
//    }

    class myTouch : View.OnTouchListener {
        var lastX: Float? = 0F
        var lastY: Float? = 0F
        override fun onTouch(v: View?, event: MotionEvent?): Boolean {
            if (event?.action == MotionEvent.ACTION_DOWN) {
                lastX = event.x
                lastY = event.y

            }
            if (event?.action == MotionEvent.ACTION_MOVE) {
                var x = event?.rawX - (lastX ?: 0F)
                var y = event?.rawY - (lastY ?: 0F)
                Log.d("aaa", "rawX=${event?.rawX},lastX=${lastX},rawY=${event?.rawY},lastY=${lastY}")
                var mlayout = v?.layoutParams
                v?.x = x
                v?.y = y-240F
                v?.layoutParams = mlayout
            }

            return true
        }
    }
}
