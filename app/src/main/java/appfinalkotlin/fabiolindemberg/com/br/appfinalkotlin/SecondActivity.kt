package appfinalkotlin.fabiolindemberg.com.br.appfinalkotlin

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.os.Parcel
import android.os.Parcelable
import android.support.v7.widget.FitWindowsLinearLayout
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.LinearLayout
import kotlinx.android.synthetic.main.activity_second.*
import kotlinx.android.synthetic.main.detail.view.*

class SecondActivity : AppCompatActivity() {

    //private lateinit var recyclerView: RecyclerView
    private lateinit var viewAdapter: MyAdapter
    private lateinit var viewManager: RecyclerView.LayoutManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        setUpRecyclerView()
    }

    fun getCars(): List<Car> {
        val cars = ArrayList<Car>()
        cars.add(Car("HB20", 2015))
        cars.add(Car("UNO", 2008))
        cars.add(Car("C3", 2011))
        cars.add(Car("XTZ", 2005))
        cars.add(Car("YBR", 2007))

        return cars
    }

    fun setUpRecyclerView(){
        viewManager = LinearLayoutManager(this)
        viewAdapter = MyAdapter(getCars())
        rvList.setHasFixedSize(true)
        rvList.layoutManager = viewManager
        rvList.adapter = viewAdapter
    }

    class MyAdapter(var cars: List<Car>) : RecyclerView.Adapter<MyAdapter.MyViewHolder>() {

        class MyViewHolder(val linearLayout: LinearLayout): RecyclerView.ViewHolder(linearLayout)

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyAdapter.MyViewHolder {
            val linearLayout = LayoutInflater.from(parent.context)
                    .inflate(R.layout.detail,parent, false) as LinearLayout
            return MyViewHolder(linearLayout)
        }

        override fun getItemCount(): Int {
            return this.cars.count()
        }

        override fun onBindViewHolder(holder: MyAdapter.MyViewHolder, position: Int) {
            holder.linearLayout.car_name.text = this.cars[position].name
            holder.linearLayout.car_year.text = this.cars[position].year.toString()
        }


    }
}
