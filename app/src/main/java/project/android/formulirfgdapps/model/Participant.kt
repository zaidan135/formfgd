package project.android.formulirfgdapps.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Participant(
    val nama: String,
    val telefon: String,
    val email: String,
    val gender: String,
    val skillset: List<String>,
    val kategori: String
) : Parcelable

// Kamis 15 Mei 2025

/*
NIM   : 10122231
NAMA  : Zaidan Febriandi
Kelas : IF-6
*/