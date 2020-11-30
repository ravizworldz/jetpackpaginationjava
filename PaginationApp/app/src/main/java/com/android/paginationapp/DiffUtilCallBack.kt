package com.android.paginationapp

import androidx.recyclerview.widget.DiffUtil
import com.android.paginationapp.network.CharacterData

class DiffUtilCallBack : DiffUtil.ItemCallback<CharacterData>() {
    override fun areItemsTheSame(oldItem: CharacterData, newItem: CharacterData): Boolean {
        return oldItem.name == newItem.name
    }

    override fun areContentsTheSame(oldItem: CharacterData, newItem: CharacterData): Boolean {
        return oldItem.name == newItem.name
                && oldItem.species == newItem.species

    }

}