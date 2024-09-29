package devandroid.isa.motivation

import android.os.Bundle
import android.view.View
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import devandroid.isa.motivation.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        binding = ActivityMainBinding.inflate(layoutInflater)

        setContentView(binding.root)

        //supportActionBar?.show()

        handleUserName()


        binding.btnNovaFrase.setOnClickListener(this)

    }

    private fun handleUserName() {
        val name = SecurityPreferences(this).getString("USER_NAME")
        binding.txtOla.text = "Olá, $name!"
    }

    override fun onClick(view: View) {
        if (view.id == R.id.btn_nova_frase) {
            var s = ""
        }
    }
}