package appfinalkotlin.fabiolindemberg.com.br.appfinalkotlin

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val cars = ArrayList<Car>()
        cars.add(Car("HB20", 2015))
        cars.add(Car("Uno", 2008))


        btnSelectCar.setOnClickListener({view ->
            val intent = Intent(this, SecondActivity::class.java)
            startActivityForResult(intent, 1)
        })
   }
}
