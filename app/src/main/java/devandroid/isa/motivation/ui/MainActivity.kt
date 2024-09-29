package devandroid.isa.motivation.ui

import android.os.Bundle
import android.view.View
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import devandroid.isa.motivation.utils.MotivationConstants
import devandroid.isa.motivation.R
import devandroid.isa.motivation.utils.SecurityPreferences
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
        val name = SecurityPreferences(this).getString(MotivationConstants.KEY.USER_NAME)
        binding.txtOla.text = "Olá, $name!"
    }

    override fun onClick(view: View) {
        if (view.id == R.id.btn_nova_frase) {
            var s = ""
        }
    }
}