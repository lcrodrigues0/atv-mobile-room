package com.example.atv_room.viewModel

import android.app.Application
import android.database.sqlite.SQLiteConstraintException
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.atv_room.data.model.ProductModel
import com.example.atv_room.data.room.AppDatabase
import com.example.atv_room.utils.Constants

class AddProductViewModel(application: Application): AndroidViewModel(application) {
    private var savedMsg = MutableLiveData<Int>()

    fun getIsSaved() : LiveData<Int>{
        return savedMsg
    }

    fun saveProduct(prod: ProductModel){
        val db = AppDatabase.getDatabase(getApplication()).ProductDAO()
        var res = 0L

        try {
            res = db.insert(prod)
            savedMsg.value = if(res > 0) Constants.BD_MSGS.SUCCESS else Constants.BD_MSGS.FAIL

        } catch (e: SQLiteConstraintException){
            savedMsg.value = Constants.BD_MSGS.CONSTRAINT
        }
    }
}