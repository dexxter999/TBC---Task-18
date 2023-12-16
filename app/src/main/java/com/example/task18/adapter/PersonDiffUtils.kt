package com.example.task18.adapter

import androidx.recyclerview.widget.DiffUtil
import com.example.task18.network.model.ResponseModel

class PersonDiffUtils : DiffUtil.ItemCallback<ResponseModel.Person>(){
    override fun areItemsTheSame(
        oldItem: ResponseModel.Person,
        newItem: ResponseModel.Person
    ) = oldItem.id == newItem.id

    override fun areContentsTheSame(
        oldItem: ResponseModel.Person,
        newItem: ResponseModel.Person
    ) = oldItem == newItem

}