package appfinalkotlin.fabiolindemberg.com.br.appfinalkotlin

import android.app.Activity
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import kotlinx.android.synthetic.main.activity_second.*

class SecondActivity : AppCompatActivity() {

    private lateinit var viewAdapter: CarListAdapter
    private lateinit var viewManager: RecyclerView.LayoutManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        setUpRecyclerView()
    }

    fun getCars(): List<Car> {
        val cars = ArrayList<Car>()
        cars.add(Car("HB20 Confort Plus 1.0", 2015))
        cars.add(Car("UNO Mile 1.0", 2008))
        cars.add(Car("C3 Converse 1.4", 2011))
        cars.add(Car("POLO BEETS 2018", 2018))
        cars.add(Car("SPORTAGE", 2014))

        return cars
    }

    fun selectCar(car: Car){
        val data = Intent()
        data.putExtra(MainActivity.RESULT_KEY, "Selected car: ${car.name}(${car.year})")
        setResult(Activity.RESULT_OK, data)
        finish()
    }

    fun setUpRecyclerView(){
        viewManager = LinearLayoutManager(this)
        viewAdapter = CarListAdapter(getCars(), ::selectCar)

        rvList.setHasFixedSize(true)
        rvList.layoutManager = viewManager
        rvList.adapter = viewAdapter
    }

}
