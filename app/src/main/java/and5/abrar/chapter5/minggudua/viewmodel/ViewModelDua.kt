package and5.abrar.chapter5.minggudua.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class ViewModelDua : ViewModel(){
    var angka =0
    val addnumber : MutableLiveData<Int> by lazy {
        MutableLiveData<Int>()
    }
    val lessnumber :MutableLiveData<Int> by lazy{
        MutableLiveData<Int>()
    }
}