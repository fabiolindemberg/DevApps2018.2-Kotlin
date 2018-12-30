package appfinalkotlin.fabiolindemberg.com.br.appfinalkotlin

import android.app.Activity
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnSelectCar.setOnClickListener({view ->
            val intent = Intent(this, SecondActivity::class.java)
            startActivityForResult(intent, 1)
        })

    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if( resultCode == Activity.RESULT_OK){
            if( data != null){
                etResult.text = data.getStringExtra("RESULT_TEXT")
            }
        }
    }
}
