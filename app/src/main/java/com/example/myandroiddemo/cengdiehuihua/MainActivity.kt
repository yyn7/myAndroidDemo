package com.example.myandroiddemo.cengdiehuihua
import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import com.example.myandroiddemo.R


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main3)

        val firstListRv = findViewById<RecyclerView>(R.id.rv_list_first)

        val tempList = ArrayList<Int>()
        tempList.add(R.drawable.ic_card_1)
        tempList.add(R.drawable.ic_card_2)
        tempList.add(R.drawable.ic_card_2)
        tempList.add(R.drawable.ic_card_4)
        tempList.add(R.drawable.ic_card_5)
        tempList.add(R.drawable.ic_card_6)

        val horizontalConfig = StackCardLayoutManager.StackConfig()
        val manager = StackCardLayoutManager(horizontalConfig)
        firstListRv.layoutManager = manager.apply {
            val listener = object : StackCardLayoutManager.OnPositionChangeListener{
                override fun onPositionChange(position: Int) {
                    manager.getTopView()
                }
            }
            setOnPositionChangeListener(listener)
        }
        firstListRv.adapter = TestAdapter(this, tempList)



    }

    /**
     * 根据手机的分辨率从 dp 的单位 转成为 px(像素)
     */
    private fun dip2px(context: Context, dpValue: Float): Int {
        val scale = context.resources.displayMetrics.density
        return (dpValue * scale + 0.5f).toInt()
    }

    private class TestAdapter(val context: Context, val data: List<Int>) : RecyclerView.Adapter<TestAdapter.ViewHolder>() {

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
            val view = LayoutInflater.from(context).inflate(R.layout.item_test, parent, false)
            return ViewHolder(view)
        }

        override fun getItemCount(): Int {
            return data.size
        }

        override fun onBindViewHolder(holder: ViewHolder, position: Int) {
            holder.imageIv.setImageResource(data[position])
            holder.itemView.setTag("" + data[position].hashCode())
            Log.e("holder", "view: ${holder.itemView.getTag()}")
        }

        private class ViewHolder : RecyclerView.ViewHolder {

            var imageIv: ImageView

            constructor(itemView: View) : super(itemView) {
                imageIv = itemView.findViewById(R.id.iv_image)
            }
        }
    }


}
