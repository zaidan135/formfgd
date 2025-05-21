package project.android.formulirfgdapps

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import project.android.formulirfgdapps.databinding.ActivityDetailBinding
import project.android.formulirfgdapps.model.Participant

class  DetailActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDetailBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val participant = intent.getParcelableExtra<Participant>("participant")

        participant?.let{
            binding.txtNamaResult.text = it.nama
            binding.txtTelefonResult.text = it.telefon
            binding.txtEmailResult.text = it.email
            binding.txtGenderResult.text = it.gender
            binding.txtSkillsetResult.text = it.skillset.joinToString(", ")
            binding.txtKategoriResult.text = it.kategori

        }

        binding.btnInfoDeveloper.setOnClickListener {
            val bottomSheetFragment = InfoDeveloper()
            bottomSheetFragment.show(supportFragmentManager, "infoDeveloper")

        }
    }
}

// Kamis 15 Mei 2025

/*
NIM   : 10122231
NAMA  : Zaidan Febriandi
Kelas : IF-6
*/