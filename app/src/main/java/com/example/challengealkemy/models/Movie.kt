package com.example.challengealkemy.models

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Movie (

    @SerializedName("id") val id : String?,
    @SerializedName("title") var title : String?,
    @SerializedName("poster_path") val poster : String?,
    @SerializedName("release_date") val release : String?
    /*
    @SerializedName("adult") val adult : Boolean,
    @SerializedName("overview") val overview : String,
    @SerializedName("genre_ids") val genero_id : ArrayList<Int>,
    @SerializedName("original_lenguage") val lenguage : String,
    @SerializedName("backdrop_path") val backdrop_path : String?,
    @SerializedName("popularity") val popularity : Number,
    @SerializedName("vote_count") val vote_count : Int*/
        ) : Parcelable{
    //FALTA INIT?
    constructor() : this("","","","")

}