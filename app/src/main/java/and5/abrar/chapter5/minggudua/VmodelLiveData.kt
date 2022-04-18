package and5.abrar.chapter5.minggudua

import and5.abrar.chapter5.R
import and5.abrar.chapter5.minggudua.viewmodel.ViewModelDua
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import kotlinx.android.synthetic.main.activity_vmodel_live_data.*

class VmodelLiveData : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_vmodel_live_data)
        val viewModel = ViewModelProvider(this).get(ViewModelDua::class.java)
        viewModel.addnumber.observe(this, Observer{
            tvnumberrr.text = it.toString()
        })
        viewModel.lessnumber.observe(this,Observer{
            tvnumberrr.text = it.toString()
        })

        btnPlusss.setOnClickListener {

                viewModel.addnumber.value =viewModel.angka++

        }

        btnMinusss.setOnClickListener {

             viewModel.lessnumber.value = viewModel.angka--

        }
    }
}