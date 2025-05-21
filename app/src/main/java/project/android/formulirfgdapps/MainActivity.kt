package project.android.formulirfgdapps

import android.content.Intent
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import project.android.formulirfgdapps.databinding.ActivityMainBinding
import project.android.formulirfgdapps.model.Participant

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    private val categories = listOf("Android", "Web", "IoT")

    private val skillMap by lazy {
        listOf(
            Pair(binding.chkAlgo, "Algoritma"),
            Pair(binding.chkProblemSolving, "Problem Solving"),
            Pair(binding.chkProgramming, "Programming"),
            Pair(binding.chkDesignThinking, "Design Thinking"),
            Pair(binding.chkCriticalThinking, "Critical Thinking")
        )
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //adapter Spinner
        val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, categories)
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        binding.spnKategori.adapter = adapter

        binding.btnSubmit.setOnClickListener {

            val name = binding.edtNama.text.toString()
            val phone = binding.edtTelefon.text.toString()
            val email = binding.edtEmail.text.toString()
            val gender = when{
                binding.radLakilaki.isChecked -> "Laki-laki"
                binding.radPerempuan.isChecked -> "Perempuan"
                else -> ""

            }

            val skillset = skillMap.filter { it.first.isChecked }.map { it.second }
            if (skillset.isEmpty()) {
                Toast.makeText(this, "Pilih minimal satu skill", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            val category = binding.spnKategori.selectedItem.toString()

            if (name.isEmpty() || phone.isEmpty() || email.isEmpty() || gender.isEmpty()) {
                Toast.makeText(this, "Semua field harus diisi", Toast.LENGTH_SHORT).show()
                return@setOnClickListener

            }

            val participant = Participant(name, phone, email, gender, skillset, category)

            val intent = Intent(this, DetailActivity::class.java)
            intent.putExtra("participant", participant)
            startActivity(intent)

        }
    }
}

// Kamis 15 Mei 2025

/*
NIM   : 10122231
NAMA  : Zaidan Febriandi
Kelas : IF-6
*/