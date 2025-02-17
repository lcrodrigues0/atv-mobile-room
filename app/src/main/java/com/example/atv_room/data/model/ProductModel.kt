package com.example.atv_room.data.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "Product")
class ProductModel {
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name="id")
    var id: Int = 0

    @ColumnInfo(name = "name")
    var name: String = ""

    @ColumnInfo(name = "price")
    var price: Double = 0.0

    @ColumnInfo(name = "quantity")
    var quantity: Int = 0
}