package com.android.paginationapp.network

data class RickAndMortyList(val results: ArrayList<CharacterData>)
data class CharacterData(val name: String, val species: String, val image: String)
