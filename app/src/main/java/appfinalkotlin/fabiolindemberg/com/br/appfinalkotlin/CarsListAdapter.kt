package appfinalkotlin.fabiolindemberg.com.br.appfinalkotlin

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.LinearLayout
import kotlinx.android.synthetic.main.detail.view.*

class CarListAdapter(var cars: List<Car>, val click: (Car)->Unit) : RecyclerView.Adapter<CarListAdapter.MyViewHolder>() {

    class MyViewHolder(val linearLayout: LinearLayout): RecyclerView.ViewHolder(linearLayout)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CarListAdapter.MyViewHolder {
        val linearLayout = LayoutInflater.from(parent.context)
                .inflate(R.layout.detail,parent, false) as LinearLayout
        return MyViewHolder(linearLayout)
    }

    override fun getItemCount(): Int {
        return this.cars.count()
    }

    override fun onBindViewHolder(holder: CarListAdapter.MyViewHolder, position: Int) {
        holder.linearLayout.car_name.text = this.cars[position].name
        holder.linearLayout.car_year.text = this.cars[position].year.toString()

        holder.linearLayout.setOnClickListener({view ->
            click(this.cars[position])
        })

    }
    
}
