package com.example.myactivity

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Button
import android.widget.Toast

class FirstActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

//        加载布局，R.layout.first_layout获取布局的资源id
        setContentView(R.layout.first_layout)
        val button1: Button = findViewById(R.id.button1)

        button1.setOnClickListener {
//            使用Toast进行消息提醒
//            Toast.makeText(this, "You clicked Button 1", Toast.LENGTH_SHORT).show()
////            销毁activity
//            finish()
//            显示例Intent：定义intent，并启动activity，SecondActivity::class.java返回java class对象
//            val intent = Intent(this, SecondActivity::class.java)
//            startActivity(intent)

//            val intent = Intent("com.example.myactivity.ACTION_START")
//            intent.addCategory("com.example.myactivity.MY_CATEGORY")
            val intent = Intent(Intent.ACTION_VIEW)
//            parse方法将字符串解析为uri对象，SetData用于指定当前intent正在操作的数据
            intent.data = Uri.parse("https://www.baidu.com")
            startActivity(intent)
        }
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
//        这里的item.itemId等同于getItemId()方法，语法糖
        when (item.itemId) {
            R.id.add_item -> Toast.makeText(this, "You clicked Add", Toast.LENGTH_SHORT).show()
            R.id.remove_item -> Toast.makeText(this, "You clicked Remove", Toast.LENGTH_SHORT)
                .show()
        }
        return true
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
//        infate，隐式膨胀，将资源隐式放到view里
        menuInflater.inflate(R.menu.main, menu)
        return true
    }
}