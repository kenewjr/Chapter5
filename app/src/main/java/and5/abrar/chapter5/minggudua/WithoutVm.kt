package and5.abrar.chapter5.minggudua

import and5.abrar.chapter5.R
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_without_vm.*

class WithoutVm : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_without_vm)
        var angka = 0
        btnPlus.setOnClickListener {
            angka++
            tvnumber.text= angka.toString()
        }
        btnMinus.setOnClickListener {
            angka--
            tvnumber.text=angka.toString()
        }
    }
}