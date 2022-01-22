package id.rafialbaihaqi_19104042.praktikum6

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.os.Parcelable
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import id.rafialbaihaqi_19104042.praktikum6.adapter.CardViewDataAdapter
import id.rafialbaihaqi_19104042.praktikum6.databinding.ActivityDetailBinding

class DetailActivity : AppCompatActivity() {
    private lateinit var binding: ActivityDetailBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)


        binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setSupportActionBar(findViewById(R.id.toolbar))
        binding.fab.setOnClickListener { view ->
            val moveWithObjectIntent = Intent(this, MapsActivity::class.java)
            moveWithObjectIntent.putExtra(MapsActivity.EXTRA_MYDATA, myData)
            startActivity(moveWithObjectIntent)
        }




        val tv_detail_description : TextView by lazy {
            findViewById(R.id.tv_detail_dalem)
        }

        //val myData by getParcelableExtra<MyData>(EXTRA_MYDATA)
        supportActionBar?.title = myData!!.name.toString()
        tv_detail_description.text = myData!!.description.toString()

        Glide.with(this)
            .load(myData!!.photo.toString())
            .apply(RequestOptions().override(700, 700))
            .into(findViewById(R.id.iv_detail_photo))
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
    }

    companion object {
        const val EXTRA_MYDATA = "extra_mydata"
    }
    val myData by getParcelableExtra<MyData>(CardViewDataAdapter.EXTRA_MYDATA)
    inline fun <reified T : Parcelable> Activity.getParcelableExtra(key: String) = lazy {
        intent.getParcelableExtra<T>(key)
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }
}