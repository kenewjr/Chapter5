package and5.abrar.chapter5.minggudua

import and5.abrar.chapter5.R
import and5.abrar.chapter5.minggudua.viewmodel.ViewModelSatu
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import kotlinx.android.synthetic.main.activity_using_vm.*

class UsingVm : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_using_vm)
        val viewModel=ViewModelProvider(this).get(ViewModelSatu::class.java)
        tvnumberr.text = viewModel.angka.toString()
        btnPluss.setOnClickListener {
            viewModel.angka++
            tvnumberr.text =viewModel.angka.toString()
        }
        btnMinuss.setOnClickListener {
            viewModel.angka--
            tvnumberr.text=viewModel.angka.toString()
        }
    }
}