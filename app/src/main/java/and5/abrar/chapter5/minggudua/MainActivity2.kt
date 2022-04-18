package and5.abrar.chapter5.minggudua

import and5.abrar.chapter5.R
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main2.*

class MainActivity2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)
        tanpaVmodel.setOnClickListener {
         val pindah = Intent(this,WithoutVm::class.java)
            startActivity(pindah)
        }
        denganVmodel.setOnClickListener {
            val pindah = Intent(this,UsingVm::class.java)
            startActivity(pindah)
        }
        VmdlLdata.setOnClickListener {
            val pindah = Intent(this,VmodelLiveData::class.java)
            startActivity(pindah)
        }
    }
}